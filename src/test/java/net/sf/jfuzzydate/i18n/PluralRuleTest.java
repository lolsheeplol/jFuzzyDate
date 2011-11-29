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
        testSelector(ASIAN, 0, 0);
        testSelector(ASIAN, 0, 1);
        testSelector(ASIAN, 0, 2);
        testSelector(ASIAN, 0, 3);
        testSelector(ASIAN, 0, 4);
        testSelector(ASIAN, 0, 11);
        testSelector(ASIAN, 0, 21);
        testSelector(ASIAN, 0, 102);
        testSelector(ASIAN, 0, 1003);
    }

    /**
     * RULE2 The one
     */
    @Test
    public void testSelectPluralForm2() {
        testSelector(TWO_FORMS_1, 1, 0);
        testSelector(TWO_FORMS_1, 0, 1);
        testSelector(TWO_FORMS_1, 1, 2);
        testSelector(TWO_FORMS_1, 1, 3);
        testSelector(TWO_FORMS_1, 1, 4);
        testSelector(TWO_FORMS_1, 1, 11);
        testSelector(TWO_FORMS_1, 1, 21);
        testSelector(TWO_FORMS_1, 1, 102);
        testSelector(TWO_FORMS_1, 1, 1003);
    }

    /**
     * RULE3 The one and zero
     */
    @Test
    public void testSelectPluralForm3() {
        testSelector(TWO_FORMS_2, 0, 0);
        testSelector(TWO_FORMS_2, 0, 1);
        testSelector(TWO_FORMS_2, 1, 2);
        testSelector(TWO_FORMS_2, 1, 3);
        testSelector(TWO_FORMS_2, 1, 4);
        testSelector(TWO_FORMS_2, 1, 11);
        testSelector(TWO_FORMS_2, 1, 21);
        testSelector(TWO_FORMS_2, 1, 102);
        testSelector(TWO_FORMS_2, 1, 1003);
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
