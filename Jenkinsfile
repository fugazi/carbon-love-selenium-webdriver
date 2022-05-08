pipeline {
    // Validando el agente en el que va a estar corriendo
    agent any
    tools{
        jdk "jdk-11"
        maven "Maven 3.8.5"
    }

    stages {
        stage('Test Smoke') {
            steps {
                echo 'Running Smoke Tests'
                git 'https://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@github.com/fugazi/carbon-love-selenium-webdriver.git'
                sh 'mvn clean'
            }
            post {
                success {
                    echo 'Smoke Test has been completed!'                
                }
            }
        }
        stage('Test Regression') {
            steps {
                echo 'Running Regression Tests'
            }
            post {
                success {
                    echo 'Regression Test has been completed!' 
                }
            }
        }
    }
}
