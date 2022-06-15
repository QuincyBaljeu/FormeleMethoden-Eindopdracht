package com.company.automata;

import java.util.ArrayList;
import java.util.List;

public class Node {

        private char charToAccept;
        private boolean isStopNode;
        private List<Node> transitions = new ArrayList<>();

        public Node(char charToAccept, List<Node> transitions, boolean isStopNode) {
                this.charToAccept = charToAccept;
                this.transitions = transitions;
                this.isStopNode = isStopNode;
        }

        public Node(char charToAccept, boolean isStopNode) {
                this.charToAccept = charToAccept;
                this.isStopNode = isStopNode;
        }

        public Node(char charToAccept) {
                this.charToAccept = charToAccept;
                this.isStopNode = false;
        }

        public char getCharToAccept() {
                return charToAccept;
        }

        public List<Node> getTransitions() {
                return transitions;
        }

        public boolean isStopNode() {
                return isStopNode;
        }

        public void setTransitions(List<Node> transitions) {
                this.transitions = transitions;
        }


        public void setStopNode(boolean stopNode) {
                this.isStopNode = stopNode;
        }

        @Override
        public String toString() {
                return "NDFANode{" +
                        "charToAccept=" + charToAccept +
                        ", stopNode=" + isStopNode +
                        '}';
        }

        public void addTransition(Node node){
                this.transitions.add(node);
        }

        public boolean containsTransition(char c){

                for (Node transition : transitions){
                        if (transition.getCharToAccept() == c){
                                return true;
                        }
                }
                return false;
        }

}
