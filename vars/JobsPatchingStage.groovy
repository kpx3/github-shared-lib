def call (){
 
 pipeline {
    agent any
        stages {
            stage('Patching'){
                steps {
                 Patching(job:"${JOB_NAME.minus("/" + JOB_BASE_NAME)}")
                }
            }
        }
 }
}
