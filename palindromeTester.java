import java.util.Scanner;

/**
 * tester class for the palindrome class
 */
public class palindromeTester {
    /**
     * main function to execute the program
     * @param args
     */
    public static void main(String[] args) {
        String line;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String:");
        while(sc.hasNext()){
            line = sc.nextLine();
            line = line.toUpperCase();
            processLine(line);
            palindrome testPalindrome = new palindrome(line);
            System.out.println(testPalindrome.toString());
        }
    }

    /**
     * displays possessing to the screen
     * @param line
     */
    public static void processLine(String line) {
        System.out.println("processing " + line);
    }
}
