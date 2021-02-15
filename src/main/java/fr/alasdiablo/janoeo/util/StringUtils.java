package fr.alasdiablo.janoeo.util;

import com.google.common.base.CaseFormat;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {

    public static String cleanOreName(String oreName) {

        String purge[] = {"DENSE_", "_GRAVEL", "_NETHER", "_BASALT", "_END"};
        String cleanOreName = oreName;
        for (int i = 0; i < purge.length; ++i) {
            cleanOreName = cleanOreName.replace(purge[i], "");
        }

        return cleanOreName.toString();
    }

    public static String decapitalize(String string) {
        if (string == null || string.length() == 0) {
            return string;
        }

        char c[] = string.toCharArray();
        c[0] = Character.toLowerCase(c[0]);

        return new String(c);
    }

    public static String formatString(String text, Boolean isProperty, String splitBy, String separateWith) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        if (isProperty) {
            return decapitalize(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, text));
        }else {
            return Arrays
                    .stream(text.split(splitBy))
                    .map(word -> word.isEmpty()
                            ? word
                            : Character.toTitleCase(word.charAt(0)) + word
                            .substring(1)
                            .toLowerCase())
                    .collect(Collectors.joining(separateWith));
        }
    }

    public static String formatString(String text) {
        return formatString(text, false, "_", " ");
    }

    public static String formatString(String text, Boolean isProperty) {
        return formatString(text, isProperty, "_", " ");
    }

    public static String formatString(String text, String splitBy, String separateWith) {
        return formatString(text, false, splitBy, separateWith);
    }
}
