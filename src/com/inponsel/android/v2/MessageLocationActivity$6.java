// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            MessageLocationActivity

class this._cls0
    implements com.android.volley.ty._cls6
{

    final MessageLocationActivity this$0;

    private void parseJSONUser(String s)
    {
        JSONObject jsonobject;
        ListModel listmodel;
        double ad[];
        MarkerOptions markeroptions;
        int i;
        try
        {
            s = (new JSONObject(s)).getJSONArray("InPonsel");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        i = 0;
        if (i >= s.length())
        {
            progbar_location.setVisibility(8);
            userJoinAdapter.notifyDataSetChanged();
            return;
        }
        jsonobject = s.getJSONObject(i);
        listmodel = new ListModel();
        if ((!jsonobject.getString("name").equals("South Jakarta") || !jsonobject.getString("categories").equals("locality")) && (!jsonobject.getString("name").equals("Jakarta") || !jsonobject.getString("alamat").equals("Jakarta")))
        {
            listmodel.setPlaces(jsonobject.getString("name"));
            listmodel.setAddress(URLDecoder.decode(jsonobject.getString("alamat"), "utf-8"));
            listmodel.setLatitude(jsonobject.getString("lat"));
            listmodel.setLongitude(jsonobject.getString("lng"));
            ad = MessageLocationActivity.access$2(MessageLocationActivity.this, Double.parseDouble(jsonobject.getString("lat")), Double.parseDouble(jsonobject.getString("lng")));
            markeroptions = (new MarkerOptions()).position(new LatLng(ad[0], ad[1])).title(jsonobject.getString("name")).snippet((new StringBuilder(String.valueOf(jsonobject.getString("alamat")))).append("-").append(jsonobject.getString("lat")).append(",").append(jsonobject.getString("lng")).toString());
            Log.e("Random", jsonobject.getString("alamat"));
            markeroptions.icon(BitmapDescriptorFactory.defaultMarker(30F));
            MessageLocationActivity.access$0(MessageLocationActivity.this).addMarker(markeroptions);
            scpencarianArray.add(listmodel);
        }
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_17;
        }
    }

    public volatile void onResponse(Object obj)
    {
        onResponse((JSONObject)obj);
    }

    public void onResponse(JSONObject jsonobject)
    {
        Log.e("response", jsonobject.toString());
        scpencarianArray.clear();
        parseJSONUser(jsonobject.toString());
    }

    Factory()
    {
        this$0 = MessageLocationActivity.this;
        super();
    }
}
