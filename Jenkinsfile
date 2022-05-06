pipeline {
    // Validando el agente en el que va a estar corriendo
    agent any
    tools{
        maven "Maven 3.8.5"
        jdk "jdk-11"
    }

    stages {
        stage('Test Smoke') {
            steps {
                echo 'Running Smoke Tests'
                git 'https://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@github.com/fugazi/carbon-love-selenium-webdriver.git'
                sh 'mvn clean install -Dmaven.test.failure.ignore=true install'
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
