// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzqc;

// Referenced classes of package com.google.android.gms.location.places:
//            PlaceLikelihood

public class PlaceLikelihoodBuffer extends AbstractDataBuffer
    implements Result
{
    public static class zza
    {

        static int zzfD(int i)
        {
            switch (i)
            {
            default:
                throw new IllegalArgumentException((new StringBuilder()).append("invalid source: ").append(i).toString());

            case 100: // 'd'
            case 101: // 'e'
            case 102: // 'f'
            case 103: // 'g'
            case 104: // 'h'
            case 105: // 'i'
                return i;
            }
        }
    }


    private final Context mContext;
    private final Status zzHb;
    private final String zzanK;
    private final int zzanL;

    public PlaceLikelihoodBuffer(DataHolder dataholder, int i, Context context)
    {
        super(dataholder);
        mContext = context;
        zzHb = new Status(dataholder.getStatusCode());
        zzanL = zza.zzfD(i);
        if (dataholder != null && dataholder.zziu() != null)
        {
            zzanK = dataholder.zziu().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
            return;
        } else
        {
            zzanK = null;
            return;
        }
    }

    public PlaceLikelihood get(int i)
    {
        return new zzqc(zzMd, i, mContext);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public CharSequence getAttributions()
    {
        return zzanK;
    }

    public Status getStatus()
    {
        return zzHb;
    }

    public String toString()
    {
        return zzw.zzk(this).zza("status", getStatus()).zza("attributions", zzanK).toString();
    }
}
