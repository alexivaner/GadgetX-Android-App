// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

// Referenced classes of package com.inponsel.android.utils:
//            Utility, Log

public class NotificationKomenHelper
{

    private int NOTIFICATION_ID;
    public String SucdiskomStatement;
    public String gagalkomStatement;
    public String komenPostWords;
    private PendingIntent mContentIntent;
    private CharSequence mContentTitle;
    private Context mContext;
    private Notification mNotification;
    private NotificationManager mNotificationManager;

    public NotificationKomenHelper(Context context)
    {
        NOTIFICATION_ID = 1;
        komenPostWords = "Mengirim komentar...";
        gagalkomStatement = "Gagal terkirim";
        SucdiskomStatement = "Berhasil terkirim";
        mContext = context;
    }

    public void completed(String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        if (!Utility.isTabletMDPI(mContext));
        String s2 = (new StringBuilder(String.valueOf(s1))).toString();
        long l = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s2).setWhen(l).setSmallIcon(0x7f02023f).setTicker(s2).setStyle((new android.app.Notification.BigTextStyle()).bigText(s2)).build();
        } else
        {
            mNotification = new Notification(0x7f02023f, s2, l);
        }
        mContentTitle = s;
        s = (new StringBuilder(String.valueOf(s1))).toString();
        s1 = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s1, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
        (new Handler()).postDelayed(new Runnable() {

            final NotificationKomenHelper this$0;

            public void run()
            {
                Log.e("close", (new StringBuilder("notif ")).append(String.valueOf(NOTIFICATION_ID)).toString());
                mNotificationManager.cancel(NOTIFICATION_ID);
            }

            
            {
                this$0 = NotificationKomenHelper.this;
                super();
            }
        }, 3000L);
    }

    public void createNotification(String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        if (!Utility.isTabletMDPI(mContext));
        String s2 = (new StringBuilder(String.valueOf(s1))).toString();
        long l = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s2).setWhen(l).setSmallIcon(0x7f02023f).setTicker(s2).setStyle((new android.app.Notification.BigTextStyle()).bigText(s2)).build();
        } else
        {
            mNotification = new Notification(0x7f02023f, s2, l);
        }
        mContentTitle = s;
        s = (new StringBuilder(String.valueOf(s1))).toString();
        s1 = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s1, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
    }

    public void gagal(String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        if (!Utility.isTabletMDPI(mContext));
        String s2 = (new StringBuilder()).append(s1).toString();
        long l = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s2).setWhen(l).setSmallIcon(0x7f02023f).setTicker(s2).setStyle((new android.app.Notification.BigTextStyle()).bigText(s2)).build();
        } else
        {
            mNotification = new Notification(0x7f02023f, s2, l);
        }
        mContentTitle = s;
        s = (new StringBuilder()).append(s1).toString();
        s1 = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s1, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
    }

    public void progressUpdate(String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        mNotification = new Notification(0x1080088, (new StringBuilder(String.valueOf(s1))).append("(Mengirim...)").toString(), System.currentTimeMillis());
        mContentTitle = s;
        s = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s1, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
    }


}
