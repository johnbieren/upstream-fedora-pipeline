def call(Map parameters = [:]) {
    def imageName = parameters.get('imageName')
    def cmd = """
              cd /
              curl -O https://pagure.io/upstream-fedora-ci/raw/master/f/fedora-ci-monitor/validate-test-subject.py && \
              rm -rf /tmp/artifacts && \
              pip install requests && \
              python validate-test-subject.py -s /${imageName} && \
              exit \$?
              """
    executeInContainer(containerName: 'singlehost-test', containerScript: cmd)

}
