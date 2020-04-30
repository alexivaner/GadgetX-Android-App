// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.internal:
//            zzqj, zzqf, zzpy

public class zzqg extends zzqj
    implements Place
{

    private final String zzanM = zzz("place_id", "");
    private boolean zzaoI;
    private final zzqf zzaoL;

    public zzqg(DataHolder dataholder, int i, Context context)
    {
        super(dataholder, i);
        if (context != null)
        {
            dataholder = zzqf.zzab(context);
        } else
        {
            dataholder = null;
        }
        zzaoL = dataholder;
        zzaoI = zzj("place_is_logging_enabled", false);
    }

    private void zzcn(String s)
    {
        if (zzaoI && zzaoL != null)
        {
            zzaoL.zzy(zzanM, s);
        }
    }

    public Object freeze()
    {
        return zzpV();
    }

    public CharSequence getAddress()
    {
        zzcn("getAddress");
        return zzz("place_address", "");
    }

    public String getId()
    {
        zzcn("getId");
        return zzanM;
    }

    public LatLng getLatLng()
    {
        zzcn("getLatLng");
        return (LatLng)zza("place_lat_lng", LatLng.CREATOR);
    }

    public Locale getLocale()
    {
        zzcn("getLocale");
        String s = zzz("place_locale", "");
        if (!TextUtils.isEmpty(s))
        {
            return new Locale(s);
        } else
        {
            return Locale.getDefault();
        }
    }

    public CharSequence getName()
    {
        zzcn("getName");
        return zzz("place_name", "");
    }

    public CharSequence getPhoneNumber()
    {
        zzcn("getPhoneNumber");
        return zzz("place_phone_number", "");
    }

    public List getPlaceTypes()
    {
        zzcn("getPlaceTypes");
        return zza("place_types", Collections.emptyList());
    }

    public int getPriceLevel()
    {
        zzcn("getPriceLevel");
        return zzC("place_price_level", -1);
    }

    public float getRating()
    {
        zzcn("getRating");
        return zza("place_rating", -1F);
    }

    public LatLngBounds getViewport()
    {
        zzcn("getViewport");
        return (LatLngBounds)zza("place_viewport", LatLngBounds.CREATOR);
    }

    public Uri getWebsiteUri()
    {
        zzcn("getWebsiteUri");
        String s = zzz("place_website_uri", null);
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public boolean zzpI()
    {
        zzcn("isPermanentlyClosed");
        return zzj("place_is_permanently_closed", false);
    }

    public float zzpO()
    {
        zzcn("getLevelNumber");
        return zza("place_level_number", 0.0F);
    }

    public Place zzpV()
    {
        Object obj = (new zzpy.zza()).zzY(zzaoI);
        zzaoI = false;
        obj = ((zzpy.zza) (obj)).zzcq(getAddress().toString()).zzp(zzb("place_attributions", Collections.emptyList())).zzco(getId()).zzX(zzpI()).zza(getLatLng()).zzc(zzpO()).zzcp(getName().toString()).zzcr(getPhoneNumber().toString()).zzfH(getPriceLevel()).zzd(getRating()).zzo(getPlaceTypes()).zza(getViewport()).zzk(getWebsiteUri()).zzpW();
        ((zzpy) (obj)).setLocale(getLocale());
        ((zzpy) (obj)).zza(zzaoL);
        return ((Place) (obj));
    }
}
