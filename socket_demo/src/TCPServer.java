import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        String clientSentence;
        String capitalizedSentence;
        ServerSocket serverSocket = new ServerSocket(6789);

        while(true){
            Socket connectionSocket = serverSocket.accept();
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase() + " 666 " + '\n';

            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
