/*
 * If you ever need some clarification on some methods, go to the equations.txt file which has links to sites
 * which contain many of the methods that we see.
 */
package SolarSystem;

import java.io.IOException;
import static java.lang.Math.pow;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 *
 * @author Gabe
 */
public class JavaFXMain extends Application {

    private PathTransition pathTransition = new PathTransition();
    private PathTransition pathTransition2 = new PathTransition();
    private PathTransition pathTransitionEllipse;
    private PathTransition pathTransitionCircle;
    private Algorithms calculator = new Algorithms();

    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane root = new BorderPane();
        Image stars = new Image("https://i.ytimg.com/vi/T40NSkd7Olc/maxresdefault.jpg"); //URL for the background image
        ImagePattern pattern = new ImagePattern(stars); //Sets up an image pattern that is based off of the stars.
        Scene scene = new Scene(root, 800, 800);
        scene.setFill(pattern); //Sets the background of the scene to be the following.
        primaryStage.setScene(scene);
        /*
        String absPath = "";                            //Initialize the string for the path to song
        File file = new File("src/Day_N_Nite.mp3");     // The source file. Need the immediate folder it is in so this works.
        absPath = file.getAbsolutePath();
        //Gets the absolute path to the file

        String musicFile = "file://";                   // When putting this into media, file has to start with "file://"
        musicFile = musicFile.concat(absPath);          //Concatenates the absolute path with the beginning
        System.out.println(musicFile);
        // For the string of the file, it was neccessary to write "file://" because the double slash allows
        // us to start from any directory. Then, I had to add an extra slash after that followed by the
        // first directory I wanted to start in. The way I got it here made it possible to play it on my computer,
        // so it's possible to get it working if we follow similar on the linux computers when we put it there.

        Media sound = new Media(musicFile);     //Create the media by directly putting the file name into it. Nothing else is needed.
        MediaPlayer mediaPlayer = new MediaPlayer(sound);  //Create the media player by using the media object just created
        mediaPlayer.setAutoPlay(true);                      //Automatically begins playing the music. Can turn this off and set them to buttons easily if we'd like.
        mediaPlayer.setVolume(0.1);     */                    //Sets volume to a tenth of it's original volume.

        Planet earth = new Planet("Earth", 152100000, 147100000, 20100023, 5.972 * pow(10, 24), 2, 100);
        Planet mars = new Planet("Mars", 249.23 * pow(10, 6), 206.92 * pow(10, 6), 3389.279464, 0.64171 * pow(10, 24), 20, 12);
        Planet jupiter = new Planet("Jupter", 816.62 * pow(10, 6), 740.52 * pow(10, 6), 69911.513, 1898.19 * pow(10, 24), 8, 8);

        primaryStage.show();

        Sphere sphere = new Sphere(15); //Create a sphere that has a raidus of 10
        Sphere sphere2 = new Sphere(15);
        Sphere sphere3 = new Sphere(15);
        Sphere sun = new Sphere(20);

        //Adding material to spheres
        PhongMaterial mat = new PhongMaterial();
        Image diffuseMap = new Image("file:earth.png");
        mat.setDiffuseMap(diffuseMap);

        PhongMaterial mat2 = new PhongMaterial();
        Image diffuseMap2 = new Image("file:mars.jpg");
        mat2.setDiffuseMap(diffuseMap2);

        sphere.setMaterial(mat);
        sphere.setDrawMode(DrawMode.FILL);
        sphere2.setMaterial(mat2);
        sphere2.setDrawMode(DrawMode.FILL);

        //CENTERING THE SUN
        sun.relocate(primaryStage.getWidth() / 2, primaryStage.getHeight() / 2); // This will give you the center of the created Scene

        double centerX = calculator.calculateCenterX(primaryStage, earth.getEccentricity(), earth.getSemiMajorAxis(), earth.getApoapsisDistanceFromSun());
        double centerY = calculator.calculateCenterY(primaryStage);
        double semiMajorAxisCoords = calculator.calculateCoordsConversion(earth.getSemiMajorAxis());
        double semiMinorAxisCoords = calculator.calculateCoordsConversion(earth.getSemiMinorAxis());
        double apoapsisDistanceCoords = calculator.apoapsisCoordsConversion(earth.getApoapsisDistanceFromSun());
        double inclination = earth.getInclination();
        Path path = calculator.createEllipsePath(centerX, centerY, semiMajorAxisCoords, semiMinorAxisCoords, inclination);
        pathTransition = calculator.createPathTransition(earth.getPeriod(), sphere, path);

        centerX = calculator.calculateCenterX(primaryStage, mars.getEccentricity(), mars.getSemiMajorAxis(), earth.getApoapsisDistanceFromSun());
        centerY = calculator.calculateCenterY(primaryStage);
        semiMajorAxisCoords = calculator.calculateCoordsConversion(mars.getSemiMajorAxis());
        semiMinorAxisCoords = calculator.calculateCoordsConversion(mars.getSemiMinorAxis());
        inclination = mars.getInclination();
        Path path2 = calculator.createEllipsePath(centerX, centerY, semiMajorAxisCoords, semiMinorAxisCoords, inclination);
        pathTransition2 = calculator.createPathTransition(mars.getPeriod(), sphere2, path2);
        pathTransition2.play();

        centerX = calculator.calculateCenterX(primaryStage, jupiter.getEccentricity(), jupiter.getSemiMajorAxis(), jupiter.getApoapsisDistanceFromSun());
        centerY = calculator.calculateCenterY(primaryStage);
        semiMajorAxisCoords = calculator.calculateCoordsConversion(jupiter.getSemiMajorAxis());
        semiMinorAxisCoords = calculator.calculateCoordsConversion(jupiter.getSemiMinorAxis());
        inclination = mars.getInclination();
        Path path3 = calculator.createEllipsePath(centerX, centerY, semiMajorAxisCoords, semiMinorAxisCoords, inclination);
        PathTransition pathTransition3 = calculator.createPathTransition(jupiter.getPeriod(), sphere3, path3);
        pathTransition3.play();

        root.getChildren().add(sphere);
        root.getChildren().add(sphere2);
        root.getChildren().add(sphere3);
        root.getChildren().add(sun);
        root.getChildren().add(path);
        root.getChildren().add(path2);
        root.getChildren().add(path3);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
