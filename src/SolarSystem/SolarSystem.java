/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import java.util.ArrayList;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Sphere;

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

    public BorderPane setSystemToRoot(BorderPane root) {

        for (int i = 0; i < planetsInSystem(); i++) {
            if (solarSystem.get(i) instanceof Sun) {
                Sphere sun = solarSystem.get(i).getPlanet();
                double centerX = root.getWidth() / 2 - 20;
                double centerY = root.getHeight() / 2 - 20;
                sun.relocate(centerX, centerY);
                root.getChildren().add(sun);
                continue;

            }
            solarSystem.get(i).setPath(root);
            root.getChildren().add(solarSystem.get(i).getPlanet());
            root.getChildren().add(solarSystem.get(i).getPath());
        }

        return root;
    }
}
