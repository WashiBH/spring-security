pipeline {
  stage("Clone project") {
    git branch: 'main', url: 'https://github.com/WashiBH/spring-security.git'
  }

  stage("Build project with test execution") {
    sh "mvn clean install"
  }
}