// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.internal:
//            zztt, zztu

public final class zztv extends zzd
    implements Moment
{

    private zztt zzavU;

    public zztv(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    private zztt zzse()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzavU == null)
        {
            byte abyte0[] = getByteArray("momentImpl");
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(abyte0, 0, abyte0.length);
            parcel.setDataPosition(0);
            zzavU = zztt.CREATOR.zzeA(parcel);
            parcel.recycle();
        }
        this;
        JVM INSTR monitorexit ;
        return zzavU;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object freeze()
    {
        return zzsd();
    }

    public String getId()
    {
        return zzse().getId();
    }

    public ItemScope getResult()
    {
        return zzse().getResult();
    }

    public String getStartDate()
    {
        return zzse().getStartDate();
    }

    public ItemScope getTarget()
    {
        return zzse().getTarget();
    }

    public String getType()
    {
        return zzse().getType();
    }

    public boolean hasId()
    {
        return zzse().hasId();
    }

    public boolean hasResult()
    {
        return zzse().hasResult();
    }

    public boolean hasStartDate()
    {
        return zzse().hasStartDate();
    }

    public boolean hasTarget()
    {
        return zzse().hasTarget();
    }

    public boolean hasType()
    {
        return zzse().hasType();
    }

    public zztt zzsd()
    {
        return zzse();
    }
}
