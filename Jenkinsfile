pipeline {
    // Validando el agente en el que va a estar corriendo
    agent any
    tools{
        maven "Maven"
    }

    stages {
        stage('Test Smoke') {
            steps {
                echo 'Running Smoke Tests'
                git 'https://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@github.com/fugazi/carbon-love-selenium-webdriver.git'
                sh 'clean install -Denvironment="$environment"'
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
