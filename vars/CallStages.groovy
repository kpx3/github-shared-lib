def call (Map config=[:]){
 def stage = config.stage
 case(stage)
 case "ZDT":
 
 pipeline {
    agent any
        stages {
            stage('ProvisionPrimary'){
                steps {
                     ProvisionPrimary(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
            stage('TerminateStby'){
                steps {
                     TerminateStby(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
        }
 }
 break;
 
 case "Migration":
 pipeline {
    agent any
        stages {
            stage('ProvisionPrimary'){
                steps {
                     ProvisionPrimary(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
            stage('TerminateStby'){
                steps {
                     TerminateStby(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
        }
 }
 break;
}
