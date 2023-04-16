
public class Card
{
    // Create the class variables
    private int value;
    private String name;

    // Getters and Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Initialize the chosen card variables
    public Card (String cardName, int cardValue)
    {
        setValue(cardValue);
        setName(cardName);
    }
    // Prints out the cards name (i.e. "2 of Clubs")
    public void describe ()
    {
        System.out.print(name);
    }
}
