package gg.letsgo.boutframework.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLResouce  implements Resource{
    private final URL url;

    public URLResouce(URL url){
        this.url = url;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
