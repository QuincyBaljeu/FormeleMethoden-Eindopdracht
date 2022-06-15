package test;

import com.company.RegexConverter;
import com.company.automata.NDFA;
import com.company.automata.Node;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RegexConverterTest {

    @Test
    void addStartNodes() {
        NDFA testNdfa = new NDFA();
        NDFA correctNdfa = new NDFA();

        RegexConverter converter = new RegexConverter();
        converter.addStartNodes(testNdfa, "abbc");

        Node a = new Node('a');
        Node b = new Node('b');
        Node b2 = new Node('b');
        Node c = new Node('c');

        a.addTransition(b);
        b.addTransition(b2);
        b2.addTransition(c);
        c.addTransition(c);

        c.setStopNode(true);

        correctNdfa.addNode(a);
        correctNdfa.addNode(b);
        correctNdfa.addNode(b2);
        correctNdfa.addNode(c);

        assertArrayEquals(correctNdfa.getAutomata().toArray(), testNdfa.getAutomata().toArray());
    }

    @Test
    void addContainsNodes() {
    }

    @Test
    void addEndNode() {
    }
}