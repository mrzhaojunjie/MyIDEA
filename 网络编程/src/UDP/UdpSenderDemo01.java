package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String message = scanner.next();
            if(message.equals("bye")){
                break;
            }
            InetAddress inetAddress = InetAddress.getByName("localhost");
            int port = 9900;
            DatagramPacket packet = new DatagramPacket(message.getBytes(),0,message.getBytes().length,inetAddress,port);
            socket.send(packet);
        }
        socket.close();
    }
}
