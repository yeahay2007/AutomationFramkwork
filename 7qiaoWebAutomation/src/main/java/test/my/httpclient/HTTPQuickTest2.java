package test.my.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPQuickTest2 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet("http://map.qq.com/lubao/?from=qqweb&ch=53a93fda8911114109f8bf82&sessionUserType=BFT.PARAMS.159952.TASKID&ADUIN=799526413&ADSESSION=1425861550&ADTAG=CLIENT.QQ.5389_.0&ADPUBNO=26441");
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			try {
				System.out.println(response1.getProtocolVersion());
				System.out.println(response1.getStatusLine().getStatusCode());
				System.out.println(response1.getStatusLine().getReasonPhrase());
				System.out.println(response1.getStatusLine());
				System.out.println(response1.getAllHeaders());
				
				HttpEntity entity1 = response1.getEntity();
				System.out.println(EntityUtils.toString(entity1));
				// do something useful with the response body
				// and ensure it is fully consumed
				EntityUtils.consume(entity1);
			} finally {
				response1.close();
			}

		} finally {
			httpclient.close();
		}
	}

}
