# PWA / Web App for WordPress

This is an old project that I decided to share. It is to displays all posts that are published. Please keep in mind that this app is an old project that has been developed in 2019.

## Set Up

In order to start and deploy this application, there are a few steps that need to be followed. Please keep in mind that this is an old project, that has been developed in 2019.

1. To begin with, open application.properties and make the necessary changes, such as setting up database credentials.
2. If you are using Member Press, it is important to keep everything as it is. Otherwise, delete the classes named mbpr.
3. Add your logo.png and logo.svg file to the images folder.
4. Lastly, session storage is not yet implemented in this project, so keep that in mind.

## Known Issues

Session storage is not implemented yet.

## Conclusion

This is a simple project to display all posts. It should show a list of posts for an established database [from WordPress]. It mostly is a first attempt at creating a PWA/ Web App that displays WordPress posts and converts them into Java objects.

## Running the application

The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

## Deploying to Production

To create a production build, call `mvnw clean package -Pproduction` (Windows),
or `./mvnw clean package -Pproduction` (Mac & Linux).
This will build a JAR file with all the dependencies and front-end resources,
ready to be deployed. The file can be found in the `target` folder after the build completes.

Once the JAR file is built, you can run it using
`java -jar target/heallifeapp-1.0-SNAPSHOT.jar`

## Project structure

- `MainView.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `frontend/` contains the client-side JavaScript views of your application.
- `themes` folder in `frontend/` contains the custom CSS styles.

## Deploying using Docker

To build the Dockerized version of the project, run

```
docker build . -t hl:latest
```

Once the Docker image is correctly built, you can test it locally using

```
docker run -p 8080:8080 hl:latest
```
