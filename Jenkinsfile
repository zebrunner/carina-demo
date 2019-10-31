@Library('QPS-Pipeline')_
import com.qaprosoft.jenkins.pipeline.runner.maven.QARunner

stage('build') {
    steps {
    echo "Hello World!"
    new com.qaprosoft.jenkins.pipeline.runner.maven.QARunner(this).onPush()
    }
}
