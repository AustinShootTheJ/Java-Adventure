package com.example.adventure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // creates a map which takes an int as a key and a Location object as a definition.
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        // populates locations with ints and Location objects. We use the new modifer since no existing Location object is being referenced.
        locations.put(0, new Location(0,"You are sitting in front of a computer learning Java",null));


        tempExit = new HashMap<String, Integer>();
        // exits from room 1
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        locations.put(1, new Location(1,"You are standing at the end of a road before a small brick building",tempExit));
        tempExit = new HashMap<String, Integer>();

        // exits for room 2
        tempExit.put("N",5);
        locations.put(2, new Location(2,"You are at the top of a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        // exits for room 3
        tempExit.put("W",1);
        locations.put(3, new Location(3,"You are inside a building, a well house for a small spring",tempExit));

        tempExit = new HashMap<String, Integer>();
        // exits for room 4
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4, new Location(4,"You are in a valley beside a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        // exits for room 5
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5, new Location(5,"You are in the forest",tempExit));
        
        // Words to check against for directional values.
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT","Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH","S");
        vocabulary.put("WEST","W");
        vocabulary.put("EAST","E");





        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }
            Map<String,Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            // checks for input that is not a single char
            if(direction.length() > 1){
                // splits the string into an array for checking
                String[] words = direction.split(" ");
                // checks each word until it finds one in our vocab and assigns direction to the related key.
                for(String word: words){
                    if(vocabulary.containsKey(word)){
                        direction = vocabulary.get(word);
                        // break is inserted so we do not check the rest of the words in the sentence.
                        break;
                    }
                }
            }


            // old solution for handling word inputs.
//            if(direction.length()>1) {
//                String[] directionArray = direction.split(" ");
//                for (String i : directionArray) {
//                    switch (i) {
//                        case "WEST":
//                            direction = "W";
//                            loc = exits.get(direction);
//                            break;
//                        case "EAST":
//                            direction = "E";
//                            loc = exits.get(direction);
//                            break;
//                        case "NORTH":
//                            direction = "N";
//                            loc = exits.get(direction);
//                            break;
//                        case "SOUTH":
//                            direction = "S";
//                            loc = exits.get(direction);
//                            break;
//                        default:
//                            break;
//                    }
//                }
//            }

            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            }

            else{
                System.out.println("You cannot go in that direction");
            }

        }

        // code for how to split a string in Java using a string array and the .split method.
//        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
//        for (String i : road){
//            System.out.println(i);
//        }




    }


}
