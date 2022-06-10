package com.company;

import com.company.automata.NDFA;
import com.company.automata.NDFANode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    RegexConverter converter = new RegexConverter();
    HashMap<NDFA, String> ndfaMap = new HashMap<>();
    HashMap<String, String> regexMap = new HashMap<>();

    public void run(){

        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean running = true;

        while(running){
            System.out.println("Options: \n 1. Check medicine \n 2. New regex");
            userInput = scanner.nextLine();
//            System.out.println("Userinput: " + userInput);
            switch (userInput){
                case "1" :
                    System.out.println("Enter medicine");
                    String inputMedicine = scanner.nextLine();
                    String prescriptionString = getPrescription(inputMedicine);
                    System.out.println(prescriptionString);
                    break;
                case "2" :
                    System.out.println("Enter regex");
                    String inputRegex = scanner.nextLine();
//                    System.out.println(inputRegex);
                    System.out.println("Enter prescription info");
                    String inputInfo = scanner.nextLine();
//                    System.out.println(inputInfo);
                    regexMap.put(inputRegex, inputInfo);
                    break;
            }
        }
    }

    private String getPrescription(String medicine){
        String prescription = "Prescription for: " + medicine + "\n";

        for (String regex : regexMap.keySet()){
            Pattern regexPattern = Pattern.compile(regex);
            if(regexPattern.matcher(medicine).find()){
                prescription += regexMap.get(regex) + "\n";
            }
        }

        return prescription;
    }
}
