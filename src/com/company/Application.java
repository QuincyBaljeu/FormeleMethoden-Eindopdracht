package com.company;

import java.util.Scanner;

public class Application {
    Benzyl benzyl = new Benzyl();
    RegexConverter converter = new RegexConverter();

    public void run(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dit werkt");

        converter.convertToNDFA("^test/asd/$yoo");
//        String input = scanner.nextLine();
//        if (benzyl.assertRegex(input)){
//            System.out.println("Dit is een benzyl medic.");
//        }


    }
}
