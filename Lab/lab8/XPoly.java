package lab8;

final public class XPoly {
    public static final double sum(double ...x) {
        double s = 0;
        for (double num: x) {
            s += num;
        }
        return s;
    }
    public static double findMin(double ...x) {
        double res = x[0];
        for (double num: x) {
            res = Math.min(res, num);
        }
        return res;
    }
    public static double findMax(double ...x) {
        double res = x[0];
        for (double num: x) {
            res = Math.max(res, num);
        }
        return res;
    }
    public static String toUpperFirstChar(String s) {
        String[] wordArr = s.split(" ");
        for (int i = 0; i < wordArr.length; i++) {
            char firstChar = wordArr[i].charAt(0);
            String upperFirstChar = String.valueOf(firstChar).toUpperCase();
            wordArr[i] = upperFirstChar + wordArr[i].substring(1);
        }
        return String.join(" ", wordArr);
    }
}