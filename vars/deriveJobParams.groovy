import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  def JOB_NAME = config.job
  
  
  
  def serviceNameSuffix = data.serviceNameSuffix.replaceAll(/\$\{(\w+)\}/) 
  def environmentName = data.environmentName
  def db_name = data.db_name
  def otmRelease = data.otmRelease
 
    properties([
        parameters([
        
        booleanParam(defaultValue: false, name: 'BuildAll', description: ''),
       
        stringParam(name: 'Test', defaultValue: JOB_NAME, description: 'Give the job name'),
          
        stringParam(name: 'SuffixName', defaultValue: "${serviceNameSuffix}", description: 'Give the suffix name'),
        
        stringParam(name: 'EnvironmentName', defaultValue: environmentName, description: 'Give the environment name'),

        choiceParam(name: 'SkipDBReset', choices: ['False', 'True'], description: 'Skips DB reset'),
        
        stringParam(name: 'DB_NAME', defaultValue: db_name, description: 'db name'),
        
        stringParam(name: 'OTM_RELEASE', defaultValue: otmRelease, description: 'new otm release'),
        
        stringParam(name: 'OTM_VERSION', defaultValue: 'latest', description: 'new latest / image name like otm20c-time-stamp'),
        
        choiceParam(name: 'OTM_IMAGE_BUILD_TYPE', choices: ['stable', 'nightly', 'weekly'], description: 'select stable / nighty / weekly'),
        
        choiceParam(name: 'POD_SIZE', choices: ['SMALL', 'MEDIUM', 'LARGE'], description: 'VM SIZE')
        
        ])
    ])
}
