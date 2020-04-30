// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.model.CameraPosition;

// Referenced classes of package com.google.android.gms.maps:
//            zza, zzb

public final class GoogleMapOptions
    implements SafeParcelable
{

    public static final com.google.android.gms.maps.zza CREATOR = new com.google.android.gms.maps.zza();
    private final int zzFG;
    private Boolean zzapJ;
    private Boolean zzapK;
    private int zzapL;
    private CameraPosition zzapM;
    private Boolean zzapN;
    private Boolean zzapO;
    private Boolean zzapP;
    private Boolean zzapQ;
    private Boolean zzapR;
    private Boolean zzapS;
    private Boolean zzapT;
    private Boolean zzapU;

    public GoogleMapOptions()
    {
        zzapL = -1;
        zzFG = 1;
    }

    GoogleMapOptions(int i, byte byte0, byte byte1, int j, CameraPosition cameraposition, byte byte2, byte byte3, 
            byte byte4, byte byte5, byte byte6, byte byte7, byte byte8, byte byte9)
    {
        zzapL = -1;
        zzFG = i;
        zzapJ = zza.zza(byte0);
        zzapK = zza.zza(byte1);
        zzapL = j;
        zzapM = cameraposition;
        zzapN = zza.zza(byte2);
        zzapO = zza.zza(byte3);
        zzapP = zza.zza(byte4);
        zzapQ = zza.zza(byte5);
        zzapR = zza.zza(byte6);
        zzapS = zza.zza(byte7);
        zzapT = zza.zza(byte8);
        zzapU = zza.zza(byte9);
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return null;
        }
        TypedArray typedarray = context.getResources().obtainAttributes(attributeset, com.google.android.gms.R.styleable.MapAttrs);
        GoogleMapOptions googlemapoptions = new GoogleMapOptions();
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_mapType))
        {
            googlemapoptions.mapType(typedarray.getInt(com.google.android.gms.R.styleable.MapAttrs_mapType, -1));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop))
        {
            googlemapoptions.zOrderOnTop(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle))
        {
            googlemapoptions.useViewLifecycleInFragment(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiCompass))
        {
            googlemapoptions.compassEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures))
        {
            googlemapoptions.rotateGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures))
        {
            googlemapoptions.scrollGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures))
        {
            googlemapoptions.tiltGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures))
        {
            googlemapoptions.zoomGesturesEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls))
        {
            googlemapoptions.zoomControlsEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_liteMode))
        {
            googlemapoptions.liteMode(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_liteMode, false));
        }
        if (typedarray.hasValue(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar))
        {
            googlemapoptions.mapToolbarEnabled(typedarray.getBoolean(com.google.android.gms.R.styleable.MapAttrs_uiMapToolbar, true));
        }
        googlemapoptions.camera(CameraPosition.createFromAttributes(context, attributeset));
        typedarray.recycle();
        return googlemapoptions;
    }

    public GoogleMapOptions camera(CameraPosition cameraposition)
    {
        zzapM = cameraposition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean flag)
    {
        zzapO = Boolean.valueOf(flag);
        return this;
    }

    public int describeContents()
    {
        return 0;
    }

    public CameraPosition getCamera()
    {
        return zzapM;
    }

    public Boolean getCompassEnabled()
    {
        return zzapO;
    }

    public Boolean getLiteMode()
    {
        return zzapT;
    }

    public Boolean getMapToolbarEnabled()
    {
        return zzapU;
    }

    public int getMapType()
    {
        return zzapL;
    }

    public Boolean getRotateGesturesEnabled()
    {
        return zzapS;
    }

    public Boolean getScrollGesturesEnabled()
    {
        return zzapP;
    }

    public Boolean getTiltGesturesEnabled()
    {
        return zzapR;
    }

    public Boolean getUseViewLifecycleInFragment()
    {
        return zzapK;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public Boolean getZOrderOnTop()
    {
        return zzapJ;
    }

    public Boolean getZoomControlsEnabled()
    {
        return zzapN;
    }

    public Boolean getZoomGesturesEnabled()
    {
        return zzapQ;
    }

    public GoogleMapOptions liteMode(boolean flag)
    {
        zzapT = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean flag)
    {
        zzapU = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions mapType(int i)
    {
        zzapL = i;
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean flag)
    {
        zzapS = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean flag)
    {
        zzapP = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean flag)
    {
        zzapR = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean flag)
    {
        zzapK = Boolean.valueOf(flag);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zzaa.zzqF())
        {
            com.google.android.gms.maps.zzb.zza(this, parcel, i);
            return;
        } else
        {
            com.google.android.gms.maps.zza.zza(this, parcel, i);
            return;
        }
    }

    public GoogleMapOptions zOrderOnTop(boolean flag)
    {
        zzapJ = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean flag)
    {
        zzapN = Boolean.valueOf(flag);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean flag)
    {
        zzapQ = Boolean.valueOf(flag);
        return this;
    }

    byte zzqh()
    {
        return zza.zzd(zzapJ);
    }

    byte zzqi()
    {
        return zza.zzd(zzapK);
    }

    byte zzqj()
    {
        return zza.zzd(zzapN);
    }

    byte zzqk()
    {
        return zza.zzd(zzapO);
    }

    byte zzql()
    {
        return zza.zzd(zzapP);
    }

    byte zzqm()
    {
        return zza.zzd(zzapQ);
    }

    byte zzqn()
    {
        return zza.zzd(zzapR);
    }

    byte zzqo()
    {
        return zza.zzd(zzapS);
    }

    byte zzqp()
    {
        return zza.zzd(zzapT);
    }

    byte zzqq()
    {
        return zza.zzd(zzapU);
    }

}
