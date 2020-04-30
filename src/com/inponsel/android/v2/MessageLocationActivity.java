// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageLocationActivity extends SherlockFragmentActivity
{
    public class ListSCProvAdapter extends BaseAdapter
    {

        private Activity activity;
        Context context;
        Cursor cursor;
        String email_user;
        String finalUrl;
        DecimalFormat fmt;
        DecimalFormatSymbols fmts;
        int hargaBaru;
        int hargaBekas;
        String komen;
        private ArrayList lm;
        ListModel lms;
        ProgressDialog mDialog;
        int pos;
        String res;
        int resource;
        String response;
        String status;
        final MessageLocationActivity this$0;
        String user;
        String username;

        public int getCount()
        {
            return lm.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public ListModel getListModel(int i)
        {
            return (ListModel)lm.get(i);
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            pos = i;
            if (view == null)
            {
                view = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(resource, null);
                viewgroup = new ViewHolder();
                viewgroup.root_people = (RelativeLayout)view.findViewById(0x7f0b084b);
                viewgroup.rl_circle = (RelativeLayout)view.findViewById(0x7f0b084c);
                viewgroup.txt_nama = (TextView)view.findViewById(0x7f0b084d);
                viewgroup.txt_username = (TextView)view.findViewById(0x7f0b0373);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (ViewHolder)view.getTag();
            }
            lms = (ListModel)lm.get(i);
            if (lm != null)
            {
                ((ViewHolder) (viewgroup)).rl_circle.setVisibility(0);
                Log.e("alamat", lms.getAddress());
                ((ViewHolder) (viewgroup)).txt_nama.setText(lms.getPlaces());
                ((ViewHolder) (viewgroup)).txt_username.setText(lms.getAddress());
                ((ViewHolder) (viewgroup)).txt_nama.setSelected(true);
            }
            return view;
        }

        public void setListArray(ArrayList arraylist)
        {
            lm = arraylist;
        }

        public ListSCProvAdapter(Activity activity1, int i, ArrayList arraylist)
        {
            this$0 = MessageLocationActivity.this;
            super();
            fmt = new DecimalFormat();
            fmts = new DecimalFormatSymbols();
            username = "";
            user = "";
            komen = "";
            email_user = "";
            finalUrl = "";
            lm = arraylist;
            activity = activity1;
            resource = i;
        }
    }

    class ListSCProvAdapter.ViewHolder
    {

        RelativeLayout rl_circle;
        RelativeLayout root_people;
        final ListSCProvAdapter this$1;
        TextView txt_nama;
        TextView txt_username;

        ListSCProvAdapter.ViewHolder()
        {
            this$1 = ListSCProvAdapter.this;
            super();
        }
    }

    class MyInfoWindowAdapter
        implements com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    {

        private final View myContentsView;
        final MessageLocationActivity this$0;

        public View getInfoContents(Marker marker)
        {
            ((TextView)myContentsView.findViewById(0x7f0b0084)).setText(marker.getTitle());
            ((TextView)myContentsView.findViewById(0x7f0b0085)).setText(marker.getSnippet());
            return myContentsView;
        }

        public View getInfoWindow(Marker marker)
        {
            return null;
        }

        MyInfoWindowAdapter()
        {
            this$0 = MessageLocationActivity.this;
            super();
            myContentsView = getLayoutInflater().inflate(0x7f030022, null);
        }
    }

    private class ReverseGeocodingTask extends AsyncTask
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
            googleMap.addMarker((new MarkerOptions()).position(latLng).title(s).snippet(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString()))).showInfoWindow();
            googleMap.setOnInfoWindowClickListener(new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {

                final ReverseGeocodingTask this$1;

                public void onInfoWindowClick(Marker marker)
                {
                    marker = new android.app.AlertDialog.Builder(_fld0);
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

                        final ReverseGeocodingTask._cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            progbar_location.setVisibility(0);
                            if (nameAddress.equals(""))
                            {
                                SendMessage(id_from, id_to, String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString()), "", t, bottom_id);
                                return;
                            }
                            try
                            {
                                SendMessage(id_from, id_to, (new StringBuilder(String.valueOf(nameAddress))).append("\n").append(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString())).toString(), "", t, bottom_id);
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
                this$2 = ReverseGeocodingTask._cls1.this;
                super();
            }
                    });
                    marker.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                        final ReverseGeocodingTask._cls1 this$2;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                        }

            
            {
                this$2 = ReverseGeocodingTask._cls1.this;
                super();
            }
                    });
                    marker.show();
                }


            
            {
                this$1 = ReverseGeocodingTask.this;
                super();
            }
            });
        }


        public ReverseGeocodingTask(Context context)
        {
            this$0 = MessageLocationActivity.this;
            super();
            nameAddress = "";
            mContext = context;
        }
    }


    ActionBar actionBar;
    int actionBarTitleId;
    String addressText;
    List addresses;
    String bottom_id;
    Button btnSendMyLoc;
    Cursor cursor;
    DatabaseHandler db;
    String email_user;
    Bundle extras;
    String from_name;
    String from_photo;
    Geocoder geocoder;
    Double getlatitude;
    Double getlongitude;
    private GoogleMap googleMap;
    String id_from;
    String id_msg;
    String id_send_to;
    String id_to;
    String key;
    String last_message;
    LatLng latLng;
    double latitude;
    ListView listPlaces;
    LocationManager lm;
    Location location;
    private final LocationListener locationListener = new LocationListener() {

        final MessageLocationActivity this$0;

        public void onLocationChanged(Location location1)
        {
            longitude = location1.getLongitude();
            latitude = location1.getLatitude();
        }

        public void onProviderDisabled(String s)
        {
        }

        public void onProviderEnabled(String s)
        {
        }

        public void onStatusChanged(String s, int i, Bundle bundle)
        {
        }

            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
    };
    double longitude;
    MarkerOptions markerOptions;
    String me_message;
    String message_type;
    String msg_date;
    String nama_asli;
    SmoothProgressBar progbar_location;
    ArrayList scpencarianArray;
    String t;
    String to_name;
    String to_photo;
    String unread_msg;
    private boolean useLogo;
    protected UserFunctions userFunctions;
    ListSCProvAdapter userJoinAdapter;
    String user_id;
    String user_jekel;
    String user_joindate;
    String user_kota;
    String user_photo;
    String user_ponsel1;
    String user_ponsel2;
    String user_profile_update;
    String user_provider1;
    String user_provider2;
    String user_provinsi;
    String user_ttl;
    String username;

    public MessageLocationActivity()
    {
        scpencarianArray = null;
        latitude = -6.2676730000000003D;
        longitude = 106.829587D;
        key = "";
        useLogo = false;
        actionBarTitleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        user_photo = "";
        username = "";
        t = Utility.session(RestClient.pelihara);
        addresses = null;
        addressText = "";
    }

    private void GetUserOnLine(String s, String s1)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("places_google").append(Utility.BASE_FORMAT).append("?ll=").append(s).append("&key=").append(s1).append("&t=").append(t).toString();
        Log.e("urlOnline", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final MessageLocationActivity this$0;

            private void parseJSONUser(String s2)
            {
                JSONObject jsonobject;
                ListModel listmodel;
                double ad[];
                MarkerOptions markeroptions;
                int i;
                try
                {
                    s2 = (new JSONObject(s2)).getJSONArray("InPonsel");
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    s2.printStackTrace();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    s2.printStackTrace();
                    return;
                }
                i = 0;
                if (i >= s2.length())
                {
                    progbar_location.setVisibility(8);
                    userJoinAdapter.notifyDataSetChanged();
                    return;
                }
                jsonobject = s2.getJSONObject(i);
                listmodel = new ListModel();
                if ((!jsonobject.getString("name").equals("South Jakarta") || !jsonobject.getString("categories").equals("locality")) && (!jsonobject.getString("name").equals("Jakarta") || !jsonobject.getString("alamat").equals("Jakarta")))
                {
                    listmodel.setPlaces(jsonobject.getString("name"));
                    listmodel.setAddress(URLDecoder.decode(jsonobject.getString("alamat"), "utf-8"));
                    listmodel.setLatitude(jsonobject.getString("lat"));
                    listmodel.setLongitude(jsonobject.getString("lng"));
                    ad = createRandLocation(Double.parseDouble(jsonobject.getString("lat")), Double.parseDouble(jsonobject.getString("lng")));
                    markeroptions = (new MarkerOptions()).position(new LatLng(ad[0], ad[1])).title(jsonobject.getString("name")).snippet((new StringBuilder(String.valueOf(jsonobject.getString("alamat")))).append("-").append(jsonobject.getString("lat")).append(",").append(jsonobject.getString("lng")).toString());
                    Log.e("Random", jsonobject.getString("alamat"));
                    markeroptions.icon(BitmapDescriptorFactory.defaultMarker(30F));
                    googleMap.addMarker(markeroptions);
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

            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final MessageLocationActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                progbar_location.setVisibility(8);
            }

            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "tag_json_obj");
    }

    private void SendMessage(String s, String s1, String s2, String s3, String s4, String s5)
        throws UnsupportedEncodingException
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("send").append(Utility.BASE_FORMAT).append("?bottom_id=").append(s5).append("&from=").append(id_from).append("&to=").append(id_to).append("&msg=").append(URLEncoder.encode(s2, "utf-8")).append("&ext=").append(URLEncoder.encode(s3, "utf-8")).append("&type=2").append("&t=").append(t).toString();
        Log.e("urlSendLocation", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final MessageLocationActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                Log.e("response", jsonobject.toString());
                progbar_location.setVisibility(8);
                finish();
            }

            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final MessageLocationActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                progbar_location.setVisibility(8);
                Toast.makeText(getApplicationContext(), "Gagal mengirim lokasi", 1).show();
            }

            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, "tag_json_obj");
    }

    private double[] createRandLocation(double d, double d1)
    {
        return (new double[] {
            (Math.random() - 0.5D) / 500D + d, (Math.random() - 0.5D) / 500D + d1, 150D + (Math.random() - 0.5D) * 10D
        });
    }

    private void initilizeMap()
    {
        if (googleMap == null)
        {
            googleMap = ((MapFragment)getFragmentManager().findFragmentById(0x7f0b0847)).getMap();
            if (googleMap == null)
            {
                Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", 0).show();
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03010e);
        userFunctions = new UserFunctions();
        db = new DatabaseHandler(this);
        int i;
        int j;
        boolean flag;
        boolean flag1;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Halaman Chat Lokasi");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        t = Utility.session(t);
        geocoder = new Geocoder(this);
        btnSendMyLoc = (Button)findViewById(0x7f0b0849);
        lm = (LocationManager)getSystemService("location");
        flag = lm.isProviderEnabled("gps");
        flag1 = lm.isProviderEnabled("network");
        if (flag && flag1)
        {
            location = lm.getLastKnownLocation("gps");
            if (location != null)
            {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                lm.requestLocationUpdates("gps", 2000L, 10F, locationListener);
            }
        } else
        if (flag && !flag1)
        {
            location = lm.getLastKnownLocation("gps");
            if (location != null)
            {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                lm.requestLocationUpdates("gps", 2000L, 10F, locationListener);
            }
        } else
        if (!flag && flag1)
        {
            location = lm.getLastKnownLocation("network");
            if (location != null)
            {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                lm.requestLocationUpdates("network", 2000L, 10F, locationListener);
            }
        } else
        {
            location = lm.getLastKnownLocation("network");
            if (location != null)
            {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
                lm.requestLocationUpdates("network", 2000L, 10F, locationListener);
            }
        }
        t = Utility.session(t);
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Pilih Lokasi</font>"));
        extras = getIntent().getExtras();
        id_msg = extras.getString("");
        id_from = extras.getString("id_from");
        from_name = extras.getString("from_name");
        from_photo = extras.getString("from_photo");
        id_to = extras.getString("id_to");
        to_name = extras.getString("to_name");
        to_photo = extras.getString("to_photo");
        id_send_to = extras.getString("id_to");
        bottom_id = extras.getString("bottom_id");
        Log.e("id_from_to", (new StringBuilder(String.valueOf(id_from))).append("=").append(id_to).toString());
        if (userFunctions.isUserLoggedIn(this))
        {
            cursor = db.getAllData();
            cursor.moveToFirst();
            try
            {
                user_id = EncodeDecodeAES.decrypt(RestClient.pelihara, cursor.getString(1));
                id_from = user_id;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
            nama_asli = cursor.getString(2);
            user_photo = (new StringBuilder(String.valueOf(Util.BASE_PATH_AVATAR))).append(cursor.getString(3)).toString();
            username = cursor.getString(4);
            email_user = cursor.getString(5);
            user_ttl = cursor.getString(6);
            user_provinsi = cursor.getString(7);
            user_kota = cursor.getString(8);
            user_jekel = cursor.getString(9);
            user_ponsel1 = cursor.getString(10);
            user_ponsel2 = cursor.getString(11);
            user_provider1 = cursor.getString(12);
            user_provider2 = cursor.getString(13);
            user_joindate = cursor.getString(14);
            user_profile_update = cursor.getString(15);
        }
        progbar_location = (SmoothProgressBar)findViewById(0x7f0b0848);
        listPlaces = (ListView)findViewById(0x7f0b084a);
        scpencarianArray = new ArrayList();
        userJoinAdapter = new ListSCProvAdapter(this, 0x7f030125, scpencarianArray);
        listPlaces.setAdapter(userJoinAdapter);
        initilizeMap();
        googleMap.setMapType(1);
        googleMap.setMyLocationEnabled(true);
        googleMap.setInfoWindowAdapter(new MyInfoWindowAdapter());
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        addresses = geocoder.getFromLocation(latitude, longitude, 1);
_L1:
        GetUserOnLine(String.valueOf((new StringBuilder(String.valueOf(latitude))).append(",").append(longitude).toString()), key);
        bundle = (new com.google.android.gms.maps.model.CameraPosition.Builder()).target(new LatLng(latitude, longitude)).zoom(15F).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(bundle));
        googleMap.setOnInfoWindowClickListener(new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {

            final MessageLocationActivity this$0;

            public void onInfoWindowClick(Marker marker)
            {
                String s = marker.getTitle();
                marker = marker.getSnippet().split("-")[0];
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MessageLocationActivity.this);
                builder.setTitle("Kirim Lokasi");
                builder.setMessage((new StringBuilder(String.valueOf(s))).append("\n").append(marker).append("\n").append(String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString())).toString());
                builder.setPositiveButton("Kirim", s. new android.content.DialogInterface.OnClickListener() {

                    final _cls2 this$1;
                    private final String val$name;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        try
                        {
                            progbar_location.setVisibility(0);
                            SendMessage(id_from, id_to, name, "", t, bottom_id);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            dialoginterface.printStackTrace();
                        }
                    }

            
            {
                this$1 = final__pcls2;
                name = String.this;
                super();
            }
                });
                builder.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                builder.show();
            }


            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        });
        listPlaces.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MessageLocationActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                adapterview = (new StringBuilder(String.valueOf(userJoinAdapter.getListModel(k).getPlaces()))).append("\n").append(userJoinAdapter.getListModel(k).getAddress()).append("\n").append(userJoinAdapter.getListModel(k).getLatitude()).append(",").append(userJoinAdapter.getListModel(k).getLongitude()).toString();
                view = new android.app.AlertDialog.Builder(MessageLocationActivity.this);
                view.setTitle("Kirim Lokasi");
                view.setMessage(adapterview);
                view.setPositiveButton("Kirim", adapterview. new android.content.DialogInterface.OnClickListener() {

                    final _cls3 this$1;
                    private final String val$message;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        try
                        {
                            progbar_location.setVisibility(0);
                            SendMessage(id_from, id_to, message, "", t, bottom_id);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            dialoginterface.printStackTrace();
                        }
                    }

            
            {
                this$1 = final__pcls3;
                message = String.this;
                super();
            }
                });
                view.setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls3 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
                view.show();
            }


            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        });
        googleMap.setOnMapClickListener(new com.google.android.gms.maps.GoogleMap.OnMapClickListener() {

            final MessageLocationActivity this$0;

            public void onMapClick(LatLng latlng)
            {
                latLng = latlng;
                googleMap.clear();
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                googleMap.addMarker(markerOptions);
                (new ReverseGeocodingTask(getBaseContext())).execute(new LatLng[] {
                    latLng
                });
            }

            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        });
_L2:
        btnSendMyLoc.setOnClickListener(new android.view.View.OnClickListener() {

            String address;
            final MessageLocationActivity this$0;

            public void onClick(View view)
            {
                Object obj;
                if (addresses != null && addresses.size() > 0)
                {
                    obj = (Address)addresses.get(0);
                    MessageLocationActivity messagelocationactivity = MessageLocationActivity.this;
                    if (((Address) (obj)).getMaxAddressLineIndex() > 0)
                    {
                        view = ((Address) (obj)).getAddressLine(0);
                    } else
                    {
                        view = "";
                    }
                    messagelocationactivity.addressText = String.format("%s, %s, %s", new Object[] {
                        view, ((Address) (obj)).getLocality(), ((Address) (obj)).getCountryName()
                    });
                }
                address = addressText;
                view = String.valueOf((new StringBuilder(String.valueOf(latitude))).append(",").append(longitude).toString());
                obj = new android.app.AlertDialog.Builder(MessageLocationActivity.this);
                ((android.app.AlertDialog.Builder) (obj)).setTitle("Kirim Lokasi");
                if (address.equals("") || address.toLowerCase().contains("unknown"))
                {
                    ((android.app.AlertDialog.Builder) (obj)).setMessage(address);
                } else
                {
                    ((android.app.AlertDialog.Builder) (obj)).setMessage((new StringBuilder(String.valueOf(address))).append("\n").append(view).toString());
                }
                ((android.app.AlertDialog.Builder) (obj)).setPositiveButton("Kirim", new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        progbar_location.setVisibility(0);
                        if (address.equals("") || address.toLowerCase().contains("unknown"))
                        {
                            SendMessage(id_from, id_to, String.valueOf((new StringBuilder()).append(getlatitude).append(",").append(getlongitude).toString()), "", t, bottom_id);
                            return;
                        }
                        try
                        {
                            SendMessage(id_from, id_to, (new StringBuilder(String.valueOf(address))).append("\n").append(String.valueOf((new StringBuilder(String.valueOf(latitude))).append(",").append(longitude).toString())).toString(), "", t, bottom_id);
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
                this$1 = _cls5.this;
                super();
            }
                });
                ((android.app.AlertDialog.Builder) (obj)).setNegativeButton("Batal", new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
                ((android.app.AlertDialog.Builder) (obj)).show();
            }


            
            {
                this$0 = MessageLocationActivity.this;
                super();
            }
        });
        return;
        bundle;
        bundle.printStackTrace();
          goto _L1
        bundle;
        bundle.printStackTrace();
          goto _L2
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 24
    //                   16908332 26;
           goto _L1 _L2
_L1:
        return true;
_L2:
        finish();
        overridePendingTransition(0x7f040001, 0x7f040002);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onResume()
    {
        super.onResume();
        initilizeMap();
    }



}
