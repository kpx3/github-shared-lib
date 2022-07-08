def call (){
 
 pipeline {
    agent any
        stages {
            stage('TerminateStby'){
                steps {
                 TerminateStby(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
            stage('ProvisionPrimary'){
                steps {
                 ProvisionPrimary(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
          stage('ProvisionStby'){
                steps {
                 ProvisionStby(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
          stage('PreSwitchoverTesting'){
                steps {
                 PreSwitchoverTesting(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
          stage('Switchover'){
                steps {
                 Switchover(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
          stage('PostSwitchoverTesting'){
                steps {
                 PostSwitchoverTesting(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
        }
 }
}
