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

        stage('Start zipkin') {
            steps {
                //sh 'docker-compose up --build -d'
                bat 'docker run -d --net microservices-net -p 9411:9411 openzipkin/zipkin'
             }
         }

        stage('Start rabbitmq') {
            steps {
                //sh 'docker-compose up --build -d'
                bat 'docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4.0-management'
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
