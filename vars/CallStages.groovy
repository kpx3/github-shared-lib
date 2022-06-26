def call (){
 pipeline {
    agent any
        stages {
            stage('ProvisionPrimary'){
                steps {
                     ProvisionPrimary(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
        }
         stages {
            stage('TerminateStby'){
                steps {
                     TerminateStby(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
        }
 }
}
