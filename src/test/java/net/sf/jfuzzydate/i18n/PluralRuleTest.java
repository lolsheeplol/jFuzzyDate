package net.sf.jfuzzydate.i18n;

import static net.sf.jfuzzydate.i18n.PluralRule.*;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Tests the {@link PluralRule} enumeration.
 *
 * @author amaasch
 */
public class PluralRuleTest {
    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Asian
     */
    @Test
    public void testSelectPluralForm1() {
        final PluralRule rule = ASIAN;
		testSelector(rule, 0, 0);
        testSelector(rule, 0, 1);
        testSelector(rule, 0, 2);
        testSelector(rule, 0, 3);
        testSelector(rule, 0, 4);
        testSelector(rule, 0, 11);
        testSelector(rule, 0, 21);
        testSelector(rule, 0, 102);
        testSelector(rule, 0, 1003);
    }

    /**
     * RULE2 The one
     */
    @Test
    public void testSelectPluralForm2() {
        final PluralRule rule = TWO_FORMS_1;
		testSelector(rule, 1, 0);
        testSelector(rule, 0, 1);
        testSelector(rule, 1, 2);
        testSelector(rule, 1, 3);
        testSelector(rule, 1, 4);
        testSelector(rule, 1, 11);
        testSelector(rule, 1, 21);
        testSelector(rule, 1, 102);
        testSelector(rule, 1, 1003);
    }

    /**
     * RULE3 The one and zero
     */
    @Test
    public void testSelectPluralForm3() {
        final PluralRule rule = TWO_FORMS_2;
		testSelector(rule, 0, 0);
        testSelector(rule, 0, 1);
        testSelector(rule, 1, 2);
        testSelector(rule, 1, 3);
        testSelector(rule, 1, 4);
        testSelector(rule, 1, 11);
        testSelector(rule, 1, 21);
        testSelector(rule, 1, 102);
        testSelector(rule, 1, 1003);
    }
    
    /**
     * RULE4 Latvian
     */
    @Test
    public void testSelectPluralForm4() {
        final PluralRule rule = LATVIAN;
		testSelector(rule, 0, 0);
        testSelector(rule, 1, 1);
        testSelector(rule, 2, 2);
        testSelector(rule, 2, 3);
        testSelector(rule, 2, 4);
        testSelector(rule, 2, 11);
        testSelector(rule, 1, 21);
        testSelector(rule, 2, 102);
        testSelector(rule, 1, 111);
        testSelector(rule, 2, 1003);
    }

    /**
     * RULE5 Celtic
     */
    @Test
    public void testSelectPluralForm5() {
        final PluralRule rule = CELTIC;
		testSelector(rule, 3, 0);
        testSelector(rule, 0, 1);
        testSelector(rule, 1, 2);
        testSelector(rule, 2, 3);
        testSelector(rule, 2, 4);
        testSelector(rule, 2, 10);
        testSelector(rule, 0, 11);
        testSelector(rule, 1, 12);
        testSelector(rule, 2, 13);
        testSelector(rule, 2, 19);
        testSelector(rule, 3, 20);
        testSelector(rule, 3, 21);
        testSelector(rule, 3, 102);
        testSelector(rule, 3, 1003);
    }
    
    /**
     * RULE7 Russian etc
     */
    @Test
    public void testSelectPluralForm7() {
        final PluralRule rule = RULE7;
		testSelector(rule, 2, 0);
        testSelector(rule, 0, 1);
        testSelector(rule, 1, 2);
        testSelector(rule, 1, 3);
        testSelector(rule, 1, 4);
        testSelector(rule, 1, 5);
        testSelector(rule, 2, 10);
        testSelector(rule, 2, 11);
        testSelector(rule, 2, 12);
        testSelector(rule, 2, 13);
        testSelector(rule, 2, 14);
        testSelector(rule, 2, 19);
        testSelector(rule, 2, 20);

    }



    
    /**
     * TODO DOCUMENT ME!
     *
     * @param rule TODO DOCUMENT ME!
     * @param expectedPluralForm TODO DOCUMENT ME!
     * @param number TODO DOCUMENT ME!
     */
    private void testSelector(final PluralRule rule, final int expectedPluralForm, final int number) {
        assertEquals(expectedPluralForm, rule.selectPluralForm(number));
    }
}
