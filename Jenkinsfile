pipeline {
    // Validando el agente en el que va a estar corriendo
    agent any
    tools{
        maven "Maven 3.8.5"
    }

    stages {
        stage('Test Smoke') {
            steps {
                echo 'Running Smoke Tests'
                git 'https://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@github.com/fugazi/carbon-love-selenium-webdriver.git'
                sh 'mvn clean install -Denvironment="$environment"'
                echo 'Smoke Test has been completed!'
            }
        }
        stage('Test Regression') {
            steps {
                echo 'Running Regression Tests'
            }
        }
    }
}
