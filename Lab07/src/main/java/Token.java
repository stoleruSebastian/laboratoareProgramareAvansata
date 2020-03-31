public class Token {
   private int number;
   private boolean blank;

    public Token(int number, boolean blank) {
        this.number = number;
        this.blank = blank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void isBlank(Token x) {
        if(x.blank==true){
        setNumber(x.number);
        x.blank=false;}
    }

    public void setBlank(boolean blank) {
        this.blank = blank;
    }

    public void setNumber(int value, int m) {
        if ((value < 1) || (value > m))
            throw new IllegalArgumentException("value is out of range for number");
        this.number = value;
    }




}
