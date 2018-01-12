package com.xueyou.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by wuxueyou on 2018/1/12.
 */
public class URLConnectionClient {
    private final static String HTTP_URL_GET = "http://www.baidu.com";
    private final static String HTTP_URL_POST =  "http://www.baidu.com";
    private static HashMap<String, String> mData = new HashMap<String, String>();

    public static void main(String[] args) throws Exception {
        mData.put("name", "HongBin");
        mData.put("sex", "male");

        System.out.println("GetResult:" + startGet(HTTP_URL_GET));
        System.out.println("PostResult:" + startPost(HTTP_URL_POST));
    }

    private static String startGet(String path) {
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            //GET请求直接在链接后面拼上请求参数
            String mPath = path + "?";
            for (String key : mData.keySet()) {
                mPath += key + "=" + mData.get(key) + "&";
            }
            mPath = mPath.substring(0, mPath.length() - 1);
            URL url = new URL(mPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            //Get请求不需要DoOutPut
            conn.setDoOutput(false);
            conn.setDoInput(true);
            //设置连接超时时间和读取超时时间
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
//            String routeCode = conn.getRequestProperty("routeCode");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //连接服务器
            conn.connect();
            // 取得输入流，并使用Reader读取
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    private static String startPost(String path) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            // 发送POST请求必须设置为true
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //设置连接超时时间和读取超时时间
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "x-www-form-urlencoded");

            out = new OutputStreamWriter(conn.getOutputStream());
            // POST的请求参数写在正文中
            for (String key : mData.keySet()) {
                out.write(key + "=" + mData.get(key) + "&");
            }
            out.flush();
            out.close();
            // 取得输入流，并使用Reader读取
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

}
