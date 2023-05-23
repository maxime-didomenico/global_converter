public class dec {

    public static String ft_str_to_decimal(String str) {
        StringBuilder buff = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            char c = str.charAt(i);
            // v = ascii value of the char
            int v = (int) c;
            buff.append(v);
            buff.append(" ");
            i++;
        }
        return buff.toString();
    }

    public static String ft_decimal_to_str(String str) {
        StringBuilder buff = new StringBuilder();
        int i = 0, j = 0, letter = 0;
        
        while (i < str.length()) {
            while (j < 3 && i < str.length()) {
                if (j == 0 && str.charAt(i) == '1') {
                    // 1st digit of the ascii value
                    letter = 100;
                    i++;
                    j++;
                }
                else if (j == 0 && str.charAt(i) != '1') {
                    // 1st digit of the ascii value
                    letter = letter + (10 * Character.getNumericValue(str.charAt(i)));
                    i++;
                    j += 2;
                }
                else if (j == 1) {
                    // 2nd digit of the ascii value
                    letter = letter + (10 * Character.getNumericValue(str.charAt(i)));
                    i++;
                    j++;;
                }
                else if (j == 2) {
                    // 3rd digit of the ascii value
                    letter = letter + Character.getNumericValue(str.charAt(i));
                    i++;
                    j++;
                }
            }
            buff.append((char) letter);
            j = 0;
            letter = 0;
        }
        return buff.toString();
    }
}