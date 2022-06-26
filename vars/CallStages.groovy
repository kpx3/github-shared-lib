def call (){
  pipeline {
    agent none
    stage("tts"){
      TerminateStby(job:"22B")
    }
  }
}
