pipeline {
    agent { label 'master' }
    stages {
        stage('build') {
            steps {
                echo "Hello World!"
                Library('QPS-Pipeline')
                import com.qaprosoft.jenkins.pipeline.runner.maven.QARunner
                new com.qaprosoft.jenkins.pipeline.runner.maven.QARunner(this).onPush()
            }
        }
    }
}
