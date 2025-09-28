// CS108 HW1 -- String static methods

import java.util.HashSet;

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int max = 1;
        int current = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                current++;
            } else {
                max = Math.max(max, current);
                current = 1;
            }
        }
        return Math.max(max, current);
    } // OK

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c) && i < str.length() - 1) {
                int k = Character.getNumericValue(c);
                for (int j = 0; j < k; j++) {
                    s.append(str.charAt(i + 1));
                }
            } else if(Character.isDigit(c) && i == str.length() - 1) {
                i++;
            } else {
                s.append(c);
            }
        }
        return s.toString();
    } // OK
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len <= 0 || a.length() < len || b.length() < len) {
            return false;
        }
        HashSet<String> sub = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            sub.add(a.substring(i, i + len));
        }
        for (int j = 0; j <= b.length() - len; j++) {
            if (sub.contains(b.substring(j, j + len))) {
                return true;
            }
        }
        return false;
    }
}
