import com.sun.tools.javac.util.List;

import java.util.ArrayList;

public class Board {
    ArrayList<Token> listaToken;

    public Board(int n) {
        this.listaToken = new ArrayList<Token>(n);
    }
    public void delete(Token x){
        this.listaToken.remove(x);
    }

    @Override
    public String toString() {
        return "Board{" +
                "listaToken=" + listaToken +
                '}';
    }
}
