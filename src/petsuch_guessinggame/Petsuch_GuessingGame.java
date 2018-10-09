
package petsuch_guessinggame;

/**
 *
 * Angela Petsuch
 * September 13, 2018
 * Guess The Number Application
 */
public class Petsuch_GuessingGame {

    public static void main(String[] args) {
        // declare variables
        final int MIN = 1;
        final int MAX = 100;
        int count = 0;
        
        welcomeMessage();
        
        String choice = "y";
        // play game while user says "y"
        while(choice.equalsIgnoreCase("y")) {
            // run the game
            playGame(MIN, MAX, count);
            // ask user if they want to play again
            choice = playAgain(choice);
            } // end game while loop
            // after user says they don't want to play again
            System.out.println("Bye - Come back soon!");
            System.out.println();
    } // end main method
       
    public static void welcomeMessage() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }

    private static void playGame(final int MIN, final int MAX, int count) {
        // play the game
        System.out.println("I\'m thinking of a number between 1 and 100.");
        System.out.println("Try to guess it.");
        System.out.println();
        // keep track of the rand num
        int winningNumber = generateRandNum();
        
        boolean wonGame = false;
        // have user continue to guess the num while they havent won
        while(!wonGame) {
            // enter number
            // validate user input to between 1-100
            int guess = getIntWithinRange(MIN, MAX);
            
            // determine if winningNumber = userGuess
            wonGame = winGame(winningNumber, guess);
            if(!wonGame){
                // if it isn't equal to winningNumber determine how far off they are
                // add to counter var prompt to guess again
                determineGuessRange(winningNumber, guess);
                count++;
            } else { // print winning message
                System.out.println("You got it in " + count + " tries.");
                if(count <= 3){
                    System.out.println("Great work! You are mathematical wizard.");
                } else if(count >3 && count <= 7){
                    System.out.println("Not too bad! You've got some potential.");
                } else {
                    System.out.println("What took you so long? Maybe you should "
                            + "take some lessons.");
                }
                System.out.println();
                wonGame = true;
            }
        } // end game 
    }
    
    private static String playAgain(String choice) {
        // make sure user enters 'y' or 'n'
        boolean isvalid = false;
        while(!isvalid){
            // ask to play again
            choice = Console.getString("Try again? (y/n): ");
            System.out.println();
            
            if(choice.isEmpty()){
                System.out.println("Error - this entry is required. Try again.");
                System.out.println();
                isvalid = false;
            } else if ((!choice.equalsIgnoreCase("y")) && (!choice.equalsIgnoreCase("n"))){
                System.out.println("Error - Entry must be \'y\' or \'n\'. Try again.");
                System.out.println();
            } else {
                isvalid = true;
            }
        }
        return choice;
    }
    
    public static int generateRandNum() {
        int n = 1 + (int)(Math.random() * ((100 - 1) + 1));
        return n;
    }
    
    public static int getIntWithinRange(int min, int max){
        int i = 0;
        boolean isValid = false;
        while(!isValid) {
            i = Console.getInt("Enter Number: ");
            if (i < min) {
                System.out.println("Error! Number must be greater than " + min + ".");
            } else if (i > max) {
                System.out.println("Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    } // end getIntWithinRange method
    
    public static boolean winGame(int winningNumber, int guess) {
        if (winningNumber == guess) {
            return true;
        } else  {
            return false;
        }
    } // end winGame method
    
    public static void determineGuessRange(int winningNumber, int guess){
        if (guess > (winningNumber + 10)) {
            System.out.println("Way too high! Guess again.");
        } else if (guess > winningNumber) {
            System.out.println("Too high! Guess again.");
        } else if (guess < (winningNumber - 10)){
            System.out.println("Way too low! Guess again.");
        } else {
            System.out.println("Too low Guess again!");
        }
        System.out.println();
    } // end determineGuessRage method
    
} // end class
