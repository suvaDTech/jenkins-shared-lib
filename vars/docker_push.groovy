def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerhubCred', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
      sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
