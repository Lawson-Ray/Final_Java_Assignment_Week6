import java.util.ArrayList;
import java.util.List;

public class Player
{
    // Create the class variables
    private List<Card> hand;
    private String name;
    private int score;

    // Initializes the player's hand
    public Player()
    {
        hand = new ArrayList<>();
    }
    // Getters and Setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
    public int getHandSize()
    {
        return hand.size();
    }

    // Prints the current hand's cards
    public void describe()
    {
        for (int i = 0; i < hand.size(); i++)
        {
            hand.get(i).describe();
            System.out.print(" ");
        }
    }
    // Initializes the score for the current player
    public void start()
    {
        setScore(0);
    }
    // Takes a card from the current deck and adds it to the player's hand
    public void draw(Deck currentDeck)
    {
       Card drawnCard = currentDeck.draw();
        this.hand.add(drawnCard);
    }
    // Removes the first card from the player's hand and returns it
    public Card flip()
    {
        Card drawnCard;
            drawnCard = hand.get(0);
            hand.remove(0);
        return drawnCard;
    }
    // Adds 1 to the player's score
    public void incrementScore()
    {
        setScore(score += 1);
    }
}