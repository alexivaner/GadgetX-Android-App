// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class MySSLSocketFactory extends SSLSocketFactory
{

    SSLContext sslContext;

    public MySSLSocketFactory(KeyStore keystore)
        throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
        super(keystore);
        sslContext = SSLContext.getInstance("TLS");
        keystore = new X509TrustManager() {

            final MySSLSocketFactory this$0;

            public void checkClientTrusted(X509Certificate ax509certificate[], String s)
                throws CertificateException
            {
            }

            public void checkServerTrusted(X509Certificate ax509certificate[], String s)
                throws CertificateException
            {
            }

            public X509Certificate[] getAcceptedIssuers()
            {
                return null;
            }

            
            {
                this$0 = MySSLSocketFactory.this;
                super();
            }
        };
        sslContext.init(null, new TrustManager[] {
            keystore
        }, null);
    }

    public static SSLSocketFactory getFixedSocketFactory()
    {
        MySSLSocketFactory mysslsocketfactory;
        try
        {
            mysslsocketfactory = new MySSLSocketFactory(getKeystore());
            mysslsocketfactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return SSLSocketFactory.getSocketFactory();
        }
        return mysslsocketfactory;
    }

    public static KeyStore getKeystore()
    {
        KeyStore keystore = null;
        KeyStore keystore1;
        try
        {
            keystore1 = KeyStore.getInstance(KeyStore.getDefaultType());
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return keystore;
        }
        keystore = keystore1;
        keystore1.load(null, null);
        return keystore1;
    }

    public static KeyStore getKeystoreOfCA(InputStream inputstream)
    {
        Object obj;
        Object obj1;
        Object obj3;
        Object obj4;
        obj1 = null;
        obj4 = null;
        obj3 = null;
        obj = obj1;
        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
        obj = obj1;
        inputstream = new BufferedInputStream(inputstream);
        obj = certificatefactory.generateCertificate(inputstream);
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                inputstream.printStackTrace();
            }
        }
_L2:
        Object obj2;
        obj1 = KeyStore.getDefaultType();
        inputstream = null;
        try
        {
            obj1 = KeyStore.getInstance(((String) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            return inputstream;
        }
        inputstream = ((InputStream) (obj1));
        ((KeyStore) (obj1)).load(null, null);
        inputstream = ((InputStream) (obj1));
        ((KeyStore) (obj1)).setCertificateEntry("ca", ((java.security.cert.Certificate) (obj)));
        return ((KeyStore) (obj1));
        obj2;
        inputstream = obj4;
_L5:
        obj = inputstream;
        ((CertificateException) (obj2)).printStackTrace();
        obj = obj3;
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        inputstream.close();
        obj = obj3;
          goto _L2
        inputstream;
        inputstream.printStackTrace();
        obj = obj3;
          goto _L2
        inputstream;
_L4:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw inputstream;
        obj2;
        obj = inputstream;
        inputstream = ((InputStream) (obj2));
        if (true) goto _L4; else goto _L3
_L3:
        obj2;
          goto _L5
    }

    public static DefaultHttpClient getNewHttpClient(KeyStore keystore)
    {
        try
        {
            Object obj = new MySSLSocketFactory(keystore);
            keystore = new SchemeRegistry();
            keystore.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            keystore.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
            obj = new BasicHttpParams();
            HttpProtocolParams.setVersion(((org.apache.http.params.HttpParams) (obj)), HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(((org.apache.http.params.HttpParams) (obj)), "UTF-8");
            keystore = new DefaultHttpClient(new ThreadSafeClientConnManager(((org.apache.http.params.HttpParams) (obj)), keystore), ((org.apache.http.params.HttpParams) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (KeyStore keystore)
        {
            return new DefaultHttpClient();
        }
        return keystore;
    }

    public Socket createSocket()
        throws IOException
    {
        return sslContext.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String s, int i, boolean flag)
        throws IOException
    {
        return sslContext.getSocketFactory().createSocket(socket, s, i, flag);
    }

    public void fixHttpsURLConnection()
    {
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }
}
