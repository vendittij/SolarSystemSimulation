/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import javafx.animation.PathTransition;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 *
 * @author Gabe
 */
public class Planet {

    private double period;
    private double semiMinorAxis;
    private double avgDistanceFromSun;
    private double acceleration;
    private double inclination;
    private double eccentricity;
    private double planetRadius;
    private double mass;
    private double currentDistanceFromSun;
    private String name;
    private double apoapsisDistanceFromSun;
    private double periapsisDistanceFromSun;
    private double semiMajorAxis;
    private double avgVelocty;
    private Algorithms calculator = new Algorithms();
    private ArrayList<Moon> planetMoons = new ArrayList<>();
    private Path path;
    private PathTransition pathTransition;
    private Sphere sphere;

    /**
     * The constructor for all Planet objects
     *
     * @param name
     * @param apoapsisDistance
     * @param periapsisDistance
     * @param planetRadius
     * @param mass
     * @param inclination
     * @param periapsisYCoord
     */
    public Planet(String name, double apoapsisDistance, double periapsisDistance, double planetRadius, double mass, double inclination, double periapsisYCoord) {

        this.name = name;
        this.apoapsisDistanceFromSun = apoapsisDistance;
        this.periapsisDistanceFromSun = periapsisDistance;
        this.planetRadius = planetRadius;
        this.mass = mass;
        this.inclination = inclination;
        this.sphere = calculator.createSphere(this.planetRadius);

        this.apoapsisDistanceFromSun = calculator.convertApoapsisDistanceToAU(this.apoapsisDistanceFromSun);
        this.periapsisDistanceFromSun = calculator.convertPeriapsisDistanceToAU(this.periapsisDistanceFromSun);

        this.semiMajorAxis = calculator.calculatSemiMajorAxis(this.apoapsisDistanceFromSun, this.periapsisDistanceFromSun);
        this.eccentricity = calculator.calculatEccentricity(this.apoapsisDistanceFromSun, this.semiMajorAxis);
        this.period = calculator.calculatePeriod(this.semiMajorAxis);
        this.avgDistanceFromSun = this.semiMajorAxis;
        this.avgVelocty = calculator.calculateAverageVelocty(apoapsisDistanceFromSun, periapsisDistanceFromSun, mass, semiMajorAxis, this.period);
        this.semiMinorAxis = calculator.calculateSemiMinorAxis(this.semiMajorAxis, this.eccentricity);

    }

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    public double getAvgVelocty() {
        return avgVelocty;
    }

    public void setAvgVelocty(double avgVelocty) {
        this.avgVelocty = avgVelocty;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public double getAvgDistanceFromSun() {
        return avgDistanceFromSun;
    }

    public void setAvgDistanceFromSun(double avgDistanceFromSun) {
        this.avgDistanceFromSun = avgDistanceFromSun;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getInclination() {
        return inclination;
    }

    public void setInclination(double inclination) {
        this.inclination = inclination;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        this.eccentricity = eccentricity;
    }

    public double getPlanetRadius() {
        return planetRadius;
    }

    public void setPlanetRadius(double planetRadius) {
        this.planetRadius = planetRadius;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getCurrentDistanceFromSun(Point2D.Double point) {
        return calculator.calculateCurrentDistanceFromSun(point);
    }

    public void setCurrentDistanceFromSun(double currentDistanceFromSun) {
        this.currentDistanceFromSun = currentDistanceFromSun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getApoapsisDistanceFromSun() {
        return apoapsisDistanceFromSun;
    }

    public void setApoapsisDistanceFromSun(double apoapsisDistanceFromSun) {
        this.apoapsisDistanceFromSun = apoapsisDistanceFromSun;
    }

    public double getPeriapsisDistanceFromSun() {
        return periapsisDistanceFromSun;
    }

    public void setPeriapsisDistanceFromSun(double periapsisDistanceFromSun) {
        this.periapsisDistanceFromSun = periapsisDistanceFromSun;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public ArrayList<Moon> getPlanetMoons() {
        return planetMoons;
    }

    public void setPlanetMoons(ArrayList<Moon> planetMoons) {
        this.planetMoons = planetMoons;
    }

    public void addMoon(Moon newMoon) {
        planetMoons.add(newMoon);
    }

    public Sphere getPlanet() {
        return this.sphere;
    }

    public Path getPath() {
        return this.path;
    }

    public PathTransition getPathTransition() {
        return this.pathTransition;
    }

    public void setPath(Stage primaryStage) {

        double centerX = calculator.calculateCenterX(primaryStage, this.eccentricity, this.semiMajorAxis, this.apoapsisDistanceFromSun);
        double centerY = calculator.calculateCenterY(primaryStage);
        double semiMajorAxisCoords = calculator.calculateCoordsConversion(this.semiMajorAxis);
        double semiMinorAxisCoords = calculator.calculateCoordsConversion(this.semiMinorAxis);
        this.path = calculator.createEllipsePath(centerX, centerY, semiMajorAxisCoords, semiMinorAxisCoords, inclination);
        this.pathTransition = calculator.createPathTransition(this.period, this.sphere, this.path);
    }
}
