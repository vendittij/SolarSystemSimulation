Solar System Simulator - Bucknell CSCI205, Spring 2017

Authors: Gabe Gomez, John Venditti, Zach Brill, Tyler DiBartolo
Team: Superfish LLC
Revision: 1.00
Date: May 2nd, 2017

INTRODUCTION
===================================================
Our project is a Solar System Simulator. It provides a basic visual and textual overview of our local solar system, centered around the Sun. In our program, the user is treated to a graphical, to-scale rendering of the planets and their motion around the Sun. 

The user will also be presented with all relevant information about each planet within the solar system. This information appears at the bottom of the interface, and uses a scrolling pane in order to allow for all information to be displayed on the screen. 



INSTRUCTIONS
===================================================
All of our main files are kept within the src directory. Within the src folder, SolarSystem will contain all relevant Java files to be compiled and run. The only file that needs to be executed is titled JavaFXMain.java. Once this file is run, our program will appear. The user can use the keys W, A, S, and D to navigate the simulation, in a similar way to controlling a video game using the same keys. W will move the frame up, A will move the frame left, S will move the frame down, and D will move the frame right. The I (capital i) key will allow the user to zoom in on whatever particular region of the solar system is in view at the time. Similarly, the O (capital o) key performs a zoom out. We’ve also implemented a reset function, that can be executed by pressing the R key. This brings the Sun back to the center of the frame, allowing the user to never get lost when zooming in or out too far. 

SIDE NOTE: If the planets do not appear with wrapper images, they have probably become corrupt when pulling from GIT. If this happens, you will have to manually retrieve the images from GIT, and add them into the DiffuseMaps folder within the project’s src folder. 

