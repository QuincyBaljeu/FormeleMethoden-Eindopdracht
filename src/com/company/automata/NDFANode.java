package com.company.automata;

public class NDFANode {

        private char charToAccept;
        private NDFANode nextNDFANode;
        private boolean startNode;
        private boolean stopNode;

        public NDFANode(char charToAccept, NDFANode nextNDFANode, boolean stopNode) {
                this.charToAccept = charToAccept;
                this.nextNDFANode = nextNDFANode;
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

        public NDFANode getNextNDFANode() {
                return nextNDFANode;
        }

        public boolean isStopNode() {
                return stopNode;
        }

        public void setNextNDFANode(NDFANode nextNDFANode) {
                this.nextNDFANode = nextNDFANode;
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
                        ", nextNDFANode=" + nextNDFANode +
                        ", startNode=" + startNode +
                        ", stopNode=" + stopNode +
                        '}';
        }
}
