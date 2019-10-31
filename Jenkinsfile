@Library('QPS-Pipeline')_
stage('build') {
    steps {
    echo "Hello World!"
    import com.qaprosoft.jenkins.pipeline.runner.maven.QARunner
    new com.qaprosoft.jenkins.pipeline.runner.maven.QARunner(this).onPush()
    }
}
