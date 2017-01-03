package net.sf.jfuzzydate.i18n;


import java.util.Locale;


/**
 * A selector for locale specific plural rules.
 * <p>
 * Each language has it's own rule for building plurals. A rule selector is used
 * to select the correct {@link PluralRule} for {@link Locale} objects.
 * 
 * @author amaasch
 */
public interface PluralRuleSelector {
    //~ Methods ----------------------------------------------------------------

    /**
     * Selects a plural rule for a given locale.
     *
     * @param locale the locale to choose the correct rule for.
     *
     * @return the plural rule for the locale parameter.
     */
    PluralRule selectRuleFor(Locale locale);
}
