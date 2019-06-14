package com.zhiling.webmagic.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Test2 {

	public static void main(String[] args) throws ClientProtocolException,
			IOException { 
		
        String userName = "928402767@qq.com";
        String password = "f0107142020.";
        String loginUrl = "http://passport.cnblogs.com/login.aspx";
        String dataUrl = "https://home.cnblogs.com/u/longxiaojiangi/";
		
        // HttpClient httpClient = new HttpClient();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        PostMethod postMethod = new PostMethod(loginUrl);
        NameValuePair[] postData = { new NameValuePair("tbUserName", userName),
                new NameValuePair("tbPassword", password) };
        postMethod.setRequestBody(postData);
        // int a = httpClient.execute(postMethod);
        

        
        
		
	}

	
}
