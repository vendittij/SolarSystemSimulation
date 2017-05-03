/*
 * If you ever need some clarification on some methods, go to the equations.txt file which has links to sites
 * which contain many of the methods that we see.
 */
package SolarSystem;

import static SolarSystem.Constants.*;
import java.awt.Button;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.UP;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.stage.Stage;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Gabe
 */
public class JavaFXMain extends Application {

    private int translationsX = 0;
    private int translationsY = 0;

    @Override
    public void start(Stage primaryStage) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        BorderPane pane = new BorderPane();
        BorderPane root = new BorderPane();
        TabInfoPane tabs = new TabInfoPane();
        
        pane.setCenter(root);
        pane.setBottom(tabs);

        Image stars = new Image("http://i.imgur.com/PgYKaSd.jpg"); //URL for the background image
        ImagePattern pattern = new ImagePattern(stars); //Sets up an image pattern that is based off of the stars.
        Scene scene = new Scene(pane, 1500, 1000);

        pane.setStyle(
                "-fx-background-image: url("
                + "'http://i.imgur.com/PgYKaSd.jpg'"
                + "); "
                + "-fx-background-size: stretch;"
        );

        primaryStage.setScene(scene);
        primaryStage.setTitle("Solar System Simulator");
        
        tabs.setProperties();

        //Music
        File file = new File("DayAndNight.mp3");
        String source = file.toURI().toString();
        //AudioClip music = new AudioClip(source);
        //music.play();
        // first directory I wanted to start in. The way I got it here made it possible to play it on my computer,
        // so it's possible to get it working if we follow similar on the linux computers when we put it there.
        // Media sound = new Media(musicFile);     //Create the media by directly putting the file name into it. Nothing else is needed.
        //MediaPlayer mediaPlayer = new MediaPlayer(sound);  //Create the media player by using the media object just created
        //mediaPlayer.setAutoPlay(true);                      //Automatically begins playing the music. Can turn this off and set them to buttons easily if we'd like.
        //mediaPlayer.setVolume(0.1);                         //Sets volume to a tenth of it's original volume.
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Sets volume to a tenth of it's original volume.

        Planet earth = new Planet("Earth", EARTHAPOAPSIS, EARTHPERIAPSIS,
                EARTHRADIUS, EARTHMASS, EARTHINCLINATION,
                EARTHRATE);
        Planet mars = new Planet("Mars", MARSAPOAPSIS, MARSPERIAPSIS, MARSRADIUS,
                MARSMASS, MARSINCLINATION, MARSRATE);
        Planet jupiter = new Planet("Jupter", JUPITERAPOAPSIS, JUPITERPERIAPSIS,
                JUPITERRADIUS, JUPITERMASS,
                JUPITERINCLINATION, JUPITERRATE);
        Planet venus = new Planet("Venus", VENUSAPOAPSIS, VENUSPERIAPSIS,
                VENUSRADIUS, VENUSMASS, VENUSINCLINATION,
                VENUSRATE);
        Planet mercury = new Planet("Mercury", MERCURYAPOAPSIS, MERCURYPERIAPSIS,
                MERCURYRADIUS, MERCURYMASS,
                MERCURYINCLINATION, MERCURYRATE);
        Planet saturn = new Planet("Saturn", SATURNAPOAPSIS, SATURNPERIAPSIS,
                SATURNRADIUS, SATURNMASS, SATURNINCLINATION,
                SATURNRATE);
        Planet uranus = new Planet("Uranus", URANUSAPOAPSIS, URANUSPERIAPSIS,
                URANUSRADIUS, URANUSMASS, URANUSINCLINATION,
                URANUSRATE);
        Planet neptune = new Planet("Neptune", NEPTUNEAPOAPSIS, NEPTUNEPERIAPSIS,
                NEPTUNERADIUS, NEPTUNEMASS,
                NEPTUNEINCLINATION, NEPTUNERATE);
        Planet pluto = new Planet("Pluto", PLUTOAPOAPSIS, PLUTOPERIAPSIS,
                PLUTORADIUS, PLUTOMASS, PLUTOINCLINATION,
                PLUTORATE);
        Sun sun = new Sun("Sun", SUNRADIUS, SUNMASS);
        
        
        SolarSystem test = new SolarSystem("New");
        // Wrap each planet with its respective image
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

        // Adding all planets to our SolarSystem
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

//        for (int i = 0; i < test.planetsInSystem(); i++) {
//            System.out.println(test.planetSelector(i));
//        }
        
        //Then call methods to populate the inner panes
        //ie. overScroll.populate(), detailSplit.populate()
        
        tabs.populateInfo(test);

        primaryStage.show();

        //Adding material to spheres
        PhongMaterial mat3 = new PhongMaterial();
        Image diffuseMap3 = new Image("file:Sun.jpg");
        mat3.setDiffuseMap(diffuseMap3);
        //Creating a light source
        PointLight light = new PointLight();
        light.setColor(Color.WHITE);
        light.relocate((primaryStage.getWidth() / 2) + 20,
                (primaryStage.getHeight() / 2) - 60);
        light.setTranslateZ(-100);
        root.getChildren().add(light);
        Button button = new Button("Display Information");

        test.setSystemToRoot(root); // A function that adds the solar system to the root
        
        
        //TODO: OVERRIDE ARROW KEY PRESSES TO NOT SHIFT TAB PANE, BUT RATHER TO REMAIN FOR ZOOM
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            // Here we write the user control handlers. These keys allow the user to navigate our Solar System using pan/zoom features.>>>>>>> 2bf0aa5b9cc54dc354b9a81bbdc0ca9c5f2f690a
            @Override
            public void handle(KeyEvent event) {
//                if (event.getCode() == KeyCode.DOWN) {
//                    root.setScaleX(root.getScaleX() / 1.2);
//                    root.setScaleY(root.getScaleY() / 1.2);
//                    //background.setFitWidth(root.getScaleX());
//                    //background.fitHeightProperty().bind(primaryStage.heightProperty());
//                } else if (event.getCode() == UP) {
//                    root.setScaleX(root.getScaleX() / .8);
//                    root.setScaleY(root.getScaleY() / .8);
//                } else 
                if (event.getCode() == KeyCode.A) {
                    root.setTranslateX(root.getTranslateX() + 30);
                    root.translateXProperty();
                    translationsX -= 30;
                }
                else if (event.getCode() == KeyCode.D) {
                    root.setTranslateX(root.getTranslateX() - 30);
                    root.translateXProperty();
                    translationsX += 30;
                }
                else if (event.getCode() == KeyCode.W) {
                    root.setTranslateY(root.getTranslateY() + 30);
                    root.translateYProperty();
                    translationsY -= 30;
                }
                else if (event.getCode() == KeyCode.S) {
                    root.setTranslateY(root.getTranslateY() - 30);
                    root.translateYProperty();
                    translationsY += 30;
                }
                else if (event.getCode() == KeyCode.R){
                    root.setTranslateY(root.getTranslateY() + translationsY);
                    root.setTranslateX(root.getTranslateX() + translationsX);
                    root.translateXProperty();
                    root.translateYProperty();
                    translationsY = 0;
                    translationsX = 0;
                }
                else if (event.getCode() == KeyCode.I){
                    root.setScaleX(root.getScaleX() / .8);
                    root.setScaleY(root.getScaleY() / .8);
                }
                else if (event.getCode() == KeyCode.O){
                    root.setScaleX(root.getScaleX() / 1.2);
                    root.setScaleY(root.getScaleY() / 1.2);
                    //background.setFitWidth(root.getScaleX());
                    //background.fitHeightProperty().bind(primaryStage.heightProperty());
                }
                
                
//                else if (event.getCode() == KeyCode.SPACE) {
//                    root.setTranslateY(root.getTranslateY() + translationsY);
//                    root.setTranslateX(root.getTranslateX() + translationsX);
//                    root.translateXProperty();
//                    root.translateYProperty();
//                    translationsY = 0;
//                    translationsX = 0;
//                }
//                else if (event.getCode() == KeyCode.P) {
//                    //Find pluto
//                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}