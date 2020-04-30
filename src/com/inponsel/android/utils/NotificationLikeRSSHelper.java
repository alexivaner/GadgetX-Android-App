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
//            Utility

public class NotificationLikeRSSHelper
{

    private int NOTIFICATION_ID;
    public String SucdislikeStatement;
    public String dislikeStatement;
    public String dislikefrontKomen;
    public String gagallikeStatement;
    public String gagdislikefrontKomen;
    public String gaglikefrontKomen;
    public String likeStatement;
    public String likefrontKomen;
    private PendingIntent mContentIntent;
    private CharSequence mContentTitle;
    private Context mContext;
    private Notification mNotification;
    private NotificationManager mNotificationManager;
    public String nilaiStatement;
    public String nilaifrontKomen;
    public String sucdislikefrontKomen;
    public String suclikefrontKomen;

    public NotificationLikeRSSHelper(Context context)
    {
        NOTIFICATION_ID = 1;
        likeStatement = "Mengirim like...";
        dislikeStatement = "Mengirim dislike...";
        gagallikeStatement = "Gagal terkirim";
        SucdislikeStatement = "Berhasil terkirim";
        nilaiStatement = "Mengirim penilaian...";
        likefrontKomen = "Mengirim like...";
        dislikefrontKomen = "Mengirim dislike...";
        suclikefrontKomen = "Like berita terkirim";
        sucdislikefrontKomen = "Dislike berita terkirim";
        gaglikefrontKomen = "Like berita gagal terkirim";
        gagdislikefrontKomen = "Dislike berita gagal terkirim";
        nilaifrontKomen = "";
        mContext = context;
    }

    public void completed(String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        if (!Utility.isTabletMDPI(mContext));
        long l = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s1).setWhen(l).setSmallIcon(0x7f02023f).setTicker(s1).setStyle((new android.app.Notification.BigTextStyle()).bigText(s1)).build();
        } else
        {
            mNotification = new Notification(0x7f02023f, s1, l);
        }
        mContentTitle = s;
        s = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s1, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
        (new Handler()).postDelayed(new Runnable() {

            final NotificationLikeRSSHelper this$0;

            public void run()
            {
                mNotificationManager.cancel(NOTIFICATION_ID);
            }

            
            {
                this$0 = NotificationLikeRSSHelper.this;
                super();
            }
        }, 3000L);
    }

    public void createNotification(String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        if (!Utility.isTabletMDPI(mContext));
        long l = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s1).setWhen(l).setSmallIcon(0x7f02023f).setTicker(s1).setStyle((new android.app.Notification.BigTextStyle()).bigText(s1)).build();
        } else
        {
            mNotification = new Notification(0x7f02023f, s1, l);
        }
        mContentTitle = s;
        s = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s1, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
    }

    public void gagal(String s, String s1)
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
        s = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s1, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
    }

    public void progressUpdate(String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        mNotification = new Notification(0x1080088, s1, System.currentTimeMillis());
        mContentTitle = s;
        s = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s1, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
    }


}
