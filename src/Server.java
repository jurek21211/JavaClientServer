import java.io.*;
import java.net.*;

public class Server {
    public static final int PORT = 50007;

    public static void main(String args[]) throws IOException {

        ServerSocket serv;
        serv = new ServerSocket(PORT);

        System.out.println("Reading: " + serv);
        Socket sock;
        sock = serv.accept();
        System.out.println("Connected: " + sock);

        BufferedReader inp, keyboard;
        inp = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter reply;
        reply = new PrintWriter(sock.getOutputStream());
        String str;
        String replyStr;

        while (true) {
            str = inp.readLine();
            System.out.println("<Received:> " + str);
            System.out.println("<Type your answer: >");
            replyStr = keyboard.readLine();
            reply.println(replyStr);
            reply.flush();
            System.out.println("<Waiting for Client to answer:>");

            if (str.equalsIgnoreCase("over") || replyStr.equalsIgnoreCase("over")) {
                inp.close();
                reply.close();
                keyboard.close();
                sock.close();
                serv.close();

                System.out.println("<Connection closed>");
                break;
            }
        }
    }
}
