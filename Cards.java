public class Cards {
    private String suit;
    private String value;
    public Cards(String suitcard, String valuecard) {
        suit = suitcard;
        value = valuecard;
    }

    public void setSuit(String a) { suit = a; }
    public void setValue(String a) { value = a; }
    public String getSuit() { return suit; }
    public String getValue() { return value; }
}