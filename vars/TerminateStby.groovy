import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  sh "echo ${data} ${config.job}"
  def p1 = config.job+data.ServiceNameSuffix
  last_started = env.STAGE_NAME
                sh """
                python ${data.PYTHON_FW_ENV}              
                echo ' ${p1} ${data.EnvironmentName} ${data.OTM_RELEASE} ${data.ServiceNameSuffix}'
                """ 
}
