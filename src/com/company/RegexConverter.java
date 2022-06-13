package com.company;

import com.company.automata.NDFA;
import com.company.automata.NDFANode;

import javax.smartcardio.ATR;
import java.util.ArrayList;

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


        if(regex.contains("^") && regex.contains("/")){
            startsWith = regex.substring(regex.indexOf("^") + 1, regex.indexOf("/"));
        } else if (regex.contains("^") && regex.contains("$")) {
            startsWith = regex.substring(regex.indexOf("^") + 1, regex.indexOf("$"));
        } else if(regex.contains("^")){
            startsWith = regex.substring(regex.indexOf("^") + 1);
        }

        if(regex.contains("/")){
            contains = regex.substring(regex.indexOf("/") + 1, regex.lastIndexOf("/"));
        }

        if (regex.contains("$")){
            endsWith = regex.substring(regex.indexOf("$") + 1);
        }

//        NDFANode initialNode = new NDFANode(startsWith.charAt(0), false);
       NDFA ndfaToReturn = new NDFA();
//
        if(startsWith != ""){
            System.out.println("Hier komt ie nog");
            addStartNodes(ndfaToReturn, startsWith);
        }if (contains != ""){
            addContainsNodes(ndfaToReturn, contains);
        }if (endsWith != ""){
            addEndNode(ndfaToReturn, endsWith);
        }

            return ndfaToReturn;
        }

        public void addStartNodes(NDFA ndfa, String startString){
        ArrayList<NDFANode> nodesToAdd = new ArrayList<>();
        NDFANode initialStartNode = new NDFANode(startString.charAt(0));
        nodesToAdd.add(initialStartNode);

        //starts at one to compensate for manual adding of first node
        for (int i = 1; i < startString.length(); i++){
            NDFANode newNode = new NDFANode(startString.charAt(i));
            //System.out.println(newNode.toString());
            nodesToAdd.get(i - 1).addTransition(newNode);
            if(i == startString.length() - 1){
               newNode.addTransition(newNode);
               //ndfa.resetStopNode();
            }
            nodesToAdd.add(newNode);
        }
            ndfa.getAutomata().addAll(nodesToAdd);
       }

        public void addContainsNodes(NDFA ndfa, String containsString){
            ArrayList<NDFANode> nodesToAdd = new ArrayList<>();
            NDFANode initialStartNode = new NDFANode(containsString.charAt(0));
            initialStartNode.addTransition(initialStartNode);
            nodesToAdd.add(initialStartNode);

            //starts at one to compensate for manual adding of first node
            for (int i = 1; i < containsString.length(); i++){
                NDFANode newNode = new NDFANode(containsString.charAt(i));
                //System.out.println(newNode.toString());
                nodesToAdd.get(i - 1).addTransition(newNode);
                if(i == containsString.length() - 1) {
                    newNode.addTransition(newNode);
                    //ndfa.resetStopNode();
                }
                nodesToAdd.add(newNode);
            }
            ndfa.getAutomata().addAll(nodesToAdd);
        }

        public void addEndNode(NDFA ndfa, String endString){
            ArrayList<NDFANode> nodesToAdd = new ArrayList<>();
            NDFANode initialStartNode = new NDFANode(endString.charAt(0));
            initialStartNode.addTransition(initialStartNode);
            nodesToAdd.add(initialStartNode);

            //starts at one to compensate for manual adding of first node
            for (int i = 1; i < endString.length(); i++){
                NDFANode newNode = new NDFANode(endString.charAt(i));
                //System.out.println(newNode.toString());
                nodesToAdd.get(i - 1).addTransition(newNode);
                nodesToAdd.add(newNode);
            }
            ndfa.getAutomata().addAll(nodesToAdd);
            //ndfa.resetStopNode();
        }
    }




