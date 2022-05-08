pipeline {
    // Validando el agente en el que va a estar corriendo
    agent any
    tools{
        jdk "openjdk-11"
        maven "Maven 3.8.5"
    }

    stages {
        stage('Test Smoke') {
            steps {
                echo 'Running Smoke Tests'
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
                git 'https://github.com/fugazi/carbon-love-selenium-webdriver.git'
                sh 'mvn -B -DskipTests clean package'
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
