import groovy.json.JsonSlurperClassic
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  sh "echo ${data}"
  last_started = env.STAGE_NAME
                echo 'Switchover Started'
                echo "Hello ${params.EnvironmentName}"
                sh """
                . ${PYTHON_FW_ENV}
                cd \$OOW_HOME/main/otmociwf
                python -u invoke_workflow.py --workflow=dr_switch_workflow --release=${params.OTM_RELEASE} --environment_name=${params.EnvironmentName} --patch_version=${params.OTM_VERSION}
                """
}
