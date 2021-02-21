package be.vdab;

public class Woord {
    private final String woord;

    public Woord(String woord) {
        this.woord = woord;
    }

    public boolean isPalindroom() {
        var palindroom=new StringBuilder(woord).reverse().toString();
        return palindroom.equals(woord);
    }
}
