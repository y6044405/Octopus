package thread.gede.com.httpDemo;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import thread.gede.com.concurrent.DelayQueue.Cache;

public class HttpUtil {

    private static final Logger LOG = Logger.getLogger(Cache.class.getName());

    private static final int CORRECT_CODE = 200;

    /**
     * 拼接参数
     * @author:  wyf 
     * @param urlStr
     * @param params
     * @return
     */
    private static String getUrl(String urlStr, String... params) {
        StringBuffer sb = new StringBuffer();
        sb.append(urlStr + "?");
        for (int i = 0; i < params.length; i++) {
            String param = params[i];
            if (param != null && param.length() > 0) {
                if (i == 0) {
                    sb.append(param);
                } else {
                    sb.append("&" + param);
                }
            }
        }
        return sb.toString();
    }

    /** 
     * get
     */
    public static void get(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            System.out.println("executing request " + httpGet.getURI());
            // 执行get请求.    
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                // 获取响应实体    
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态    
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度    
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容    
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源    
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /** 
     * post
     *//*
       public static void postForm(String url, String... params) {
        if (url == null || url.isEmpty()) {
            System.out.println("请求地址不能为空");
            return;
        }
        // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost    
        HttpPost httppost = new HttpPost(url);
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        if (params != null && params.length >= 0) {
            for (int i = 0; i < params.length; i++) {
                String param = params[i];
       
            }
        }
        // 创建参数队列    
        formParams.add(new BasicNameValuePair("username", "admin"));
        formParams.add(new BasicNameValuePair("password", "123456"));
        UrlEncodedFormEntity uefEntity;
        try {
            if (formParams.size() > 0) {
                uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
                httppost.setEntity(uefEntity);
            }
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       }*/

    public static void main(String[] args) {
        /*String[] params = new String[2];
        params[0] = "username=xuanze";
        params[1] = "time=1231";
        String url = HttpUtil.getUrl("http://10.0.2.2:8080", params);
        System.out.println(url);*/

        String username = "选择";
        long time = 123123l;
        String url = "http://www.baidu.com";
        String params = "username=" + username + "&time=" + time;
        url = url + "?" + params;
        HttpUtil.get(url);
    }

}
