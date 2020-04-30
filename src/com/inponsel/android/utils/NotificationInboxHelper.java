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
import com.inponsel.android.v2.InboxMessageActivity;

// Referenced classes of package com.inponsel.android.utils:
//            Utility

public class NotificationInboxHelper
{

    private int NOTIFICATION_ID;
    private PendingIntent mContentIntent;
    private CharSequence mContentTitle;
    private Context mContext;
    private Notification mNotification;
    private NotificationManager mNotificationManager;
    public String nilaifrontKomen;

    public NotificationInboxHelper(Context context)
    {
        NOTIFICATION_ID = 999;
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
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s1).setWhen(l).setSmallIcon(0x7f020227).setTicker(s1).setStyle((new android.app.Notification.BigTextStyle()).bigText(s1)).build();
        } else
        {
            mNotification = new Notification(0x7f020227, s1, l);
        }
        mContentTitle = s;
        s = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s, 0);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s1, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(NOTIFICATION_ID, mNotification);
        (new Handler()).postDelayed(new Runnable() {

            final NotificationInboxHelper this$0;

            public void run()
            {
                mNotificationManager.cancel(NOTIFICATION_ID);
            }

            
            {
                this$0 = NotificationInboxHelper.this;
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
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s1).setWhen(l).setSmallIcon(0x7f020227).setTicker(s1).setStyle((new android.app.Notification.BigTextStyle()).bigText(s1)).build();
        } else
        {
            mNotification = new Notification(0x7f020227, s1, l);
        }
        mContentTitle = s;
        s = new Intent();
        s.setClass(mContext, com/inponsel/android/v2/InboxMessageActivity);
        mContentIntent = PendingIntent.getActivity(mContext, NOTIFICATION_ID, s, 0);
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
            mNotification = (new android.app.Notification.Builder(mContext)).setContentTitle(s).setContentText(s2).setWhen(l).setSmallIcon(0x7f020227).setTicker(s2).setStyle((new android.app.Notification.BigTextStyle()).bigText(s2)).build();
        } else
        {
            mNotification = new Notification(0x7f020227, s2, l);
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
