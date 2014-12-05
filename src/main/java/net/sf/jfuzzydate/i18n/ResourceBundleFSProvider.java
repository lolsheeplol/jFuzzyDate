/*
 * Copyright 2005-2014 chemmedia AG
 *
 * You should have received a copy of a license with this program. If not,
 * contact us by visiting http://www.chemmedia.de/ or write to chemmedia AG,
 * Parkstraße 35, 09120 Chemnitz, Germany.
 *
 * You may not use, copy, modify, sublicense, or distribute the Program or any
 * portion of it, except as expressly provided under the given license.
 */
package net.sf.jfuzzydate.i18n;

import net.sf.jfuzzydate.FuzzyStringProvider;

import java.text.MessageFormat;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * Fuzzy string builder.
 *
 * @author amaasch
 */
public class ResourceBundleFSProvider implements FuzzyStringProvider {

    //~ Instance fields --------------------------------------------------------------------------------------

    /**
     * Java {@link ResourceBundle} base name. The bundle at this name contains the keys for this string
     * builder instance.
     */
    private final String bundleBaseName;

    //~ Constructors -----------------------------------------------------------------------------------------

    /**
     * Creates a new fuzzy string builder instance using a java resource bundle.
     *
     * @param fuzzyStringBundle the base name of the bundle that contains the keys for this fuzzy string
     *                          builder.
     */
    public ResourceBundleFSProvider(final String fuzzyStringBundle) {
        bundleBaseName = fuzzyStringBundle;
    }

    //~ Methods ----------------------------------------------------------------------------------------------

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.i18n.FuzzyStringProvider#getString(java.lang.String)
     */
    public String getString(final String key) {
        return getString(key, Locale.getDefault());
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.i18n.FuzzyStringProvider#getString(java.lang.String, java.util.Locale)
     */
    public String getString(final String key, final Locale locale) {
        final ResourceBundle bundle = ResourceBundle.getBundle(bundleBaseName, locale);

        try {
            return bundle.getString(key);
        } catch (final MissingResourceException e) {
            final ResourceBundle fallbackBundle = ResourceBundle.getBundle(bundleBaseName, Locale.ROOT);

            return fallbackBundle.getString(key);
        }
    }

    /* (non-Javadoc)
     * @see net.sf.jfuzzydate.i18n.FuzzyStringProvider#getString(java.lang.String, java.util.Locale, java.lang.Object)
     */
    public String getString(final String key, final Locale locale, final Object... params) {
        return MessageFormat.format(getString(key, locale), params);
    }
}
