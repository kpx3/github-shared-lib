import groovy.json.JsonSlurperClassic
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  sh "echo ${data}"
last_started = env.STAGE_NAME
                echo 'Create DR'
                sh """
                . ${data.PYTHON_FW_ENV}
               
                echo '${params.EnvironmentName}'
              
                """
}
