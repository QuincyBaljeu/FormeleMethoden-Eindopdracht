package com.company.automata;

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
        boolean passed = false;
        for (char charToCheck : stringToCheck.toCharArray()){
            while(!passed){


            }
        }
        return true;
    }
}
