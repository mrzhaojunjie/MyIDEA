package TCP;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo02 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9000);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("1.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //客户端传输完成后要终止程序
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buffer2))!=-1){
            bos.write(buffer2,0,len2);
        }
        System.out.println(bos.toString());
        bos.close();
        fis.close();
        os.close();
        socket.close();

    }

}
