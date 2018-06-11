package com.chinadci.backendservice.common.tomcatDownloadPath;

public class tomcatDownloadPath {
    public static String getPath(){
        String pic_path;
        //获取Tomcat服务器所在的路径
        String tomcat_path = System.getProperty( "user.dir" );
        System.out.println(tomcat_path);
        //获取Tomcat服务器所在路径的最后一个文件目录
        String bin_path = tomcat_path.substring(tomcat_path.lastIndexOf("\\")+1,tomcat_path.length());
        System.out.println(bin_path);
        //若最后一个文件目录为bin目录，则服务器为手动启动
        if(("bin").equals(bin_path)){//手动启动Tomcat时获取路径为：D:\Software\Tomcat-8.5\bin
            //获取保存上传图片的文件路径
            pic_path = tomcat_path.substring(0,System.getProperty( "user.dir" ).lastIndexOf("\\")) +"\\webapps"+"\\file\\";
        }else{//服务中自启动Tomcat时获取路径为：D:\Software\Tomcat-8.5
            pic_path = tomcat_path+"\\webapps"+"\\file\\";
        }
        return pic_path;
    }
}
