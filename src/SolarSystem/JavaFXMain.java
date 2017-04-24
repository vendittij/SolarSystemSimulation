/*
 * If you ever need some clarification on some methods, go to the equations.txt file which has links to sites
 * which contain many of the methods that we see.
 */
package SolarSystem;

import java.io.File;
import static java.lang.Math.pow;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
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
    private PathTransition pathTransition3 = new PathTransition();
    private Algorithms calculator = new Algorithms();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Image stars = new Image("https://i.ytimg.com/vi/T40NSkd7Olc/maxresdefault.jpg"); //URL for the background image
        ImagePattern pattern = new ImagePattern(stars); //Sets up an image pattern that is based off of the stars.
        Scene scene = new Scene(root, 800, 800);
        scene.setFill(pattern); //Sets the background of the scene to be the following.
        primaryStage.setScene(scene);

        String absPath = "";                            //Initialize the string for the path to song
        File file = new File("src/Day_N_Nite.mp3");     // The source file. Need the immediate folder it is in so this works.
        absPath = file.getAbsolutePath();               //Gets the absolute path to the file

        String musicFile = "file://";                   // When putting this into media, file has to start with "file://"
        musicFile = musicFile.concat(absPath);          //Concatenates the absolute path with the beginning
        // For the string of the file, it was neccessary to write "file://" because the double slash allows
        // us to start from any directory. Then, I had to add an extra slash after that followed by the
        // first directory I wanted to start in. The way I got it here made it possible to play it on my computer,
        // so it's possible to get it working if we follow similar on the linux computers when we put it there.

        // Media sound = new Media(musicFile);     //Create the media by directly putting the file name into it. Nothing else is needed.
        //MediaPlayer mediaPlayer = new MediaPlayer(sound);  //Create the media player by using the media object just created
        //mediaPlayer.setAutoPlay(true);                      //Automatically begins playing the music. Can turn this off and set them to buttons easily if we'd like.
        //mediaPlayer.setVolume(0.1);                         //Sets volume to a tenth of it's original volume.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Planet earth = new Planet("Earth", 152100000, 147100000, 6000, 5.972 * pow(10, 24), 2, 100);
        Planet mars = new Planet("Mars", 249.23 * pow(10, 6), 206.92 * pow(10, 6), 3389.279464, 0.64171 * pow(10, 24), 20, 12);
        Planet jupiter = new Planet("Jupter", 816.62 * pow(10, 6), 740.52 * pow(10, 6), 69911.513, 1898.19 * pow(10, 24), 8, 8);
        Planet venus = new Planet("Venus", 108.939 * pow(10, 6), 107.477 * pow(10, 6), 6000, 4.8 * pow(10, 24), 20, 12);
        SolarSystem test = new SolarSystem("New");
        test.addPlanet(mars);
        test.addPlanet(earth);
        test.addPlanet(venus);
        test.addPlanet(jupiter);

        primaryStage.show();

        Sphere sun = new Sphere(20);

        sun.relocate(primaryStage.getWidth() / 2, primaryStage.getHeight() / 2); // This will give you the center of the created Scene

        root.getChildren().add(sun);
        test.setSystemToRoot(root, primaryStage); // A function that adds the solar system to the root

    }

    public static void main(String[] args) {
        launch(args);
    }
}
