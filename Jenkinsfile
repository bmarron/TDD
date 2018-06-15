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
        sh 'mvn clean site:site'
      }
    }
  }
  post {
      always {
        junit '**/surefire-reports/*.xml'
        step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])
      }
    }
  environment {
    ENV1 = 'formation'
  }
}
