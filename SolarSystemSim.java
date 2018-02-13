/*
    Author: Michael Moschetti
    References: https://www.britannica.com/science/astronomical-unit
                https://stackoverflow.com/questions/2722122/java-parse-a-number-in-exponential-notation
                https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
*/
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

class Body {

    // Distance between Earth and Sun in meters. Used to calculate AU
    public static final long auFactor = Double.valueOf("149597870.7e3").longValue();

    private String bodyName;
    private String orbitSrc;
    private long mass;
    private long diameter;
    private long meanDistance;

    Body(String bodyName, String orbitSrc, long mass, long diameter, long meanDistance) {
        this.bodyName = bodyName;
        this.orbitSrc = orbitSrc;
        this.mass = mass;
        this.diameter = diameter;
        this.meanDistance = meanDistance;
    }

    public String toString() {
        return "*****Body info*****\n"
            + "Name: " + bodyName + '\n'
            + "Orbits: " + orbitSrc + '\n'
            + "Mass: " + mass + " kg\n"
            + "Diameter: " + diameter + " m\n"
            + "Mean distance (m): " + meanDistance + '\n'
            + "Mean distance (AU): " + convertToAU() + '\n';
    }

    // Get relative distance as compared to Earth and Sun
    // Need to cast to double
    public double convertToAU() {
        return meanDistance*1.0/auFactor;
    }
}

class SolarSystemSim {
    
    private static HashMap<String, Body> solarSystem;

    public static void main(String args[]) {
        solarSystem = new HashMap<>();
        read();
        
        Body sun = solarSystem.get("Sun");
        Body venus = solarSystem.get("Venus");
        Body earth = solarSystem.get("Earth");
        Body moon = solarSystem.get("Moon"); 
        
        System.out.print(sun);
        System.out.print(venus);
        System.out.print(earth);
        System.out.print(moon);
    }

    public static void read() {
        try {
            File f = new File("solarsystem.dat");
            FileReader fr = new FileReader(f);
            Scanner s = new Scanner(new BufferedReader(fr));
            s.nextLine();
            while(s.hasNextLine()) {
                String line = s.nextLine();
                String[] splitted = line.split("\\s+");

                String name = splitted[0];
                String orbitSrc = splitted[1];
                long mass = Double.valueOf(splitted[2]).longValue();
                long diameter = Double.valueOf(splitted[3]).longValue();
                long pHel = Double.valueOf(splitted[4]).longValue();
                long aHel = Double.valueOf(splitted[5]).longValue();

                solarSystem.put(name, new Body(name, orbitSrc, mass, diameter, (pHel + aHel) / 2));
            }
            s.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    public static void viewAllBodies() {
        for(String key : solarSystem.keySet()) {
            System.out.println(key);
        }
    }

    public static void printAll() {
        for(Object body : solarSystem.values()) {
            System.out.print(body);
        }
    }
};
