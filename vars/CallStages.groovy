def call (){
  pipeline {
    agent {
      any
    }
    stage("tts"){
      TerminateStby(job:"22B")
    }
  }
}
