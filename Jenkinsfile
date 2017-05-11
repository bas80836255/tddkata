library 'bas'
node {
        echo env.BRANCH_NAME
        stage('SCM Checkout') {
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: 'origin/'+env.BRANCH_NAME]],
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [],//[[$class: 'CleanCheckout']], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[
                        credentialsId: '27d4ffd5-bbb7-4b58-86ca-5a936720704e',
                        url: 'https://github.com/bas80836255/tddkata.git',
                        remote: 'origin',
                        fetch: '+refs/heads/*:refs/remotes/origin/* +refs/merge-requests/*/head:refs/remotes/origin/merge-requests/*'
                        ]]
                ])

            def version = version(readFile('pom.xml'))
            if (version) {
                echo "Building version ${version}"
                // version = version.replace(".", "-")
                env.BUILD_VERSION = version
                echo "env.Building version ${env.BUILD_VERSION}"
            }

        }

        stage('Build & Unit Testing'){
                configFileProvider(
                        [configFile(fileId: '1840430d-b0ba-486a-be42-c97116317ef3', variable: 'MAVEN_SETTINGS')]){
                            //Define maven command
                                            def mvnCmd = "mvn -s $MAVEN_SETTINGS -B clean install -X -Dmaven.timezone='Asia/Bangkok'"
                                                        withEnv(["PATH+MAVEN=${tool 'mavenlocal'}/bin"]) {
                                                        sh mvnCmd
                                                        }

                        }




        }

        stage('Static Code Analysis'){
            Analyze 'hello'
            }


}
    
@NonCPS
def version(text) {
  def matcher = text =~ '<version>(.+)</version>'
  matcher ? matcher[0][1] : null
}