// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.accounts.Account;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzir, zzwy, zzjj, zzjb

public class zzji
{

    private static zzir zza(String s, zzop.zzc zzc)
    {
        s = (new zziz.zza(s)).zzI(true).zzaA(s).zzaz("blob").zzgX();
        return new zzir(zzwy.zzf(zzc), s);
    }

    public static zzjb zza(Action action, long l, String s, int i)
    {
        boolean flag = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzgZ());
        Object obj1 = bundle.getBundle("object");
        Object obj;
        String s1;
        String s2;
        int j;
        if (((Bundle) (obj1)).containsKey("id"))
        {
            obj = Uri.parse(((Bundle) (obj1)).getString("id"));
        } else
        {
            obj = null;
        }
        s1 = ((Bundle) (obj1)).getString("name");
        s2 = ((Bundle) (obj1)).getString("type");
        obj1 = zzjj.zza(s, Uri.parse(((Bundle) (obj1)).getString("url")));
        obj = zzjb.zza(((android.content.Intent) (obj1)), s1, ((Uri) (obj)), s2, null);
        if (bundle.containsKey(".private:ssbContext"))
        {
            ((zzin.zza) (obj)).zza(zzir.zzd(bundle.getByteArray(".private:ssbContext")));
            action.zzgZ().remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName"))
        {
            ((zzin.zza) (obj)).zza(new Account(bundle.getString(".private:accountName"), "com.google"));
            action.zzgZ().remove(".private:accountName");
        }
        j = i;
        if (bundle.containsKey(".private:isContextOnly"))
        {
            j = i;
            if (bundle.getBoolean(".private:isContextOnly"))
            {
                j = 4;
                action.zzgZ().remove(".private:isContextOnly");
            }
        }
        if (bundle.containsKey(".private:isDeviceOnly"))
        {
            flag = bundle.getBoolean(".private:isDeviceOnly", false);
            action.zzgZ().remove(".private:isDeviceOnly");
        }
        ((zzin.zza) (obj)).zza(zza(".private:action", zzh(action.zzgZ())));
        return new zzjb(zzjb.zza(s, ((android.content.Intent) (obj1))), l, j, null, ((zzin.zza) (obj)).zzgU(), flag, -1);
    }

    static zzop.zzc zzh(Bundle bundle)
    {
        zzop.zzc zzc = new zzop.zzc();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            zzop.zzb zzb = new zzop.zzb();
            zzb.name = s;
            zzb.zzalj = new zzop.zzd();
            if (obj instanceof String)
            {
                zzb.zzalj.zzQN = (String)obj;
            } else
            if (obj instanceof Bundle)
            {
                zzb.zzalj.zzalo = zzh((Bundle)obj);
            } else
            {
                Log.e("AppDataSearchClient", (new StringBuilder()).append("Unsupported value: ").append(obj).toString());
            }
            arraylist.add(zzb);
        }
        if (bundle.containsKey("type"))
        {
            zzc.type = bundle.getString("type");
        }
        zzc.zzalk = (zzop.zzb[])arraylist.toArray(new zzop.zzb[arraylist.size()]);
        return zzc;
    }
}
