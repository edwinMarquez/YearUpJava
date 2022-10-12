package com.yearup.week7.regexsample;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * This class is used to test regex, it works by first asking the regex , then asking for
 * string to test the regex against, it tries and print all information regarding the matcher.
 *
 * @author Edwin
 */
public class RegexMain {


    public static void main(String[] args){
        System.out.println("Regex Testing: ");


        //this program is intended to help test and experiment with regular expressions.
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while(true){
            //first set a regex
            System.out.println("==================================");
            System.out.println("Please do set a Regex (or type quit): ");
            input = scanner.nextLine();
            if(input.trim().equals("quit"))break;
            try {
                Pattern pattern = Pattern.compile(input);
                while(true){
                    //then ask for any string to test the regex against.
                    System.out.println("\tType a string to test against (or type back)");
                    System.out.print("\t"); input = scanner.nextLine();
                    if(input.trim().equals("back"))break;
                    Matcher matcher = pattern.matcher(input);
                    boolean matches = matcher.matches();
                    System.out.println("\tMatches: " + matcher.matches());
                    if(matches || matcher.find(0)){
                        do {
                            System.out.println(" \t------------- find -----------");
                            System.out.println("\tstart: " + matcher.start() + ":: end: " + matcher.end() + ":: matched: " + input.substring(matcher.start(), matcher.end()));
                            System.out.println(" \t------------- group(s) -----------");
                            int totalGroups = matcher.groupCount();
                            System.out.println("\tgroup count: " + totalGroups);
                            if (totalGroups > 0) {
                                for (int i = 0; i <= totalGroups; i++) {
                                    System.out.println("\tgroup: " + i + " :: content: " + matcher.group(i));
                                }
                            }
                        }while(matcher.find());
                    }
                }
            }catch (IllegalArgumentException iae){
                iae.printStackTrace();
            }
        }
    }
}
