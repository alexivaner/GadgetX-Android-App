// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// Referenced classes of package com.inponsel.android.v2:
//            RoomShareLocationActivity

class this._cls0
    implements com.google.android.gms.maps.
{

    final RoomShareLocationActivity this$0;

    public void onMapClick(LatLng latlng)
    {
        latLng = latlng;
        RoomShareLocationActivity.access$0(RoomShareLocationActivity.this).clear();
        RoomShareLocationActivity.access$0(RoomShareLocationActivity.this).animateCamera(CameraUpdateFactory.newLatLng(latLng));
        markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        RoomShareLocationActivity.access$0(RoomShareLocationActivity.this).addMarker(markerOptions);
        (new verseGeocodingTask(RoomShareLocationActivity.this, getBaseContext())).execute(new LatLng[] {
            latLng
        });
    }

    verseGeocodingTask()
    {
        this$0 = RoomShareLocationActivity.this;
        super();
    }
}
