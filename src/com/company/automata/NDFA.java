package com.company.automata;

import java.util.ArrayList;

public class NDFA {
    private ArrayList<Node> automata = new ArrayList<>();

    public NDFA(){

    }

    public void addNode(Node node){
        this.automata.add(node);
    }


}
