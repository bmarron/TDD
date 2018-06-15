pipeline {
  agent any
  stages {
    stage('setup') {
      parallel {
        stage('setup') {
          steps {
            echo 'Setup du job'
          }
        }
        stage('Dodo') {
          steps {
            sleep 3
          }
        }
      }
    }
    stage('Tests') {
      steps {
        sh 'mvn test'
      }
    }
    post {
      always {
        junit '**/surefire-reports/*.xml'
      }
    }
  }
  environment {
    ENV1 = 'formation'
  }
}
