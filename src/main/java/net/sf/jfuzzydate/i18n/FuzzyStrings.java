package net.sf.jfuzzydate.i18n;

import net.sf.jfuzzydate.Unit;

import java.text.MessageFormat;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Fuzzy string builder.
 *
 * @author amaasch
 */
public class FuzzyStrings {
    //~ Instance fields --------------------------------------------------------

    /**
     * Plural form builder instance.
     */
    private final Pluralizer pluralizer;

    /**
     * Java {@link ResourceBundle} base name. The bundle at this name
     * contains the keys for this string builder instance.
     */
    private final String bundleBaseName;

    //~ Constructors -----------------------------------------------------------

/**
     * Creates a new fuzzy string builder instance using a java resource bundle.
     *
     * @param fuzzyStringBundle the base name of the bundle that contains the 
     *        keys for this fuzzy string builder. 
     */
    public FuzzyStrings(final String fuzzyStringBundle) {
        bundleBaseName = fuzzyStringBundle;
        pluralizer = new Pluralizer(this);
    }

/**
     * Creates a new FuzzyStrings object.
     *
     * @param fuzzyStringBundle the base name of the bundle that contains the 
     *        keys for this fuzzy string builder. 
     * @param pluralizer a custom pluralizer for building plurals (e.g. for 
     *        unit plurals like "minutes").
     */
    public FuzzyStrings(final String fuzzyStringBundle,
                        final Pluralizer pluralizer) {
        bundleBaseName = fuzzyStringBundle;
        this.pluralizer = pluralizer;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * Returns the correctly pluralized form of a unit as string. This
     * method  uses the JVM default locale for internationalization.
     *
     * @param number the number of objects to named by the plural form.
     * @param unit the unit of which its name should be pluralized.
     *
     * @return the pluralized unit name.
     *
     * @see Locale#getDefault()
     */
    public String getPlural(final int number, final Unit unit) {
        return pluralizer.pluralize(number, unit.name(), Locale.getDefault());
    }

    /**
     * Returns the correctly pluralized form of a unit as string. The
     * desired plural will be built for the given locale.
     *
     * @param number the number of objects to named by the plural form.
     * @param unit the unit of which its name should be pluralized.
     * @param locale the locale to select the correct plural form.
     *
     * @return the pluralized unit name.
     */
    public String getPlural(final int number, final Unit unit,
                            final Locale locale) {
        return pluralizer.pluralize(number, unit.name().toLowerCase(), locale);
    }

    /**
     * Returns a string for a given key using the default locale.<br>
     * Calls to this method are equal to <br>
     * <code>getString(key, Locale.getDefault());</code>
     *
     * @param key the key to look up in the bundle.
     *
     * @return the string for the given key.
     *
     * @see #getString(String, Locale)
     */
    public String getString(final String key) {
        return getString(key, Locale.getDefault());
    }

    /**
     * Returns a string for a given key and locale.
     *
     * @param key the key to look up in the bundle.
     * @param locale the locale for which the string should be returned.
     *
     * @return the string for the given key.
     */
    public String getString(final String key, final Locale locale) {
        final ResourceBundle rb = ResourceBundle.getBundle(bundleBaseName,
                                                           locale);

        return rb.getString(key);
    }

    /**
     * Returns a string for a given key and locale. This method is also
     * able to pass parameters to the string. String replacement is done by
     * using {@link MessageFormat} expressions like <code>"abc {0} d {1}
     * efg"</code>.
     *
     * @param key the key to look up in the bundle.
     * @param locale the locale for which the string should be returned.
     *
     * @return the string for the key and locale formatted with the given
     *         params.
     */
    public String getString(final String key, final Locale locale,
                            final Object... params) {
        String message = null;

        if (params == null) {
            message = getString(key);
        } else {
            message = MessageFormat.format(getString(key, locale), params);
        }

        return message;
    }
}
