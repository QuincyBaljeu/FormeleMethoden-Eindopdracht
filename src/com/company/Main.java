package com.company;


import com.company.automata.NDFA;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Application application = new Application();
        RegexConverter converter = new RegexConverter();

        //application.run();

        NDFA ndfaTest = converter.convertToNDFA("/benzeen/");
        System.out.println(ndfaTest.toString());
        ndfaTest.check("benzyl");
    }
}
