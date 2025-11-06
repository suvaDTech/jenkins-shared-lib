def call(){
  sh '''
      docker ps -q --filter "publish=80" | xargs -r docker stop
      docker ps -aq --filter "publish=80" | xargs -r docker rm
     '''
  sh "docker-compose down && docker-compose up -d"
}
