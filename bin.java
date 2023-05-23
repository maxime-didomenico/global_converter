public class bin {
    
    public static String ft_str_to_binary(String str) {
        char[] binaryArray = "01".toCharArray();
        StringBuilder buff = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            char c = str.charAt(i);
            int v = (int) c;
            StringBuilder binary = new StringBuilder();

            while (v > 0) {
                // v % 2 = 1st binary num
                int rem = v % 2;
                binary.append(binaryArray[rem]);
                // v / 2 = 2nd binary num
                v /= 2;
            }

            while (binary.length() < 8) {
                // adding 0 to the left of the binary num
                binary.append('0');
            }
            // reversing the binary num
            buff.append(binary.reverse());
            buff.append(" ");
            i++;
        }
        return buff.toString();
    }

    public static String ft_binary_to_str(String str) {
        StringBuilder buff = new StringBuilder();
        int i = 0, j = 0, letter = 0;

        while (i < str.length()) {
            while (j < 8 && i < str.length()) {
                if (str.charAt(i) == '1') {
                    // 1st digit of the ascii value by adding 2^(7-j)
                    letter += (int) Math.pow(2, 7 - j);
                    i++;
                    j++;
                }
                else if (str.charAt(i) == '0') {
                    // if the digit is 0, we just increment j because 2^(7-j) = 0
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