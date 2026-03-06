pipeline {
agent any

```
environment {
    IMAGE_NAME = "scientific-calculator"
}

stages {

    stage('Clone Repo') {
        steps {
            git branch: 'main',
            url: 'git@github.com:Poojan-Pandyaa/SPE_MiniProject_Scientific_Calc.git'
        }
    }

    stage('Build') {
        steps {
            sh 'mvn clean package'
        }
    }

    stage('Run Tests') {
        steps {
            sh 'mvn test'
        }
    }

    stage('Build Docker Image') {
        steps {
            sh 'docker build -t $IMAGE_NAME -f docker/Dockerfile .'
        }
    }

    stage('Push Docker Image to DockerHub') {
        steps {
            withCredentials([usernamePassword(
                credentialsId: 'dockerhub-creds',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS'
            )]) {

                sh '''
                echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                docker tag $IMAGE_NAME $DOCKER_USER/$IMAGE_NAME
                docker push $DOCKER_USER/$IMAGE_NAME
                '''
            }
        }
    }

    stage('Cleanup Docker Images') {
        steps {
            sh 'docker rmi $IMAGE_NAME || true'
        }
    }

    stage('Ansible Deployment') {
        steps {
            sh '''
            if ! command -v ansible >/dev/null 2>&1; then
                echo "Installing Ansible..."
                sudo apt update
                sudo apt install -y ansible
            fi

            ansible-playbook ansible/deploy.yml
            '''
        }
    }

}

post {

    success {
        emailext(
            subject: "Jenkins Build SUCCESS",
            body: "Scientific Calculator pipeline completed successfully.",
            to: "your-email@gmail.com"
        )
    }

    failure {
        emailext(
            subject: "Jenkins Build FAILED",
            body: "Scientific Calculator pipeline failed. Check Jenkins logs.",
            to: "your-email@gmail.com"
        )
    }

}
```

}

