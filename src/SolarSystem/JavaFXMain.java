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
import static javafx.scene.input.KeyCode.ENTER;
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

        Planet earth = new Planet("Earth", 152100000, 147100000, 20100023, 5.972 * pow(10, 24), 2, 100);
        Planet mars = new Planet("Mars", 249.23 * pow(10, 6), 206.92 * pow(10, 6), 3389.279464, 0.64171 * pow(10, 24), 20, 12);
        Planet jupiter = new Planet("Jupter", 816.62 * pow(10, 6), 740.52 * pow(10, 6), 69911.513, 1898.19 * pow(10, 24), 8, 8);

        primaryStage.show();

        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.getTransforms().addAll(
                new Rotate(-20, Rotate.Y_AXIS),
                new Rotate(90, Rotate.X_AXIS),
                new Translate(0, 0, -50));

        Sphere sphere = new Sphere(10); //Create a sphere that has a raidus of 10
        Sphere sphere2 = new Sphere(10 * .53);
        Sphere sphere3 = new Sphere(10 * 6);
        Sphere sun = new Sphere(20);

        //Adding material to spheres
        PhongMaterial mat = new PhongMaterial();
        Image diffuseMap = new Image("file:earth.png");
        mat.setDiffuseMap(diffuseMap);

        PhongMaterial mat2 = new PhongMaterial();
        Image diffuseMap2 = new Image("file:mars.jpg");
        mat2.setDiffuseMap(diffuseMap2);

        PhongMaterial mat3 = new PhongMaterial();
        Image diffuseMap3 = new Image("file:Sun.jpg");
        mat3.setDiffuseMap(diffuseMap3);

        PhongMaterial mat4 = new PhongMaterial();
        Image diffuseMap4 = new Image("file:jupiter.jpg");
        mat4.setDiffuseMap(diffuseMap4);

        sphere.setMaterial(mat);
        sphere.setDrawMode(DrawMode.FILL);
        sphere2.setMaterial(mat2);
        sphere2.setDrawMode(DrawMode.FILL);
        sun.setMaterial(mat3);
        sun.setDrawMode(DrawMode.FILL);
        sphere3.setMaterial(mat4);
        sphere3.setDrawMode(DrawMode.FILL);

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
        root.getChildren().add(path);
        root.getChildren().add(path2);
        root.getChildren().add(path3);

        //scene.setCamera(camera);
        path.toBack();
        path3.toBack();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == ENTER) {
                    //testBox.getTransforms().add(new Rotate(10, 0, 0, 0, Rotate.Y_AXIS));
                    //jupiter.getTransforms().add(new Rotate(10, 0, 0, 0, Rotate.Y_AXIS));
                    camera.setFieldOfView(camera.getFieldOfView() + 10);
                }
                else if (event.getCode() == UP) {

                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
