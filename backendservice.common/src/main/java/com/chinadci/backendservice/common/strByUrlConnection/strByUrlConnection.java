package com.chinadci.backendservice.common.strByUrlConnection;

import com.chinadci.backendservice.common.stream2Str.stream2Str;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class strByUrlConnection {
    public static String getStrByUrlConnection(String spec) {
        String result = null;
        try {
            URL url = new URL(spec);
            URLConnection urlConnection = url.openConnection();
            /* send get request default */
            urlConnection.setDoInput(true);
            /* send post request, communication through url.getOutputStream */
            // urlConnection.setDoOutput(true);
            // OutputStream outputStream = urlConnection.getOutputStream();
            InputStream inputStream = urlConnection.getInputStream();
            result = stream2Str.getStream2Str(inputStream);
        } catch (IOException e) {
            return null;
        }
        return result;
    }
}
