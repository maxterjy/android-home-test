package thachpham.hometest.util;

public class TextFormatter {

    public static String getTwoLineFormat(String str) {
        int len = str.length();
        int left = (len-1)/2, right = len/2;
        int dividePos = 0;

        for(; left >= 0 && right < len; left--, right++) {
            if (str.charAt(right) == ' ') {
                dividePos = right;
                break;
            } else if (str.charAt(left) == ' ') {
                dividePos = left;
                break;
            }
        }

        String formattedkey;
        if (dividePos != 0) {
            formattedkey = str.substring(0, dividePos) + "\n" + str.substring(dividePos+1);
        }
        else {
            formattedkey = str;
        }

        return formattedkey;
    }
}
