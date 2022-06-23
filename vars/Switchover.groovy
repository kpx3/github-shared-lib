import groovy.json.JsonSlurperClassic
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  sh "echo ${data}"
  last_started = env.STAGE_NAME
                echo 'Switchover Started'
                echo "Hello ${params.EnvironmentName}"
                sh """
                python ${PYTHON_FW_ENV}
               
                """
}
