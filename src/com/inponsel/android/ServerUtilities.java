// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.content.Context;
import com.google.android.gcm.GCMRegistrar;
import com.inponsel.android.utils.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package com.inponsel.android:
//            CommonUtilities

public final class ServerUtilities
{

    private static final int BACKOFF_MILLI_SECONDS = 2000;
    private static final int MAX_ATTEMPTS = 5;
    private static final Random random = new Random();

    public ServerUtilities()
    {
    }

    private static void post(String s, Map map)
        throws IOException
    {
        Object obj;
        byte abyte0[];
        int i;
        try
        {
            obj = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new IllegalArgumentException((new StringBuilder("invalid url: ")).append(s).toString());
        }
        s = new StringBuilder();
        map = map.entrySet().iterator();
_L2:
        if (map.hasNext())
        {
            break MISSING_BLOCK_LABEL_252;
        }
        s = s.toString();
        Log.v("InPonesl GCM", (new StringBuilder("Posting '")).append(s).append("' to ").append(obj).toString());
        abyte0 = s.getBytes();
        map = null;
        s = map;
        Log.e("URL", (new StringBuilder("> ")).append(obj).toString());
        s = map;
        map = (HttpURLConnection)((URL) (obj)).openConnection();
        s = map;
        map.setDoOutput(true);
        s = map;
        map.setUseCaches(false);
        s = map;
        map.setFixedLengthStreamingMode(abyte0.length);
        s = map;
        map.setRequestMethod("POST");
        s = map;
        map.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        s = map;
        obj = map.getOutputStream();
        s = map;
        ((OutputStream) (obj)).write(abyte0);
        s = map;
        ((OutputStream) (obj)).close();
        s = map;
        i = map.getResponseCode();
        if (i == 200)
        {
            break; /* Loop/switch isn't completed */
        }
        s = map;
        throw new IOException((new StringBuilder("Post failed with error code ")).append(i).toString());
        map;
        if (s != null)
        {
            s.disconnect();
        }
        throw map;
        java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
        s.append((String)entry.getKey()).append('=').append((String)entry.getValue());
        if (map.hasNext())
        {
            s.append('&');
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (map != null)
        {
            map.disconnect();
        }
        return;
    }

    public static void register(Context context, String s, String s1, String s2)
    {
        String s3;
        HashMap hashmap;
        int i;
        long l;
        Log.i("InPonesl GCM", (new StringBuilder("registering device (regId = ")).append(s2).append(")").toString());
        s3 = CommonUtilities.SERVER_URL;
        hashmap = new HashMap();
        hashmap.put("regId", s2);
        hashmap.put("name", s);
        hashmap.put("email", s1);
        l = random.nextInt(1000) + 2000;
        i = 1;
_L5:
        if (i <= 5) goto _L2; else goto _L1
_L1:
        s = context.getString(0x7f0c0091, new Object[] {
            Integer.valueOf(5)
        });
        CommonUtilities.displayMessage(context, s, s);
        return;
_L2:
        Log.d("InPonesl GCM", (new StringBuilder("Attempt #")).append(i).append(" to register").toString());
        try
        {
            CommonUtilities.displayMessage(context, context.getString(0x7f0c008e, new Object[] {
                Integer.valueOf(i), Integer.valueOf(5)
            }), context.getString(0x7f0c008e, new Object[] {
                Integer.valueOf(i), Integer.valueOf(5)
            }));
            post(s3, hashmap);
            GCMRegistrar.setRegisteredOnServer(context, true);
            CommonUtilities.displayMessage(context, context.getString(0x7f0c008f), "Registered");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("InPonesl GCM", (new StringBuilder("Failed to register on attempt ")).append(i).append(":").append(s).toString());
        }
        if (i == 5) goto _L1; else goto _L3
_L3:
        try
        {
            Log.d("InPonesl GCM", (new StringBuilder("Sleeping for ")).append(l).append(" ms before retry").toString());
            Thread.sleep(l);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.d("InPonesl GCM", "Thread interrupted: abort remaining retries!");
            Thread.currentThread().interrupt();
            return;
        }
        l *= 2L;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static void unregister(Context context, String s)
    {
        Log.i("InPonesl GCM", (new StringBuilder("unregistering device (regId = ")).append(s).append(")").toString());
        String s1 = (new StringBuilder(String.valueOf(CommonUtilities.SERVER_URL))).append("/unregister").toString();
        HashMap hashmap = new HashMap();
        hashmap.put("regId", s);
        try
        {
            post(s1, hashmap);
            GCMRegistrar.setRegisteredOnServer(context, false);
            s = context.getString(0x7f0c0090);
            CommonUtilities.displayMessage(context, s, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = context.getString(0x7f0c0092, new Object[] {
                s.getMessage()
            });
        }
        CommonUtilities.displayMessage(context, s, s);
    }

}
