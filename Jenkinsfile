node {
        echo env.BRANCH_NAME
        stage('SCM Checkout') {
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: 'origin/${env.BRANCH_NAME}']],
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
            gitlabCommitStatus("build") {

                configFileProvider(
                        [configFile(fileId: '720fc814-8d86-46d9-ac73-b0eb1b5c3d03', variable: 'MAVEN_SETTINGS')]){
                            //Define maven command
                                            def mvnCmd = "mvn -s $MAVEN_SETTINGS -B clean install -X -Dmaven.timezone='Asia/Bangkok' -Dmaven.repo.local=${WORKSPACE}/.repository"

                                            withEnv([
                                               'MAVEN_OPTS=-Xmx1024m -Xms1024m -Xdebug',
                                               'HOME=.',
                                            ]) {
                                                // Run maven command
                                                sh mvnCmd
                                            }
                                            // Vote up on merge request
                                            addGitLabMRComment comment: ':+1:'

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
def version(text) {
  def matcher = text =~ '<version>(.+)</version>'
  matcher ? matcher[0][1] : null
}