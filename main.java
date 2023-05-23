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
                buff = hex.ft_str_to_hexadecimal(str);
                System.out.println(buff);
                break;

            case "-b":
                buff = bin.ft_str_to_binary(str);
                System.out.println(buff);
                break;

            case "-o":
                buff = oct.ft_str_to_octal(str);
                System.out.println(buff);
                break;

            case "-d":
                buff = dec.ft_str_to_decimal(str);
                System.out.println(buff);
                break;

            case "-rs":
                str = str.replaceAll(" ", "");
                System.out.println(str);
                break;

            case "--h":
                if (str.length() % 2 != 0) {
                    System.out.println("Error : invalid binary string");
                    System.exit(0);
                }
                else {
                    buff = hex.ft_hexadecimal_to_str(str);
                    System.out.println(buff);
                    break;
                }

            case "--b":
                if (str.length() % 8 != 0) {
                    System.out.println("Error : invalid binary string");
                    System.exit(0);
                }
                else {
                    buff = bin.ft_binary_to_str(str);
                    System.out.println(buff);
                    break;
                }

            case "--o":
                if (str.length() % 3 != 0) {
                    System.out.println("Error : invalid binary string");
                    System.exit(0);
                }
                else {
                    buff = oct.ft_octal_to_str(str);
                    System.out.println(buff);
                    break;}

            case "--d":
                buff = dec.ft_decimal_to_str(str);
                System.out.println(buff);
                break;

            default:
                System.out.println("Error : invalid option");
                break;
        }
    }
}