package com.company;

import com.company.automata.NDFA;
import com.company.automata.Node;

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

        NDFA ndfaToReturn = new NDFA();

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
        ArrayList<Node> nodesToAdd = new ArrayList<>();
        Node initialStartNode = new Node(startString.charAt(0));
        nodesToAdd.add(initialStartNode);

        //starts at one to compensate for manual adding of first node
        for (int i = 1; i < startString.length(); i++){
            Node newNode = new Node(startString.charAt(i));
            //System.out.println(newNode.toString());
            nodesToAdd.get(i - 1).addTransition(newNode);
            if(i == startString.length() - 1){
               newNode.addTransition(newNode);
            }
            nodesToAdd.add(newNode);
        }
            ndfa.getAutomata().addAll(nodesToAdd);
            ndfa.resetStopNode();
       }

        public void addContainsNodes(NDFA ndfa, String containsString){
            ArrayList<Node> nodesToAdd = new ArrayList<>();
            Node initialStartNode = new Node(containsString.charAt(0));
            initialStartNode.addTransition(initialStartNode);
            nodesToAdd.add(initialStartNode);

            if(!ndfa.getAutomata().isEmpty()){
                ndfa.getAutomata().get(ndfa.getAutomata().size()-1).addTransition(initialStartNode);
            }

            //starts at one to compensate for manual adding of first node
            for (int i = 1; i < containsString.length(); i++){
                Node newNode = new Node(containsString.charAt(i));
                //System.out.println(newNode.toString());
                nodesToAdd.get(i - 1).addTransition(newNode);
                if(i == containsString.length() - 1) {
                    newNode.addTransition(newNode);

                }
                nodesToAdd.add(newNode);
            }
            ndfa.getAutomata().addAll(nodesToAdd);
            ndfa.resetStopNode();
        }

        public void addEndNode(NDFA ndfa, String endString){
            ArrayList<Node> nodesToAdd = new ArrayList<>();
            Node initialStartNode = new Node(endString.charAt(0));
            initialStartNode.addTransition(initialStartNode);
            nodesToAdd.add(initialStartNode);

            if(!ndfa.getAutomata().isEmpty()){
                ndfa.getAutomata().get(ndfa.getAutomata().size()-1).addTransition(initialStartNode);
            }

            //starts at one to compensate for manual adding of first node
            for (int i = 1; i < endString.length(); i++){
                Node newNode = new Node(endString.charAt(i));
                //System.out.println(newNode.toString());
                nodesToAdd.get(i - 1).addTransition(newNode);
                nodesToAdd.add(newNode);
            }
            ndfa.getAutomata().addAll(nodesToAdd);
            ndfa.resetStopNode();
        }
    }




