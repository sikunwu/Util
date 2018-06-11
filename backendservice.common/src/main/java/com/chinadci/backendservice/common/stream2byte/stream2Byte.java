package com.chinadci.backendservice.common.stream2byte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class stream2Byte {
    public static byte[] getStream2Byte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(buf)) != -1) {
          outStream.write(buf, 0, len);
        }
        return outStream.toByteArray();
    }
}
