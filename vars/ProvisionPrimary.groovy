import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  def JOB_NAME = config.job
  last_started = env.STAGE_NAME
                echo 'Provisioning '
                sh """
                 JOB_NAME=${config.job}
                python ${data.PYTHON_FW_ENV}
                """
                echo "Provisioning done"
                echo "Sleep for sometime before QA testing"
                sleep 3 
                }
