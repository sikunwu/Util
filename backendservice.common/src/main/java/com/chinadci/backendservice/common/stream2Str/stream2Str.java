package com.chinadci.backendservice.common.stream2Str;

import java.io.IOException;
import java.io.InputStream;

public class stream2Str {
    public static String getStream2Str(InputStream inputStream) {
        StringBuffer sb = new StringBuffer();
        byte[] buf = new byte[1024];
        int len = -1;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                sb.append(new String(buf, 0, len, "utf-8"));
            }
        } catch (IOException e) {
            return null;
        }
        return sb.toString();
    }
}
