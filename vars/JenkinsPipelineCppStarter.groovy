def call(String configJsonPath = "PipelineConfig.json", def body) {
    node {
        // Git checkout before load source the file
        checkout scm

        stage('Test Pipeline Utility Steps plugin') {
            def json = readJSON(file: "PipelineConfig.json", returnPojo: true)
            println(json)
        }

        stage('Build') {
            echo "Build stage"
            sh 'rm -rf git_sed_jenkins_pipeline'
            sh 'git clone ssh://gitea@homer.sedenius.com:2222/ENGINEERING/git_sed_jenkins_pipeline.git'
            dir("git_sed_jenkins_pipeline") {
                dir("lib/googletest") {
                    //sh 'rm -rf googletest'
                    //sh 'git clone https://github.com/google/googletest'
                }
                dir("build") {
                    sh 'cmake -G "Unix Makefiles" -DCMAKE_BUILD_TYPE=Debug ..'
                    sh 'cmake --build .'
                }
            }

        }

        stage('Test') {
            echo "Test stage"
            //if(params.RUN_TESTS) {
            dir('git_sed_jenkins_pipeline/build') {
                sh 'bin/Product 7 8 2'
                sh 'bin/Product_test'
            }
            //}
        }

        stage('Deploy') {
            echo "Deploy stage"
        }
    }
}


