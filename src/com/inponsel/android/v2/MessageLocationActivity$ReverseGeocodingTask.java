// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Context;
import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.inponsel.android.utils.Log;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

// Referenced classes of package com.inponsel.android.v2:
//            MessageLocationActivity

private class mContext extends AsyncTask
{

    Context mContext;
    String nameAddress;
    final MessageLocationActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((LatLng[])aobj);
    }

    protected transient String doInBackground(LatLng alatlng[])
    {
        Object obj;
        String s;
        obj = new Geocoder(mContext);
        getlatitude = Double.valueOf(alatlng[0].latitude);
        getlongitude = Double.valueOf(alatlng[0].longitude);
        alatlng = null;
        s = "";
        obj = ((Geocoder) (obj)).getFromLocation(getlatitude.doubleValue(), getlongitude.doubleValue(), 1);
        alatlng = ((LatLng []) (obj));
_L1:
        Object obj1 = s;
        if (alatlng != null)
        {
            obj1 = s;
            if (alatlng.size() > 0)
            {
                obj1 = (Address)alatlng.get(0);
                IOException ioexception;
                if (((Address) (obj1)).getMaxAddressLineIndex() > 0)
                {
                    alatlng = ((Address) (obj1)).getAddressLine(0);
                } else
                {
                    alatlng = "";
                }
                obj1 = String.format("%s, %s, %s", new Object[] {
                    alatlng, ((Address) (obj1)).getLocality(), ((Address) (obj1)).getCountryName()
                });
            }
        }
        nameAddress = ((String) (obj1));
        return ((String) (obj1));
        ioexception;
        ioexception.printStackTrace();
          goto _L1
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        Log.e("addressText", s);
        Log.e("LL", String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString()));
        MessageLocationActivity.access$0(MessageLocationActivity.this).addMarker((new MarkerOptions()).position(latLng).title(s).snippet(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString()))).showInfoWindow();
        MessageLocationActivity.access$0(MessageLocationActivity.this).setOnInfoWindowClickListener(new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {

            final MessageLocationActivity.ReverseGeocodingTask this$1;

            public void onInfoWindowClick(Marker marker)
            {
                marker = new android.app.AlertDialog.Builder(this$0);
                marker.setTitle("Kirim Lokasi");
                if (nameAddress.equals(""))
                {
                    nameAddress = String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString());
                    marker.setMessage(nameAddress);
                } else
                {
                    marker.setMessage((new StringBuilder(String.valueOf(nameAddress))).append("\n").append(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString())).toString());
                }
                marker.setPositiveButton("Kirim", new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        progbar_location.setVisibility(0);
                        if (nameAddress.equals(""))
                        {
                            MessageLocationActivity.access$1(this$0, id_from, id_to, String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString()), "", t, bottom_id);
                            return;
                        }
                        try
                        {
                            MessageLocationActivity.access$1(this$0, id_from, id_to, (new StringBuilder(String.valueOf(nameAddress))).append("\n").append(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString())).toString(), "", t, bottom_id);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            dialoginterface.printStackTrace();
                        }
                        return;
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
                marker.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$2;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
                marker.show();
            }


            
            {
                this$1 = MessageLocationActivity.ReverseGeocodingTask.this;
                super();
            }
        });
    }


    public _cls1.this._cls1(Context context)
    {
        this$0 = MessageLocationActivity.this;
        super();
        nameAddress = "";
        mContext = context;
    }
}
