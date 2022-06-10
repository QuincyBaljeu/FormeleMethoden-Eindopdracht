package com.company;

import com.company.automata.NDFA;
import com.company.automata.NDFANode;

public class RegexConverter {

    public RegexConverter() {

    }

    //set to NDFA
    public NDFA convertToNDFA(String regex) {

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
       NDFA ndfaToReturn = new NDFA();
//
        if(startsWith != ""){
            addStartNodes(ndfaToReturn, startsWith);

        }if (contains != ""){

        }if (endsWith != ""){

        }

            return ndfaToReturn;
        }

        public void addStartNodes(NDFA ndfa, String startString){
            if (ndfa.getAutomata().isEmpty()){
                NDFANode initalNode = new NDFANode(startString.charAt(0));
                initalNode.setStartNode(true);
                ndfa.getAutomata().add(initalNode);
            }

            for(int i = 0; i < startString.length(); i ++){
//                if(i == startString.length()){
//                    NDFANode newNode = new NDFANode(startString.charAt(i));
//                    newNode.setStopNode(true);
//                    newNode.toString();
//                } else {
//                    NDFANode newNode = new NDFANode(startString.charAt(i+1));
//                    ndfa.getAutomata().add(newNode);
//                    ndfa.getAutomata().get(i).setNextNDFANode(newNode);
//                }
//                System.out.println(i);

            }

        }
    }




