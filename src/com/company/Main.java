package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int key;
	    String fileName = "C:\\Users\\GBTC440018ur\\IdeaProjects\\HashMapsExercise\\myHashMap.txt";
        Scanner input = new Scanner(System.in);
        HashMap<Integer, String> myMap = new HashMap<>();
        populateFromFile(myMap, fileName);//Populates a HashMap from a file
        //myMap.put(1,"one");
        //myMap.put(2,"two");
        //myMap.put(3,"three");

        System.out.print("Enter a number: ");
        key = input.nextInt();
        getValue(key, myMap);
        //writeToFile(myMap);
    }

    private static void populateFromFile(HashMap<Integer, String> myMap, String fileName) {
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(
//                    new FileReader("C:\\Users\\GBTC440018ur\\IdeaProjects\\HashMapsExercise\\myHashMap.txt"));
//            String line = reader.readLine();
//
//            while(line != null){
//                String[] key_value_pair = line.split(" ");
//                //System.out.printf("Key: %s Value: %s\n",key_value_pair[0],key_value_pair[1]);
//                myMap.put(Integer.parseInt(key_value_pair[0]), key_value_pair[1]);
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found!");
//        } catch(Exception ex){
//            System.out.println("Something went wrong!");
//        }
        File file = new File(fileName);
        try {
            Scanner scanInput = new Scanner(file);
            while(scanInput.hasNextLine()){
                myMap.put(scanInput.nextInt(),scanInput.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }
    }

    private static void writeToFile(HashMap<Integer, String> myMap) {
        String fileName = (System.getProperty("user.dir")+File.separatorChar+"myHashMap.txt");
        File file = new File(fileName);
        PrintWriter writer=null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }

        for(Integer key: myMap.keySet()){
            writer.printf("%d %s\n", key, myMap.get(key));
        }
        writer.close();
    }

    private static void getValue(int k, HashMap<Integer, String> map){
        String value;
        Scanner input = new Scanner(System.in);
        if(!map.containsKey(k)){
            System.out.print("The number was not found, please spell it to add it: ");
            value=input.nextLine();
            map.put(k,value);
            getValue(k,map);
        }else{
            System.out.printf("You entered %s.\n", map.get(k));
        }
    }
}
