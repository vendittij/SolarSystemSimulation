/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolarSystem;

import static java.lang.Math.pow;

/**
 * Constants for all relevant planet information needed by the Planet
 * constructor.
 *
 * @author zmb004
 */
public final class Constants {

    public static final double MERCURYMASS = 0.330 * pow(10, 24);
    public static final double MERCURYRADIUS = (4879 / 2);
    public static final double MERCURYPERIAPSIS = 46 * pow(10, 6);
    public static final double MERCURYAPOAPSIS = 69.8 * pow(10, 6);
    public static final double MERCURYINCLINATION = 7;
    public static final String MERCURYIMAGE = "mercury.jpg";
    public static final int MERCURYRATE = 1;
    public static final double VENUSMASS = 4.867 * pow(10, 24);
    public static final double VENUSRADIUS = 6051.8;
    public static final double VENUSPERIAPSIS = 107.48 * pow(10, 6);
    public static final double VENUSAPOAPSIS = 108.94 * pow(10, 6);
    public static final double VENUSINCLINATION = 3.39;
    public static final String VENUSIMAGE = "venus.jpg";
    public static final int VENUSRATE = -1;
    public static final double EARTHMASS = 5.9723 * pow(10, 24);
    public static final double EARTHRADIUS = (12756 / 2);
    public static final double EARTHPERIAPSIS = 147.1 * pow(10, 6);
    public static final double EARTHAPOAPSIS = 152.1 * pow(10, 6);
    public static final double EARTHINCLINATION = 0;
    public static final String EARTHIMAGE = "earth.jpg";
    public static final int EARTHRATE = 1;
    public static final double MARSMASS = 0.6417 * pow(10, 24);
    public static final double MARSRADIUS = 3396.2;
    public static final double MARSPERIAPSIS = 206.62 * pow(10, 6);
    public static final double MARSAPOAPSIS = 249.23 * pow(10, 6);
    public static final double MARSINCLINATION = 1.85;
    public static final String MARSIMAGE = "mars.jpg";
    public static final int MARSRATE = 1;
    public static final double JUPITERMASS = 1898.19 * pow(10, 24);
    public static final double JUPITERRADIUS = 71492;
    public static final double JUPITERPERIAPSIS = 740.52 * pow(10, 6);
    public static final double JUPITERAPOAPSIS = 816.62 * pow(10, 6);
    public static final double JUPITERINCLINATION = 1.304;
    public static final String JUPITERIMAGE = "jupiter.jpg";
    public static final int JUPITERRATE = 1;
    public static final double SATURNMASS = 568.34 * pow(10, 24);
    public static final double SATURNRADIUS = 60268;
    public static final double SATURNPERIAPSIS = 1352.55 * pow(10, 6);
    public static final double SATURNAPOAPSIS = 1514.5 * pow(10, 6);
    public static final double SATURNINCLINATION = 2.485;
    public static final String SATURNIMAGE = "saturn.jpg";
    public static final int SATURNRATE = 1;
    public static final double URANUSMASS = 86.813 * pow(10, 24);
    public static final double URANUSRADIUS = 25559;
    public static final double URANUSPERIAPSIS = 2741.3 * pow(10, 6);
    public static final double URANUSAPOAPSIS = 3003.62 * pow(10, 6);
    public static final double URANUSINCLINATION = 0.772;
    public static final String URANUSIMAGE = "uranus.jpg";
    public static final int URANUSRATE = -1;
    public static final double NEPTUNEMASS = 102.413 * pow(10, 24);
    public static final double NEPTUNERADIUS = 24764;
    public static final double NEPTUNEPERIAPSIS = 4444.45 * pow(10, 6);
    public static final double NEPTUNEAPOAPSIS = 4545.67 * pow(10, 6);
    public static final double NEPTUNEINCLINATION = 1.769;
    public static final String NEPTUNEIMAGE = "neptune.jpg";
    public static final int NEPTUNERATE = 1;
    public static final double PLUTOMASS = 0.01303 * pow(10, 24);
    public static final double PLUTORADIUS = 1187;
    public static final double PLUTOPERIAPSIS = 4436.82 * pow(10, 6);
    public static final double PLUTOAPOAPSIS = 7375.93 * pow(10, 6);
    public static final double PLUTOINCLINATION = 17.16;
    public static final String PLUTOIMAGE = "pluto.jpg";
    public static final int PLUTORATE = 1;
    public static final double SUNMASS = 1988500 * pow(10, 24);
    public static final double SUNRADIUS = 695700;
    public static final String SUNIMAGE = "sun.jpg";
}
