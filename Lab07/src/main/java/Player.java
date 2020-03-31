import java.util.Random;
import java.util.Vector;

public class Player implements Runnable {
    String name;
    Game aGame;
    Vector<Token> selectedTokens;
    private boolean doStop = false;
    public Player() {
    }
    public void extractToken(Token a){
      this.selectedTokens.add(a);
       aGame.aBoard.delete(a);
    }
    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }
    @Override
    public void run() {
        while(keepRunning()) {
            Random rand=new Random();
            this.extractToken(aGame.aBoard.listaToken.get(rand.nextInt(10)));
            System.out.println("Running");

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
