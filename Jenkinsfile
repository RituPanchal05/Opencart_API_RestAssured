pipeline {
    agent any

    tools {
        maven 'Maven_3.8.6'  // Name from Jenkins global tools config
        jdk 'JDK_17'         // Also from Jenkins global config
    }

    environment {
        JAVA_HOME = "${tool 'JDK_17'}"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git credentialsId: 'your-credentials-id', url: 'https://github.com/RituPanchal05/Opencart_API_ResrAssured.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test -Dsurefire.suiteXmlFiles=testng.xml'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
