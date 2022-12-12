def call(String configJsonPath = "PipelineConfig.json", def body) {
    node {
        // Git checkout before load source the file
        // checkout scm
        stage('Build') {
            JenkinsHelper jenkinsHelper = new JenkinsHelper()
            jenkinsHelper.callEcho("Use JenkinsHelper")
        }
    }
}
