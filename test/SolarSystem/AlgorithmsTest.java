/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import java.awt.geom.Point2D;
import javafx.animation.PathTransition;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jtd027
 */
public class AlgorithmsTest {
       
    public AlgorithmsTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of convertApoapsisDistanceToAU method, of class Algorithms.
     */
    @Test
    public void testConvertApoapsisDistanceToAU() {
        System.out.println("convertApoapsisDistanceToAU");
        double apoapsisDistance = 16523;
        double expResult = 0.00011044;
        double result = Algorithms.convertApoapsisDistanceToAU(apoapsisDistance);
        assertEquals(expResult, result, 0.00000001);
    }

    /**
     * Test of convertPeriapsisDistanceToAU method, of class Algorithms.
     */
    @Test
    public void testConvertPeriapsisDistanceToAU() {
        System.out.println("convertApoapsisDistanceToAU");
        double apoapsisDistance = 16523;
        double expResult = 0.00011044;
        double result = Algorithms.convertPeriapsisDistanceToAU(apoapsisDistance);
        assertEquals(expResult, result, 0.00000001);
    }

    /**
     * Test of calculatSemiMajorAxis method, of class Algorithms.
     */
    @Test
    public void testCalculatSemiMajorAxis() {
        System.out.println("calculatSemiMajorAxis");
        int apoapsisDistance = 16523;
        int periapsisDistance = 16523;
        int expResult = 16523;
        double result = Algorithms.calculatSemiMajorAxis(apoapsisDistance, periapsisDistance);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculatEccentricity method, of class Algorithms.
     */
    @Test
    public void testCalculatEccentricity() {
        System.out.println("calculatEccentricity");
        double apoapsisDistance = 16523;
        double semiMajorAxis = 16523;
        double expResult = 0.0;
        double result = Algorithms.calculatEccentricity(apoapsisDistance, semiMajorAxis);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculatePeriod method, of class Algorithms.
     */
    @Test
    public void testCalculatePeriod() {
        System.out.println("calculatePeriod");
        double semiMajorAxis = 16523;
        double expResult = 2123896.5247;
        double result = Algorithms.calculatePeriod(semiMajorAxis);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of calculateAverageVelocity method, of class Algorithms.
     */
    @Test
    public void testCalculateAverageVelocity() {
        System.out.println("calculateAverageVelocity");
        double apoapsisDistanceFromSun = 16523;
        double periapsisDistanceFromSun = 16523;
        double mass = 16523654;
        double semiMajorAxis = 16523;
        double period = 2;
        double apoVel = Algorithms.calculateVelocity(apoapsisDistanceFromSun, semiMajorAxis, mass, period);
        double periVel = Algorithms.calculateVelocity(periapsisDistanceFromSun, semiMajorAxis, mass, period);
        
        double expResult = apoVel;
        double result = Algorithms.calculateAverageVelocity(apoapsisDistanceFromSun, periapsisDistanceFromSun, mass, semiMajorAxis, period);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calculateVelocity method, of class Algorithms.
     */
    @Test
    public void testCalculateVelocity() {
        System.out.println("calculateVelocity");
        double radiusFromSun = 16523;
        double semiMajorAxis = 16523;
        double mass = 16523654;
        double period = 2;
        double expResult = 246242.92548590555;
        double result = Algorithms.calculateVelocity(radiusFromSun, semiMajorAxis, mass, period);
        System.out.println(result);
        assertEquals(expResult, result, 0.0000001);
    }

    /**
     * Test of calculateSemiMinorAxis method, of class Algorithms.
     */
    @Test
    public void testCalculateSemiMinorAxis() {
        System.out.println("calculateSemiMinorAxis");
        double semiMajorAxis = 16523;
        double eccentricity = 0.6;
        double expResult = 16523 * 0.8;
        double result = Algorithms.calculateSemiMinorAxis(semiMajorAxis, eccentricity);
        assertEquals(expResult, result, 0.00001);
    }

    /**
     * Test of calculateCoordsConversion method, of class Algorithms.
     */
    @Test
    public void testCalculateCoordsConversion() {
        System.out.println("calculateCoordsConversion");
        double semiMajorAxis = 16523;
        double expResult = 16523*200;
        double result = Algorithms.calculateCoordsConversion(semiMajorAxis);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of apoapsisCoordsConversion method, of class Algorithms.
     */
    @Test
    public void testApoapsisCoordsConversion() {
        System.out.println("apoapsisCoordsConversion");
        double apoapsisDistance = 16523;
        double expResult = 16523*5;
        double result = Algorithms.apoapsisCoordsConversion(apoapsisDistance);
        assertEquals(expResult, result, 0.0);
    }
    
}
