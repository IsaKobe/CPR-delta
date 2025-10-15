package cz.richard.cards;

public class Card {
    public long number;

    public int expireMonth;
    public int expireYear;
    public int CVC;

    @Override
    public String toString() {
        return number + " " +  " " + expireMonth + " " + expireYear;
    }
}
