import java.io.IOException;
import java.net.*;
import java.io.*;

public class Client {

    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String args[]) throws IOException {

        Socket sock;
        sock = new Socket(HOST, PORT);
        System.out.println("Connection established: " + sock);

        BufferedReader keyboard;
        keyboard = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter output;
        output = new PrintWriter(sock.getOutputStream());

        String str = "";
        while (true) {

            System.out.println("<Sending:> ");
            str = keyboard.readLine();
            System.out.println(str);

            if (str.equalsIgnoreCase("koniec")) {
                output.println(str);
                keyboard.close();
                output.close();
                sock.close();
                break;
            } else {
                output.println(str);
                output.flush();
            }
        }
    }
}
