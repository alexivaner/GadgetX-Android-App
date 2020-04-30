// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Base64;
import android.widget.RemoteViews;
import com.inponsel.android.v2.RoomMyDraftPost;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.inponsel.android.utils:
//            Base64, Utility, Log

public class NotificationTanyaArtHelper
{

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

    public NotificationTanyaArtHelper(Context context)
    {
        likeStatement = "Mengirim like...";
        dislikeStatement = "Mengirim dislike...";
        gagallikeStatement = "Gagal terkirim";
        SucdislikeStatement = "Berhasil terkirim";
        nilaiStatement = "Mengirim penilaian...";
        likefrontKomen = "Mengirim like komentar...";
        dislikefrontKomen = "Mengirim dislike komentar...";
        suclikefrontKomen = "Like komentar terkirim";
        sucdislikefrontKomen = "Dislike komentar terkirim";
        gaglikefrontKomen = "Like komentar gagal terkirim";
        gagdislikefrontKomen = "Dislike komentar gagal terkirim";
        nilaifrontKomen = "";
        mContext = context;
    }

    public String BitMapToString(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        return Base64.encodeToString(bytearrayoutputstream.toByteArray(), 0);
    }

    public Bitmap StringToBitMap(String s)
    {
        try
        {
            s = Base64.decode(s, 0);
            s = BitmapFactory.decodeByteArray(s, 0, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
            return null;
        }
        return s;
    }

    public void completed(final String id, Bitmap bitmap, String s, String s1)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        if (!Utility.isTabletMDPI(mContext));
        long l = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            android.support.v4.app.NotificationCompat.BigTextStyle bigtextstyle = new android.support.v4.app.NotificationCompat.BigTextStyle();
            bigtextstyle.setBigContentTitle(s);
            bigtextstyle.setSummaryText("InPonsel");
            bigtextstyle.bigText(s1);
            if (bitmap == null)
            {
                mNotification = (new android.support.v4.app.NotificationCompat.Builder(mContext)).setSmallIcon(0x7f02023f).setAutoCancel(false).setContentTitle(s).setContentText(s1).setStyle(bigtextstyle).build();
            } else
            {
                mNotification = (new android.support.v4.app.NotificationCompat.Builder(mContext)).setSmallIcon(0x7f02023f).setAutoCancel(false).setLargeIcon(getResizedBitmap(bitmap)).setContentTitle(s).setContentText(s1).setStyle(bigtextstyle).build();
            }
        } else
        {
            mNotification = new Notification(0x7f02023f, s1, l);
        }
        mContentTitle = s;
        bitmap = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, bitmap, 0x48000000);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s1, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(Integer.parseInt(id), mNotification);
        (new Handler()).postDelayed(new Runnable() {

            final NotificationTanyaArtHelper this$0;
            private final String val$id;

            public void run()
            {
                mNotificationManager.cancel(Integer.parseInt(id));
            }

            
            {
                this$0 = NotificationTanyaArtHelper.this;
                id = s;
                super();
            }
        }, 3000L);
    }

    public void createNotification(String s, Bitmap bitmap, String s1, String s2)
    {
        if (!Utility.isTabletMDPI(mContext));
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            NotificationManager notificationmanager = (NotificationManager)mContext.getSystemService("notification");
            Log.e("Pesan", s2);
            Object obj = new android.support.v4.app.NotificationCompat.BigTextStyle();
            ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj)).setBigContentTitle(s1);
            ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj)).setSummaryText("InPonsel");
            ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj)).bigText(s2);
            if (bitmap == null)
            {
                bitmap = (new android.support.v4.app.NotificationCompat.Builder(mContext)).setSmallIcon(0x7f02023f).setAutoCancel(false).setContentTitle(s1).setContentText(s2).setStyle(((android.support.v4.app.NotificationCompat.Style) (obj))).build();
            } else
            {
                bitmap = (new android.support.v4.app.NotificationCompat.Builder(mContext)).setSmallIcon(0x7f02023f).setAutoCancel(false).setLargeIcon(getResizedBitmap(bitmap)).setContentTitle(s1).setContentText(s2).setStyle(((android.support.v4.app.NotificationCompat.Style) (obj))).build();
            }
            obj = new Intent();
            ((Intent) (obj)).setClass(mContext, com/inponsel/android/v2/RoomMyDraftPost);
            ((Intent) (obj)).setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s1))).append("+").append(s2).toString());
            bitmap.contentIntent = PendingIntent.getActivity(mContext, Integer.parseInt(s), ((Intent) (obj)), 0x8000000);
            bitmap.flags = ((Notification) (bitmap)).flags | 0x20;
            bitmap.ledARGB = ((Notification) (bitmap)).ledARGB | 0xffff9900;
            bitmap.flags = ((Notification) (bitmap)).flags | 1;
            bitmap.ledOnMS = ((Notification) (bitmap)).ledOnMS | 0x3e8;
            bitmap.ledOffMS = ((Notification) (bitmap)).ledOffMS | 0x2710;
            bitmap.defaults = ((Notification) (bitmap)).defaults | 2;
            notificationmanager.notify(Integer.parseInt(s), bitmap);
            return;
        } else
        {
            long l = System.currentTimeMillis();
            bitmap = (NotificationManager)mContext.getSystemService("notification");
            Notification notification = new Notification(0x7f02023f, s1, l);
            Object obj1 = new RemoteViews(mContext.getPackageName(), 0x7f030023);
            ((RemoteViews) (obj1)).setImageViewResource(0x7f0b007f, 0x7f02023f);
            ((RemoteViews) (obj1)).setTextViewText(0x7f0b0088, s1);
            ((RemoteViews) (obj1)).setTextViewText(0x7f0b0089, s2);
            notification.contentView = ((RemoteViews) (obj1));
            obj1 = new Intent();
            ((Intent) (obj1)).setClass(mContext, com/inponsel/android/v2/RoomMyDraftPost);
            ((Intent) (obj1)).setFlags(0x24000000);
            Log.e("generateMessage", (new StringBuilder(String.valueOf(s1))).append("+").append(s2).toString());
            notification.contentIntent = PendingIntent.getActivity(mContext, Integer.parseInt(s), ((Intent) (obj1)), 0x8000000);
            notification.flags = notification.flags | 0x20;
            notification.ledARGB = notification.ledARGB | 0xffff9900;
            notification.flags = notification.flags | 1;
            notification.ledOnMS = notification.ledOnMS | 0x64;
            notification.ledOffMS = notification.ledOffMS | 0x64;
            notification.defaults = notification.defaults | 2;
            bitmap.notify(Integer.parseInt(s), notification);
            return;
        }
    }

    public void gagal(String s, Bitmap bitmap, String s1, String s2)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        if (!Utility.isTabletMDPI(mContext));
        Object obj = (new StringBuilder(String.valueOf(s2))).toString();
        long l = System.currentTimeMillis();
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            obj = new android.support.v4.app.NotificationCompat.BigTextStyle();
            ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj)).setBigContentTitle(s1);
            ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj)).setSummaryText("InPonsel");
            ((android.support.v4.app.NotificationCompat.BigTextStyle) (obj)).bigText(s2);
            if (bitmap == null)
            {
                mNotification = (new android.support.v4.app.NotificationCompat.Builder(mContext)).setSmallIcon(0x7f02023f).setAutoCancel(false).setContentTitle(s1).setContentText(s2).setContentIntent(mContentIntent).setStyle(((android.support.v4.app.NotificationCompat.Style) (obj))).build();
            } else
            {
                mNotification = (new android.support.v4.app.NotificationCompat.Builder(mContext)).setSmallIcon(0x7f02023f).setAutoCancel(false).setLargeIcon(getResizedBitmap(bitmap)).setContentIntent(mContentIntent).setContentTitle(s1).setContentText(s2).setStyle(((android.support.v4.app.NotificationCompat.Style) (obj))).build();
            }
        } else
        {
            mNotification = new Notification(0x7f02023f, ((CharSequence) (obj)), l);
        }
        mContentTitle = s1;
        bitmap = new Intent();
        bitmap.setClass(mContext, com/inponsel/android/v2/RoomMyDraftPost);
        bitmap.setFlags(0x24000000);
        mContentIntent = PendingIntent.getActivity(mContext, 0, bitmap, 0x48000000);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s2, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(Integer.parseInt(s), mNotification);
    }

    public Bitmap getResizedBitmap(Bitmap bitmap)
    {
        Resources resources = mContext.getResources();
        int i = (int)resources.getDimension(0x1050006);
        return Bitmap.createScaledBitmap(bitmap, (int)resources.getDimension(0x1050005), i, false);
    }

    public void progressUpdate(String s, String s1, String s2)
    {
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
        mNotification = new Notification(0x1080088, s2, System.currentTimeMillis());
        mContentTitle = s1;
        s1 = new Intent();
        mContentIntent = PendingIntent.getActivity(mContext, 0, s1, 0x48000000);
        mNotification.setLatestEventInfo(mContext, mContentTitle, s2, mContentIntent);
        mNotification.flags = 16;
        mNotificationManager.notify(Integer.parseInt(s), mNotification);
    }

}
