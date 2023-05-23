public class enc {

    public static String ft_cesar(String str, int inc) {
        StringBuilder buff = new StringBuilder();
        int i = 0;

        if (inc < 0)
            inc = 0;

        if (inc > 10)
            inc = 10;

        while (i < str.length()) {
            char c = str.charAt(i);
            // v = ascii value of the char + the inc value
            int v = ((int) c) + inc;
            buff.append(v);
            buff.append(" ");
            i++;
        }
        return buff.toString();
    }
}