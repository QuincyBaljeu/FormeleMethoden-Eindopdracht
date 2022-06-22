package com.company.automata;

import java.util.LinkedList;
import java.util.List;

public class NDFA {
    private List<Node> automata = new LinkedList<>();
    private Node initialNode;
    private boolean isDFA;
    private boolean containsStartNodes;

    public NDFA(Node initialNode){
        this.initialNode = initialNode;
        this.isDFA = false;
    }

    public NDFA() {
        this.isDFA = false;
    }

    public void addNode(Node Node){
        this.automata.add(Node);
    }

    public List<Node> getAutomata() {
        return automata;
    }

    public void setAutomata(List<Node> automata) {
        this.automata = automata;
    }

    public Node getInitialNode() {
        return initialNode;
    }

    public void setInitialNode(Node initialNode) {
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

        //Chek rest of nodes
        for(int i = 1; i < stringToCheck.length(); i++){
            for(Node transition : automata.get(automataIterator).getTransitions()){
                //If node is stopnode, automata has reached its end
                if(transition.isStopNode()){
                    return true;
                }
                if(stringToCheck.charAt(i) == transition.getCharToAccept()){
                        automataIterator++;
                }
            }
        }
        return false;
    }

    public boolean containsStopNode(){
        for (Node node : automata){
            if (node.isStopNode()){
                return true;
            }
        }
        return false;
    }

    //Reset stop node to last node in automata
    public void resetStopNode(){
        if(!automata.isEmpty()){
            for (Node node : automata){
                node.setStopNode(false);
            }
            automata.get(automata.size()-1).setStopNode(true);
        }
    }

    //Convert NDFA to DFA
    public void convertToDFA(String alphabet){
        Node firstEndsWithNode = automata.get(getIndexOfLastBeginsWithNode());
        for(Node node : automata){
            //If node is part of "Begins with" automata. Transition to fuik node
            if(node.isBeginsWithNode() && !node.isStopNode()){
                //Add transition to fuik node for every char in alphabet
                for (char charToAdd : alphabet.toCharArray()){
                    if (!node.containsTransition(charToAdd)){
                        Node newNode = new Node(charToAdd);
                        newNode.addTransition(newNode);
                        node.addTransition(newNode);
                    }
                }
            } else {

                for(char charToAdd : alphabet.toCharArray()){
                    if(!node.containsTransition(charToAdd)){
                        Node newNode = new Node(charToAdd);
                        newNode.addTransition(firstEndsWithNode);
                        node.addTransition(newNode);
                    }
                }

            }
        }


        this.isDFA = true;
    }

    private int getIndexOfLastBeginsWithNode(){
        int lastIndex = 0;
      for (int i =0; i < automata.size(); i++){
          if(!automata.get(i).isBeginsWithNode()){
              lastIndex = i;
          }
      }
      return lastIndex;
    }

    public void print(){
      for (int i =0; i <this.automata.size(); i++){
          System.out.println("Node: " + i);
          this.automata.get(i).print();
          System.out.println("");
      }
    }
}
