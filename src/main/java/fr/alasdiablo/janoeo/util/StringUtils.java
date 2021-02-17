package fr.alasdiablo.janoeo.util;

import com.google.common.base.CaseFormat;
import fr.alasdiablo.janoeo.Janoeo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static fr.alasdiablo.janoeo.util.Registries.registryName;

public class StringUtils {

    public static String cleanOreName(String oreName, Boolean removeOreSuffix) {
        List<String> purgeWords = new ArrayList<String>() {{
            add("_DENSE"); add("_dense");
            add("SAND_"); add("sand_");
            add("GRAVEL_"); add("gravel_");
            add("NETHER_"); add("nether_");
            add("BASALT_"); add("basalt_");
            add("END_"); add("end_");
            add("_INGOT"); add("_ingot");
            add("_DUST"); add("_dust");
            add("_GEAR"); add("_gear");
            add("_ROD"); add("_rod");
        }};
        if (removeOreSuffix) {
            purgeWords.add("_ORE");
            purgeWords.add("_ore");
        }

        String cleanOreName = oreName;
        for (String purgeWord : purgeWords) {
            cleanOreName = cleanOreName.replace(purgeWord, "");
        }

        return cleanOreName.toString();
    }
    public static String cleanOreName(String oreName) {
        return cleanOreName(oreName, false);
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
