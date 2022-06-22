package test;

import com.company.RegexConverter;
import com.company.automata.NDFA;
import com.company.automata.Node;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RegexConverterTest {

    //Test if addStartNodes adds correct amount of nodes
    @Test
    void addStartNodesAmount() {
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addStartNodes(testNdfa, "abbc");

        assertEquals(testNdfa.getAutomata().size(), 4);
    }

    //Test if addContainsNodes adds correct amount of nodes
    @Test
    void addContainsNodesAmount() {
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addContainsNodes(testNdfa, "abbc");

        assertEquals(testNdfa.getAutomata().size(), 4);
    }

    //Test if addEndNodes contain correct amount of nodes
    @Test
    void addEndNodeAmount() {
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addEndNodes(testNdfa, "abbc");

        assertEquals(testNdfa.getAutomata().size(), 4);
    }

    //Check if final node resets properly after multiple node addings
    @Test
    void checkFinalNode(){
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addStartNodes(testNdfa, "abb");
        converter.addEndNodes(testNdfa, "ccd");

        //Get last node and check if it is true
        assertTrue(testNdfa.getAutomata().get(testNdfa.getAutomata().size()-1).isStopNode());
    }

    //Check if correct nodes are added after dfa conversion
    @Test
    void correctDFAConversion(){

        NDFA testNdfa = new NDFA();
        RegexConverter converter = new RegexConverter();

        converter.addStartNodes(testNdfa, "ab");
        converter.addEndNodes(testNdfa, "cd");

        testNdfa.convertToDFA("abcde");

        boolean containsENode = false;

        for (Node node : testNdfa.getAutomata()){
            for (Node transition : node.getTransitions()){
                if(transition.getCharToAccept() == 'e'){
                    containsENode = true;
                }
            }
        }

        assertTrue(containsENode);
    }

    //Check if last node of start automata contains a loop node
    @Test
    void startNodeLoop(){
        NDFA testNdfa = new NDFA();
        RegexConverter regexConverter = new RegexConverter();

        regexConverter.addStartNodes(testNdfa, "ab");

        assertTrue(testNdfa.getAutomata().get(1).containsTransition('b'));

    }

    //Test if first and last node of contains nodes have loop nodes
    @Test
    void containsNodeLoop(){
        NDFA testNdfa = new NDFA();
        RegexConverter regexConverter = new RegexConverter();

        regexConverter.addContainsNodes(testNdfa, "abb");

        boolean correctLoopNodes = false;

        if(testNdfa.getAutomata().get(0).containsTransition('a') || testNdfa.getAutomata().get(2).containsTransition('b')){
            correctLoopNodes = true;
        }

        assertTrue(correctLoopNodes);
    }

    //Test if first node of end nodes have loop node
    @Test
    void endNodeLoop(){
        NDFA testNdfa = new NDFA();
        RegexConverter regexConverter = new RegexConverter();

        regexConverter.addEndNodes(testNdfa, "ab");

        assertTrue(testNdfa.getAutomata().get(0).containsTransition('a'));
    }
}