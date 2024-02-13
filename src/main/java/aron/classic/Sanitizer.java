package aron.classic;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class Sanitizer {
    private static final List <String> swearWords = new LinkedList <>();

    static {
        swearWords.add("cretin");
        swearWords.add("crap");
    }

    public static String censorPhoneNumbers( final String string ) {
        if ( string == null || string.isEmpty() ) {
            throw new InvalidParameterException();
        }

        return string.replaceAll("[0-9]{11}", "******");
    }

    public static String censorSwearWords( final String string )
    throws InvalidParameterException {
        if ( string == null || string.isEmpty() ) {
            throw new InvalidParameterException();
        }

        String cleaned = string;
        for ( String badWord : swearWords ) {
            cleaned = cleaned.replaceAll(badWord, "******");
        }

        return cleaned;
    }

    public static String censorEmailAddress(final String string ) {
         if ( string == null || string.isEmpty() ) {
             throw new InvalidParameterException();
        }

        return string.replaceAll("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]{2,4}", "******");
    }

    public static String cleanupWord( final String string )
    throws InvalidParameterException {
        return censorEmailAddress(censorPhoneNumbers(censorSwearWords(string)));
    }
}
