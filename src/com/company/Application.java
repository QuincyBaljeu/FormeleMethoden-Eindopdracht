package com.company;

import com.company.automata.NDFA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    RegexConverter converter = new RegexConverter();
    HashMap<String, NDFA> automataMap = new HashMap<>();
    HashMap<String, String> regexMap = new HashMap<>();

    public void run(){

        Scanner scanner = new Scanner(System.in);
        String userInput;
        boolean running = true;

        getTestData();
        while(running){
            System.out.println("Options: \n 1. Check medicine \n 2. New regex \n 3. Run NDFA \n 4. Run DFA \n 5. Quit");
            userInput = scanner.nextLine();
//            System.out.println("Userinput: " + userInput);
            switch (userInput){
                case "1" :
                    System.out.println("Enter medicine");
                    String inputMedicine = scanner.nextLine();
                    String prescriptionString = getPrescriptionAlt(inputMedicine);
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
//                        System.out.println("What string?");
//                        String stringToCheck = scanner.nextLine();
//
//                        if(!stringToCheck.isEmpty()){
//                            System.out.println("Result of automata is: " + automataMap.get(userInput).check(stringToCheck));
//                        }
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
                        alphabet = alphabet.replace("^", "");
                        alphabet = alphabet.replace("/", "");
                        alphabet = alphabet.replace("$", "");

                        convertedAutomata.convertToDFA(alphabet);

//                        System.out.println("What string?");
//                        String stringToCheck = scanner.nextLine();
//
//                        if(!stringToCheck.isEmpty()){
//                            System.out.println("Result of automata is: " + convertedAutomata.check(stringToCheck));
//                        }
                        convertedAutomata.print();

                    }

                    break;
                case "5":
                    running = false;
                    break;
            }
        }
    }

    //set to private
    public String getPrescription(String medicine){
        String prescription = "Prescription for: " + medicine + "\n";

        for (String regex : regexMap.keySet()){
            Pattern regexPattern = Pattern.compile(regex);
            Matcher matcher = regexPattern.matcher(medicine);
            boolean regexMatch = matcher.find();

            if(regexMatch){
                prescription += regexMap.get(regex) + "\n";
            }
        }

        return prescription;
    }

    private String getPrescriptionAlt(String medicine){
        String prescription = "Prescription for: " + medicine + "\n";

        for(String regex : regexMap.keySet()){
            String sequence = "";
            if(regex.contains("^")){
                sequence = regex.replace("^", "");
                if(medicine.startsWith(sequence)){
                    prescription+= regexMap.get(regex) + "\n";
                }
            } else if (regex.contains("/")){
                sequence = regex.replace("/", "");
                if (medicine.contains(sequence)){
                    prescription+=regexMap.get(regex) + "\n";
                }
            } else if(regex.contains("$")){
                sequence = regex.replace("$", "");
                if (medicine.endsWith(sequence)){
                    prescription += regexMap.get(regex) + "\n";
                }
            }
        }

        return prescription;
    }

    //set to private
    public void getTestData(){

        //prefixes
        regexMap.put("^benzyl", "Dit middel bevat een benzyl groep \n" +
                "Een benzylgroep kan gebruikt worden voor het beschermen van een binding \n" +
                "of deze juist open te stellen om te reageren met een andere stof");
        automataMap.put("^benzyl", converter.convertToNDFA("^benzyl"));

        regexMap.put("^methyl", "Dit middel bevat een methyl groep \n" +
                "Een methylgroep kan gebruikt worden om er voor te zorgen dat een stof beter oplost in organisch middel \n");
        automataMap.put("^methyl", converter.convertToNDFA("^methyl"));

        regexMap.put("^fenyl", "Dit middel bevat een fenyl groep \n" +
                "Een fenylgroep kan gebruikt worden om een binding met een andere stof te laten reageren\n");
        automataMap.put("^fenyl", converter.convertToNDFA("^fenyl"));

        //tussen fixes
        regexMap.put("/mono/", "Dit middel bevat 1 van de hierna genoemde groepen");
        automataMap.put("/mono/", converter.convertToNDFA("/mono/"));

        regexMap.put("/di/", "Dit middel bevat 2 van de hierna genoemde groepen");
        automataMap.put("/di/", converter.convertToNDFA("/di/"));

        regexMap.put("/tri/", "Dit middel bevat 3 van de hierna genoemde groepen");
        automataMap.put("tri", converter.convertToNDFA("/tri/"));

                //postfixes
        regexMap.put("zepam$", "Dit middel bevat een benzodiazepine \n" +
                "Dit middel is een pschytroop middel \n" +
                "Dit middel kan verslavend zijn \n" +
                "Mogelijke bijwerkingen: \n Slaperigheid, afname in concentratie, geheugenverlies");
        automataMap.put("zepam$", converter.convertToNDFA("$zepam"));

        regexMap.put("illine$", "Dit middel bevat penicilline \n" +
                "Dit middel is een antibacterieel middel \n +" +
                "Mogelijke bijwerkingen: Huiduitslag, jeuk, maag-darmklachten");
        automataMap.put("illine$", converter.convertToNDFA("$illine"));

        regexMap.put("mycine$", "Dit middel bevat een macrolide \n" +
                "Dit middel is een antibiotica, dit middle kan gebruikt worden voor infecties" +
                "Mogelijke bijwerkingen: Maag-darmklachten, duizeligheid");
        automataMap.put("mycine$", converter.convertToNDFA("$mycine"));

        regexMap.put("caine$", "Dit middel is een anaesthesia \n" +
                "Dit middel kan gebruikt worden voor plaatselijke verdovingen \n" +
                "Dit middel mag niet gebruikt worden indien er gebreken zijn bij het bloedvolume of zuurstofgehalte \n" +
                "Dit middel kan invloed hebben op rijvaardigheid \n" +
                "Mogelijke bijwerkingen: Misselijkheid of braken, plaatselijke pijn");
        automataMap.put("caine$", converter.convertToNDFA("$caine"));


        System.out.println("test data added");
    }

    public HashMap<String, String> getRegexMap() {
        return regexMap;
    }
}
