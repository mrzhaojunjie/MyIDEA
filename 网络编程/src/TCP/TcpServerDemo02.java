package TCP;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpServerDemo02{
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(9000);
        Socket accept = socket.accept();
        InputStream is = accept.getInputStream();
        FileOutputStream fos = new FileOutputStream("2.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        OutputStream os = accept.getOutputStream();
        os.write("我接受完毕了".getBytes());
        fos.close();
        is.close();
        accept.close();
        socket.close();

    }
}
