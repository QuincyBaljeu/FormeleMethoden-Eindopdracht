package com.company;


import com.company.automata.NDFA;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Application application = new Application();
        RegexConverter converter = new RegexConverter();

        //application.run();

        //application.getTestData();
        //application.getPrescription("dioxazepam");

        NDFA ndfaTest = converter.convertToNDFA("^aab$cd");
        ndfaTest.convertToDFA("abcd");
        System.out.println(ndfaTest.toString());
        //System.out.println(ndfaTest.check("benzylpentend"));
    }
}
