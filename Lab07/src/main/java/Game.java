import java.util.*;
import java.util.Random;

public class Game {
    int n;
    int m;
    int k;
    Board aBoard;
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Game(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
    }

}
