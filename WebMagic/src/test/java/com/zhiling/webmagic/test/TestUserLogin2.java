package com.zhiling.webmagic.test;


import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class TestUserLogin2 {
	
	 public static void main(String[] args) {
	        String userName = "wl001";
	        String password = "147258";
	        // String loginUrl = "https://passport.cnblogs.com/login.aspx";
	        String loginUrl = "http://120.24.215.143:8080/login.action";
	        String dataUrl = "http://120.24.215.143:8080/creditor.action?function=CreditorInfo&module=creditors&menuId=83";
	        HttpClientLogin(userName, password, loginUrl, dataUrl);
	    }

	    private static void HttpClientLogin(String userName, String password,
	            String loginUrl, String dataUrl) {
	    	
	        HttpClient httpClient = new HttpClient();
	        /*	        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
	        PostMethod postMethod = new PostMethod(loginUrl);
	        NameValuePair[] postData = { new NameValuePair("username", userName),
	                new NameValuePair("password", password) };
	        postMethod.setRequestBody(postData);*/

	        try {
/*	            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
	            int code = httpClient.executeMethod(postMethod);
	            System.out.println("code=" + code);
	            Cookie[] cookies = httpClient.getState().getCookies();
	            StringBuffer stringBuffer = new StringBuffer();
	            for (Cookie c : cookies) {
	                stringBuffer.append(c.toString() + "");
	            }
	            System.out.println("cookies：" + stringBuffer);*/

	            GetMethod getMethod = new GetMethod(dataUrl);
	            // getMethod.setRequestHeader("Cookie", stringBuffer.toString());

	            // String aa = "_ga=GA1.2.2006910901.1560393050; _gid=GA1.2.1338120032.1560393050; __gads=ID=1f9499b476280f16:T=1560393052:S=ALNI_MZzEEtITGZTpCxbDr1BasS02w9yFQ; .Cnblogs.AspNetCore.Cookies=CfDJ8D8Q4oM3DPZMgpKI1MnYlrl98WSKBJQ9Q03y0_ByJpDRZDGgrqIQQVWup2lsba7ypyVD-qkpGH18NUx9NjORr-dUzsqNXJqfrI6bcPxpJkAcBZ2obJnFIzZB8q_2sS_eh6GcdefuqDTa47knJZCkOzVE0RgFaaecJy_8z0A1q6qfvdEgPDR2ne5auQq8UR9z6i3kc2XKhbXrTAWIpId9fIMd0U-yEcqf4-WYJbRP8t4Ub7G8qEiDo7M7XJrEjaqq1vr181HtOR5hQaXXonFu7hoBEl7KLJd6g95naxFRXqqqbDPIEaqyR6HcNL9QmmOmpkLgfHJrnpMG-gKCHe_HSOagXH26QGBVNgTHwvSpZi4lnX_u3v9pdKdN-FggyoJO0zWlvhBaM7X5-6NNKuiT2f01JKixE-BR7UzeOlFR58qfzerJqyt2JTydN7cUzhVoX-vRpIn1NLNwviiWiZgFyiArVAoYE-Zbvfr7NFC-9gnd; .CNBlogsCookie=682433C0D042E1D9383096B90749201EB4E50329E23CBCA58CB562F4C14915B35E489666DA20048E606A36CA8A5BFF7F6CFC2406952859B8C29114DEE6B7A8BB0FF148338E36A31F9D8C50D3036CC04CE09C20D60F9C8A1C51208480F3831BE312742F4E; _gat=1";
	            //String aa = ".Cnblogs.AspNetCore.Cookies=CfDJ8D8Q4oM3DPZMgpKI1MnYlrkiUQo0i7j1xEeFR-YTfoutlS_mQboxj30jJzT0HKmkpAB16NiCty5K7xT8MKrDpwDgkHTxeLLaBCU8XvpuUwa9ZCrR3N1XWJDEIaN6JYJRXUNbpcaD4eMyLt46tM3L0Yk;";
	            // String aa = "SERVERID=e22839ee23fb43e93e9a4296b4ccb588|1560416843|1560416843;";
	            getMethod.setRequestHeader("Cookie", "JSESSIONID=abcjozfBEgHIH83IjPtTw");
	            getMethod.setRequestHeader("Host", "passport.cnblogs.com");
	            getMethod.setRequestHeader("Referer", "http://home.cnblogs.com/");
	            getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
	            httpClient.executeMethod(getMethod);

	            String result = getMethod.getResponseBodyAsString();
	            System.out.println(result);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
