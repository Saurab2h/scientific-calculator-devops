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
                sh '''
                docker login -u saurab2h -p $DOCKER_PASSWORD
                docker push saurab2h/scientific-calculator
                '''
            }
        }

        stage('Cleanup Docker Images') {
            steps {
                sh 'docker rmi saurab2h/scientific-calculator || true'
            }
        }

        stage('Ansible Deployment') {
            steps {
                sh 'ansible-playbook ansible/deploy.yml || true'
            }
        }

    }
}
