package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiverDemo01 {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(9900);
        while (true){

            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
            socket.receive(packet);
            byte[] data = packet.getData();
            String message = new String(data, 0, data.length);
            System.out.println(message);
            if(message.equals("bye")){
                break;
            }
            
        }
        socket.close();
    }
}
