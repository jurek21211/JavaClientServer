import java.io.IOException;
import java.net.*;
import java.io.*;

public class Client {

    public static final int PORT = 50007;
    public static final String HOST = "127.0.0.1";

    public static void main(String args[]) throws IOException {


        Socket sock = null;
        BufferedReader keyboard = null, server = null;
        PrintWriter output = null;

        try {
            sock = new Socket(HOST, PORT);
            System.out.println("Connection established: " + sock);

            keyboard = new BufferedReader(new InputStreamReader(System.in));
            server = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            output = new PrintWriter(sock.getOutputStream());
        } catch (ConnectException c) {
            System.out.println(c);
        }
        catch(SocketException s){
            System.out.println(s);
        }



        String str = "";
        String replyStr = "";

        while (true) {

            System.out.println("<Sending:> ");
            str = keyboard.readLine();
            System.out.println(str);

            if (str.equalsIgnoreCase("over") || replyStr.equalsIgnoreCase("over")) {
                output.println(str);
                keyboard.close();
                server.close();
                output.close();
                sock.close();
                break;
            } else {
                output.println(str);
                output.flush();
                System.out.println("<Waiting for server to answer:>");
                replyStr = server.readLine();
                System.out.println("<Server replied:> " + replyStr);

            }
        }
    }
}
