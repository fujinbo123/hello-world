package com.zhiling.webmagic.test;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpLogin2 {
	public static void main(String[] args) {

		// 登陆 Url
		String loginUrl = "http://passport.mop.com/?targetUrl=http://hi.mop.com/?&g=1447141423230&loginCheck=UNLOGINED";
		// 需登陆后访问的 Url
		String dataUrl = "http://hi.mop.com/";
		HttpClient httpClient = new HttpClient();
		// 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
		PostMethod postMethod = new PostMethod(loginUrl);
		// 设置登陆时要求的信息，用户名和密码
		NameValuePair[] data = { new NameValuePair("fujinbo123_001", "f0107142020.") };
		postMethod.setRequestBody(data);
		try {
			httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			int statusCode = httpClient.executeMethod(postMethod);
			// 获得登陆后的 Cookie
			Cookie[] cookies = httpClient.getState().getCookies();
			StringBuffer tmpcookies = new StringBuffer();
			for (Cookie c : cookies) {
				tmpcookies.append(c.toString() + ";");
			}
			System.out.println("cookies=" + tmpcookies.toString());
			System.out.println("statusCode:" + statusCode);

			// 进行登陆后的操作
			GetMethod getMethod = new GetMethod(dataUrl);
            getMethod.setRequestHeader("Cookie", tmpcookies.toString());
            // _ga=GA1.2.2006910901.1560393050; _gid=GA1.2.1338120032.1560393050; __gads=ID=1f9499b476280f16:T=1560393052:S=ALNI_MZzEEtITGZTpCxbDr1BasS02w9yFQ; .Cnblogs.AspNetCore.Cookies=CfDJ8D8Q4oM3DPZMgpKI1MnYlrl98WSKBJQ9Q03y0_ByJpDRZDGgrqIQQVWup2lsba7ypyVD-qkpGH18NUx9NjORr-dUzsqNXJqfrI6bcPxpJkAcBZ2obJnFIzZB8q_2sS_eh6GcdefuqDTa47knJZCkOzVE0RgFaaecJy_8z0A1q6qfvdEgPDR2ne5auQq8UR9z6i3kc2XKhbXrTAWIpId9fIMd0U-yEcqf4-WYJbRP8t4Ub7G8qEiDo7M7XJrEjaqq1vr181HtOR5hQaXXonFu7hoBEl7KLJd6g95naxFRXqqqbDPIEaqyR6HcNL9QmmOmpkLgfHJrnpMG-gKCHe_HSOagXH26QGBVNgTHwvSpZi4lnX_u3v9pdKdN-FggyoJO0zWlvhBaM7X5-6NNKuiT2f01JKixE-BR7UzeOlFR58qfzerJqyt2JTydN7cUzhVoX-vRpIn1NLNwviiWiZgFyiArVAoYE-Zbvfr7NFC-9gnd; .CNBlogsCookie=682433C0D042E1D9383096B90749201EB4E50329E23CBCA58CB562F4C14915B35E489666DA20048E606A36CA8A5BFF7F6CFC2406952859B8C29114DEE6B7A8BB0FF148338E36A31F9D8C50D3036CC04CE09C20D60F9C8A1C51208480F3831BE312742F4E; _gat=1
            getMethod.setRequestHeader("Host", "passport.cnblogs.com");
            getMethod.setRequestHeader("Referer", "http://home.cnblogs.com/");
            getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
            httpClient.executeMethod(getMethod);
			// 打印出返回数据，检验一下是否成功
			String text = getMethod.getResponseBodyAsString();
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
