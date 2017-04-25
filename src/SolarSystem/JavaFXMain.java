/*
 * If you ever need some clarification on some methods, go to the equations.txt file which has links to sites
 * which contain many of the methods that we see.
 */
package SolarSystem;

import static SolarSystem.Constants.*;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

/**
 *
 * @author Gabe
 */
public class JavaFXMain extends Application {

    private PathTransition pathTransition = new PathTransition();
    private PathTransition pathTransition2 = new PathTransition();
    private PathTransition pathTransition3 = new PathTransition();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Image stars = new Image("https://i.ytimg.com/vi/T40NSkd7Olc/maxresdefault.jpg"); //URL for the background image
        ImagePattern pattern = new ImagePattern(stars); //Sets up an image pattern that is based off of the stars.
        Scene scene = new Scene(root, 800, 800);
        scene.setFill(pattern); //Sets the background of the scene to be the following.
        primaryStage.setScene(scene);
        //Sets volume to a tenth of it's original volume.

        Planet earth = new Planet("Earth", EARTHAPOAPSIS, EARTHPERIAPSIS, EARTHRADIUS, EARTHMASS, EARTHINCLINATION);
        Planet mars = new Planet("Mars", MARSAPOAPSIS, MARSPERIAPSIS, MARSRADIUS, MARSMASS, MARSINCLINATION);
        Planet jupiter = new Planet("Jupter", JUPITERAPOAPSIS, JUPITERPERIAPSIS, JUPITERRADIUS, JUPITERMASS, JUPITERINCLINATION);
        Planet venus = new Planet("Venus", VENUSAPOAPSIS, VENUSPERIAPSIS, VENUSRADIUS, VENUSMASS, VENUSINCLINATION);
        Planet mercury = new Planet("Mercury", MERCURYAPOAPSIS, MERCURYPERIAPSIS, MERCURYRADIUS, MERCURYMASS, MERCURYINCLINATION);
        Planet saturn = new Planet("Saturn", SATURNAPOAPSIS, SATURNPERIAPSIS, SATURNRADIUS, SATURNMASS, SATURNINCLINATION);
        Planet uranus = new Planet("Uranus", URANUSAPOAPSIS, URANUSPERIAPSIS, URANUSRADIUS, URANUSMASS, URANUSINCLINATION);
        Planet neptune = new Planet("Neptune", NEPTUNEAPOAPSIS, NEPTUNEPERIAPSIS, NEPTUNERADIUS, NEPTUNEMASS, NEPTUNEINCLINATION);
        Planet pluto = new Planet("Pluto", PLUTOAPOAPSIS, PLUTOPERIAPSIS, PLUTORADIUS, PLUTOMASS, PLUTOINCLINATION);

        Sun sun = new Sun("Sun", SUNRADIUS, SUNMASS);
        SolarSystem test = new SolarSystem("New");
        earth.setStyle(EARTHIMAGE);
        mars.setStyle(MARSIMAGE);
        jupiter.setStyle(JUPITERIMAGE);
        venus.setStyle(VENUSIMAGE);
        sun.setStyle(SUNIMAGE);
        mercury.setStyle(MERCURYIMAGE);
        saturn.setStyle(SATURNIMAGE);
        uranus.setStyle(URANUSIMAGE);
        neptune.setStyle(NEPTUNEIMAGE);
        pluto.setStyle(PLUTOIMAGE);

        test.addPlanet(sun);
        test.addPlanet(mars);
        test.addPlanet(earth);
        test.addPlanet(venus);
        test.addPlanet(jupiter);
        test.addPlanet(mercury);
        test.addPlanet(saturn);
        test.addPlanet(uranus);
        test.addPlanet(neptune);
        test.addPlanet(pluto);

        primaryStage.show();

        test.setSystemToRoot(root); // A function that adds the solar system to the root

    }

    public static void main(String[] args) {
        launch(args);
    }
}
