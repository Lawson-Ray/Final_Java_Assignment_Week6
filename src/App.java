import java.util.Scanner;
public class App
{
    // Takes a user input and returns a boolean
    public static boolean userAnswer()
    {
        boolean result = true;
        boolean needLoop = true;
        // Use an infinite do while with a try catch to repeatedly ask for input until given appropriate response
        do {
            Scanner goesFirst = null;
            try {
                goesFirst = new Scanner(System.in);
                String userFirst = goesFirst.next();
                // Allow all case inputs
                if (userFirst.toLowerCase().equals("yes")) {
                    result = true;
                    needLoop = false;
                } else if (userFirst.toLowerCase().equals("no")) {
                    result = false;
                    needLoop = false;
                }
            } catch (Exception ex) {
                goesFirst.reset();
            }
            if (needLoop == true) {
                System.out.println("");
                System.out.print("Answer with a 'yes' or 'no': ");
            }
        }
        while (needLoop == true);
        return result;
    }
    // Use scanner to acquire a String
    public static String userName()
    {
        Scanner givenName = new Scanner(System.in);
        // returns the given input including spaces
        return givenName.nextLine();
    }
    // Returns a user provided int
    public static int userNumber()
    {
        // initialize variables
        boolean needLoop = true;
        Scanner givenNum = null;
        // Initialize userNum here so that it can be used in the loop
        int userNum = 0;
        // similar infinite loop used by userAnswer method
        do {
            try {
                givenNum = new Scanner(System.in);
                userNum = givenNum.nextInt();
                // check if given a positive int
                if (userNum >= 0) {
                    needLoop = false;
                }
            } catch (Exception ex) {
                givenNum.reset();
            }
            if (needLoop == true) {
                System.out.println("");
                System.out.print("Answer with a whole number of 0 or greater: ");
            }
        }
        while (needLoop == true);
        // return userNum * 1000 since the delay counts milliseconds
        return userNum * 1000;
    }
    public static void main(String[] args)
    {
        // initialize players and instantiate the deck
        Player player1 = new Player();
        Player player2 = new Player();
        Deck deck = new Deck();

        // shuffle the deck
        deck.shuffle();

        // initialize the player scores
        player1.start();
        player2.start();

        // Ask player to give name
        System.out.print("What is your name?: ");
        player1.setName(userName());

        // Ask player to give opponent's name
        System.out.print("What is your opponent's name?: ");
        player2.setName(userName());

        // Check if player wants to draw first, and then draw from the deck accordingly
        System.out.print("Would you like to draw first?: ");
        boolean firstHand = userAnswer();
        while (deck.cardsLeft() > 0)
        {
            if (firstHand == true)
            {
                player1.draw(deck);
                player2.draw(deck);
            }
            else
            {
                player2.draw(deck);
                player1.draw(deck);
            }
        }

        System.out.print("Would you like to see the cards in your hand?: ");
        boolean revealCards = userAnswer();

        // Request user for delay in seconds between each flip and at round end
        System.out.println("Last question... how long in seconds do you want pauses between each card being played and for the end of each round?");
        System.out.print("input your answer as a whole number. (enter 0 for no delays): ");
        int delay = userNumber();

        if (revealCards == true)
        {
            // Prints the user's hand
            System.out.println("These are the cards that are in your hand.");
            player1.describe();
            System.out.println("");
        }

        // Queries user readiness
        System.out.print("I lied... Are you ready to play?: ");
        boolean ready = userAnswer();
        if (ready == true)
        {
            System.out.println("excellent, let's begin.");
        }
        else
        {
            System.out.println("too bad, we're starting anyway.");
        }
        // Plays War until all cards have been used
        int rounds = 0;
        int maxRounds = player1.getHandSize();
        while (rounds < maxRounds)
        {
            System.out.println("Round " + (rounds + 1));
            // Print out the cards drawn from both hands
            System.out.print(player1.getName() + " played a ");
            Card yourCard = player1.flip();
            yourCard.describe();
            System.out.println("");
            // Create pauses between cards being played and when round ends to simulate realistic gameplay (or just to allow the player to know what's going on)
            try
            {
                Thread.sleep(delay);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            // Print out which player played what card
            System.out.print(player2.getName() + " played a ");
            Card oppCard = player2.flip();
            oppCard.describe();
            System.out.println("");
            try
            {
                Thread.sleep(delay);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

            // Print the results of the round
            if (yourCard.getValue() > oppCard.getValue())
            {
                System.out.println(player1.getName() + " won this round");
                player1.incrementScore();
            }
            else if (oppCard.getValue() > yourCard.getValue())
            {
                System.out.println(player2.getName() + " won this round");
                player2.incrementScore();
            }
            else
            {
                System.out.println(player1.getName() + " and " + player2.getName() + " Tied");
            }
            try
            {
                Thread.sleep(delay);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println(player1.getName() + " has " + player1.getScore() + " points to " + player2.getName() + "'s " + player2.getScore() + " points");
            try
            {
                Thread.sleep(delay);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            rounds ++;
        }
        // Print round results and Increment to score based on round
        if (player1.getScore() > player2.getScore())
        {
            System.out.println(player1.getName() + " won");
        }
        else if (player2.getScore() > player1.getScore())
        {
            System.out.println(player2.getName() + " won");
        }
        else
        {
            System.out.println(player1.getName() + " and " + player2.getName() + " tied");
        }
    }
}