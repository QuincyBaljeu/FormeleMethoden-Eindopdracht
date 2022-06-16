package com.company;

import com.company.automata.NDFA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    RegexConverter converter = new RegexConverter();
    ArrayList<NDFA> automata = new ArrayList<>();
    HashMap<String, NDFA> automataMap = new HashMap<>();
    HashMap<String, String> regexMap = new HashMap<>();

    public void run(){

        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean running = true;

        while(running){
            System.out.println("Options: \n 1. Check medicine \n 2. New regex \n 3. Run NDFA \n 4. Run DFA \n 5. Quit");
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
                    automataMap.put(inputRegex, converter.convertToNDFA(inputRegex));
                    break;
                case "3" :
                    System.out.println("Which NDFA?");
                    for (String regex : automataMap.keySet()){
                        System.out.println(regex);
                    }

                    userInput = scanner.nextLine();
                    if (!automataMap.containsKey(userInput)){
                        System.out.println("No NDFA found");
                    } else {
                        automataMap.get(userInput).print();
                    }
                    break;
                case "4" :
                    System.out.println("Which DFA?");
                    for (String regex : automataMap.keySet()){
                        System.out.println(regex);
                    }

                    userInput = scanner.nextLine();
                    if (!automataMap.containsKey(userInput)){
                        System.out.println("No DFA found");
                    } else {
                        NDFA convertedAutomata = automataMap.get(userInput);

                        //Remove regex characters from alphabet, does not work :(
                        String alphabet = userInput;
                        alphabet.replace("^", "");
                        alphabet.replace("/", "");
                        alphabet.replace("$", "");

                        convertedAutomata.convertToDFA(alphabet);
                        convertedAutomata.print();
                    }

                    break;
                case "5":
                    running = false;
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


    private void getTestData(){
        regexMap.put("$zepam", "Dit middel bevat een benzodiazepine \n" +
                "Dit middel kan spierontspannend/rustgevend werken \n" +
                "Dit middel kan verslavend zijn");
        System.out.println("test data added");
    }
}
