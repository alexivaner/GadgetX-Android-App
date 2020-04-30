// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.content.Context;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.analytics:
//            StandardExceptionParser, zzae, ExceptionParser, Tracker, 
//            GoogleAnalytics

public class ExceptionReporter
    implements Thread.UncaughtExceptionHandler
{

    private final Context mContext;
    private final Thread.UncaughtExceptionHandler zzBK;
    private final Tracker zzBL;
    private ExceptionParser zzBM;
    private GoogleAnalytics zzBN;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler uncaughtexceptionhandler, Context context)
    {
        if (tracker == null)
        {
            throw new NullPointerException("tracker cannot be null");
        }
        if (context == null)
        {
            throw new NullPointerException("context cannot be null");
        }
        zzBK = uncaughtexceptionhandler;
        zzBL = tracker;
        zzBM = new StandardExceptionParser(context, new ArrayList());
        mContext = context.getApplicationContext();
        context = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
        if (uncaughtexceptionhandler == null)
        {
            tracker = "null";
        } else
        {
            tracker = uncaughtexceptionhandler.getClass().getName();
        }
        zzae.zzab(context.append(tracker).toString());
    }

    public ExceptionParser getExceptionParser()
    {
        return zzBM;
    }

    public void setExceptionParser(ExceptionParser exceptionparser)
    {
        zzBM = exceptionparser;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        Object obj = "UncaughtException";
        if (zzBM != null)
        {
            if (thread != null)
            {
                obj = thread.getName();
            } else
            {
                obj = null;
            }
            obj = zzBM.getDescription(((String) (obj)), throwable);
        }
        zzae.zzab((new StringBuilder()).append("Tracking Exception: ").append(((String) (obj))).toString());
        zzBL.send((new HitBuilders.ExceptionBuilder()).setDescription(((String) (obj))).setFatal(true).build());
        obj = zzfC();
        ((GoogleAnalytics) (obj)).dispatchLocalHits();
        ((GoogleAnalytics) (obj)).zzfj();
        if (zzBK != null)
        {
            zzae.zzab("Passing exception to original handler.");
            zzBK.uncaughtException(thread, throwable);
        }
    }

    GoogleAnalytics zzfC()
    {
        if (zzBN == null)
        {
            zzBN = GoogleAnalytics.getInstance(mContext);
        }
        return zzBN;
    }

    Thread.UncaughtExceptionHandler zzfD()
    {
        return zzBK;
    }
}
