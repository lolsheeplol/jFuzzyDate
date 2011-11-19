package net.sf.jfuzzydate.i18n;


/**
 * This enumeration specifies different rules and their behavior. It aims to 
 * built a complete set of rules for all languages, but is not a mapping file 
 * for rule<->locale. 
 * <p>
 * Mostly derived from  
 * <a href="https://developer.mozilla.org/en/Localization_and_Plurals">Mozilla 
 * developer community plural rule list</a> which itself references GNU gettext 
 * documentation of
 * <a href="http://www.gnu.org/software/gettext/manual/html_node/gettext_150.html#Plural-
 * forms">plural forms</a>.
 * <p>
 * Implementation still incomplete.
 * 
 * @author amaasch
 */
public enum PluralRule {
/**
     * Plural rule #0 (1 form)<br>
     * Families: Asian (Chinese, Japanese, Korean, Vietnamese), Persian,
     * Turkic/Altaic (Turkish), Thai, Lao<br>
     * everything: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
     * 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
     * 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, ...
     */
    ASIAN, 
/**
     * Plural rule #1 (2 forms)<br>
     * Families: Germanic (Danish, Dutch, English, Faroese, Frisian, German,
     * Norwegian, Swedish), Finno-Ugric (Estonian, Finnish, Hungarian), Language
     * isolate (Basque), Latin/Greek (Greek), Semitic (Hebrew), Romanic
     * (Italian, Portuguese, Spanish, Catalan)<br>
     * is 1: 1<br>
     * everything else: 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
     * 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
     * 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, ...
     */
    TWO_FORMS_1, 
/**
     * Plural rule #2 (2 forms)<br>
     * Families: Romanic (French, Brazilian Portuguese)<br>
     * is 0 or 1: 0, 1<br>
     * everything else: 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
     * 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
     * 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, ...
     */
    TWO_FORMS_2, 
/**
     * Plural rule #3 (3 forms)<br>
     * Families: Baltic (Latvian)<br>
     * is 0: 0<br>
     * ends in 1, not 11: 1, 21, 31, 41, 51, 61, 71, 81, 91, 101, 121, 131, 141,
     * 151, 161, 171, 181, 191, 201, 221, 231, 241, 251, 261, 271, 281, 291, ...<br>
     * everything else: 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
     * 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37,
     * 38, 39, 40, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 53, 54, 55, ...
     */
    LATVIAN, 
/**
     * Plural rule #4 (4 forms)<br>
     * Families: Celtic (Scottish Gaelic)<br>
     * is 1 or 11: 1, 11<br>
     * is 2 or 12: 2, 12<br>
     * others between 3 and 19: 3, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 16, 17, 18,
     * 19<br>
     * everything else: 0, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
     * 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
     * 51, ...
     */
    CELTIC, RULE5, RULE6, RULE7, RULE8, RULE9, RULE10, RULE11, RULE12, RULE13, 
    RULE14, RULE15;
    /**
     * Checks whether a number ends in a specific range.
     *
     * @param number the number to check.
     * @param lower the lower bound of the range.
     * @param upper the upper bound of the range.
     * @param digits the number of digits to be checked.
     *
     * @return <code>true</code> if the last digits of the number are in the
     *         selected range, otherwise <code>false</code>.
     */
    private static final boolean endsBetween(final int number, final int lower,
                                             final int upper, final int digits) {
        final int divisor = 10 * digits;
        final int remainder = number % divisor;

        return (remainder >= lower) && (remainder <= upper);
    }

/**
     * Creates a new PluralRule object.
     */
    private PluralRule() {
    }

    /**
     * Select the correct plural form id for a given number of objects.
     *
     * @param number the number of objects.
     *
     * @return the plural form id selected based on this rule.
     *
     * @throws IllegalStateException unknown or not implemented plural rule.
     */
    public int selectPluralForm(final int number) {
        final int absNumber = Math.abs(number);

        int pluralForm;

        switch (this) {
            case ASIAN :
                return 0;

            case TWO_FORMS_1 :

                if (absNumber == 1) {
                    pluralForm = 0;
                } else {
                    pluralForm = 1;
                }

                break;

            case TWO_FORMS_2 :

                if (absNumber <= 1) {
                    pluralForm = 0;
                } else {
                    pluralForm = 1;
                }

                break;

            case LATVIAN :

                if (absNumber == 0) {
                    pluralForm = 0;
                } else if (endsBetween(absNumber, 1, 1, 1) &&
                               endsBetween(absNumber, 11, 11, 2)) {
                    pluralForm = 1;
                } else {
                    pluralForm = 2;
                }

                break;

            case CELTIC :

                if ((absNumber == 1) || (absNumber == 11)) {
                    pluralForm = 0;
                } else if ((absNumber == 2) || (absNumber == 12)) {
                    pluralForm = 1;
                } else if ((absNumber > 2) && (absNumber < 20)) {
                    pluralForm = 2;
                } else {
                    pluralForm = 3;
                }

                break;

            case RULE5 :

                if (absNumber == 1) {
                    pluralForm = 0;
                } else if ((absNumber == 0) ||
                               endsBetween(absNumber, 1, 19, 2)) {
                    pluralForm = 1;
                } else {
                    pluralForm = 2;
                }

                break;

            default :

                //FIXME list is incomplete and has to be finished
                throw new IllegalStateException("Undefined PluralRule.");
        }

        return pluralForm;
    }
}
