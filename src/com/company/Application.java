package com.company;

import java.util.Scanner;

public class Application {
    Benzyl benzyl = new Benzyl();

    public void run(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dit werkt");

        String input = scanner.nextLine();
        if (benzyl.assertRegex(input)){
            System.out.println("Dit is een benzyl medic.");
        }


    }
}
