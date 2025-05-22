import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    int clientCounter;
    int activeclientCounter;
   // public int port=66%24+2000;



    public Server() throws IOException {

        serverSocket = new ServerSocket(2025);
        clientCounter=0;
        activeclientCounter=0;
        while (true)
        {
            try{
                Socket s= serverSocket.accept();
                clientCounter++;
                activeclientCounter++;
                ServerThread serverThread=new ServerThread(this, s);
                Thread thread=new Thread(serverThread);
            }catch (Exception e )
            {
                //ignore
            }
        }
    }
}
