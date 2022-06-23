import groovy.json.JsonSlurperClassic
def call(Map config = [:]) { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  def JOB_NAME = config.job
  sh "echo ${data}"
  last_started = env.STAGE_NAME
                 def testGroup = [:]
                 testGroup['sanitlyLite'] = {
                 echo 'Build SanityLite Test'
                 build(job: './pipelineOne')
                 parallel testGroup
                }
}
