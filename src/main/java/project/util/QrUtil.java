package project.util;

public class QrUtil {
    private QrUtil() {
        throw new UnsupportedOperationException("this is utility class");
    }

    public static String long2string(Long l) {
        return l == null ? null : String.valueOf(l);
    }

    public static Long string2long(String l) {
        return l == null ? null : Long.valueOf(l);
    }
}
