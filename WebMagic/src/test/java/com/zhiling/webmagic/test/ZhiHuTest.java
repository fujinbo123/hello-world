package com.zhiling.webmagic.test;

import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ZhiHuTest {

	public static void main(String[] args) throws java.text.ParseException {
		String name = "928402767@qq.com";
		String password = "f0107142020.";
		
		// 全局请求设置
		RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		// 创建cookie store的本地实例
		CookieStore cookieStore = new BasicCookieStore();
		// 创建HttpClient上下文
		HttpClientContext context = HttpClientContext.create();
		context.setCookieStore(cookieStore);
		// 创建一个HttpClient
		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig).setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse res = null;

		
/*        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        PostMethod postMethod = new PostMethod("http://passport.cnblogs.com/login.aspx");
        NameValuePair[] postData = { new NameValuePair("tbUserName", name),
                new NameValuePair("tbPassword", password) };
        postMethod.setRequestBody(postData);
			
		// 放在post请求之后,获取的是响应头的Set-Cookie
		System.out.println("登陆成功后,新的Cookie:===============");
		for (Cookie c : context.getCookieStore().getCookies()) {
			System.out.println(c.getName() + ": " + c.getValue());
		}

		// 构造一个新的get请求，用来测试登录是否成功
		HttpGet newGet = new HttpGet("http://www.zhihu.com/question/following");
		res = httpClient.execute(newGet, context);
		String content = EntityUtils.toString(res.getEntity());
		System.out.println("登陆成功后访问的页面===============");
		System.out.println(content);
		res.close();*/

	}

}
