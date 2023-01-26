pipeline {
    agent any
    environment {
        dockerHome = tool 'myDocker'
        PATH = "$dockerHome/bin:$PATH"
    }
    stages{
        stage("Checkout"){
            steps {
                sh 'docker version'
                sh 'mvn --version'
                echo "PATH $PATH"
                echo "Build number $BUILD_NUMBER"
                echo "Build TAG $BUILD_TAG"
                echo "Build_url $BUILD_URL"
            }
        }
        stage("Compile"){
                    steps {
                        sh 'mvn clean compile'
                    }
        }
        stage("Integration Test"){
            steps {
                 sh 'mvn test'
            }
        }
        stage("Package"){
            steps {
                  sh 'mvn package -DskipTests'
                  }
        }
        stage("Build Docker Image"){
                    steps {
                        script{
                          dockerImage = docker.build("yashkasat32/graphql-java:${env.BUILD_TAG}")

                        }
                    }
                }
        stage("Push Docker Image"){
                            steps {
                                script{
                                  dockerImage = docker.withRegistry('','dockerhub')
                                  dockerImage.push()
                                  dockerImage.push('latest')
                                }
                            }
                        }
    }
    post{
        always {
            echo "I run always"
        }
        success {
            echo "Great! Pipeline passed!!"
        }
        failure {
            echo "Sorry, Pipeline failed!!"
        }
    }
}