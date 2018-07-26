// ["dev", "qa", "uat"]
def copyConfigFile(environment) {
    sh "cp ./config/$environment/index.js ./config"
}
def getApproval(environment = "UAT") {
    try {
        timeout(time: 12, unit: 'HOURS') {
            input message: "build $environment version?"
        }
        return true
    } catch (err) {
        // catch timeout or aborting error.
        return false
    }
}

stage('Build DEV') {
    node {
        copyConfigFile "dev"

        injectEnvironments({
            dir("android") {
                sh "echo dev in android directory"
            }
        })
    }
}

stage('Build UAT') {
    def isApproved = getApproval()

    if (isApproved) {
        node {
            copyConfigFile "uat"

            injectEnvironments({

                dir("android") {
                    sh "echo uat in android directory"
                }
            })
        }
    }
}