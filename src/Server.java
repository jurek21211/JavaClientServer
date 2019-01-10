import java.io.*;
import java.net.*;

public class Server {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException{

        ServerSocket serv;
        serv = new ServerSocket(PORT);

        System.out.println("Reading: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Connected: " + sock);

        BufferedReader inp;
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        String str;
        str = inp.readLine();
        System.out.println("<Received:> " + str);
        while(true) {
            inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            str = inp.readLine();
            System.out.println("<Received:> " + str);
            if (str.equalsIgnoreCase("koniec")) {
                inp.close();
                sock.close();
                serv.close();
                break;
            }

        }
    }
}
