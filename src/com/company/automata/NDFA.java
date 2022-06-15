package com.company.automata;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.List;

public class NDFA {
    private List<NDFANode> automata = new LinkedList<>();
    private NDFANode initialNode;

    public NDFA(NDFANode initialNode){
        this.initialNode = initialNode;
    }

    public NDFA() {
    }

    public void addNode(NDFANode NDFANode){
        this.automata.add(NDFANode);
    }

    public List<NDFANode> getAutomata() {
        return automata;
    }

    public void setAutomata(List<NDFANode> automata) {
        this.automata = automata;
    }

    public NDFANode getInitialNode() {
        return initialNode;
    }

    public void setInitialNode(NDFANode initialNode) {
        this.initialNode = initialNode;
    }

    @Override
    public String toString() {
        return "NDFA{" +
                "automata=" + automata +
                ", initialNode=" + initialNode +
                '}';
    }

    public boolean check(String stringToCheck){
        System.out.println("Checking");

        int automataIterator = 0;

        //Check initial node
        if(stringToCheck.charAt(0) != automata.get(0).getCharToAccept()){
            return false;
        }

        for(int i = 1; i < stringToCheck.length(); i++){
            for(NDFANode transition : automata.get(automataIterator).getTransitions()){
                if(transition.isStopNode()){
                    return true;
                }
                if(stringToCheck.charAt(i) == transition.getCharToAccept()){
                        automataIterator++;
                }
            }
        }
        return false;

//        return false;
//        for (char charToCheck : stringToCheck.toCharArray()){
//            for (NDFANode node : automata){
//                for (NDFANode transition : node.getTransitions()){
//                    if(charToCheck == transition.getCharToAccept()){
//                        System.out.println(transition.getCharToAccept());
//                    }
//                }
//            }
//        }
//        return true;
    }

    public boolean containsStopNode(){
        for (NDFANode node : automata){
            if (node.isStopNode()){
                return true;
            }
        }
        return false;
    }

    public void resetStopNode(){
        if(!automata.isEmpty()){
            for (NDFANode node : automata){
                node.setStopNode(false);
            }
            automata.get(automata.size()-1).setStopNode(true);
        }


    }
}
