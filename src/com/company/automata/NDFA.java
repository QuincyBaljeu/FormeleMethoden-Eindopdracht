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

    public boolean check(){
        return true;
    }
}
