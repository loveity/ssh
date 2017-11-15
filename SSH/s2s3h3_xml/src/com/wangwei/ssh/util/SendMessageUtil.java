package com.wangwei.ssh.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * Created by Wei_Wang on 2017/1/4.
 * send 短信测试代码
 */
public class SendMessageUtil {

    public static void main(String[] args)throws Exception {
        test();
    }

    public static void test() throws Exception {

            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
            post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
            NameValuePair[] data = {
                    new NameValuePair("Uid", "ww102133"),
                    new NameValuePair("Key", "82a1ff0145c1d4e76d7b"),
                    new NameValuePair("smsMob", "18780937904"),
                    new NameValuePair("smsText", "上课怎么样")};
            post.setRequestBody(data);

            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            System.out.println("statusCode:" + statusCode);
            for (Header h : headers) {
                System.out.println(h.toString());
            }
            String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
            System.out.println(result); //打印返回消息状态

            post.releaseConnection();

    }
}
