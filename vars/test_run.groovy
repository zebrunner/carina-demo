@Library('QPS-Pipeline')
import com.qaprosoft.jenkins.pipeline.runner.maven.QARunner

def mew() {
	echo "MEW-MEW-MEW-MEW-MEW"
	new com.qaprosoft.jenkins.pipeline.runner.maven.QARunner(this).onPush()
}
