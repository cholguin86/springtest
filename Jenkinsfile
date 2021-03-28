pipeline{
    agent any
    options {
      timestamps()
    }
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    
    environment {
      PATH_SONAR = tool"sonarqube-scanner"
      PROJECT_KEY = "sonar_pilot"
      EXCLUSIONS = "**/util/**,**/exception/**" 
	  BINARIES = "./src/main"      
    }
    

    stages{
        stage('Build') {
            steps {
              echo "Building..."
              sh '''              
              mvn clean install -DskipTests
              '''
            }
        }
        stage('Unit Test') {
            steps {
              echo "Building..."
              sh '''              
              mvn test -U -X
              mvn clean
              '''
            }
        }
        stage('SonarQube') {    
            agent any   
            steps {
              withSonarQubeEnv("sonarqube-scanner") {
                sh "${PATH_SONAR}/bin/sonar-scanner \
                -Dsonar.projectKey=${PROJECT_KEY} \
                -Dsonar.projectVersion=1 \
                -Dsonar.scm.disabled=true \
                -Dsonar.exclusions=${EXCLUSIONS} \
                -Dsonar.sources=src \
				-Dsonar.java.libraries=$HOME/.m2/**/*.jar \
				-Dsonar.java.binaries=${BINARIES} \
				-Dsonar.jacoco.reportPaths=target/jacoco.exec \
                -Dsonar.sourceEncoding=UTF-8"
              }                       
            }
        }       
    }
    post{
        success{
            echo "Excelente trabajo"                        
        }
        failure{
            echo "Fallo el proceso"                                                         
        }
    }
}