pipeline {
    agent any

    stages {
        stage('Pull Code') {
            steps {
                echo 'Code pulled from GitHub!'
            }
        }
        stage('Build') {
            steps {
                echo 'Building Java project...'
                sh 'javac Selenium_Project/src/Package1/thirdbranch_test.java'
            }
        }
        stage('Run') {
            steps {
                echo 'Running the Java class...'
                sh 'java -cp Selenium_Project/src Package1.thirdbranch_test'
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
