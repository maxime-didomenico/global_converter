public class oct {

    public static String ft_str_to_octal(String str) {
        char[] octalArray = "01234567".toCharArray();
        StringBuilder buff = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            char c = str.charAt(i);
            int v = (int) c;
            StringBuilder octal = new StringBuilder();

            while (v > 0) {
                // v % 8 = 1st octal num
                int rem = v % 8;
                octal.append(octalArray[rem]);
                // v / 8 = 2nd octal num
                v /= 8;
            }

            while (octal.length() < 3) {
                // adding 0 to the left of the octal num
                octal.append('0');
            }
            // reversing the octal num
            buff.append(octal.reverse());
            buff.append(" ");
            i++;
        }
        return buff.toString();
    }

    public static String ft_octal_to_str(String str) {
        StringBuilder buff = new StringBuilder();
        int i = 0, j = 0, letter = 0;

        while (i < str.length()) {
            while (j < 3 && i < str.length()) {
                if (j == 0 && str.charAt(i) == '1') {
                    // 1st digit of the ascii value
                    letter = 64;
                    i++;
                    j++;
                }
                else if (j == 0 && str.charAt(i) != '1') {
                    // 1st digit of the ascii value
                    letter = letter + (8 * Character.getNumericValue(str.charAt(i)));
                    i++;
                    j += 2;
                }
                else if (j == 1) {
                    // 2nd digit of the ascii value
                    letter = letter + (8 * Character.getNumericValue(str.charAt(i)));
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