package com.company.automata;

import java.util.ArrayList;
import java.util.List;

public class NDFANode {

        private char charToAccept;
        private boolean startNode;
        private boolean stopNode;
        private List<NDFANode> transitions = new ArrayList<>();

        public NDFANode(char charToAccept, List<NDFANode> transitions, boolean stopNode) {
                this.charToAccept = charToAccept;
                this.transitions = transitions;
                this.stopNode = stopNode;
        }

        public NDFANode(char charToAccept, boolean stopNode) {
                this.charToAccept = charToAccept;
                this.stopNode = stopNode;
        }

        public NDFANode(char charToAccept) {
                this.charToAccept = charToAccept;
        }

        public char getCharToAccept() {
                return charToAccept;
        }

        public List<NDFANode> getTransitions() {
                return transitions;
        }

        public boolean isStopNode() {
                return stopNode;
        }

        public void setTransitions(List<NDFANode> transitions) {
                this.transitions = transitions;
        }

        public void setStartNode(boolean startNode) {
                this.startNode = startNode;
        }

        public void setStopNode(boolean stopNode) {
                this.stopNode = stopNode;
        }

        @Override
        public String toString() {
                return "NDFANode{" +
                        "charToAccept=" + charToAccept +
                        ", transitions=" + transitions +
                        ", startNode=" + startNode +
                        ", stopNode=" + stopNode +
                        '}';
        }

        public void addTransition(NDFANode node){
                List<NDFANode> transitions = new ArrayList<>();
                transitions.add(node);
                this.transitions = transitions;
        }

}
