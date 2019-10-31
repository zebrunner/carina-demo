echo "MEW-MEW-MEW-MEW-MEW"
@Library('QPS-Pipeline')
import com.qaprosoft.jenkins.pipeline.runner.maven.QARunner
new com.qaprosoft.jenkins.pipeline.runner.maven.QARunner(this).onPush()
