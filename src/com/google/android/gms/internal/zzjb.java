// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

// Referenced classes of package com.google.android.gms.internal:
//            zzjc, zzir, zzwy, zzip, 
//            zzin

public class zzjb
    implements SafeParcelable
{

    public static final zzjc CREATOR = new zzjc();
    final int zzFG;
    final boolean zzGA;
    int zzGB;
    final zzip zzGw;
    final long zzGx;
    final int zzGy;
    final zzin zzGz;
    public final String zzpZ;

    zzjb(int i, zzip zzip1, long l, int j, String s, zzin zzin, 
            boolean flag, int k)
    {
        zzFG = i;
        zzGw = zzip1;
        zzGx = l;
        zzGy = j;
        zzpZ = s;
        zzGz = zzin;
        zzGA = flag;
        zzGB = k;
    }

    public zzjb(zzip zzip1, long l, int i)
    {
        this(1, zzip1, l, i, null, null, false, -1);
    }

    public zzjb(zzip zzip1, long l, int i, String s, zzin zzin, boolean flag, 
            int j)
    {
        this(1, zzip1, l, i, s, zzin, flag, j);
    }

    public zzjb(String s, Intent intent, String s1, Uri uri, String s2, List list)
    {
        this(1, zza(s, intent), System.currentTimeMillis(), 0, null, zza(intent, s1, uri, s2, list).zzgU(), false, -1);
    }

    public static zzin.zza zza(Intent intent, String s, Uri uri, String s1, List list)
    {
        zzin.zza zza1 = new zzin.zza();
        zza1.zza(zzaB(s));
        if (uri != null)
        {
            zza1.zza(zzh(uri));
        }
        if (list != null)
        {
            zza1.zza(zzd(list));
        }
        s = intent.getAction();
        if (s != null)
        {
            zza1.zza(zzm("intent_action", s));
        }
        s = intent.getDataString();
        if (s != null)
        {
            zza1.zza(zzm("intent_data", s));
        }
        s = intent.getComponent();
        if (s != null)
        {
            zza1.zza(zzm("intent_activity", s.getClassName()));
        }
        intent = intent.getExtras();
        if (intent != null)
        {
            intent = intent.getString("intent_extra_data_key");
            if (intent != null)
            {
                zza1.zza(zzm("intent_extra_data", intent));
            }
        }
        return zza1.zzax(s1).zzH(true);
    }

    public static zzip zza(String s, Intent intent)
    {
        return zzl(s, zzg(intent));
    }

    private static zzir zzaB(String s)
    {
        return new zzir(s, (new zziz.zza("title")).zzW(1).zzJ(true).zzaA("name").zzgX(), "text1");
    }

    private static zzir zzd(List list)
    {
        zzop.zza zza1 = new zzop.zza();
        zzop.zza.zza azza[] = new zzop.zza.zza[list.size()];
        for (int i = 0; i < azza.length; i++)
        {
            azza[i] = new zzop.zza.zza();
            com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink appindexinglink = (com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink)list.get(i);
            azza[i].zzalg = appindexinglink.appIndexingUrl.toString();
            azza[i].viewId = appindexinglink.viewId;
            if (appindexinglink.webUrl != null)
            {
                azza[i].zzalh = appindexinglink.webUrl.toString();
            }
        }

        zza1.zzale = azza;
        return new zzir(zzwy.zzf(zza1), (new zziz.zza("outlinks")).zzI(true).zzaA(".private:outLinks").zzaz("blob").zzgX());
    }

    private static String zzg(Intent intent)
    {
        intent = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try
        {
            crc32.update(intent.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new IllegalStateException(intent);
        }
        return Long.toHexString(crc32.getValue());
    }

    private static zzir zzh(Uri uri)
    {
        return new zzir(uri.toString(), (new zziz.zza("web_url")).zzW(4).zzI(true).zzaA("url").zzgX());
    }

    private static zzip zzl(String s, String s1)
    {
        return new zzip(s, "", s1);
    }

    private static zzir zzm(String s, String s1)
    {
        return new zzir(s1, (new zziz.zza(s)).zzI(true).zzgX(), s);
    }

    public int describeContents()
    {
        zzjc zzjc1 = CREATOR;
        return 0;
    }

    public String toString()
    {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", new Object[] {
            zzGw, Long.valueOf(zzGx), Integer.valueOf(zzGy)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzjc zzjc1 = CREATOR;
        zzjc.zza(this, parcel, i);
    }

}
