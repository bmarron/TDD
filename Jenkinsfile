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
  }
  post {
      always {
        junit '**/surefire-reports/*.xml'
        step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])

      }
    }
  environment {
    ENV1 = 'formation'
  }
}
