import groovy.json.JsonSlurperClassic
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  last_started = env.STAGE_NAME
                echo 'Provisioning '
                sh """
                python ${data.PYTHON_FW_ENV}
                """
                echo "Provisioning done"
                echo "Sleep for sometime before QA testing"
                sleep 300 
                }
