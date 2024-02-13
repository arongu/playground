package aron.classic;

/*
    James was a crap builder and generally a cretin.
    Send him your complaints on james@jollycleverbuilders.com or (07512345696)

    James was a **** builder and generally a ******.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Sanitizer_Test {
    private static final String sentence = "James was a crap builder and generally a cretin. Send him your complaints on james@jollycleverbuilders.com or (07965123456)";

    @Test
    public void censorSwearWords_shouldNotContainSwearWordCretin_whenFinished() {
        final String sanitized = Sanitizer.censorSwearWords(sentence);

        final boolean result = sanitized.contains("cretin");

        System.out.println(sanitized);
        assertFalse(result);
    }

    @Test
    public void censorPhoneNumbers_shouldNotContainVisiblePhoneNumbers_whenFinished() {
        final String sanitized = Sanitizer.censorPhoneNumbers(sentence);
        System.out.println(sanitized);

        final boolean result = sanitized.contains("07965123456");

        assertFalse(result);
    }

    @Test
    public void censorEmailAddress_shouldNotContainAnyEmailAddress_whenFinished() {
        final String sanitized = Sanitizer.censorEmailAddress(sentence);

        final boolean result = sanitized.contains("james@jollycleverbuilders.com");

        System.out.println(sanitized);
        assertFalse(result);
    }

    @Test
    public void cleanupWord_shouldNotContainAnyBadWordsOrPhoneNumberOrEmailAddresses_whenFinished() {
        final String clean = Sanitizer.cleanupWord(sentence);
        System.out.println(clean);

        assertFalse(clean.contains("cretin"));
        assertFalse(clean.contains("crap"));
        assertFalse(clean.contains("07512345696"));
        assertFalse(clean.contains("james@jollycleverbuilders.com"));
    }
}
