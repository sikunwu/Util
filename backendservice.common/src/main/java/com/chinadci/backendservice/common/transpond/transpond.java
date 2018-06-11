package com.chinadci.backendservice.common.transpond;

import com.chinadci.backendservice.model.GrantFieldinfo;
import com.chinadci.backendservice.model.ServiceResult;
import com.chinadci.backendservice.model.ServiceResultCode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.net.ssl.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class transpond {
    @Autowired
    TranspondUtil transpondUtil;

    public void setTranspondUtil(TranspondUtil transpondUtil) {
        this.transpondUtil = transpondUtil;
    }

    public static ServiceResult gettranspond(String url, String parameters, String method, HttpServletRequest request, HttpServletResponse response) {
        ServiceResult result = new ServiceResult();
        try {
            if (method != null && method.equals("GET")) {

                if (parameters != null && !parameters.equals("")) {
                    url += "/";
                    url += parameters;
                }
                String query = request.getQueryString();
                if (query != null && !query.equals("")) {
                    url += "?";
                    url += query;
                }

                URL urlPath = new URL(url);
                URLConnection urlConnection = urlPath.openConnection();
                Map headers = urlConnection.getHeaderFields();
                Set<String> keys = headers.keySet();
                for (String key : keys) {
                    String val = urlConnection.getHeaderField(key);
                    System.out.println(key + "  " + val);
                    response.setHeader(key, val);
                }
                // response.setHeader("Content-Type","application/json;charset=utf-8");
                //response.setCharacterEncoding("UTF-8");
                OutputStream out = response.getOutputStream();
                // char[] buff=new char[1024];
                byte[] bytes = new byte[512];
                int len = -1;
                InputStream inputStream = urlConnection.getInputStream();

                while ((len = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                    out.flush();
                }
                inputStream.close();
                out.close();
            } else if (method != null && method.equals("POST")) {
                if (parameters != null && !parameters.equals("")) {
                    url += "/";
                    url += parameters;
                }
                String query = request.getQueryString();
                if (query != null && !query.equals("")) {
                    url += "?";
                    url += query;
                }

                URL urlPath = new URL(url);
                HttpURLConnection urlConnection = (HttpURLConnection) urlPath.openConnection();

                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", request.getHeader("Content-Type"));
                urlConnection.connect();

                InputStream is = request.getInputStream();
                int len1 = -1;
                byte[] buff1 = new byte[512];

                DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
                // dataOutputStream.writeBytes(wholeStr.toString());
                while ((len1 = is.read(buff1)) != -1) {
                    dataOutputStream.write(buff1, 0, len1);
                }
                dataOutputStream.flush();
                dataOutputStream.close();

                Map headers = urlConnection.getHeaderFields();
                Set<String> keys = headers.keySet();
                for (String key : keys) {
                    String val = urlConnection.getHeaderField(key);
                    response.setHeader(key, val);
                }
                // response.setHeader("Content-Type","application/json;charset=utf-8");
                // response.setCharacterEncoding("UTF-8");
                OutputStream out = response.getOutputStream();
                // char[] buff=new char[1024];
                byte[] bytes = new byte[512];
                int len = -1;
                InputStream inputStream = urlConnection.getInputStream();

                while ((len = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                    out.flush();
                }

                inputStream.close();
                out.close();
            }
        } catch (Exception ex) {
            result = new ServiceResult(ServiceResultCode.Error, ex.toString());
        }

        return result;
    }

    public ServiceResult getResourceTranspond(String clientId, String url, String parameters, String method, String query, List<GrantFieldinfo> fieldsList, HttpServletRequest request, HttpServletResponse response) {
        ServiceResult result = new ServiceResult();
        try {
            if (method != null && method.equals("GET")) {

                if (parameters != null && !parameters.equals("")) {
                    url += "/";
                    url += parameters;
                }
                //String query = request.getQueryString();
                if (query != null && !query.equals("")) {
                    url += "?";
                    url += query;
                }

                URL urlPath = new URL(url);
                URLConnection urlConnection = urlPath.openConnection();
                //如果是https
                if (urlConnection instanceof HttpsURLConnection) {
                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
                    ((HttpsURLConnection) urlConnection).setSSLSocketFactory(sc.getSocketFactory());
                    ((HttpsURLConnection) urlConnection).setHostnameVerifier(new TrustAnyHostnameVerifier());
                }
                Map headers = urlConnection.getHeaderFields();
                Set<String> keys = headers.keySet();
                for (String key : keys) {
                    String val = urlConnection.getHeaderField(key);
                    System.out.println(key + "  " + val);
                    response.setHeader(key, val);
                }
                // response.setHeader("Content-Type","application/json;charset=utf-8");
                //response.setCharacterEncoding("UTF-8");
                if (urlConnection.getHeaderField("Content-Type") != null
                        && (urlConnection.getHeaderField("Content-Type").indexOf("text/html") > -1
                        || urlConnection.getHeaderField("Content-Type").indexOf("application/json") > -1) || urlConnection.getHeaderField("Content-Type").indexOf("text/plain") > -1) {
                    String fieldtype = "alias";
                    if(parameters.indexOf("returnFieldName=true") > -1)
                        fieldtype = "name";

                    byte[] bytes = transpondUtil.gettranspondJson(urlConnection, response, clientId + parameters + method,fieldtype,fieldsList);
                    OutputStream out = response.getOutputStream();
                    out.write(bytes);
                    out.flush();
                    out.close();
                } else {
                    OutputStream out = response.getOutputStream();
                    // char[] buff=new char[1024];
                    byte[] bytes = new byte[512];
                    int len = -1;
                    InputStream inputStream = urlConnection.getInputStream();

                    while ((len = inputStream.read(bytes)) != -1) {
                        out.write(bytes, 0, len);
                        out.flush();
                    }
                    inputStream.close();
                    out.close();
                }

            } else if (method != null && method.equals("POST")) {
                if (parameters != null && !parameters.equals("")) {
                    url += "/";
                    url += parameters;
                }
                //String query = request.getQueryString();
                if (query != null && !query.equals("")) {
                    url += "?";
                    url += query;
                }

                URL urlPath = new URL(url);
                HttpURLConnection urlConnection = (HttpURLConnection) urlPath.openConnection();

                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", request.getHeader("Content-Type"));
                urlConnection.connect();

                InputStream is = request.getInputStream();
                int len1 = -1;
                byte[] buff1 = new byte[512];

                DataOutputStream dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
                // dataOutputStream.writeBytes(wholeStr.toString());
                while ((len1 = is.read(buff1)) != -1) {
                    dataOutputStream.write(buff1, 0, len1);
                }
                dataOutputStream.flush();
                dataOutputStream.close();

                Map headers = urlConnection.getHeaderFields();
                Set<String> keys = headers.keySet();
                for (String key : keys) {
                    String val = urlConnection.getHeaderField(key);
                    response.setHeader(key, val);
                }
                // response.setHeader("Content-Type","application/json;charset=utf-8");
                // response.setCharacterEncoding("UTF-8");

                OutputStream out = response.getOutputStream();
                // char[] buff=new char[1024];
                byte[] bytes = new byte[512];
                int len = -1;
                InputStream inputStream = urlConnection.getInputStream();

                while ((len = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, len);
                    out.flush();
                }

                inputStream.close();
                out.close();
            }
        } catch (Exception ex) {
            result = new ServiceResult(ServiceResultCode.Error, ex.toString());
        }

        return result;
    }

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
