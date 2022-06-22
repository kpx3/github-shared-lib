import groovy.json.JsonSlurperClassic
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  last_started = env.STAGE_NAME
                echo 'Provisioning '
                sh """
                . ${data.PYTHON_FW_ENV}
                cd \$OOW_HOME/main/otmociwf
                python -u invoke_workflow.py --workflow=provisioning_workflow --release=${params.data.OTM_RELEASE} --patch_version=${params.data.OTM_VERSION} --db_name=${params.data.DB_NAME} --service_name_suffix=${params.SuffixName} --pod_size=${params.POD_SIZE} --db_node=otm-dev-phx-ad1-mvqnq1.exaclientsub1.zone2phx1exa.oraclevcn.com --skip_db_reset=${params.SkipDBReset}
                """
                echo "Provisioning done"
                echo "Sleep for sometime before QA testing"
                sleep 300 
                }
