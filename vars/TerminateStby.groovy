import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  def JOB_NAME = config.job
  sh "echo ${data} "
  last_started = env.STAGE_NAME
                sh """
                python ${data.PYTHON_FW_ENV}              
                echo ' ${data.EnvironmentName} ${data.OTM_RELEASE} ${data.serviceNameSuffix}'
                """ 
}
