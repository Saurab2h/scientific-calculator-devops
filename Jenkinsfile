pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        DOCKER_USER = "saurab2h"
        IMAGE_NAME = "scientific-calculator"
    }

    stages {

        stage('Git Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/Saurab2h/scientific-calculator-devops.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_USER/$IMAGE_NAME -f docker/Dockerfile .'
            }
        }

        stage('Push Docker Image to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS')]) {

                    sh '''
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    docker push $DOCKER_USER/$IMAGE_NAME
                    '''
                }
            }
        }

        stage('Cleanup Docker Images') {
            steps {
                sh 'docker rmi $DOCKER_USER/$IMAGE_NAME || true'
            }
        }
    }
}
