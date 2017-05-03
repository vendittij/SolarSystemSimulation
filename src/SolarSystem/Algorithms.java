package SolarSystem;

import java.awt.geom.Point2D;
import static java.lang.Math.*;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

/**
 * The algorithms class holds all algorithms associated with information a
 * planet may have.
 *
 * @author Gabe
 */
public final class Algorithms {

    Point2D.Double sun = new Point2D.Double(400, 350); // The Sun will be at the origin of our view
    static double gravitationalConstant = 6.67408 * pow(10, -11); // The gravitational constant
    static double coordinateScale = 200;                  //The scale for going from AU to coordinate
    static double AUToKM = 1.496 * pow(10, 8);              //Proportion for going from AU to kilometers

    /**
     * A method for converting the distance of the apoapsis that was given in
     * Kilometers to astronomical units (AU)
     *
     * @param apoapsisDistance - The distance the apoapsis is from the sun
     *
     * @return double : The conversion from Kilometers to astronomical units for
     * the apoapsis
     */
    public static double convertApoapsisDistanceToAU(double apoapsisDistance) {
        double AUApoapsisDistance;

        AUApoapsisDistance = apoapsisDistance / AUToKM; //This converts the Apoapsis distance from AU to KM

        return AUApoapsisDistance;
    }

    /**
     * A method for converting the distance of the periapsis that given in
     * kilometers to AU
     *
     * @param periapsisDistance - The distance that the periapsis is from the
     * sun
     *
     * @return double : The conversion from Kilometers to astronomical units for
     * the periapsis
     */
    public static double convertPeriapsisDistanceToAU(double periapsisDistance) {
        double AUPeriapsisDistance;

        AUPeriapsisDistance = periapsisDistance / AUToKM; //This converts the Periapsis distance from AU to KM

        return AUPeriapsisDistance;
    }

    /**
     * A method that calculates the semiMajorAxis of the planet
     *
     * @param apoapsisDistance - The distance that the apoapsis is from the sun
     * @param periapsisDistance - The distance that the periapsis is from the
     * sun
     *
     * @return double : The semi-major axis of the elliptical orbit
     */
    public static double calculatSemiMajorAxis(double apoapsisDistance,
                                               double periapsisDistance) {

        return (apoapsisDistance + periapsisDistance) / 2; //Very similar to how you would find radius of a circle
    }

    /**
     * A method that calculates the eccentricity of the planet
     *
     * @param apoapsisDistance - The distance the apoapsis is from the sun
     * @param semiMajorAxis - Also known as the average distance of the planet
     * from the sun
     *
     * @return double : The eccentricity of the orbit
     */
    public static double calculatEccentricity(double apoapsisDistance,
                                              double semiMajorAxis) {
        double eccentricity;

        eccentricity = (apoapsisDistance / semiMajorAxis) - 1; //To calculate eccentricity, must do this.

        return eccentricity;
    }

    /**
     * A method that calculates the period of the planet
     *
     * @param semiMajorAxis - Also known as the average distance of the planet
     * from the sun
     *
     * @return double : The period of the planet for its orbit
     */
    public static double calculatePeriod(double semiMajorAxis) {
        double period;

        period = sqrt(pow(semiMajorAxis, 3)); // For our sun, and for our sun only, period can be found with this equation

        return period;
    }

//    /**
//     * A method that returns the point of the periapsis of the planet
//     *
//     * @param periapsisDistanceFromSun - The distance the periapsis is from the
//     * sun
//     * @param YCoord - The Y coordinate for where to place periapsis
//     *
//     * @return Point2D.Double : Gives the point of the periapsis for the planet
//     */
//    public static Point2D.Double calculatePeriapsis(
//            double periapsisDistanceFromSun, double YCoord) {
//        Point2D.Double periapsis;
//
//        //May need to revise this!!!!!
//        periapsis = new Point2D.Double(
//                350 + periapsisDistanceFromSun * coordinateScale, 350 - YCoord);
//        return periapsis;
//    }

//    /**
//     * A method that returns the point of the apoapsis of the planet
//     *
//     * @param apoapsisDistanceFromSun - The distance the apoapsis is from the
//     * sun
//     * @param YCoord - The Y coordinate for where to place apoapsis (relative to
//     * periapsis)
//     *
//     * @return Point2D.Double : Gives the point of the apoapsis
//     */
//    public static Point2D.Double calculateApoapsis(
//            double apoapsisDistanceFromSun, double YCoord) {
//        Point2D.Double apoapsis;
//
//        //May need to revise this!!!!!
//        apoapsis = new Point2D.Double(
//                400 - apoapsisDistanceFromSun * coordinateScale, 350 + YCoord);
//        return apoapsis;
//    }

    /**
     * A method that calculates the average velocity of a planet. Uses the
     * calculateVelocity() method to do so
     *
     * @param apoapsisDistanceFromSun - The distance the apoapsis is from the
     * sun
     * @param periapsisDistanceFromSun - The distance the periapsis is from the
     * sun
     * @param mass - The mass of the planet in question
     * @param semiMajorAxis - The average distance of the planet from the sun
     * @param period - The length of time it takes for one full revolution
     *
     * @return double : The average velocity of the planet
     */
    public static double calculateAverageVelocity(double apoapsisDistanceFromSun,
                                                  double periapsisDistanceFromSun,
                                                  double mass,
                                                  double semiMajorAxis,
                                                  double period) {
        double averageVelocity;

        double apoapsisVelocity = calculateVelocity(apoapsisDistanceFromSun,
                                                    semiMajorAxis, mass, period); //Only need to find velocity at apopasis
        double periapsisVelocity = calculateVelocity(periapsisDistanceFromSun,
                                                     semiMajorAxis, mass, period); //and the velocity at periapsis to find average velocity

        averageVelocity = (apoapsisVelocity + periapsisVelocity) / 2; //Similar to how you find any average

        return averageVelocity;
    }

    /**
     * A method that calculates the velocity
     *
     * @param radiusFromSun - The distance that the planet currently is from the
     * sun
     * @param semiMajorAxis - The average distance of the planet from the sun
     * @param mass - The mass of the planet
     * @param period - The length of time it takes for the planet to complete
     * one revolution (relative to earth year)
     *
     * @return double : The velocity of the planet based off current position
     */
    public static double calculateVelocity(double radiusFromSun,
                                           double semiMajorAxis, double mass,
                                           double period) {
        double velocity;
        double gravitationalParameter;
        double difference;
        radiusFromSun = radiusFromSun * AUToKM;
        semiMajorAxis = semiMajorAxis * AUToKM;
        gravitationalParameter = 4 * pow(PI, 2) * pow(semiMajorAxis, 3) / pow(
                period * 365 * 24 * 60 * 60, 2);
        difference = (2 / radiusFromSun) - (1 / semiMajorAxis);
        velocity = sqrt(gravitationalParameter * difference);
        return velocity;
    }

    /**
     * A method that calculates the semi-minor axis
     *
     * @param semiMajorAxis - The average distance that the planet is from the
     * sun
     * @param eccentricity - Determines how close the sun is to the -apsis and
     * how ovular the ellipse is
     *
     * @return double : The semi-minor axis a.k.a the Y distance for the
     * ellipse.
     */
    public static double calculateSemiMinorAxis(double semiMajorAxis,
                                                double eccentricity) {
        double semiMinorAxis;

        semiMinorAxis = semiMajorAxis * sqrt(1 - pow(eccentricity, 2));

        return semiMinorAxis;
    }

    public static PathTransition createPathTransition(double period,
                                                      Sphere planet, Path path,
                                                      int rate) {

        PathTransition transition = new PathTransition();
        int daysInYear = 365;
        int hoursInDay = 24;

        double duration = daysInYear * hoursInDay * period;

        transition.setDuration(Duration.millis(duration));
        transition.setNode(planet);
        transition.setPath(path);
        transition.setRate(rate);
        transition.setOrientation(OrientationType.NONE);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.setCycleCount(Timeline.INDEFINITE);

        transition.play();

        return transition;
    }

    public static double calculateCenterX(BorderPane root, double eccentricity,
                                          double semiMajorAxis,
                                          double apoapsisDistance) {
        double x;

        if (semiMajorAxis < 0.5) {
            int eccentricityMultiple = 50;
            x = root.getWidth() / 2 + semiMajorAxis * coordinateScale + apoapsisDistance * eccentricityMultiple;
            return x;
        }

        x = root.getWidth() / 2 + eccentricity * coordinateScale + semiMajorAxis * coordinateScale + apoapsisCoordsConversion(
                apoapsisDistance) + 10;

        return x;
    }

    public static double calculateCenterY(BorderPane root) {
        double y;

        y = root.getHeight() / 2 + 20;

        return y;
    }

    public static Sphere createSphere(double radius) {
        Sphere sphere = new Sphere();
        double sphereConversionRate;     //For KM to coords
        int radiusThreshold = 100000;

        if (radius >= radiusThreshold) {
            sphereConversionRate = 15000;
        }
        else {
            sphereConversionRate = 500;
        }

        sphere.setRadius(radius / sphereConversionRate);

        return sphere;
    }

    /**
     * *************************************************************************************
     * Title: Create Ellipse path Author: Uluk Biy Date: April 14th, 2017 Code
     * version: 1.0 Availability:
     * http://stackoverflow.com/questions/14171856/javafx-2-circle-path-for-animation
     *
     **************************************************************************************
     */
    public static Path createEllipsePath(double centerX, double centerY,
                                         double radiusX, double radiusY,
                                         double rotate) {
        ArcTo arcTo = new ArcTo();
        arcTo.setX(centerX - radiusX + 1); // to simulate a full 360 degree celcius circle.
        arcTo.setY(centerY - radiusY);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
        arcTo.setXAxisRotation(rotate);

        Path path = PathBuilder.create()
                .elements(
                        new MoveTo(centerX - radiusX, centerY - radiusY),
                        arcTo,
                        new ClosePath()) // close 1 px gap.
                .build();
        path.setStroke(Color.WHITE);
        path.toBack();

        if (radiusX > 305) {
            path.setStrokeWidth(path.getStrokeWidth() * 4);
        }
        else if (radiusX > 1000) {
            path.setStrokeWidth(path.getStrokeWidth() * 10);
        }

        return path;
    }

    public static double calculateCoordsConversion(double semiMajorAxis) {
        return semiMajorAxis * coordinateScale;
    }

    public static double apoapsisCoordsConversion(double apoapsisDistance) {
        return apoapsisDistance * 5;
    }

}
