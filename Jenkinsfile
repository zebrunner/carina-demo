@Library('QPS-Pipeline')_
import com.qaprosoft.jenkins.pipeline.runner.maven.QARunner

stage('build') {
    echo "Hello World!"
    new com.qaprosoft.jenkins.pipeline.runner.maven.QARunner(this).onPush()
}
