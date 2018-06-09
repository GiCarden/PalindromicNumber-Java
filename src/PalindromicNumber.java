import java.util.Scanner;

/**
 * A palindromic number or numeral palindrome is a number that remains the same when its digits are reversed.
 */
class PalindromicNumber {
//--------------------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

//Constructor---------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

//Private Methods-----------------------------------------------------------------------------------------------------//
    /**
     * iterative-based palindrome tester
     *
     * @param integer to test
     */
    private static void isNumberPalindrome(Integer integer) {

        String number = integer.toString();
        int j = number.length() - 1;

        if (number.length() <= 1) {

            System.out.printf("\n%s is a numeral palindrome\n", number);
            return;
        }

        for (int i = 0; i < number.length(); i++) {

            if (number.charAt(i) != number.charAt(j)) {

                System.out.printf("\n%s is not a numeral palindrome\n", number);
                return;
            }
            j--;
        }
        System.out.printf("\n%s is a numeral palindrome\n", number);
    }

    /**
     * mathematically-based palindrome tester
     *
     * @param number to test
     */
    private static void isNumberPalindrome(int number) {

        int original = number;
        int reverse = 0;
        int lastDigit;

        // Repeat this process until number is reduced to zero and reversal is completed.
        while (original > 0) {

            // Step 1  - Isolate the last digit in number
            // In this case, we divide number by 10 and return the remainder.
            lastDigit = original % 10;

            // Step 2  -  Append lastDigit to reverse
            // We multiply reverse by 10 so that the ones column becomes the tens column, the tens column becomes the
            // hundreds column, and so on. This also leaves us with a new ones column where we can add our lastDigit
            reverse = (reverse * 10) + lastDigit;

            // Step 3 - Remove last digit from number
            // To remove the last digit from number we simply divide it by 10. This works because we are performing
            // integer division which rounds results down to the nearest integer
            original = original / 10;
        }

        if (number == reverse) {

            System.out.printf("%s is a numeral palindrome\n", number);
        } else {

            System.out.printf("%s is not a numeral palindrome\n", number);
        }
    }
//--------------------------------------------------------------------------------------------------------------------//

//Package Private Methods---------------------------------------------------------------------------------------------//
    /**
     * test's user input to make sure they entered an integer.
     */
    static void inputProcessor() {

        Scanner cin = new Scanner(System.in);
        boolean isInt = false;
        int temp = -1;

        System.out.println("\nEnter an integer to check if its a Numeral Palindrome");

        do {
            try {

                temp = Integer.parseInt(cin.next().trim());
                isInt = true;
            } catch (NumberFormatException | NullPointerException e) {

                System.out.println("Did not enter an integer, try again");
            }
        } while (!isInt);

        isNumberPalindrome(Integer.valueOf(temp));
        isNumberPalindrome(temp);
    }
//--------------------------------------------------------------------------------------------------------------------//

//Public Methods------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

//Setters-------------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

//Getters-------------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

}//End of Class.
