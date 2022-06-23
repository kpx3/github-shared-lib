import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  def JOB_NAME = config.job
    properties([
        parameters([
        
        booleanParam(defaultValue: false, name: 'BuildAll', description: ''),
       
        stringParam(name: 'Test', defaultValue: JOB_NAME, description: 'Give the job name'),
          
        stringParam(name: 'SuffixName', defaultValue: evaluate(data.serviceNameSuffix), description: 'Give the suffix name'),
        
        stringParam(name: 'EnvironmentName', defaultValue: data.environmentName, description: 'Give the environment name'),

        choiceParam(name: 'SkipDBReset', choices: ['False', 'True'], description: 'Skips DB reset'),
        
        stringParam(name: 'DB_NAME', defaultValue: data.db_name, description: 'db name'),
        
        stringParam(name: 'OTM_RELEASE', defaultValue: data.otmRelease, description: 'new otm release'),
        
        stringParam(name: 'OTM_VERSION', defaultValue: 'latest', description: 'new latest / image name like otm20c-time-stamp'),
        
        choiceParam(name: 'OTM_IMAGE_BUILD_TYPE', choices: ['stable', 'nightly', 'weekly'], description: 'select stable / nighty / weekly'),
        
        choiceParam(name: 'POD_SIZE', choices: ['SMALL', 'MEDIUM', 'LARGE'], description: 'VM SIZE')
        
        ])
    ])
}
