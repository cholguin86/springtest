pipeline{
    agent any
    options {
      timestamps()
    }
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
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