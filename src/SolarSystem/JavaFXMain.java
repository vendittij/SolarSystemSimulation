/*
 * If you ever need some clarification on some methods, go to the equations.txt file which has links to sites
 * which contain many of the methods that we see.
 */
package SolarSystem;

import java.io.File;
import java.io.IOException;
import static java.lang.Math.pow;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Gabe
 */
public class JavaFXMain extends Application {

    private PathTransition pathTransition = new PathTransition();
    private PathTransition pathTransition2 = new PathTransition();
    private PathTransition pathTransitionEllipse;
    private PathTransition pathTransitionCircle;

    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane root = new BorderPane();
        Image stars = new Image("https://i.ytimg.com/vi/T40NSkd7Olc/maxresdefault.jpg"); //URL for the background image
        ImagePattern pattern = new ImagePattern(stars); //Sets up an image pattern that is based off of the stars.
        Scene scene = new Scene(root, 800, 800);
        scene.setFill(pattern); //Sets the background of the scene to be the following.
        primaryStage.setScene(scene);

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
        mediaPlayer.setVolume(0.1);                         //Sets volume to a tenth of it's original volume.

        Planet earth = new Planet("Earth", 152100000, 147100000, 20100023, 5.972 * pow(10, 24), 2, 100);
        Planet mars = new Planet("Mars", 249.23 * pow(10, 6), 206.92 * pow(10, 6), 3389.279464, 0.64171 * pow(10, 24), 20, 12);

        primaryStage.show();

        Sphere sphere = new Sphere(10); //Create a sphere that has a raidus of 10
        Sphere sphere2 = new Sphere(10);
        Sphere sun = new Sphere(20);

        sun.relocate(primaryStage.getWidth() / 2, primaryStage.getHeight() / 2); // This will give you the center of the created Scene
        //double centerX = primaryStage.getWidth() /2 + 120;
        double centerX = primaryStage.getWidth() / 2 + 100 + earth.getSemiMajorAxis() * earth.getSemiMinorAxis();
        double centerY = primaryStage.getHeight() / 2 + 20;

        System.out.println(primaryStage.getWidth());
        System.out.println(primaryStage.getHeight());
        System.out.println(centerX);
        System.out.println(centerY);

        Path path = createEllipsePath(centerX, centerY, earth.getSemiMajorAxis() * 100, earth.getSemiMinorAxis() * 100, 90); //Goes to the method and creates a proper ellipse
        path.getElements().add(new ClosePath()); //Ensures that the path is closed

        pathTransition.setDuration(Duration.seconds((earth.getPeriod() * 365 * 24 * 60 * 60) / 1000000));    //Controls how fast the planet is going
        pathTransition.setNode(sphere);                     //Puts the sphere on the path of the ellipse
        pathTransition.setPath(path);                       //Sets the path the sphere will follow as the ellipse
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);   //Not 100% sure what this does but it was in the example and it works
        pathTransition.setCycleCount(Timeline.INDEFINITE);                      //Makes this run forver until we say stop.
        pathTransition.setInterpolator(Interpolator.LINEAR);                    //Makes the runs between each iteration of the sphere going around the ellipse continuous instead of chopped up
        pathTransition.play();

        centerX = primaryStage.getWidth() / 2 + 100 + mars.getSemiMajorAxis() * mars.getSemiMinorAxis();
        centerY = primaryStage.getHeight() / 2 + 20;

        Ellipse ellipse = new Ellipse(centerX, centerY, mars.getSemiMajorAxis() * 100, mars.getSemiMinorAxis() * 100);

        Path path2 = createEllipsePath(ellipse.getCenterX(), ellipse.getCenterY(), mars.getSemiMajorAxis() * 100, mars.getSemiMinorAxis() * 100, 0);
        pathTransition2.setDuration(Duration.seconds(4));
        pathTransition2.setNode(sphere2);                     //Puts the sphere on the path of the ellipse
        pathTransition2.setPath(path2);                       //Sets the path the sphere will follow as the ellipse
        pathTransition2.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);   //Not 100% sure what this does but it was in the example and it works
        pathTransition2.setCycleCount(Timeline.INDEFINITE);                      //Makes this run forver until we say stop.
        pathTransition2.setInterpolator(Interpolator.LINEAR);                    //Makes the runs between each iteration of the sphere going around the ellipse continuous instead of chopped up
        pathTransition2.setOrientation(OrientationType.NONE);
        pathTransition2.play();

        root.getChildren().add(sphere);
        root.getChildren().add(sphere2);
        root.getChildren().add(sun);
        root.getChildren().add(path);
        root.getChildren().add(path2);

    }

    /**
     * *************************************************************************************
     * Title: Create Ellipse path Author: Uluk Biy Date: April 14th, 2017 Code
     * version: 1.0 Availability:
     * http://stackoverflow.com/questions/14171856/javafx-2-circle-path-for-animation
     *
     **************************************************************************************
     */
    private Path createEllipsePath(double centerX, double centerY, double radiusX, double radiusY, double rotate) {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree celcius circle.
        arcTo.setY(centerY - radiusY);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
        arcTo.setXAxisRotation(rotate);

        Path path = PathBuilder.create()
                .elements(
                        new MoveTo(centerX - radiusX, centerY - radiusY),
                        arcTo,
                        new ClosePath()) // close 1 px gap.
                .build();
        path.setStroke(Color.WHITE);
        return path;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
