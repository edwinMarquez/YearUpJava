package com.yearup.week2.homework;
import java.util.*;
//LuClandereine Leger
//Parts 4-6 Java HW 2 and HW 3
//note: since HW3 uses the executor class I have included in this file
//HomeWork 3 is located at the bottom starting line 107
class Planet implements Calculator{
    //Part 4
    static String star;

    String getStar(){
        return this.star;
    }
    String planetName;
    double planetRadius;

    @Override
    public double Area(double length, double width) {
        double Area = 3.14*this.planetRadius*this.planetRadius;
        return Area;
    }

    @Override
    public double Sum(double num1, double num2) {
        return 0;
    }

    @Override
    public double Volume(double length, double width, double height) {
        return 0;
    }
}
class SolarSystemPlanet extends Planet{
    static private String star = "SUN";
    @Override
    String getStar(){
        return this.star;
    }
    int planetPosition(String planet){
        int position;
        switch(planet){
            case "Mercury":
                position = 1;
                break;
            case "Venus":
                position = 2;
                break;
            case "Earth":
                position = 3;
                break;
            case "Mars":
                position = 4;
                break;
            case "Jupiter":
                position = 5;
                break;
            case "Saturn":
                position = 6;
                break;
            case "Uranus":
                position = 7;
                break;
            case "Neptune":
                position = 8;
                break;
            default:
                position =  0;
                break;
        }
        return position;
    }


}
//Part 6
class Executor{
    static Scanner scanner = new Scanner(System.in);
    static SolarSystemPlanet planet = new SolarSystemPlanet();
    static double radius;
    static String setPlanet(){//question 5
        System.out.println("Enter the planet name: ");
        planet.planetName = scanner.nextLine();
        return planet.planetName;
    }
    static double setRadius(){//7
        System.out.println("Enter the planets radius: ");
        planet.planetRadius = scanner.nextDouble();
        radius = planet.planetRadius;
        return planet.planetRadius;
    }
    //9
    static void getArea(double area){
        System.out.println("Area of the planet is "+ area);
    }
    //10 hmmmmmm
    static void getStar(){
        System.out.println("Star of the planet is " + planet.getStar());

    }
    //12
    //parameter: position function
    //
    static void planetPosition(int position){
        System.out.println("The position of the planet is "+ position);
    }

    //Start of HomeWork 3//
    //Part 1
    interface CelestialObject{
        void displayCelestialobject();
    }
    CelestialObject CelestialObject = new CelestialObject(){
        @Override
        public void displayCelestialobject() {
            System.out.println("Comet is a celestial object.");
        }
    };
    //part 2
    static class Milky{
        void location(){
            System.out.println("Your planet belongs to Milky way galaxy.");
        }
    }
    enum PlanetName{
        MERCURY(0,"MERCURY"),
        VENUS(0,"VENUS"),
        EARTH(1,"EARTH"),
        MARS(2,"MARS"),
        JUPITER(80,"JUPITER"),
        SATURN(83,"SATURN"),
        URANUS(27,"URANUS"),
        NEPTUNE(14,"NEPTUNE");

        int moons;
        String planetName;

        PlanetName(int moons, String planetName) {
            this.planetName = planetName;
            this.moons = moons;
        }
        int getMoons(String planetName){
            return this.moons;
        }
        String getPlanetName(){
            return this.planetName;
        }
    }
    static void check(){
        System.out.println("This is a loop to test the enum " +
            "PlanetName getMoons method.\n Enter all the planet" +
            "names in any order you want.\n The loop will go" +
            " 8 times because there are 8 planets.\n To exit the" +
            "loop enter -1 ");
        for (PlanetName test : PlanetName.values()){

            System.out.println("Enter a planet: ");
            String planet = (scanner.nextLine()).toUpperCase();
            if (planet.equals("-1")){
                break;
            }

            //first loops is just a counter, second loop checks
            //which planet name the person said
            //this may seem extra but its necessary
            for (PlanetName ah: PlanetName.values()){
                if (planet.equals(ah.getPlanetName())){
                    System.out.println(ah.getMoons(planet));
                }

            }


        }
    }

    ////////////////end of HW 3 (to be continued in main)/////////////
    public static void main (String[] args){
        //Welcome
        System.out.println("===========================\n" +
                            "Welcome to the Solar System\n"+
                            "===========================\n");
        //question 6
        String storePlanet;
        storePlanet = setPlanet();
        //8
        double area;
        area = planet.Area(planet.planetRadius, planet.planetRadius);

        //11
        getStar();
        //13
        planetPosition(planet.planetPosition(storePlanet));

        //Bonus Question
        System.out.println("Would you like to check the details for any other planet? Say 'y' for yes");
        String again = scanner.nextLine();
        if (again.equals("y")){
            storePlanet = setPlanet();
            area = planet.Area(planet.planetRadius, planet.planetRadius);
            getStar();
            //13
            planetPosition(planet.planetPosition(storePlanet));
        }else{
            System.out.println("Thanks for using our planet application. Goodbye!");
        }

        //Start of Main class for Homework 3 --------------------------------------------------------------

        String test = " ";
        do {
            check();
            System.out.println("Do you want to test again? Press y " +
                    "for yes and n for no");
            test = scanner.nextLine();
        }while(test.equals("y"));

    }

}