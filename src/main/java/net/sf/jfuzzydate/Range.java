package net.sf.jfuzzydate;

import java.util.ResourceBundle;


/**
 * Fuzzing range. A range for fuzzy time formatting has an internationalization 
 * key (e.g. a {@link ResourceBundle}-key).
 *
 * @author amaasch
  */
public interface Range {
    //~ Methods ----------------------------------------------------------------

    /**
     * Checks if a number is contained by this range.
     *
     * @param number the number to be checked.
     *
     * @return <code>true</code>, if this range contains the given number,
     *         otherwise <code>false</code>.
     */
    boolean contains(long number);

    /**
     * Returns the internationalization key of this range. The value of
     * this key contains the string used to format this range.
     *
     * @return the internationalization key.
     */
    String getI18nKey();
}
