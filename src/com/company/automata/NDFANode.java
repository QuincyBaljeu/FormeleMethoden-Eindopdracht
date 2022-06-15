package com.company.automata;

import java.util.ArrayList;
import java.util.List;

public class NDFANode {

        private char charToAccept;
        private boolean isStopNode;
        private List<NDFANode> transitions = new ArrayList<>();

        public NDFANode(char charToAccept, List<NDFANode> transitions, boolean isStopNode) {
                this.charToAccept = charToAccept;
                this.transitions = transitions;
                this.isStopNode = isStopNode;
        }

        public NDFANode(char charToAccept, boolean isStopNode) {
                this.charToAccept = charToAccept;
                this.isStopNode = isStopNode;
        }

        public NDFANode(char charToAccept) {
                this.charToAccept = charToAccept;
                this.isStopNode = false;
        }

        public char getCharToAccept() {
                return charToAccept;
        }

        public List<NDFANode> getTransitions() {
                return transitions;
        }

        public boolean isStopNode() {
                return isStopNode;
        }

        public void setTransitions(List<NDFANode> transitions) {
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

        public void addTransition(NDFANode node){
//                List<NDFANode> transitions = new ArrayList<>();
//                transitions.add(node);
//                this.transitions = transitions;
                this.transitions.add(node);
        }

}
