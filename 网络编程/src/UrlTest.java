import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://s3.ananas.chaoxing.com/doc/c5/66/03/d41f085cebc19dff0101b274b2d69027/thumb/1.png");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        InputStream is = httpURLConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("a.png");

        int len;
        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        httpURLConnection.disconnect();

    }
}
