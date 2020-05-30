package TCP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务器端
public class TcpServerDemo01 {
    public static void main(String[] args){
        ByteArrayOutputStream bos = null;
        InputStream is = null;
        Socket accept = null;
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(9999);
            accept = socket.accept();
            is = accept.getInputStream();
            bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);

            }
            System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(accept != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
