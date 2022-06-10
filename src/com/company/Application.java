package com.company;

import com.company.automata.NDFA;
import com.company.automata.NDFANode;

import java.util.Scanner;

public class Application {
    Benzyl benzyl = new Benzyl();
    RegexConverter converter = new RegexConverter();

    public void run(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Options: \n 1. Check medicine \n 2. New regex");

        boolean running = true;

        while(running){
            String userInput = scanner.nextLine();
            System.out.println("Userinput: " + userInput);
            if (userInput == "1"){
                System.out.println("medicine");
            } else if(scanner.nextLine() == "2"){
                System.out.println("regex");
            }

        }


//        NDFA ndfa = converter.convertToNDFA("^test/asd/$yoo");

//        for (NDFANode node : ndfa.getAutomata()){
//            System.out.println(node.toString());
//        }

//        String input = scanner.nextLine();
//        if (benzyl.assertRegex(input)){
//            System.out.println("Dit is een benzyl medic.");
//        }


    }
}
