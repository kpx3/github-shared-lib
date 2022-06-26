import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/JobParameters.json") //loading parameter from the json
  def data = new JsonSlurperClassic().parseText(props)
  def JOB = config.job

  sh " JOB=config.job echo $data $config.job $JOB_NAME"
  last_started = env.STAGE_NAME
                sh """
                $JOB=$config.job
                python ${data.PYTHON_FW_ENV}      #running a python file       
                JOB_NAME=${config.job}
                echo  ${data.EnvironmentName} ${data.OTM_RELEASE} ${data.serviceNameSuffix}
                """ 
}
