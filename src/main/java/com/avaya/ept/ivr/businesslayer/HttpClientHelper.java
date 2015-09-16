package com.avaya.ept.ivr.businesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;


/**
 * @author rpinheiro
 *
 */
public class HttpClientHelper {

	public static HttpClient getNewHttpClient(int port) throws KeyManagementException, NoSuchAlgorithmException {
		SSLContext sslContext = SSLContext.getInstance("SSL");

		// set up a TrustManager that trusts everything
		sslContext.init(null, new TrustManager[] { new X509TrustManager() {


					public void checkClientTrusted(
							java.security.cert.X509Certificate[] arg0,
							String arg1) throws CertificateException {
						//System.out.println("checkClientTrusted =============");

					}

					public void checkServerTrusted(
							java.security.cert.X509Certificate[] arg0,
							String arg1) throws CertificateException {
						//System.out.println("checkServerTrusted =============");

					}

					public java.security.cert.X509Certificate[] getAcceptedIssuers() {

						return null;
					}
		} }, new SecureRandom());

		SSLSocketFactory sf = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		Scheme httpsScheme = new Scheme("https", port, sf);
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(httpsScheme);

		HttpParams params = new BasicHttpParams();
		ClientConnectionManager cm = new SingleClientConnManager(schemeRegistry);
		HttpClient              httpClient = new DefaultHttpClient(cm, params);
		return httpClient;

	}

	public static SSLSocketFactory getSSLContextAllHostTrusted() throws GeneralSecurityException {
		return new SSLSocketFactory(new TrustStrategy() {

			    public boolean isTrusted(
			            final X509Certificate[] chain, String authType) throws CertificateException {
			        return true;
			    }
			}, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

	}

	public static String getString (InputStream is) throws IOException{
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, "UTF-8");
		String result = writer.toString();
		return result;
	}
}