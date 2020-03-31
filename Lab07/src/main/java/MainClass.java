import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Player x = new Player();
        x.aGame = new Game(10, 10, 4);
        x.aGame.aBoard = new Board(x.aGame.getN());
        Random rand = new Random();
        for (int i = 1; i <= x.aGame.n; i++)
            x.aGame.aBoard.listaToken.add(new Token(rand.nextInt(x.aGame.m), false));
        x.run();
        System.out.println(x.aGame.aBoard.listaToken);
        Thread thread = new Thread(x);
        thread.start();
        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x.doStop();
    }
}