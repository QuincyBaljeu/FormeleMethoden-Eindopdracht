package com.company.automata;

import java.util.LinkedList;
import java.util.List;

public class NDFA {
    private List<Node> automata = new LinkedList<>();
    private Node initialNode;
    private boolean isDFA;

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

        for(int i = 1; i < stringToCheck.length(); i++){
            for(Node transition : automata.get(automataIterator).getTransitions()){
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

    public void resetStopNode(){
        if(!automata.isEmpty()){
            for (Node node : automata){
                node.setStopNode(false);
            }
            automata.get(automata.size()-1).setStopNode(true);
        }
    }

    public void convertToDFA(String alphabet){

        for (char fuikChar : alphabet.toCharArray()) {

            Node fuikNode = new Node(fuikChar);
            fuikNode.addTransition(fuikNode);

            for (Node node : this.automata) {
                if (!node.containsTransition(fuikChar)) {
                    node.addTransition(fuikNode);
                }
            }
        }
        this.isDFA = true;
    }

    public void print(){
      for (int i =0; i <this.automata.size(); i++){
          System.out.println("Node: " + i);
          this.automata.get(i).print();
          System.out.println("");
      }
    }
}
