pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
    
        stage('Compile and Clean') {
            steps {
                echo "mvn clean"
                git 'https://github.com/zvikasp/DockerTest.git'
				sh "mvn clean"
            }
        }
        
        stage('deploy') {
            steps {
                echo "mvn install"
				sh "mvn install"
            }
        }

        stage('Build Docker image') {
            steps {
                echo "Build Docker image"
				sh 'docker build -t zvikasp/docker-demo_spingboot:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login') {
            steps {
                echo "Docker Login"
				WithCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
				sh 'docker login -u zvikasp -p ${Dockerpwd}'
				}
			}	
        }		

        stage('Docker Push') {
            steps {
                echo "Docker Push"
				sh 'docker push zvikasp/docker-demo_spingboot:${BUILD_NUMBER}'
            }
        }

        stage('Docker deploy') {
            steps {
                echo "Docker deploy"
				sh 'docker run -itd -p 9091:8080 zvikasp/docker-demo_spingboot:${BUILD_NUMBER}'
			}            
        }

        stage('Archiving') {
            steps {
                echo "Archiving"
				archiveArtifacts '**target/*.jar'
			}        
        }
    }
}
