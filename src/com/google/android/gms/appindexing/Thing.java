// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

public class Thing
{
    public static class Builder
    {

        final Bundle zzGK = new Bundle();

        public Thing build()
        {
            return new Thing(zzGK);
        }

        public Builder put(String s, Thing thing)
        {
            zzx.zzl(s);
            if (thing != null)
            {
                zzGK.putParcelable(s, thing.zzGJ);
            }
            return this;
        }

        public Builder put(String s, String s1)
        {
            zzx.zzl(s);
            if (s1 != null)
            {
                zzGK.putString(s, s1);
            }
            return this;
        }

        public Builder setDescription(String s)
        {
            put("description", s);
            return this;
        }

        public Builder setId(String s)
        {
            if (s != null)
            {
                put("id", s);
            }
            return this;
        }

        public Builder setName(String s)
        {
            zzx.zzl(s);
            put("name", s);
            return this;
        }

        public Builder setType(String s)
        {
            put("type", s);
            return this;
        }

        public Builder setUrl(Uri uri)
        {
            zzx.zzl(uri);
            put("url", uri.toString());
            return this;
        }

        public Builder()
        {
        }
    }


    final Bundle zzGJ;

    Thing(Bundle bundle)
    {
        zzGJ = bundle;
    }

    public Bundle zzgZ()
    {
        return zzGJ;
    }
}
