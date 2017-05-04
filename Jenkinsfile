node{
        stage('SCM Checkout') {

                    def credential = credential(readFile('pom.xml'))
                    if (credential) {
                        echo "Building credential ${credential}"
                        // credential = credential.replace(".", "-")
                        env.CREDENTIAL = credential
                        echo "env.Building credential ${env.CREDENTIAL}"
                    }

                    def giturl = giturl(readFile('pom.xml'))
                    if (giturl) {
                        echo "Building giturl ${giturl}"
                        // giturl = giturl.replace(".", "-")
                        env.GITURL = giturl
                        echo "env.Building giturl ${env.GITURL}"
                    }

                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: 'origin/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [],//[[$class: 'CleanCheckout']], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[
                        credentialsId: '${env.CREDENTIAL}',
                        url: '${env.GITURL}',
                        remote: 'origin',
                        fetch: '+refs/heads/*:refs/remotes/origin/* +refs/merge-requests/*/head:refs/remotes/origin/merge-requests/*'
                        ]]
                ])

        }

        configFileProvider(
        [configFile(fileId: '1840430d-b0ba-486a-be42-c97116317ef3', variable: 'MAVEN_SETTINGS')]){
        stage('Build & Unit Testing'){


            def mvnCmd = "mvn -s $MAVEN_SETTINGS -B clean install -X -Dmaven.timezone='Asia/Bangkok'"
            withEnv(["PATH+MAVEN=${tool 'mavenlocal'}/bin"]) {
            sh mvnCmd
            }

        }

        }

        stage('Static Code Analysis'){
            step([$class: 'CheckStylePublisher', pattern: 'target/checkstyle-result.xml'])
            step([$class: 'PmdPublisher', pattern: 'target/pmd.xml'])
            step([$class: 'FindBugsPublisher', pattern: 'target/findbugsXml.xml'])
            step([$class: 'JacocoPublisher',classPattern:'**/classes', execPattern: '**/**.exec', exclusionPattern: '**/*Test*', sourcePattern: '**/src/main/java'])

            //-Dcheckstyle.skip
            // def mvnCmd = "mvn checkstyle:check pmd:check pmd:cpd-check findbugs:check -X -Dmaven.timezone='Asia/Bangkok' -Dmaven.repo.local=${WORKSPACE}/.repository"
            // step([$class: 'PmdPublisher', canComputeNew: false, defaultEncoding: '', pattern: 'build/logs/pmd.xml', alwaysLinkToLastBuild: true, healthy: '', unHealthy: ''])
            // step([$class: 'CheckStylePublisher', pattern: '/target/checkstyle-result.xml', unstableTotalAll:'0',unhealthy:'100', healthy:'100'])
            // step([$class             : 'FindBugsPublisher', canComputeNew      : false,    pattern            : '**/findbugs/*.xml',   unstableTotalHigh  : '0'  unstableTotalNormal: '5',      unstableTotalLow   : '10'] )
        }
}

@NonCPS
def credential(text) {
  def matcher = text =~ '<credential>(.+)</credential>'
  matcher ? matcher[0][1] : null
}

@NonCPS
def giturl(text) {
  def matcher = text =~ '<giturl>(.+)</giturl>'
  matcher ? matcher[0][1] : null
}