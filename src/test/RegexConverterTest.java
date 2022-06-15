package test;

import com.company.RegexConverter;
import com.company.automata.NDFA;
import com.company.automata.Node;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RegexConverterTest {

    @Test
    void addStartNodesAmount() {
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addStartNodes(testNdfa, "abbc");

        assertEquals(testNdfa.getAutomata().size(), 4);
    }

    @Test
    void addContainsNodesAmount() {
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addContainsNodes(testNdfa, "abbc");

        assertEquals(testNdfa.getAutomata().size(), 4);
    }

    @Test
    void addEndNodeAmount() {
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addEndNode(testNdfa, "abbc");

        assertEquals(testNdfa.getAutomata().size(), 4);
    }

    @Test
    void checkFinalNode(){
        NDFA testNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addStartNodes(testNdfa, "abb");
        converter.addEndNode(testNdfa, "ccd");

        //Get last node and check if it is true
        assertTrue(testNdfa.getAutomata().get(testNdfa.getAutomata().size()-1).isStopNode());
    }

    @Test
    void correctDFAConversion(){

        NDFA testNdfa = new NDFA();
        RegexConverter converter = new RegexConverter();

        converter.addStartNodes(testNdfa, "ab");
        converter.addEndNode(testNdfa, "cd");

        testNdfa.convertToDFA("abcde");

        boolean containsENode = false;



    }
    //Test if DFA conversion adds correct node
    //Test if start/begin/end have correct loop nodes
    //test if start/begin/edn add correct nodes

}