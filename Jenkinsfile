pipeline {
    agent any
    tools{
            maven 'maven-3.5.2'
    }
    stages {
        stage('Pull From Git') {
            steps {
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/stockgit/m1_report_service.git'
            }
        }
        stage('Test') {
            steps {
                // Build your Spring Boot application using Maven
                echo 'Test with Maven'
                //sh 'mvn clean install'
                bat 'mvn clean test'
            }
        }
        stage('Package') {
            steps {
                // Build your Spring Boot application using Maven
                echo 'Package'
                //sh 'mvn package'
                bat 'mvn package'
            }
        }
        stage('Deploy to Docker Compose') {
            steps {
                //sh 'docker-compose up --build -d'
                bat 'docker-compose down -v'
                bat 'docker-compose up --build -d'
            }
        }
        stage('Success') {
            steps {
                echo 'Deploy Successfully'
            }
        }
    }
}
