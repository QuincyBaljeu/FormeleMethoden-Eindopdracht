package com.company.automata;

import java.util.ArrayList;

public class NDFA {
    private ArrayList<NDFANode> automata = new ArrayList<>();
    private NDFANode initalNode;

    public NDFA(NDFANode initialNode){
        this.initalNode = initialNode;
    }

    public void addNode(NDFANode NDFANode){
        this.automata.add(NDFANode);
    }


}
