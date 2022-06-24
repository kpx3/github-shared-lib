import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/Parameters.json") //loading parameter from the json
  def data = new JsonSlurperClassic().parseText(props)
  def JOB_NAME = config.job

  sh "echo ${data} ${config.job} ${JOB_NAME}"
  last_started = env.STAGE_NAME
                sh """
                python ${data.PYTHON_FW_ENV}      #running a python file       
                JOB_NAME = config.job
                echo  ${data.EnvironmentName} ${data.OTM_RELEASE} ${data.serviceNameSuffix}
                """ 
}
