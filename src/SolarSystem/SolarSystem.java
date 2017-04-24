/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Gabe
 */
public class SolarSystem {

    private ArrayList<Planet> solarSystem;
    String name;

    public SolarSystem(String name) {
        solarSystem = new ArrayList<>();
        this.name = name;
    }

    public void addPlanet(Planet newPlanet) {
        solarSystem.add(newPlanet);
    }

    public Planet planetSelector(int index) {
        return solarSystem.get(index);
    }

    public int planetsInSystem() {
        return solarSystem.size();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public BorderPane setSystemToRoot(BorderPane root, Stage primaryStage) {

        for (int i = 0; i < planetsInSystem(); i++) {
            solarSystem.get(i).setPath(primaryStage);
            root.getChildren().add(solarSystem.get(i).getPlanet());
            root.getChildren().add(solarSystem.get(i).getPath());
        }

        return root;
    }
}
