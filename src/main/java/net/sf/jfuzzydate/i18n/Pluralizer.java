package net.sf.jfuzzydate.i18n;


import java.util.Locale;


/**
 * Plural form builder. Creates a plural based on number of objects, {@link
 * Locale} and a plural block string ("year;years").
 *
 * @author amaasch
 */
public class Pluralizer {
    //~ Static fields/initializers ---------------------------------------------

    /**
     * Character used to split the plural forms.
     */
    public static final String PLURAL_SEPARATOR = ";";

    //~ Instance fields --------------------------------------------------------

    /**
     * The fuzzy string builder.
     */
    private final FuzzyStrings fuzzyStringBuilder;

    /**
     * A selector for selecting the correct {@link PluralRule} for a
     * {@link Locale}.
     */
    private final PluralRuleSelector ruleSelector;

    //~ Constructors -----------------------------------------------------------

/**
     * Creates a new Pluralizer object.
     *
     * @param fuzzyStringBuilder
     */
    public Pluralizer(final FuzzyStrings fuzzyStringBuilder) {
        this.fuzzyStringBuilder = fuzzyStringBuilder;
        ruleSelector = new I18nStringLookupRuleSelector(fuzzyStringBuilder,
                                                        "plurals.mode");
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Pluralizes a word for the given {@link Locale}. The word is
     * specified by a plural block key. Each key consists of a set of at least
     * one plural form. Multiple plural forms are separated by {@value
     * #PLURAL_SEPARATOR}. This method selects the correct plural form for the
     * given number of objects.
     *
     * @param number the number of named objects.
     * @param pluralBlockKey a key of plural forms separated by {{@link
     *        #PLURAL_SEPARATOR}
     * @param locale the locale used to select the correct plural form.
     *
     * @return the correct plural form of the word for the specified number of
     *         objects.
     */
    public String pluralize(final int number, final String pluralBlockKey,
                            final Locale locale) {
        final PluralRule rule = ruleSelector.selectRuleFor(locale);

        return getPluralForm(number,
                             fuzzyStringBuilder.getString(pluralBlockKey, locale),
                             rule);
    }

    /**
     * Selects a plural form by applying a {@link PluralRule} on a
     * plural block.
     *
     * @param number the number of named objects.
     * @param pluralBlock a string containing plural forms separated by {@value
     *        #PLURAL_SEPARATOR}.
     * @param rule the rule to apply for selecting a form.
     *
     * @return the localized plural form.
     */
    private String getPluralForm(final int number, final String pluralBlock,
                                 final PluralRule rule) {
        final int position = rule.selectPluralForm(number);
        final String[] plurals = pluralBlock.split(PLURAL_SEPARATOR);

        return plurals[position];
    }
}
