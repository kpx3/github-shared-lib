import groovy.json.JsonSlurperClassic
def call(Map config =[:]) { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  def JOB_NAME = config.job
  sh " JOB_NAME=${config.job} echo ${data}"
last_started = env.STAGE_NAME
                echo 'Create DR'
                sh """
                 JOB_NAME=${config.job}
                python ${data.PYTHON_FW_ENV}
               
                echo ${data.EnvironmentName}
              
                """
}
