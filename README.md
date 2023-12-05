# Restaurant Collection API Project

This is my project that can be run using Docker.

## Requirements

* Docker

## Installation:

1. Clone the repository: git clone https://github.com/npoank/restaurant-collection-api.git
2. Open a command prompt or terminal window. Navigate to the root directory of your Spring Boot project. This is typically the directory where pom.xml file is located. Run the following command:

        mvn install

4. The project includes a docker-compose.yml file that can be used to run the project with Docker Compose. Following the steps:
   * Open a command prompt or terminal window. Navigate to the root directory of this project where the docker-compose.yml file is located.
   * Run the following command to start the application using docker-compose:

          docker-compose up

5. This will start the project and expose the REST endpoint at `http://localhost:8080/`
6. All APIs implemented in this application are listed in technical_assignment file in root directory of this project.
7. Once you've followed these steps, this application should be up and running. You can stop the application by running the following command:
      
          docker-compose down

    This command will stop all containers defined in docker-compose.yml file.