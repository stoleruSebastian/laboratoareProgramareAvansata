import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

class ClientThread extends Thread {
    private Socket socket = null;
    private boolean ok ;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.ok=true;
    }

    public void run() {
        try {
            while (ok) {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());

                if (request.equals("stop")) {
                    ok = false;
                    String raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    try {
                        GameServer.stop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    String raspuns = "Server received the request ... ";
                    out.println(raspuns);
                    out.flush();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
