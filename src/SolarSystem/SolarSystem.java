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

    public void addPlanet(Planet newPlanet) { //Allows a planet to be added
        solarSystem.add(newPlanet);
    }

    public Planet planetSelector(int index) { //Allows for the selection of a specific planet
        return solarSystem.get(index);
    }

    public int planetsInSystem() { //Returns the number of planets in our SolarSystem
        return solarSystem.size();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * This is the Solar System creation method. Uses a for loop to loop through
     * each planet. The first time through the loop we add the sun to our solar
     * system. This also adds each planet's orbit (PathTransition) to the solar
     * system BorderPane.
     *
     * @param root
     * @return BorderPane
     */
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
            root.getChildren().add(solarSystem.get(i).getPath());
            root.getChildren().add(solarSystem.get(i).getPlanet());

        }

        return root;
    }
}
