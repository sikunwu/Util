package com.chinadci.backendservice.common.dealFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileCopy
{
  public static void copyFileUsingFileChannels(String sourcePath, String destPath) throws IOException {
    File source=new File(sourcePath);
    File dest=new File(destPath);
    dest.setExecutable(true);//设置可执行权限
    dest.setReadable(true);//设置可读权限
    dest.setWritable(true);//设置可写权限

    FileChannel inputChannel = null;
    FileChannel outputChannel = null;
    try {
      inputChannel = new FileInputStream(source).getChannel();
      outputChannel = new FileOutputStream(dest).getChannel();
      outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
    } finally {
      inputChannel.close();
      outputChannel.close();
    }
  }
}
