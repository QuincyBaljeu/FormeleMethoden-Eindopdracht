package com.company;

import com.company.automata.NDFA;

public class RegexConverter {

    public RegexConverter(){

    }

    public NDFA convertToNDFA(String regex){

        //Starts with ^
        //ends with $
        // contains /test/
        NDFA ndfa = new NDFA();

        String startsWith = "";
        String contains = "";
        String endsWith = "";

        if(regex.contains("^")){
            startsWith = regex.substring(0, regex.lastIndexOf("^"));
        } if (regex.contains("/")){
            contains = regex.substring(regex.lastIndexOf("/"), regex.lastIndexOf("/"));
        } if (regex.contains("$")){
            endsWith = regex.substring(regex.lastIndexOf("$"));
        }

        System.out.println(startsWith + " // " + contains + " // " + endsWith);

        return ndfa;
    }
}
