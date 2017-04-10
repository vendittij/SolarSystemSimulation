/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

/**
 *
 * @author Gabe
 */
public class Moon extends Planet {
    
    public Moon(String name, double apoapsisDistance, double periapsisDistance, double planetRadius, double mass, double inclination, double periapsisYCoord) {
        super(name,apoapsisDistance,periapsisDistance,planetRadius,mass,inclination, periapsisYCoord);
    }
}
