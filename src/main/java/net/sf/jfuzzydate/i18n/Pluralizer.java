package net.sf.jfuzzydate.i18n;

import net.sf.jfuzzydate.FuzzyStringProvider;

import java.util.Locale;


/**
 * Plural form builder. Creates a plural based on number of objects, {@link Locale} and a plural block
 * string ("year;years").
 *
 * @author amaasch
 */
public class Pluralizer {
    //~ Static fields/initializers ---------------------------------------------------------------------------

    /**
     * Character used to split the plural forms.
     */
    public static final String DEFAULT_PLURAL_SEPARATOR = ";";

    //~ Instance fields --------------------------------------------------------------------------------------

    /**
     * The fuzzy string provider.
     */
    private final FuzzyStringProvider fuzzyStringProvider;

    /**
     * A selector for selecting the correct {@link PluralRule} for a {@link Locale}.
     */
    private final PluralRuleSelector ruleSelector;

    /**
     * The plural form separator;
     */
    private String separator = DEFAULT_PLURAL_SEPARATOR;

    //~ Constructors -----------------------------------------------------------------------------------------

/**
     * Creates a new Pluralizer object.
     *
     * @param stringProvider
     */
    public Pluralizer(final FuzzyStringProvider stringProvider) {
        this.fuzzyStringProvider = stringProvider;
        ruleSelector = new I18nStringLookupRuleSelector(stringProvider, "plurals.mode");
    }

/**
     * Creates a new Pluralizer object.
     *
     * @param stringProvider
     * @param separator
     */
    public Pluralizer(final FuzzyStringProvider stringProvider, final String separator) {
        this.fuzzyStringProvider = stringProvider;
        this.separator = separator;
        ruleSelector = new I18nStringLookupRuleSelector(stringProvider, "plurals.mode");
    }

    //~ Methods ----------------------------------------------------------------------------------------------

    /**
     * Pluralizes a word for the given {@link Locale}. The word is specified by a plural block key.
     * Each key consists of a set of at least one plural form. Multiple plural forms are separated by
     * {@value #DEFAULT_PLURAL_SEPARATOR}. This method selects the correct plural form for the given number
     * of objects.
     *
     * @param number the number of named objects.
     * @param pluralBlockKey a key of plural forms separated by {{@link #DEFAULT_PLURAL_SEPARATOR}
     * @param locale the locale used to select the correct plural form.
     *
     * @return the correct plural form of the word for the specified number of objects.
     */
    public String pluralize(final int number, final String pluralBlockKey, final Locale locale) {
        final PluralRule rule = ruleSelector.selectRuleFor(locale);

        return getPluralForm(number, fuzzyStringProvider.getString(pluralBlockKey, locale), rule);
    }

    /**
     * Selects a plural form by applying a {@link PluralRule} on a plural block.
     *
     * @param number the number of named objects.
     * @param pluralBlock a string containing plural forms separated by {@value #DEFAULT_PLURAL_SEPARATOR}.
     * @param rule the rule to apply for selecting a form.
     *
     * @return the localized plural form.
     */
    private String getPluralForm(final int number, final String pluralBlock, final PluralRule rule) {
        final int position = rule.selectPluralForm(number);
        final String[] plurals = pluralBlock.split(separator);

        return plurals[position];
    }
}
