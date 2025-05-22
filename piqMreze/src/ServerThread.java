import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Server server;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String delivered;
    private String toSend;
    public ServerThread(Server ser, Socket soc) throws IOException {
        this.socket=soc;
        this.server=ser;
        in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        out=new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()),true);
    }

    @Override
    public void run() {



    }
}
