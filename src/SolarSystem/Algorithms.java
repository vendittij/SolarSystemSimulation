/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import java.awt.geom.Point2D;
import static java.lang.Math.*;

/**
 *
 * @author Gabe
 */
public class Algorithms {
    Point2D.Double sun = new Point2D.Double(0.0,0.0); // The Sun will be at the origin of our view
    double gravitationalConstant = 6.67408*pow(10,-11); // The gravitational constant 
    double coordinateScale = 100;                  //The scale for going from AU to coordinate
    double AUToKM = 1.496 * pow(10,8);              //Proportion for going from AU to kilometers
    double massOfSun = 1.989 * pow(10,30);          //Mass of the sun
    
    
    /**
     * A method for converting the distance of the apoapsis that was given in Kilometers to astronomical units (AU)
     * 
     * @param apoapsisDistance
     * @return double : The conversion from Kilometers to astronomical units for the apoapsis
     */
    double convertApoapsisDistanceToAU(double apoapsisDistance) {
        double AUApoapsisDistance;
        
        AUApoapsisDistance = apoapsisDistance / AUToKM;
                
        return AUApoapsisDistance;
    }
    
    /**
     * A method for converting the distance of the periapsis that given in kilometers to AU
     * 
     * @param periapsisDistance
     * @return double : The conversion from Kilometers to astronomical units for the periapsis
     */
    double convertPeriapsisDistanceToAU(double periapsisDistance) {
        double AUPeriapsisDistance;
        
        AUPeriapsisDistance = periapsisDistance / AUToKM;
                
        return AUPeriapsisDistance;
    }
    
    /**
     * A method that calculates the semiMajorAxis of the planet
     * 
     * @param apoapsisDistance
     * @param periapsisDistance
     * @return double : The semi-major axis of the elliptical orbit
     */
    double calculatSemiMajorAxis(double apoapsisDistance, double periapsisDistance) {
        return (apoapsisDistance + periapsisDistance)/2;
    }
    
    /**
     * A method that calculates the eccentricity of the planet
     * 
     * @param apoapsisDistance
     * @param semiMajorAxis
     * @return double : The eccentricity of the orbit
     */
    double calculatEccentricity(double apoapsisDistance, double semiMajorAxis) {
        double eccentricity;
        
        eccentricity = (apoapsisDistance/semiMajorAxis) - 1;
        
        return eccentricity;
    }

    /**
     * A method that calculates the period of the planet
     * 
     * @param semiMajorAxis
     * @param mass
     * @return double : The period of the planet for its orbit
     */
    double calculatePeriod(double semiMajorAxis, double mass) {
        double period;
        
        period = sqrt(pow(semiMajorAxis,3));
                
        return period;
    }
    
    /**
     * A method for calculating the current distance from the sun
     * 
     * @return double : The planet's current distance from the Sun.
     */
    double calculateCurrentDistanceFromSun(Point2D.Double currentPosition) {
        return currentPosition.distance(sun) / coordinateScale;
    }

    /**
     * A method that returns the point of the periapsis of the planet
     * 
     * @param periapsisDistanceFromSun
     * @param YCoord
     * @return Point2D.Double : Gives the point of the periapsis for the planet
     */
    Point2D.Double calculatePeriapsis(double periapsisDistanceFromSun, double YCoord) {
        Point2D.Double periapsis;
        
        periapsis = new Point2D.Double(-1*periapsisDistanceFromSun * coordinateScale, YCoord);
                
        return periapsis;
    }

    /**
     * A method that returns the point of the apoapsis of the planet
     * 
     * @param apoapsisDistanceFromSun
     * @param YCoord
     * @return Point2D.Double : Gives the point of the apoapsis 
     */
    Point2D.Double calculateApoapsis(double apoapsisDistanceFromSun, double YCoord) {
        Point2D.Double apoapsis;
        
        apoapsis = new Point2D.Double(apoapsisDistanceFromSun * coordinateScale, -1 * YCoord);
        
        return apoapsis;
    }
    
    /**
     * A method that calculates the average velocity of a planet. Uses the calculateVelocity() method to do so
     * 
     * @param apoapsisDistanceFromSun
     * @param periapsisDistanceFromSun
     * @param mass
     * @param semiMajorAxis
     * @param period
     * @return double : The average velocity of the planet
     */
    double calculateAverageVelocty(double apoapsisDistanceFromSun, double periapsisDistanceFromSun, double mass, double semiMajorAxis, double period) {
        double averageVelocity;
        
        double apoapsisVelocity = calculateVelocity(apoapsisDistanceFromSun, semiMajorAxis,mass, period);
        double periapsisVelocity = calculateVelocity(periapsisDistanceFromSun, semiMajorAxis,mass, period);
        
        averageVelocity = (apoapsisVelocity + periapsisVelocity) / 2; 
        
        return averageVelocity;
    }
    
    /**
     * A method that calculates the velocity 
     * 
     * @param radiusFromSun
     * @param semiMajorAxis
     * @param mass
     * @param period
     * @return double : The velocity of the planet based off current position
     */
    double calculateVelocity(double radiusFromSun, double semiMajorAxis, double mass, double period) {
        double velocity;        
        double gravitationalParameter;
        double difference;
        
        radiusFromSun = radiusFromSun * AUToKM;
        semiMajorAxis = semiMajorAxis * AUToKM;
        
        gravitationalParameter = 4*pow(PI, 2)*pow(semiMajorAxis,3)/pow(period * 365 * 24 * 60*60,2);
        
        difference = (2 / radiusFromSun) - (1 / semiMajorAxis);
        
        velocity = sqrt(gravitationalParameter * difference);
        
        return velocity;
    }
   
}
