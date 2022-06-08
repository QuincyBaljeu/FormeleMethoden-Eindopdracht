package com.company.automata;

public class NDFANode {

        private char charToAccept;
        private NDFANode nextNDFANode;
        private boolean finalNode;

        public NDFANode(char charToAccept, NDFANode nextNDFANode, boolean finalNode) {
                this.charToAccept = charToAccept;
                this.nextNDFANode = nextNDFANode;
                this.finalNode = finalNode;
        }

        public char getCharToAccept() {
                return charToAccept;
        }

        public NDFANode getNextNDFANode() {
                return nextNDFANode;
        }

        public boolean isFinalNode() {
                return finalNode;
        }
}
