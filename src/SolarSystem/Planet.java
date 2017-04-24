/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;

/**
 *
 * @author Gabe
 */
public class Planet {

    private double period;
    private double velocity;
    private double semiMinorAxis;
    private double avgDistanceFromSun;
    private double acceleration;
    private double inclination;
    private double eccentricity;
    private double planetRadius;
    private double mass;
    private double currentDistanceFromSun;
    private Point2D.Double position;
    private String name;
    private Point2D.Double apoapsis;
    private Point2D.Double periapsis;
    private double apoapsisDistanceFromSun;
    private double periapsisDistanceFromSun;
    private double semiMajorAxis;
    private double avgVelocty;
    private Algorithms calculator = new Algorithms();
    private ArrayList<Moon> planetMoons = new ArrayList<>();
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
    public Planet(String name, double apoapsisDistance, double periapsisDistance,
                  double planetRadius, double mass, double inclination,
                  double periapsisYCoord) {
        this.name = name;
        this.apoapsisDistanceFromSun = apoapsisDistance;
        this.periapsisDistanceFromSun = periapsisDistance;
        this.planetRadius = planetRadius;
        this.mass = mass;
        this.inclination = inclination;

        this.apoapsisDistanceFromSun = calculator.convertApoapsisDistanceToAU(
                this.apoapsisDistanceFromSun);
        this.periapsisDistanceFromSun = calculator.convertPeriapsisDistanceToAU(
                this.periapsisDistanceFromSun);

        this.periapsis = calculator.calculatePeriapsis(
                this.periapsisDistanceFromSun, periapsisYCoord);
        this.apoapsis = calculator.calculateApoapsis(
                this.apoapsisDistanceFromSun, periapsisYCoord);
        this.semiMajorAxis = calculator.calculatSemiMajorAxis(
                this.apoapsisDistanceFromSun, this.periapsisDistanceFromSun);
        this.eccentricity = calculator.calculatEccentricity(
                this.apoapsisDistanceFromSun, this.semiMajorAxis);
        this.period = calculator.calculatePeriod(this.semiMajorAxis);
        this.avgDistanceFromSun = this.semiMajorAxis;
        this.avgVelocty = calculator.calculateAverageVelocty(
                apoapsisDistanceFromSun, periapsisDistanceFromSun, mass,
                semiMajorAxis, this.period);
        this.semiMinorAxis = calculator.calculateSemiMinorAxis(
                this.semiMajorAxis, this.eccentricity);

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

    public double getVelocity() {
        return calculator.calculateVelocity(this.getCurrentDistanceFromSun(
                this.position), this.semiMajorAxis, this.mass, this.period);
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
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

    public double getPlanetRaidus() {
        return planetRadius;
    }

    public void setPlanetRaidus(double planetRaidus) {
        this.planetRadius = planetRaidus;
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

    public Point2D.Double getPosition() {
        return position;
    }

    public void setPosition(Point2D.Double position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point2D.Double getApoapsis() {
        return apoapsis;
    }

    public void setApoapsis(Point2D.Double apoapsis) {
        this.apoapsis = apoapsis;
    }

    public Point2D.Double getPeriapsis() {
        return periapsis;
    }

    public void setPeriapsis(Point2D.Double periapsis) {
        this.periapsis = periapsis;
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

    public void wrapImage(String filePath) {
        PhongMaterial mat = new PhongMaterial();
        Image diffuseMap = new Image("file:" + filePath);
        mat.setDiffuseMap(diffuseMap);
        this.sphere.setMaterial(mat);
    }
}
