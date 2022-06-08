package com.company;

import com.company.automata.NDFA;

public class RegexConverter {

    public RegexConverter() {

    }

    public void convertToNDFA(String regex) {

        //Starts with ^
        //ends with $
        // contains /test/
//        NDFA ndfa = new NDFA();

        String startsWith = "";
        String contains = "";
        String endsWith = "";

        if(regex.contains("^") || regex.contains("/")){
            startsWith = regex.substring(regex.indexOf("^") + 1, regex.indexOf("/"));
        } else if (regex.contains("^") || regex.contains("$")) {
            startsWith = regex.substring(regex.indexOf("^") + 1, regex.indexOf("$"));
        } else {
            startsWith = regex.substring(regex.indexOf("^") + 1);
        }

        if(regex.contains("/")){
            contains = regex.substring(regex.indexOf("/") + 1, regex.lastIndexOf("/"));
        }

        if (regex.contains("$")){
            endsWith = regex.substring(regex.indexOf("$") + 1);
        }

//        if (regex.contains("^") || regex.contains("/")) {
//            startsWith = regex.substring(0, regex.indexOf("/"));
//        } if (regex.contains("/")){
//            contains = regex.substring(regex.lastIndexOf("/"), regex.lastIndexOf("/"));
//        } if (regex.contains("$")){
//            endsWith = regex.substring(regex.lastIndexOf("$"));
//        }

            System.out.println(startsWith + " // " + contains + " // " + endsWith);

            // return ndfa;
        }
    }


