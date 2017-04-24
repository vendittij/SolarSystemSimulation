/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import static java.lang.Math.*;

/**
 *
 * @author Gabe
 */
public class PlanetTestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Planet earth = new Planet("Earth", 147100000, 152100000, 20100023, 5.972 * pow(10, 24), 2, 12);
        System.out.printf("Name: %s\n", earth.getName());
        System.out.printf("Average Velocity: %f\n", earth.getAvgVelocty());
        System.out.printf("Acceleration: %f\n", earth.getAcceleration());
        //System.out.printf("Apoapsis Coordinate: x-coord = %f     y-coord = %f\n", earth.getApoapsis().getX(), earth.getApoapsis().getY());
        System.out.printf("Aposis Distance from Sun: %f\n", earth.getApoapsisDistanceFromSun());
        //System.out.printf("Periapsis Coordinate: x-coord = %f    y-coord = %f\n", earth.getPeriapsis().getX(), earth.getPeriapsis().getY());
        System.out.printf("Periapsis Distance from Sun: %f\n", earth.getPeriapsisDistanceFromSun());
        System.out.printf("Average Distance from Sun: %f\n", earth.getAvgDistanceFromSun());
        System.out.printf("Ecentricity: %f\n", earth.getEccentricity());
        System.out.printf("Inclination: %f\n", earth.getInclination());
        System.out.printf("Mass: %f\n", earth.getMass());
        System.out.printf("Period: %f\n", earth.getPeriod());
        System.out.printf("Planet Radius: %f\n", earth.getPlanetRadius());
        System.out.printf("Semi-Major Axis: %f\n", earth.getSemiMajorAxis());
        //System.out.printf("Current Distance From Sun: %f\n", earth.getCurrentDistanceFromSun(earth.getPosition()));
        //System.out.printf("Velocity at this distance: %f\n\n", earth.getVelocity());

        Planet mars = new Planet("Mars", 249.23 * pow(10, 6), 206.92 * pow(10, 6), 3389.279464, 0.64171 * pow(10, 24), 20, 12);
        System.out.printf("Name: %s\n", mars.getName());
        System.out.printf("Average Velocity: %f\n", mars.getAvgVelocty());
        System.out.printf("Acceleration: %f\n", mars.getAcceleration());
        //System.out.printf("Apoapsis Coordinate: x-coord = %f     y-coord = %f\n", mars.getApoapsis().getX(), mars.getApoapsis().getY());
        System.out.printf("Aposis Distance from Sun: %f\n", mars.getApoapsisDistanceFromSun());
        //System.out.printf("Periapsis Coordinate: x-coord = %f    y-coord = %f\n", mars.getPeriapsis().getX(), mars.getPeriapsis().getY());
        System.out.printf("Periapsis Distance from Sun: %f\n", mars.getPeriapsisDistanceFromSun());
        System.out.printf("Average Distance from Sun: %f\n", mars.getAvgDistanceFromSun());
        System.out.printf("Ecentricity: %f\n", mars.getEccentricity());
        System.out.printf("Inclination: %f\n", mars.getInclination());
        System.out.printf("Mass: %f\n", mars.getMass());
        System.out.printf("Period: %f\n", mars.getPeriod());
        System.out.printf("Planet Radius: %f\n", mars.getPlanetRadius());
        System.out.printf("Semi-Major Axis: %f\n\n", mars.getSemiMajorAxis());

        Planet jupiter = new Planet("Jupter", 816.62 * pow(10, 6), 740.52 * pow(10, 6), 69911.513, 1898.19 * pow(10, 24), 8, 8);
        System.out.printf("Name: %s\n", jupiter.getName());
        System.out.printf("Average Velocity: %f\n", jupiter.getAvgVelocty());
        System.out.printf("Acceleration: %f\n", jupiter.getAcceleration());
        //System.out.printf("Apoapsis Coordinate: x-coord = %f     y-coord = %f\n", jupiter.getApoapsis().getX(), jupiter.getApoapsis().getY());
        System.out.printf("Aposis Distance from Sun: %f\n", jupiter.getApoapsisDistanceFromSun());
        //System.out.printf("Periapsis Coordinate: x-coord = %f    y-coord = %f\n", jupiter.getPeriapsis().getX(), jupiter.getPeriapsis().getY());
        System.out.printf("Periapsis Distance from Sun: %f\n", jupiter.getPeriapsisDistanceFromSun());
        System.out.printf("Average Distance from Sun: %f\n", jupiter.getAvgDistanceFromSun());
        System.out.printf("Ecentricity: %f\n", jupiter.getEccentricity());
        System.out.printf("Inclination: %f\n", jupiter.getInclination());
        System.out.printf("Mass: %f\n", jupiter.getMass());
        System.out.printf("Period: %f\n", jupiter.getPeriod());
        System.out.printf("Planet Radius: %f\n", jupiter.getPlanetRadius());
        System.out.printf("Semi-Major Axis: %f\n\n", jupiter.getSemiMajorAxis());
        //earth.setPosition(new Point2D.Double(-earth.getPeriapsisDistanceFromSun(), 8));

    }

}
