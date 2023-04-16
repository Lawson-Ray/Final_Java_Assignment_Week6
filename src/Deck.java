import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    // Create the variables used in the Deck class
    private List<Card> cards;

    // Instantiate and create a standard 52 card poker deck
    public Deck()
    {
        cards = new ArrayList<>();
        String suit;
        String face;

        for (int i = 1; i <= 4; i++)
        {
            switch(i)
            {
                case 1:
                    suit = " of Spades";
                    break;
                case 2:
                    suit = " of Clubs";
                    break;
                case 3:
                    suit = " of Diamonds";
                    break;
                default: suit = " of Hearts";
                    break;
            }
            for (int j = 2; j <= 14; j++)
            {
                if (j < 11)
                {
                    cards.add(new Card(j + suit, j));
                }
                else if (j == 11)
                {
                    face = "Jack";
                    cards.add(new Card(face + suit, j));
                }
                else if (j == 12)
                {
                    face = "Queen";
                    cards.add(new Card(face + suit, j));
                }
                else if (j == 13)
                {
                    face = "King";
                    cards.add(new Card(face + suit, j));
                }
                else
                {
                    face = "Ace";
                    cards.add(new Card(face + suit, j));
                }
            }
        }
    }
    // Checks and returns an int representation of the number of cards left in the deck
    public int cardsLeft()
    {
        return cards.size();
    }
    // shuffles the deck
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    // Takes the first card from the deck list and returns it after removing said element from deck
    public Card draw()
    {
        Card drawnCard = new Card(cards.get(0).getName(), cards.get(0).getValue());
        cards.remove(0);
        return drawnCard;
    }
    // Prints out the deck's elements in its current order
    public void describe()
    {
        int totalCards = cards.size();
        for (int l = 0; l < totalCards; l++)
        {
            cards.get(l).describe();
            System.out.print(" ");
        }
    }
}
