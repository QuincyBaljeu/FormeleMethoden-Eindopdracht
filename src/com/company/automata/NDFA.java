package com.company.automata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NDFA {
    private List<NDFANode> automata = new LinkedList<>();
    private NDFANode initalNode;

    public NDFA(NDFANode initialNode){
        this.initalNode = initialNode;
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

    public NDFANode getInitalNode() {
        return initalNode;
    }

    public void setInitalNode(NDFANode initalNode) {
        this.initalNode = initalNode;
    }
}
