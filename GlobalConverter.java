import java.util.Scanner;

public class GlobalConverter {

    public static String ft_valid_string() {
        int check = 0;
        Scanner scanner = new Scanner(System.in);  
        String str = ""; 

        while (check == 0) {
            try {
                System.out.println("\033[31m" + "Error : invalid string");
                System.out.println("Please enter a string of character :" + "\033[0m");
                str = scanner.nextLine();
                check = ft_check_string(str);
            }
            catch (Exception e) {
                System.out.println("\033[31m" + "Error : invalid string" + "\033[0m");
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

    public static void main(String[] args) {
        int check;
        String str = "", buff = "";

        if (args.length > 5) {
            System.out.println("\033[31m" + "Error : too many arguments" + "\033[0m");
        }

        if (args.length >= 2) {
            check = ft_check_string(args[1]);
            
            if (check == 0) {
                str = ft_valid_string();
            }

            else {
                str = args[1];
            }
        }

        if (args[0].equals("-man") && args.length == 1) {
            System.out.println("\033[36m" + "Here's the list of the available options :\n -h : hexadecimal\n -b : binary\n -o : octal\n -d : decimal\n -man : man\nIf you want the translation of an encrypted string, use :\n --d : decimal\n --h : hexadecimal\n --o : octal\n --b : binary\n\nIf you want to encrypt your string use :\njava GlobalConverter -X example -c value(int)" + "\033[0m");
            System.exit(0);
        }

        if (!args[0].equals("-man") && args.length == 1) {
            str = ft_valid_string();
        }

        switch (args[0]) {

            case "-h":
                buff = hex.ft_str_to_hexadecimal(str);
                break;

            case "-b":
                buff = bin.ft_str_to_binary(str);
                break;

            case "-o":
                buff = oct.ft_str_to_octal(str);
                break;

            case "-d":
                buff = dec.ft_str_to_decimal(str);
                break;

            case "--h":
                if (str.length() % 2 != 0) {
                    System.out.println("\033[31m" + "Error : invalid hexadecimal string" + "\033[0m");
                    System.exit(0);
                }
                else {
                    str = str.replaceAll(" ", "");
                    buff = hex.ft_hexadecimal_to_str(str);
                    break;
                }

            case "--b":
                if (str.length() % 8 != 0) {
                    System.out.println("\033[31m" + "Error : invalid binary string" + "\033[0m");
                    System.exit(0);
                }
                else {
                    str = str.replaceAll(" ", "");
                    buff = bin.ft_binary_to_str(str);
                    break;
                }

            case "--o":
                if (str.length() % 3 != 0) {
                    System.out.println("\033[31m" + "Error : invalid octal string" + "\033[0m");
                    System.exit(0);
                }
                else {
                    str = str.replaceAll(" ", "");
                    buff = oct.ft_octal_to_str(str);
                    break;}

            case "--d":
                str = str.replaceAll(" ", "");
                buff = dec.ft_decimal_to_str(str);
                break;

            default:
                System.out.println("\033[31m" + "Error : invalid option" + "\033[0m");
                System.exit(0);
        }

        if (args.length > 2) {
            switch (args[2]) {
                case "-c":
                    buff = enc.ft_cesar(str, Integer.parseInt(args[3]));
                    break;

                default:
                    break;
            }
        }

        if (args.length >= 1 && args[0] != "-man") {
            System.out.println("\033[32m" + buff + "\033[0m");
        }
    }
}