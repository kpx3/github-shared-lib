import groovy.json.JsonSlurperClassic
def call() { 
  def props = libraryResource("foo/Parameters.json")
  def data = new JsonSlurperClassic().parseText(props)
  sh "echo ${data}"
  last_started = env.STAGE_NAME
                 def testGroup = [:]
                 testGroup['sanitlyLite'] = {
                 echo 'Build SanityLite Test'
                 build(job: './QA/22A_DR_SanityLite')
                 parallel testGroup
                }
}
