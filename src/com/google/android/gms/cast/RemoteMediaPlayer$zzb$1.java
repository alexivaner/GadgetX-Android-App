// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzkf;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzJO
    implements zzkf
{

    final j zzJO;

    public void zza(long l, int i, Object obj)
    {
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
        } else
        {
            obj = null;
        }
        zzJO.tResult(new nit>(new Status(i), ((JSONObject) (obj))));
    }

    public void zzn(long l)
    {
        zzJO.tResult(zzJO.j(new Status(2103)));
    }

    _cls9(_cls9 _pcls9)
    {
        zzJO = _pcls9;
        super();
    }
}
