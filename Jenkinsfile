library 'bas'
node {
        echo env.BRANCH_NAME
        stage('SCM Checkout') {

                gitCheckout('27d4ffd5-bbb7-4b58-86ca-5a936720704e','https://github.com/bas80836255/tddkata.git')

        }

        stage('Build & Unit Testing'){
        
               mavenBuild()

        }

        stage('Static Code Analysis'){
            analyzeBas()

        }


}
    
@NonCPS
def version(text) {
  def matcher = text =~ '<version>(.+)</version>'
  matcher ? matcher[0][1] : null
}