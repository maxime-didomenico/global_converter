import java.util.Scanner;

public class main {

    public static String ft_valid_string() {
        int check = 0;
        Scanner scanner = new Scanner(System.in);  
        String str = ""; 

        while (check == 0) {
            try {
                System.out.println("Error : invalid string");
                System.out.println("Please enter a string of character :");
                str = scanner.nextLine();
                check = ft_check_string(str);
            }
            catch (Exception e) {
                System.out.println("Error : invalid string");
            }
        }
        scanner.close();
        return str;
    }

    public static int ft_check_string(String str) {
        int i = 0;

        while (i < str.length()) {

            char c = str.charAt(i);
            int v = (int) c;
            
            // checking if the ascii value is in the man ascii table
            if (v < 0 || v > 127) {
                return 0;
            }
            i++;
        }
        return 1;
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

    public static void main(String[] args) {
        int check;
        String str = "", buff = "";

        if (args.length == 2) {
            check = ft_check_string(args[1]);
            
            if (check == 0) {
                str = ft_valid_string();
            }

            else {
                str = args[1];
            }
        }

        if (args.length > 2) {
            System.out.println("Error : too many arguments");
        }

        if (args[0].equals("-man") && args.length == 1) {
            System.out.println("Here's the list of the available options :\n -h : hexadecimal\n -b : binary\n -o : octal\n -d : decimal\n -man : man\nIf you want the translation of an encrypted string, use :\n --d : decimal\n --h : hexadecimal\n --o : octal\n --b : binary\n\nIf you want to remove the spaces for the --X traductions use :\n-rs : remove space");
            System.exit(0);
        }

        if (!args[0].equals("-man") && args.length == 1) {
            str = ft_valid_string();
        }

        switch (args[0]) {

            case "-h":
                buff = ft_str_to_hexadecimal(str);
                System.out.println(buff);
                break;

            case "-b":
                buff = ft_str_to_binary(str);
                System.out.println(buff);
                break;

            case "-o":
                buff = ft_str_to_octal(str);
                System.out.println(buff);
                break;

            case "-d":
                buff = ft_str_to_decimal(str);
                System.out.println(buff);
                break;

            case "-rs":
                str = str.replaceAll(" ", "");
                System.out.println(str);
                break;

            case "--h":
                if (str.length() % 8 != 0) {
                    System.out.println("Error : invalid binary string");
                    System.exit(0);
                }
                else {
                    buff = ft_hexadecimal_to_str(str);
                    System.out.println(buff);
                    break;
                }

            case "--b":
                if (str.length() % 8 != 0) {
                    System.out.println("Error : invalid binary string");
                    System.exit(0);
                }
                else {
                    buff = ft_binary_to_str(str);
                    System.out.println(buff);
                    break;
                }

            case "--o":
                if (str.length() % 3 != 0) {
                    System.out.println("Error : invalid binary string");
                    System.exit(0);
                }
                else {
                    buff = ft_octal_to_str(str);
                    System.out.println(buff);
                    break;}

            case "--d":
                buff = ft_decimal_to_str(str);
                System.out.println(buff);
                break;

            default:
                System.out.println("Error : invalid option");
                break;
        }
    }
}