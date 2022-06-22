import groovy.json.JsonSlurperClassic
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  sh "echo ${data}"
last_started = env.STAGE_NAME
                echo 'Create DR'
                sh """
                . ${data.PYTHON_FW_ENV}
                cd \$OOW_HOME/main/otmociwf
                echo '${params.EnvironmentName}'
                python invoke_workflow.py --workflow=create_dr_workflow --release=${params.OTM_RELEASE} --environment_name=${params.EnvironmentName} --skip_stby_db_creation=False
                """
}
