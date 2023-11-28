pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clona el repositorio desde tu sistema de control de versiones (puede requerir configuración de credenciales)
                git branch: 'main', url: 'https://github.com/WashiBH/spring-security.git'
            }
        }

        stage('Build') {
            steps {
                // Ejecuta el comando Maven para limpiar e instalar el proyecto
                script {
                    def mavenHome = tool 'Maven' // 'Maven' debe coincidir con el nombre del JDK configurado en Jenkins
                    def mavenCmd = "${mavenHome}/bin/mvn"
                    sh "${mavenCmd} clean install"
                }
            }
        }
    }

    post {
        success {
            // Acciones a realizar si la compilación tiene éxito
            echo 'Build successful!'

            // Puedes agregar pasos adicionales aquí, como despliegues o notificaciones
        }
        failure {
            // Acciones a realizar si la compilación falla
            echo 'Build failed!'
        }
    }
}
