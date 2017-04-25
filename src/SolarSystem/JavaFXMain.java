/*
 * If you ever need some clarification on some methods, go to the equations.txt file which has links to sites
 * which contain many of the methods that we see.
 */
package SolarSystem;

import java.io.File;
import java.io.IOException;
import static java.lang.Math.pow;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
    public void start(Stage primaryStage) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        BorderPane root = new BorderPane();
        Image stars = new Image("http://i.imgur.com/PgYKaSd.jpg"); //URL for the background image
        ImagePattern pattern = new ImagePattern(stars); //Sets up an image pattern that is based off of the stars.
        Scene scene = new Scene(root, 1500, 1000);
        scene.setFill(pattern); //Sets the background of the scene to be the following.
        primaryStage.setScene(scene);

        //Music
        File file = new File("DayAndNight.mp3");
        String source = file.toURI().toString();
        AudioClip music = new AudioClip(source);
        music.play();
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

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-20, Rotate.Y_AXIS),
                new Rotate(90, Rotate.X_AXIS),
                new Translate(0, 0, -50));
        camera.setFieldOfView(1000);

        Sphere sphere = new Sphere(10); //Create a sphere that has a raidus of 10
        Sphere sphere2 = new Sphere(10 * .53);
        Sphere sphere3 = new Sphere(10 * 6);
        Sphere sun = new Sphere(20);

        //Adding material to spheres
        earth.setMapping("earth.png");
        mars.setMapping("mars.jpg");
        jupiter.setMapping("file:jupiter.jpg");

        PhongMaterial mat3 = new PhongMaterial();
        Image diffuseMap3 = new Image("file:Sun.jpg");
        mat3.setDiffuseMap(diffuseMap3);

        sun.setMaterial(mat3);
        sun.setDrawMode(DrawMode.FILL);

        //Creating a light source
        PointLight light = new PointLight();
        light.setColor(Color.WHITE);
        light.relocate(primaryStage.getWidth() / 2, primaryStage.getHeight() / 2);
        light.setTranslateZ(-100);

        //CENTERING THE SUN
        sun.relocate(primaryStage.getWidth() / 2, primaryStage.getHeight() / 2); // This will give you the center of the created Scene

        double centerX = calculator.calculateCenterX(primaryStage, earth.getEccentricity(), earth.getSemiMajorAxis(), earth.getApoapsisDistanceFromSun());
        double centerY = calculator.calculateCenterY(primaryStage);
        double semiMajorAxisCoords = calculator.calculateCoordsConversion(earth.getSemiMajorAxis());
        double semiMinorAxisCoords = calculator.calculateCoordsConversion(earth.getSemiMinorAxis());
        double apoapsisDistanceCoords = calculator.apoapsisCoordsConversion(earth.getApoapsisDistanceFromSun());
        double inclination = earth.getInclination();
        Path path = calculator.createEllipsePath(centerX, centerY, semiMajorAxisCoords, semiMinorAxisCoords, inclination);
        path.setStroke(Color.TEAL);

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

        root.getChildren().add(camera);
        root.getChildren().add(sphere);
        root.getChildren().add(sphere2);
        root.getChildren().add(sphere3);
        root.getChildren().add(light);

        root.getChildren().add(sun);
        test.setSystemToRoot(root, primaryStage); // A function that adds the solar system to the root

        //scene.setCamera(camera);
        path.toBack();
        path3.toBack();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DOWN) {
                    //testBox.getTransforms().add(new Rotate(10, 0, 0, 0, Rotate.Y_AXIS));
                    //jupiter.getTransforms().add(new Rotate(10, 0, 0, 0, Rotate.Y_AXIS));
                    root.setScaleX(root.getScaleX() / 1.2);
                    root.setScaleY(root.getScaleY() / 1.2);
                }
                else if (event.getCode() == UP) {
                    root.setScaleX(root.getScaleX() / .8);
                    root.setScaleY(root.getScaleY() / .8);
                }
                else if (event.getCode() == KeyCode.LEFT) {
                    root.setTranslateX(-10);
                    root.translateXProperty();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
