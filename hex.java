public class hex {

    public static String ft_hexadecimal_to_str(String str) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        StringBuilder buff = new StringBuilder();
        int i = 0, j = 0, k = 0, letter = 0;
       
        while (i < str.length()) {
                
            while (j < 2) {
                    
                while (k < hexArray.length) {
                        
                    if (str.charAt(i) == hexArray[k]) {
                        // finding the 1st hexa num
                        letter = letter * 16 + k;
                        i++;
                        break;
                    }
                    k++;
                }
                // fiding the 2nd hexa num
                j++;
                k = 0;
            }
            buff.append((char) letter);
            j = 0;
            letter = 0;
        }
        return buff.toString();
    }

    public static String ft_str_to_hexadecimal(String str) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        StringBuilder buff = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            char c = str.charAt(i);
            int v = (int) c;
            // v / 16 = 1st hexa num
            buff.append(hexArray[v >>> 4]);
            // v % 16 = 2nd hexa num
            buff.append(hexArray[v & 0x0F]);
            buff.append(" ");
            i++;
        }
        return buff.toString();
    }
}