def call (Map config=[:]){
 
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
}
