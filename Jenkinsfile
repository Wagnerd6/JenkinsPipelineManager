node {
    stage('Build') {
        echo "Build stage"    
    }

    stage('Test') {
            echo "Test stage"
            if(params.RUN_TESTS) {
                dir('build') {
                    sh 'bin/Product 7 8 2'
                    sh 'bin/Product_test'
                } 
            }
                
    }

    ('Deploy') {
        "Deploy stage"     
    }
}
