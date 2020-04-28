import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public static ExecutorService threadPool =
            Executors.newFixedThreadPool(10);
    public static ServerSocket serverSocket = null;
    public static void stop() throws InterruptedException, IOException {
        GameServer.threadPool.shutdown();
        if (GameServer.threadPool.awaitTermination(1000, TimeUnit.SECONDS))
            System.err.println("Threads didn't finish in 20 seconds!");
        GameServer.serverSocket.close();
    }
    public GameServer() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                threadPool.execute(new ClientThread(socket));
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();

        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();


    }
}