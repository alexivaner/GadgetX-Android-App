// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.inponsel.android.utils:
//            UrlImageGetter

public class urlDrawable extends AsyncTask
{

    final UrlImageGetter this$0;
    onPostExecute urlDrawable;

    private InputStream fetch(String s)
        throws MalformedURLException, IOException
    {
        return (new DefaultHttpClient()).execute(new HttpGet(s)).getEntity().getContent();
    }

    protected transient Drawable doInBackground(String as[])
    {
        return fetchDrawable(as[0]);
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    public Drawable fetchDrawable(String s)
    {
        try
        {
            s = Drawable.createFromStream(fetch(s), "src");
            s.setBounds(0, 0, s.getIntrinsicWidth() + 0, s.getIntrinsicHeight() + 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    protected void onPostExecute(Drawable drawable)
    {
        urlDrawable.(0, 0, drawable.getIntrinsicWidth() + 0, drawable.getIntrinsicHeight() + 0);
        urlDrawable.urlDrawable = drawable;
        container.invalidate();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Drawable)obj);
    }

    public ( )
    {
        this$0 = UrlImageGetter.this;
        super();
        urlDrawable = ;
    }
}
