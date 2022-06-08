package com.company;

import com.company.automata.NDFA;
import com.company.automata.NDFANode;

public class RegexConverter {

    public RegexConverter() {

    }

    public void convertToNDFA(String regex) {

        //Starts with ^
        //ends with $
        // contains /test/
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

        System.out.println(startsWith + " // " + contains + " // " + endsWith);

//        NDFANode initialNode = new NDFANode(startsWith.charAt(0), false);
//        NDFA ndfa = new NDFA(initialNode);
//
        if(startsWith != ""){

        }if (contains != ""){

        }if (endsWith != ""){

        }

        // return ndfa;
        }

        public void addStartNodes(NDFA ndfa, String startString){
            if (ndfa.getAutomata().isEmpty()){
                NDFANode initalNode = new NDFANode(startString.charAt(0));
                initalNode.setStartNode(true);
                ndfa.getAutomata().add(initalNode);
            }

            for(int i = 1; i < startString.length(); i ++){
                NDFANode
            }

        }
    }




