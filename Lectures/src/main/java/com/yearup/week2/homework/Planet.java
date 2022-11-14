package com.yearup.week2.homework;
import java.util.*;
//LuClandereine Leger
//Parts 4-6 Java HW
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

    }

}