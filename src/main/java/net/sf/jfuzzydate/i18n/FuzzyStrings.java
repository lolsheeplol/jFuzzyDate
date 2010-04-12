package net.sf.jfuzzydate.i18n;

import java.text.MessageFormat;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;


/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public class FuzzyStrings {
    //~ Static fields/initializers ---------------------------------------------

    /**
     * 
     */
    private static final Map<Locale, ResourceBundle> resourcesByLocale = new HashMap<Locale, ResourceBundle>();

    //~ Instance fields --------------------------------------------------------

    /**
     * 
     */
    private String bundle;

    //~ Constructors -----------------------------------------------------------

/**
         * @param fuzzyStringBundle
         */
    public FuzzyStrings(String fuzzyStringBundle) {
        this.bundle = fuzzyStringBundle;
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * 
     *
     * @param key 
     *
     * @return 
     */
    public String getString(final String key) {
        return getString(key, Locale.getDefault());
    }

    /**
     * 
     *
     * @param key 
     * @param locale 
     *
     * @return 
     */
    public String getString(final String key, final Locale locale) {
        ResourceBundle rb = resourcesByLocale.get(locale);

        if (rb == null) {
            rb = ResourceBundle.getBundle(bundle, locale);
            resourcesByLocale.put(locale, rb);
        }

        return rb.getString(key);
    }

    /**
     * 
     *
     * @param key
     * @param locale
     *
     * @return
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
