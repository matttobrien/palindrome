/**
 * Assignment 1
 * Create a program which reads a string from the user,
 * then determines if the string is a palindrome, mirrored palindrome or mirrored string.
 * @author Matthew O'Brien
 * @date October 5th 2018
 * @version 1
 */

class palindrome {
    private String line;

    /**
     * default constructor
     */
    public palindrome(){
        line = "empty";
    }

    /**
     * overloaded constructor
     * @param str
     */
    public palindrome(String str) {
        this();
        setLine(str);
    }

    /**
     * setter for line
     * @param str
     */
    public void setLine(String str) {
        if(str.length() > 0) {
            this.line = str;
        }
    }

    /**
     * getter for line
     * @return
     */
    public String getLine() {
        return line;
    }

    /**
     * checks if the user entered string is a palindrome by reversing the string then comparing it to the original
      * @param line
     * @return
     */
    public static boolean isPalindrome(String line) {
        StringBuilder reverse = new StringBuilder(line).reverse();
        return reverse.toString().equalsIgnoreCase(line);
    }

    /**
     * checks if the user entered string is a Mirrored string
     * @param line
     * @return true/false
     */
    public static boolean isMirror(String line) {
        /*
        a new char array is introduced to replace the mirror characters
        the length is 128 to represent the number of character in ASCII
        at each letters position in ASCII its mirror is placed
        */
        char[] mirrorArray = new char[128];
        mirrorArray['A'] = 'A';
        mirrorArray['E'] = '3';
        mirrorArray['3'] = 'E';
        mirrorArray['H'] = 'H';
        mirrorArray['I'] = 'I';
        mirrorArray['J'] = 'L';
        mirrorArray['L'] = 'J';
        mirrorArray['M'] = 'M';
        mirrorArray['O'] = 'O';
        mirrorArray['S'] = '2';
        mirrorArray['2'] = 'S';
        mirrorArray['T'] = 'T';
        mirrorArray['U'] = 'U';
        mirrorArray['V'] = 'V';
        mirrorArray['W'] = 'W';
        mirrorArray['X'] = 'X';
        mirrorArray['Y'] = 'Y';
        mirrorArray['Z'] = '5';
        mirrorArray['5'] = 'Z';
        mirrorArray['1'] = '1';
        mirrorArray['8'] = '8';
        //introduces Mirror as true
        boolean Mirror = true;
        /*
        fills a new char array with the user entered string
        while replacing 0 with O as 0 is not valid
        */
        char[] charArray = line.replace("0", "O").toCharArray();
        /*
        for-loop to check if the the letters on both sides of the string match
        Mirror is initially set to true as it it featured in the parameters for the for loop
        if the letters don't match then mirror is set to false, thus breaking the loop
        */
        for (int i = 0; i < charArray.length / 2 && Mirror; i++) {
            /*
            the char array is inside the mirrorArray as the char array will return its character
            then the letter will return its place in ASCII in the mirror array
            if it has a mirror then the mirror letter will be compared to its equal position on the other half of the string
            if there is a match then mirror remains true, if not then it is set to false
            */
            Mirror = (mirrorArray[charArray[i]] == charArray[charArray.length - 1 - i]);
        }
        /*
        this for-loop checks the middle character if the string has an odd length
        if the middle character has a mirror in the mirrorArray then mirror will remain true
         */
        if (charArray.length % 2 == 1) {
            Mirror = Mirror && mirrorArray[charArray[charArray.length / 2]] == charArray[charArray.length / 2];
        }
        //returns the boolean value of Mirror
        return Mirror;
    }

    /**
     * custom toString to properly display the programs results
     * @return
     */
    public String toString() {
        //if else to check if a valid string has been entered
        if(getLine().equals("empty")){
            return "Please enter a valid String.";
        }
        else {
            /*
            uses if statements to determine what kind of word has been entered
            each method is boolean so if the both methods/method returns true then the if statement is activated
            thus printing the result to the screen
            */
            if (isPalindrome(getLine()) && isMirror(getLine())) {
                return getLine() + " -- is a mirrored palindrome.";
            }
            else if (isPalindrome(getLine())) {
                return getLine() + " -- is a regular palindrome.";
            }
            else if (isMirror(getLine())) {
                return getLine() + " -- is a mirrored string.";
            }
            else {
                return getLine() + " -- is not a palindrome.";
            }
        }
    }
}
