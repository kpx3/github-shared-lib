import groovy.json.JsonSlurper
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def cfg = new groovy.json.JsonSlurper.parse(new File('./Parameters.json'))
  assert cfg instanceof Map
  sh "echo ${cfg}"
  last_started = env.STAGE_NAME
                sh """
                . ${cfg[PYTHON_FW_ENV]}
                cd \$OOW_HOME/main/otmociwf
                echo '${params.EnvironmentName}'
                python invoke_workflow.py --workflow=terminate_dr_workflow --release=${params.OTM_RELEASE} --environment_name=${params.EnvironmentName}
                """ 
}
