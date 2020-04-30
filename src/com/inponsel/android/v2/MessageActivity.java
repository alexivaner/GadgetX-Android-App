// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.android.volley.VolleyError;
import com.google.android.gms.analytics.Tracker;
import com.inponsel.android.adapter.ListChatMessageAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.PonselBaseApp;
import com.inponsel.android.utils.Base64;
import com.inponsel.android.utils.DatabaseHandler;
import com.inponsel.android.utils.EncodeDecodeAES;
import com.inponsel.android.utils.InternalStorageContentProvider;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.MyObjectRequest;
import com.inponsel.android.utils.RestClient;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.DroidWriterEditText;
import com.sherlock.navigationdrawer.compat.SherlockActionBarDrawerToggle;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import eu.janmuller.android.simplecropimage.CropImage;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            BaseDrawer, MessageLocationActivity

public class MessageActivity extends BaseDrawer
    implements android.view.View.OnClickListener, Observer
{
    class MyTimerTask extends TimerTask
    {

        final MessageActivity this$0;

        public void run()
        {
            Log.e("timertask", "running");
            runOnUiThread(new Runnable() {

                final MyTimerTask this$1;

                public void run()
                {
label0:
                    {
                        MessageActivity messageactivity = _fld0;
                        messageactivity.countRefresh = messageactivity.countRefresh + 1;
                        Log.e("update_msgread", "ok");
                        db.update_msgread(from_name);
                        if (netInfo != null && netInfo.isConnected())
                        {
                            try
                            {
                                Utility.removeMSGNotif(getApplicationContext(), Integer.parseInt(id_to));
                            }
                            catch (NumberFormatException numberformatexception)
                            {
                                numberformatexception.printStackTrace();
                            }
                            catch (Exception exception)
                            {
                                exception.printStackTrace();
                            }
                            if (listpMessageArrayList.size() != 0)
                            {
                                break label0;
                            }
                            GetJSONConversation(id_from, id_to, t);
                        }
                        return;
                    }
                    RepeatGetMessage(id_from, id_to, t, bottom_id);
                }

            
            {
                this$1 = MyTimerTask.this;
                super();
            }
            });
        }


        MyTimerTask()
        {
            this$0 = MessageActivity.this;
            super();
        }
    }

    public class UploadImage extends AsyncTask
    {

        final MessageActivity this$0;
        String urlImage;

        protected transient Long doInBackground(URL aurl[])
        {
            aurl = new ByteArrayOutputStream();
            photo_upload.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, aurl);
            String s = Base64.encodeBytes(aurl.toByteArray());
            aurl = new ArrayList();
            aurl.add(new BasicNameValuePair("image", s));
            if (id_send_to.equals(user_id))
            {
                id_send_to = id_to;
                Log.e("imgto1", (new StringBuilder("from ")).append(id_send_to).append(" to ").append(id_from).toString());
                urlImage = (new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMGMSG))).append("photo_upload").append(Utility.BASE_FORMAT).append("?id_from=").append(id_from).append("&id_to=").append(id_to).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
            } else
            {
                Log.e("imgto2", (new StringBuilder("from ")).append(user_id).append(" to ").append(id_to).toString());
                urlImage = (new StringBuilder(String.valueOf(Util.BASE_PATH_UPLIMGMSG))).append("photo_upload").append(Utility.BASE_FORMAT).append("?id_from=").append(user_id).append("&id_to=").append(id_send_to).append("&bottom_id=").append(bottom_id).append("&t=").append(t).toString();
            }
            Log.e("urlImage", urlImage);
            try
            {
                DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(urlImage);
                Log.e("urlImage", urlImage);
                httppost.setEntity(new UrlEncodedFormEntity(aurl));
                aurl = defaulthttpclient.execute(httppost).getEntity();
                inpstream = aurl.getContent();
                resp = MessageActivity.inputToString(inpstream);
                Log.e("url", resp);
            }
            // Misplaced declaration of an exception variable
            catch (URL aurl[])
            {
                Log.e("log_tag", (new StringBuilder("Error in http connection ")).append(aurl.toString()).toString());
            }
            return null;
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((URL[])aobj);
        }

        protected void onPostExecute(Long long1)
        {
            super.onPostExecute(long1);
            try
            {
                Log.e("update_byImage", resp);
                hideSmoothProgress();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Long long1)
            {
                return;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Long)obj);
        }

        protected void onPreExecute()
        {
            showSmoothProgress();
        }

        public UploadImage()
        {
            this$0 = MessageActivity.this;
            super();
            urlImage = "";
        }
    }


    private static final String FOLDER_NAME = "InPonsel";
    public static final int REQUEST_CODE_CROP_IMAGE = 3;
    public static final int REQUEST_CODE_GALLERY = 1;
    public static final int REQUEST_CODE_TAKE_PICTURE = 2;
    public static final String TEMP_PHOTO_FILE_NAME = (new StringBuilder("inponsel_")).append(System.currentTimeMillis()).append(".jpg").toString();
    Animation animFadein;
    Animation animFadeout;
    String bottom_id;
    Button btn_send_komen;
    int charCount;
    ListChatMessageAdapter chatMsgAdapter;
    String chat_avaible;
    ConnectivityManager cm;
    int countAllKom;
    int countKomOld;
    int countRefresh;
    DroidWriterEditText edt_pop_komen;
    Bundle extras;
    String from_name;
    String from_photo;
    String id_from;
    String id_msg;
    String id_send_to;
    String id_to;
    String img_height;
    ImageView img_user_picture;
    String img_width;
    InputMethodManager imm;
    InputStream inpstream;
    int jum_msg;
    String komencount;
    String last_message;
    String last_seen;
    RelativeLayout lay_button_send;
    LayoutInflater layoutInflater;
    LinearLayout layout_empty;
    LinearLayout layout_header_msg;
    LinearLayout layout_popup;
    ArrayList listInboxDB;
    ListView listMessaging;
    ArrayList listpMessageArrayList;
    LinearLayout ll_UserBack;
    private File mFileTemp;
    String me_message;
    String message_type;
    String msg_date;
    String msg_ext;
    String msg_kordinat;
    MyTimerTask myTimerTask;
    NetworkInfo netInfo;
    String older_count;
    String online_stat;
    Bitmap photo_upload;
    String pop_show;
    TextView pop_txtCountKomen;
    RelativeLayout popupOutside;
    View popupView;
    PopupWindow popupWindow;
    SmoothProgressBar progbar_send;
    ProgressBar progressbar_item;
    ProgressBar progressbar_middle;
    String resp;
    RelativeLayout rl_share_camera;
    RelativeLayout rl_share_galleri;
    RelativeLayout rl_share_location;
    String t;
    private String tag_json_obj;
    Timer timer;
    String to_name;
    String to_photo;
    String top_id;
    String top_id_msg;
    TextView txtLastSeen;
    TextView txtNotif;
    TextView txtUsername;
    TextView txtWaktu;
    TextView txt_OlderMessage;
    TextView txt_empty;
    TextView txt_new_message;
    String unread_msg;
    String url_thumb;
    private boolean useLogo;
    UserFunctions userFunctions;

    public MessageActivity()
    {
        id_msg = "";
        id_from = "";
        from_name = "";
        from_photo = "";
        id_to = "";
        to_name = "";
        to_photo = "";
        last_message = "";
        msg_ext = "";
        msg_kordinat = "";
        message_type = "";
        unread_msg = "";
        msg_date = "";
        me_message = "";
        img_width = "";
        img_height = "";
        id_send_to = "";
        countRefresh = 0;
        top_id_msg = "";
        jum_msg = 0;
        listpMessageArrayList = null;
        tag_json_obj = "jobj_req";
        t = Utility.session(RestClient.pelihara);
        older_count = "";
        chat_avaible = "";
        last_seen = "";
        online_stat = "";
        url_thumb = "";
        countKomOld = 0;
        countAllKom = 0;
        komencount = "";
        pop_show = "0";
        useLogo = false;
    }

    private void GetJSONConversation(String s, String s1, String s2)
    {
        showProgressDialog();
        (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_conversation").append(Utility.BASE_FORMAT).append("?from=").append(s).append("&to=").append(s1).append("&t=").append(s2).toString();
        if (id_send_to.equals(id_to))
        {
            id_send_to = id_to;
            Log.e("chatto1", (new StringBuilder("from ")).append(id_send_to).append(" to ").append(s).toString());
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_conversation").append(Utility.BASE_FORMAT).append("?from=").append(id_send_to).append("&to=").append(s).append("&t=").append(s2).toString();
        } else
        {
            id_send_to = id_from;
            Log.e("chatto2", (new StringBuilder("from ")).append(id_send_to).append(" to ").append(s1).toString());
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_conversation").append(Utility.BASE_FORMAT).append("?from=").append(s).append("&to=").append(s1).append("&t=").append(s2).toString();
        }
        Log.e("urlConversation", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final MessageActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSON(jsonobject.toString());
                chatMsgAdapter.setListArray(listpMessageArrayList);
                if (listpMessageArrayList.size() == 20)
                {
                    txt_OlderMessage.setVisibility(0);
                } else
                {
                    txt_OlderMessage.setVisibility(8);
                }
                chatMsgAdapter.notifyDataSetChanged();
                if (online_stat.equals("1"))
                {
                    txtLastSeen.setText("Online");
                } else
                {
                    txtLastSeen.setText((new StringBuilder("Last seen ")).append(Utility.convertDate(last_seen)).toString());
                }
                txtLastSeen.setVisibility(0);
                hideProgressDialog();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final MessageActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideProgressDialog();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, "test", "test");
        scrollMyListViewToBottom();
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void GetOlderMessage(String s, String s1, String s2, String s3)
    {
        s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_conversation").append(Utility.BASE_FORMAT).append("?top_id=").append(s3).append("&from=").append(user_id).append("&to=").append(s1).append("&t=").append(s2).toString();
        Log.e("olderURL", s);
        showOlderProgress();
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final MessageActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
label0:
                {
                    parseJSONOlderMessage(jsonobject.toString());
                    Log.e("jum_msg", String.valueOf(jum_msg));
                    if (jum_msg != 0)
                    {
                        chatMsgAdapter.setListArray(listpMessageArrayList);
                        chatMsgAdapter.notifyDataSetChanged();
                    }
                    if (online_stat.equals("1"))
                    {
                        txtLastSeen.setText("Online");
                    } else
                    {
                        txtLastSeen.setText((new StringBuilder("Last seen ")).append(Utility.convertDate(last_seen)).toString());
                    }
                    txtLastSeen.setVisibility(0);
                    Log.e("older_countafter", older_count);
                    if (layout_header_msg.getVisibility() == 0)
                    {
                        if (Integer.parseInt(older_count) != 20)
                        {
                            break label0;
                        }
                        layout_header_msg.setVisibility(8);
                        txt_OlderMessage.setVisibility(0);
                    }
                    return;
                }
                layout_header_msg.setVisibility(8);
                txt_OlderMessage.setVisibility(8);
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final MessageActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                layout_header_msg.setVisibility(8);
                txt_OlderMessage.setVisibility(0);
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void RepeatGetMessage(String s, String s1, String s2, String s3)
    {
        if (id_send_to.equals(id_to))
        {
            id_send_to = id_to;
            Log.e("chatto1", (new StringBuilder("from ")).append(id_send_to).append(" to ").append(s).toString());
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_conversation").append(Utility.BASE_FORMAT).append("?bottom_id=").append(s3).append("&from=").append(id_send_to).append("&to=").append(s).append("&t=").append(s2).toString();
        } else
        {
            id_send_to = id_from;
            Log.e("chatto2", (new StringBuilder("from ")).append(id_send_to).append(" to ").append(s1).toString());
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("chat_conversation").append(Utility.BASE_FORMAT).append("?bottom_id=").append(s3).append("&from=").append(s).append("&to=").append(s1).append("&t=").append(s2).toString();
        }
        Log.e("repeatURL", s);
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final MessageActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONRepeatMessage(jsonobject.toString());
                if (jum_msg != 0)
                {
                    chatMsgAdapter.setListArray(listpMessageArrayList);
                    chatMsgAdapter.notifyDataSetChanged();
                }
                if (online_stat.equals("1"))
                {
                    txtLastSeen.setText("Online");
                } else
                {
                    txtLastSeen.setText((new StringBuilder("Last seen ")).append(Utility.convertDate(last_seen)).toString());
                }
                txtLastSeen.setVisibility(0);
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final MessageActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, "test", "test");
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    private void SendMessage(String s, String s1, String s2, String s3, String s4)
    {
        if (id_send_to.equals(id_to))
        {
            id_send_to = id_to;
            Log.e("sendto1", (new StringBuilder("from ")).append(s).append(" to ").append(id_send_to).toString());
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("send").append(Utility.BASE_FORMAT).append("?bottom_id=").append(s4).append("&from=").append(s).append("&to=").append(id_send_to).append("&msg=").append(s2).append("&t=").append(s3).toString();
        } else
        {
            id_send_to = id_from;
            Log.e("sendto2", (new StringBuilder("from ")).append(s1).append(" to ").append(id_send_to).toString());
            s = (new StringBuilder(String.valueOf(Util.BASE_PATH_MSG))).append("send").append(Utility.BASE_FORMAT).append("?bottom_id=").append(s4).append("&from=").append(s1).append("&to=").append(id_send_to).append("&msg=").append(s2).append("&t=").append(s3).toString();
        }
        Log.e("urlSend", s);
        showSmoothProgress();
        s = new MyObjectRequest(s, new com.android.volley.Response.Listener() {

            final MessageActivity this$0;

            public volatile void onResponse(Object obj)
            {
                onResponse((JSONObject)obj);
            }

            public void onResponse(JSONObject jsonobject)
            {
                parseJSONSendMessage(jsonobject.toString());
                edt_pop_komen.requestFocus();
                edt_pop_komen.setFocusable(true);
                chatMsgAdapter.notifyDataSetChanged();
                edt_pop_komen.setText("");
                hideSmoothProgress();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, new com.android.volley.Response.ErrorListener() {

            final MessageActivity this$0;

            public void onErrorResponse(VolleyError volleyerror)
            {
                Log.d("response", (new StringBuilder("Errora: ")).append(volleyerror.getMessage()).toString());
                hideSmoothProgress();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        }, "test", "test");
        scrollMyListViewToBottom();
        PonselBaseApp.getInstance().addToRequestQueue(s, tag_json_obj);
    }

    public static void copyStream(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                return;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
    }

    private File createFolders()
    {
        File file;
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            file = Environment.getExternalStorageDirectory();
        }
        if (file == null)
        {
            file = Environment.getExternalStorageDirectory();
        } else
        {
            File file1 = new File(file, "InPonsel");
            file = file1;
            if (!file1.exists())
            {
                file = file1;
                if (!file1.mkdirs())
                {
                    return Environment.getExternalStorageDirectory();
                }
            }
        }
        return file;
    }

    private File getNextFileName()
    {
        if (mFileTemp != null && mFileTemp.exists())
        {
            return new File(mFileTemp, TEMP_PHOTO_FILE_NAME);
        } else
        {
            return null;
        }
    }

    private void hideProgressDialog()
    {
        if (progressbar_middle.getVisibility() == 0)
        {
            Log.e("chat_avaible", chat_avaible);
            if (chat_avaible.equals("0"))
            {
                layout_empty.setVisibility(8);
                txt_empty.setText("Belum ada pesan");
            } else
            {
                layout_empty.setVisibility(8);
            }
            progressbar_middle.setVisibility(8);
        }
    }

    private void hideSmoothProgress()
    {
        if (progbar_send.getVisibility() == 0)
        {
            progbar_send.setVisibility(8);
            progbar_send.setVisibility(8);
            if (chat_avaible.equals("0"))
            {
                layout_empty.setVisibility(8);
                txt_empty.setText("Belum ada pesan");
            } else
            {
                layout_empty.setVisibility(8);
            }
        }
        scrollMyListViewToBottom();
    }

    private static String inputToString(InputStream inputstream)
        throws Exception
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        inputstream = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
_L4:
        String s = inputstream.readLine();
        if (s != null) goto _L3; else goto _L2
_L2:
        return stringbuilder.toString();
_L3:
        stringbuilder.append(s).append('\n');
          goto _L4
        inputstream;
          goto _L2
    }

    private void openGallery()
    {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    private void parseJSONOlderMessage(String s)
    {
        JSONObject jsonobject;
        int i;
        try
        {
            jsonobject = new JSONObject(s);
            s = jsonobject.getJSONArray("InPonsel");
            last_seen = jsonobject.getString("last_seen");
            online_stat = jsonobject.getString("online");
            older_count = jsonobject.getString("total");
            Log.e("older_countparse", older_count);
            url_thumb = jsonobject.getString("url_thumb");
            if (jsonobject.getString("top_id").equals("0"))
            {
                jum_msg = 0;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        top_id = jsonobject.getString("top_id");
        i = 0;
_L2:
        if (i >= s.length())
        {
            jum_msg = listpMessageArrayList.size();
            return;
        }
        JSONObject jsonobject1 = s.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setId_msg(jsonobject1.getString("id"));
        listmodel.setId_from(jsonobject1.getString("id_from"));
        listmodel.setFrom_name(jsonobject1.getString("from_name"));
        listmodel.setFrom_photo(jsonobject1.getString("from_photo"));
        listmodel.setId_to(jsonobject1.getString("id_to"));
        listmodel.setTo_name(jsonobject1.getString("to_name"));
        listmodel.setTo_photo(jsonobject1.getString("to_photo"));
        listmodel.setLast_message(jsonobject1.getString("message"));
        listmodel.setExt(jsonobject1.getString("ext"));
        listmodel.setKordinat(jsonobject1.getString("ext").substring(jsonobject1.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject1.getString("message_type"));
        listmodel.setMsg_date(jsonobject1.getString("post_date"));
        listmodel.setMe_message(jsonobject1.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        if (!db.checkMSGIfExist(jsonobject1.getString("id")))
        {
            db.addMSG(jsonobject1.getString("id"), jsonobject1.getString("id_from"), jsonobject1.getString("from_name"), jsonobject1.getString("from_photo"), jsonobject1.getString("id_to"), jsonobject1.getString("to_name"), jsonobject1.getString("to_photo"), jsonobject1.getString("message"), jsonobject1.getString("ext"), jsonobject1.getString("message_type"), last_seen, jsonobject1.getString("me"), jsonobject1.getString("post_date"), jsonobject1.getString("width"), jsonobject1.getString("height"));
        }
        listpMessageArrayList.add(0, listmodel);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void parseJSONRepeatMessage(String s)
    {
        JSONArray jsonarray;
        int i;
        try
        {
            s = new JSONObject(s);
            jsonarray = s.getJSONArray("InPonsel");
            last_seen = s.getString("last_seen");
            online_stat = s.getString("online");
            url_thumb = s.getString("url_thumb");
            if (s.getString("bottom_id").equals("0"))
            {
                jum_msg = 0;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        bottom_id = s.getString("bottom_id");
        i = 0;
_L7:
        if (i >= jsonarray.length())
        {
            jum_msg = listpMessageArrayList.size();
            return;
        }
        ListModel listmodel;
        JSONObject jsonobject;
        jsonobject = jsonarray.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_msg(jsonobject.getString("id"));
        listmodel.setId_from(jsonobject.getString("id_from"));
        listmodel.setFrom_name(jsonobject.getString("from_name"));
        listmodel.setFrom_photo(jsonobject.getString("from_photo"));
        listmodel.setId_to(jsonobject.getString("id_to"));
        listmodel.setTo_name(jsonobject.getString("to_name"));
        listmodel.setTo_photo(jsonobject.getString("to_photo"));
        listmodel.setLast_message(jsonobject.getString("message"));
        listmodel.setExt(jsonobject.getString("ext"));
        listmodel.setKordinat(jsonobject.getString("ext").substring(jsonobject.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject.getString("message_type"));
        listmodel.setMsg_date(jsonobject.getString("post_date"));
        listmodel.setMe_message(jsonobject.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject.getString("height"));
        listmodel.setImg_width(jsonobject.getString("width"));
        if ((listMessaging.getFirstVisiblePosition() != 0 || listMessaging.getChildAt(0).getTop() < 0) && (listMessaging.getLastVisiblePosition() == listMessaging.getAdapter().getCount() - 1 || listMessaging.getChildAt(listMessaging.getChildCount() - 1).getBottom() < listMessaging.getHeight())) goto _L2; else goto _L1
_L1:
        TextView textview;
        txt_new_message.startAnimation(animFadein);
        txt_new_message.setVisibility(0);
        textview = txt_new_message;
        if (!jsonobject.getString("message_type").equals("1")) goto _L4; else goto _L3
_L3:
        s = "New Message : Image";
_L8:
        textview.setText(s);
_L2:
        if (!db.checkMSGIfExist(jsonobject.getString("id")))
        {
            Log.e("insert", jsonobject.getString("message"));
            db.addMSG(jsonobject.getString("id"), jsonobject.getString("id_from"), jsonobject.getString("from_name"), jsonobject.getString("from_photo"), jsonobject.getString("id_to"), jsonobject.getString("to_name"), jsonobject.getString("to_photo"), jsonobject.getString("message"), jsonobject.getString("ext"), jsonobject.getString("message_type"), last_seen, jsonobject.getString("me"), jsonobject.getString("post_date"), jsonobject.getString("width"), jsonobject.getString("height"));
        }
        if (!db.checkIfInboxExist(jsonobject.getString("id_from"))) goto _L6; else goto _L5
_L5:
        db.update_usrmsg(jsonobject.getString("id_from"), jsonobject.getString("last_message"), jsonobject.getString("message_type"), jsonobject.getString("post_date"), jsonobject.getString("me"), jsonobject.getString("unread"));
_L9:
        listpMessageArrayList.add(listpMessageArrayList.size(), listmodel);
        i++;
          goto _L7
_L4:
        s = (new StringBuilder("New Message : ")).append(jsonobject.getString("message")).toString();
          goto _L8
_L6:
        db.addInbox(jsonobject.getString("id"), jsonobject.getString("id_from"), jsonobject.getString("from_name"), jsonobject.getString("from_photo"), jsonobject.getString("id_to"), jsonobject.getString("to_name"), jsonobject.getString("to_photo"), jsonobject.getString("last_message"), jsonobject.getString("message_type"), jsonobject.getString("last_seen"), jsonobject.getString("unread"), jsonobject.getString("me"), jsonobject.getString("post_date"));
          goto _L9
        s;
        s.printStackTrace();
          goto _L9
        s;
        s.printStackTrace();
          goto _L9
    }

    private void parseJSONSendMessage(String s)
    {
        JSONObject jsonobject1;
        ListModel listmodel;
        int i;
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            listpMessageArrayList = new ArrayList();
            s = jsonobject.getJSONArray("InPonsel");
            top_id = jsonobject.getString("top_id");
            bottom_id = jsonobject.getString("bottom_id");
            chat_avaible = jsonobject.getString("success");
            last_seen = jsonobject.getString("last_seen");
            online_stat = jsonobject.getString("online");
            url_thumb = jsonobject.getString("url_thumb");
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
            return;
        }
        jsonobject1 = s.getJSONObject(i);
        listmodel = new ListModel();
        listmodel.setId_msg(jsonobject1.getString("id"));
        listmodel.setId_from(jsonobject1.getString("id_from"));
        listmodel.setFrom_name(jsonobject1.getString("from_name"));
        listmodel.setFrom_photo(jsonobject1.getString("from_photo"));
        listmodel.setId_to(jsonobject1.getString("id_to"));
        listmodel.setTo_name(jsonobject1.getString("to_name"));
        listmodel.setTo_photo(jsonobject1.getString("to_photo"));
        listmodel.setLast_message(jsonobject1.getString("message"));
        listmodel.setExt(jsonobject1.getString("ext"));
        listmodel.setKordinat(jsonobject1.getString("ext").substring(jsonobject1.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject1.getString("message_type"));
        listmodel.setMsg_date(jsonobject1.getString("post_date"));
        listmodel.setMe_message(jsonobject1.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        listpMessageArrayList.add(listpMessageArrayList.size(), listmodel);
        i++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_96;
        }
    }

    private void scrollMyListViewToBottom()
    {
        listMessaging.post(new Runnable() {

            final MessageActivity this$0;

            public void run()
            {
                listMessaging.setSelection(chatMsgAdapter.getCount() - 1);
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
    }

    private void showOlderProgress()
    {
        if (layout_header_msg.getVisibility() != 0)
        {
            layout_header_msg.setVisibility(0);
        }
        txt_OlderMessage.setVisibility(8);
    }

    private void showProgressDialog()
    {
label0:
        {
            if (progressbar_middle.getVisibility() != 0)
            {
                if (!chat_avaible.equals("0"))
                {
                    break label0;
                }
                progressbar_middle.setVisibility(0);
                layout_empty.setVisibility(8);
                txt_empty.setText("Belum ada pesan");
            }
            return;
        }
        layout_empty.setVisibility(8);
        txt_empty.setText("Belum ada pesan");
    }

    private void showSmoothProgress()
    {
        if (progbar_send.getVisibility() != 0)
        {
            progbar_send.setVisibility(0);
        }
        btn_send_komen.setEnabled(false);
    }

    private void startCropImage()
    {
        Intent intent = new Intent(this, eu/janmuller/android/simplecropimage/CropImage);
        intent.putExtra("image-path", mFileTemp.getPath());
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        startActivityForResult(intent, 3);
    }

    private void starttask()
    {
        if (timer != null)
        {
            timer.cancel();
        }
        timer = new Timer();
        myTimerTask = new MyTimerTask();
        timer.schedule(myTimerTask, 1000L, 5000L);
    }

    private void stopTask()
    {
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }

    private void takePicture()
    {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uri;
        if (!"mounted".equals(Environment.getExternalStorageState()))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        uri = Uri.fromFile(mFileTemp);
_L1:
        intent.putExtra("output", uri);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 2);
        return;
        try
        {
            uri = InternalStorageContentProvider.CONTENT_URI;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
          goto _L1
    }

    public ArrayList loadInboxDB(String s)
    {
        Object obj;
        int i;
        i = 0;
        obj = null;
        if (!s.equals("older")) goto _L2; else goto _L1
_L1:
        Log.e("top_id_msg", top_id_msg);
        layout_header_msg.setVisibility(0);
        txt_OlderMessage.setVisibility(8);
        Cursor cursor = db.getOlderMSGData(id_from, id_to, top_id_msg);
        obj = cursor;
_L3:
        if (((Cursor) (obj)).moveToFirst())
        {
            do
            {
                int j = i + 1;
                Object obj1;
                try
                {
                    id_msg = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("id_msg"));
                    id_from = EncodeDecodeAES.decrypt(RestClient.pelihara, ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("id_from")));
                    from_name = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("from_name"));
                    from_photo = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("from_photo"));
                    id_to = EncodeDecodeAES.decrypt(RestClient.pelihara, ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("id_to")));
                    to_name = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("to_name"));
                    to_photo = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("to_photo"));
                    last_message = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("message"));
                    last_message = last_message.replace("null,null ", "");
                    last_message = last_message.replace("null,null\n", "");
                    msg_ext = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("ext"));
                    msg_kordinat = msg_ext.substring(msg_ext.lastIndexOf("Intele%7C") + 1).replace("ntele%7C", "");
                    Log.e("msg_kordinat", msg_kordinat);
                    message_type = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("message_type"));
                    me_message = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("message_me"));
                    msg_date = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("post_date"));
                    img_width = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("img_width"));
                    img_height = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("img_height"));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    ((Exception) (obj1)).printStackTrace();
                }
                bottom_id = id_msg;
                Log.e("loadinboxLoop", String.valueOf(j));
                if (s.equals("older"))
                {
                    if (j == 20)
                    {
                        top_id_msg = id_msg;
                        top_id = id_msg;
                    }
                } else
                if (j == 1)
                {
                    top_id_msg = id_msg;
                    top_id = id_msg;
                }
                obj1 = new ListModel();
                ((ListModel) (obj1)).setId_msg(id_msg);
                ((ListModel) (obj1)).setId_from(id_from);
                ((ListModel) (obj1)).setFrom_name(from_name);
                ((ListModel) (obj1)).setFrom_photo(from_photo);
                ((ListModel) (obj1)).setId_to(id_to);
                ((ListModel) (obj1)).setTo_name(to_name);
                ((ListModel) (obj1)).setTo_photo(to_photo);
                ((ListModel) (obj1)).setLast_message(last_message);
                ((ListModel) (obj1)).setExt(msg_ext);
                ((ListModel) (obj1)).setKordinat(msg_kordinat);
                ((ListModel) (obj1)).setMessage_type(message_type);
                ((ListModel) (obj1)).setMe_message(me_message);
                ((ListModel) (obj1)).setMsg_date(msg_date);
                ((ListModel) (obj1)).setUrl_thumb(Util.BASE_URL_THUMB);
                ((ListModel) (obj1)).setImg_width(img_width);
                ((ListModel) (obj1)).setImg_height(img_height);
                if (s.equals("older"))
                {
                    listInboxDB.add(0, obj1);
                } else
                {
                    listInboxDB.add(obj1);
                }
                i = j;
            } while (((Cursor) (obj)).moveToNext());
            Log.e("getINBOXData", String.valueOf(listInboxDB.size()));
            Log.e("loadinboxLast", String.valueOf(j));
            if (j == 20)
            {
                txt_OlderMessage.setVisibility(0);
                layout_header_msg.setVisibility(8);
            } else
            {
                layout_header_msg.setVisibility(8);
                txt_OlderMessage.setVisibility(8);
            }
            listMessaging.setVisibility(0);
        } else
        {
            Log.e("getINBOXData", "nol");
        }
        Log.e("top_id_msg", top_id_msg);
        db.close();
        return listInboxDB;
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L3
_L2:
        listInboxDB = new ArrayList();
        obj1 = db.getMSGData(id_from, id_to);
        obj = obj1;
          goto _L3
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L3
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 40
    //                   2 95
    //                   3 102;
           goto _L3 _L4 _L5 _L6
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        continue; /* Loop/switch isn't completed */
_L7:
        super.onActivityResult(i, j, intent);
        return;
_L4:
        try
        {
            InputStream inputstream = getContentResolver().openInputStream(intent.getData());
            FileOutputStream fileoutputstream = new FileOutputStream(mFileTemp);
            copyStream(inputstream, fileoutputstream);
            fileoutputstream.close();
            inputstream.close();
            startCropImage();
        }
        catch (Exception exception) { }
          goto _L7
_L5:
        startCropImage();
          goto _L7
        if (intent.getStringExtra("image-path") == null) goto _L1; else goto _L8
_L8:
        photo_upload = BitmapFactory.decodeFile(mFileTemp.getPath());
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            (new UploadImage()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new URL[0]);
        } else
        {
            (new UploadImage()).execute(new URL[0]);
        }
          goto _L7
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void onBackPressed()
    {
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
            Log.e("vis", "on");
            return;
        } else
        {
            Log.e("vis", "off");
            stopTask();
            finish();
            overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f0300da, null, false);
        mDrawerLayout.addView(bundle, 0);
        menu_pesan.setBackgroundResource(0x7f0201cf);
        menu_pesan.setEnabled(false);
        int i;
        int j;
        try
        {
            bundle = ((PonselBaseApp)getApplication()).getTracker(com.inponsel.android.adapter.PonselBaseApp.TrackerName.APP_TRACKER);
            bundle.setScreenName("Halaman Chat");
            bundle.send((new com.google.android.gms.analytics.HitBuilders.AppViewBuilder()).build());
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
        }
        actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(useLogo);
        actionBar.setBackgroundDrawable(getResources().getDrawable(0x7f0200e5));
        j = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        i = j;
        if (j == 0)
        {
            i = 0x7f0b0037;
        }
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Inbox</font>"));
        bundle = (TextView)findViewById(i);
        bundle.setSelected(true);
        bundle.setTextColor(Color.parseColor("#FFFFFF"));
        bundle.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040009);
        animFadeout = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04000a);
        bundle = getSharedPreferences("notif_count_file", 2).edit();
        bundle.putString("notif_count", "0");
        bundle.putString("notif_id", "0");
        bundle.apply();
        cm = (ConnectivityManager)getSystemService("connectivity");
        netInfo = cm.getActiveNetworkInfo();
        extras = getIntent().getExtras();
        id_msg = extras.getString("");
        id_from = extras.getString("id_from");
        from_name = extras.getString("from_name");
        from_photo = extras.getString("from_photo");
        id_to = extras.getString("id_to");
        to_name = extras.getString("to_name");
        to_photo = extras.getString("to_photo");
        id_send_to = extras.getString("id_to");
        t = Utility.session(t);
        Log.e("id_from", id_from);
        Log.e("id_to", id_to);
        Log.e("id_send_to", id_send_to);
        getSherlock().setProgressBarIndeterminateVisibility(true);
        getSherlock().setProgressBarVisibility(true);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        bundle = LayoutInflater.from(this).inflate(0x7f03006a, null);
        getSupportActionBar().setCustomView(bundle);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        t = Utility.session(t);
        img_user_picture = (ImageView)bundle.findViewById(0x7f0b0418);
        ll_UserBack = (LinearLayout)bundle.findViewById(0x7f0b0417);
        txtUsername = (TextView)bundle.findViewById(0x7f0b0419);
        txtLastSeen = (TextView)bundle.findViewById(0x7f0b041a);
        lay_button_send = (RelativeLayout)findViewById(0x7f0b04dd);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        edt_pop_komen = (DroidWriterEditText)findViewById(0x7f0b04de);
        pop_txtCountKomen = (TextView)findViewById(0x7f0b04df);
        btn_send_komen = (Button)findViewById(0x7f0b04e0);
        progbar_send = (SmoothProgressBar)findViewById(0x7f0b06b1);
        progbar_send.setVisibility(8);
        progressbar_item = (ProgressBar)bundle.findViewById(0x7f0b00b3);
        userFunctions = new UserFunctions();
        txtUsername.setText(from_name);
        layout_empty = (LinearLayout)findViewById(0x7f0b0091);
        progressbar_middle = (ProgressBar)findViewById(0x7f0b00ca);
        txt_empty = (TextView)findViewById(0x7f0b0093);
        listMessaging = (ListView)findViewById(0x7f0b06af);
        bundle = View.inflate(this, 0x7f030069, null);
        txt_OlderMessage = (TextView)bundle.findViewById(0x7f0b0416);
        txt_new_message = (TextView)findViewById(0x7f0b06b0);
        txt_new_message.setVisibility(8);
        txt_new_message.setSelected(true);
        layout_header_msg = (LinearLayout)bundle.findViewById(0x7f0b0413);
        txt_OlderMessage.setVisibility(8);
        layout_header_msg.setVisibility(8);
        listpMessageArrayList = new ArrayList();
        chatMsgAdapter = new ListChatMessageAdapter(this, 0x7f0300bf, listpMessageArrayList);
        listMessaging.addHeaderView(bundle);
        listMessaging.setAdapter(chatMsgAdapter);
        layoutInflater = (LayoutInflater)getBaseContext().getSystemService("layout_inflater");
        popupView = layoutInflater.inflate(0x7f03007c, null);
        popupWindow = new PopupWindow(popupView, -1, -1);
        popupWindow.setOutsideTouchable(true);
        popupOutside = (RelativeLayout)popupView.findViewById(0x7f0b0485);
        rl_share_camera = (RelativeLayout)popupView.findViewById(0x7f0b048e);
        rl_share_galleri = (RelativeLayout)popupView.findViewById(0x7f0b0491);
        rl_share_location = (RelativeLayout)popupView.findViewById(0x7f0b0494);
        layout_popup = (LinearLayout)findViewById(0x7f0b06ae);
        popupOutside.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
                popupWindow.dismiss();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        rl_share_camera.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                imm = (InputMethodManager)getSystemService("input_method");
                imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                takePicture();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        rl_share_location.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/inponsel/android/v2/MessageLocationActivity);
                view.putExtra("id_msg", id_msg);
                view.putExtra("id_from", id_from);
                view.putExtra("from_name", from_name);
                view.putExtra("from_photo", from_photo);
                view.putExtra("id_to", id_to);
                view.putExtra("to_name", to_name);
                view.putExtra("to_photo", to_photo);
                view.putExtra("last_message", last_message);
                view.putExtra("message_type", message_type);
                view.putExtra("unread_msg", unread_msg);
                view.putExtra("msg_date", msg_date);
                view.putExtra("bottom_id", bottom_id);
                startActivityForResult(view, 0);
                overridePendingTransition(0x7f040003, 0x7f040004);
                popupWindow.dismiss();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        rl_share_galleri.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
                popupWindow.dismiss();
                imm = (InputMethodManager)getSystemService("input_method");
                imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
                mFileTemp = createFolders();
                mFileTemp = getNextFileName();
                openGallery();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        btn_send_komen.setEnabled(false);
        edt_pop_komen.addTextChangedListener(new TextWatcher() {

            final MessageActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                komencount = edt_pop_komen.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                komencount = edt_pop_komen.getText().toString();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int k, int l, int i1)
            {
                komencount = edt_pop_komen.getText().toString();
                if (edt_pop_komen.getText().toString().trim().length() == 0)
                {
                    btn_send_komen.setEnabled(false);
                    pop_txtCountKomen.setText("512");
                    return;
                }
                btn_send_komen.setEnabled(true);
                charCount = 512 - edt_pop_komen.getText().toString().length();
                pop_txtCountKomen.setText(String.valueOf(charCount));
                if (charCount < 0)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                }
                if (charCount > 0 && charCount < 4)
                {
                    btn_send_komen.setEnabled(false);
                    return;
                } else
                {
                    btn_send_komen.setEnabled(true);
                    return;
                }
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        btn_send_komen.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    Log.e("id_from", id_from);
                    Log.e("id_to", id_to);
                    edt_pop_komen.requestFocus();
                    edt_pop_komen.setFocusable(true);
                    SendMessage(id_from, id_to, URLEncoder.encode(edt_pop_komen.getText().toString(), "utf-8"), t, bottom_id);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        ll_UserBack.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        if (db.getMSGCount() > 0)
        {
            listpMessageArrayList = loadInboxDB("last");
            chatMsgAdapter = new ListChatMessageAdapter(this, 0x7f0300bf, listpMessageArrayList);
            listMessaging.setAdapter(chatMsgAdapter);
            scrollMyListViewToBottom();
            hideProgressDialog();
            if (netInfo != null)
            {
                netInfo.isConnected();
            }
        }
        scrollMyListViewToBottom();
        txt_OlderMessage.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
                if (netInfo != null && netInfo.isConnected())
                {
                    Log.e("GetOlderMessage", "online");
                    GetOlderMessage(id_from, id_to, t, top_id);
                    return;
                } else
                {
                    Log.e("GetOlderMessage", "offline");
                    listpMessageArrayList = loadInboxDB("older");
                    chatMsgAdapter.notifyDataSetChanged();
                    return;
                }
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        listMessaging.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final MessageActivity this$0;

            public void onScroll(AbsListView abslistview, int k, int l, int i1)
            {
                if (k + l == i1)
                {
                    if (txt_new_message.getVisibility() != 8)
                    {
                        txt_new_message.startAnimation(animFadeout);
                    }
                    txt_new_message.setVisibility(8);
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int k)
            {
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        txt_new_message.setOnClickListener(new android.view.View.OnClickListener() {

            final MessageActivity this$0;

            public void onClick(View view)
            {
                scrollMyListViewToBottom();
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
        Picasso.with(this).load((new StringBuilder(String.valueOf(url_thumb))).append(from_photo).toString()).into(img_user_picture, new Callback() {

            final MessageActivity this$0;

            public void onError()
            {
                img_user_picture.setImageResource(0x7f020297);
            }

            public void onSuccess()
            {
            }

            
            {
                this$0 = MessageActivity.this;
                super();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0012, menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        stopTask();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return super.onKeyDown(i, keyevent);

        case 82: // 'R'
            break;
        }
        if (mDrawerLayout.isDrawerOpen(0x800003))
        {
            mDrawerLayout.closeDrawers();
        } else
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            mDrawerLayout.openDrawer(0x800003);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            mDrawerToggle.onOptionsItemSelected(menuitem);
            imm.hideSoftInputFromWindow(edt_pop_komen.getWindowToken(), 0);
            return true;

        case 2131429689: 
            break;
        }
        if (popupWindow.isShowing() || pop_show.equals("1"))
        {
            Log.e("show", "show");
            popupWindow.dismiss();
            pop_show = "0";
            return true;
        } else
        {
            pop_show = "1";
            Log.e("dis", "dis");
            popupWindow.showAsDropDown(layout_popup, 40, -10);
            return true;
        }
    }

    protected void onPause()
    {
        super.onPause();
        stopTask();
    }

    protected void onResume()
    {
        super.onResume();
        starttask();
    }

    void parseJSON(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        listpMessageArrayList = new ArrayList();
        s = jsonobject.getJSONArray("InPonsel");
        url_thumb = jsonobject.getString("url_thumb");
        top_id = jsonobject.getString("top_id");
        bottom_id = jsonobject.getString("bottom_id");
        last_seen = jsonobject.getString("last_seen");
        online_stat = jsonobject.getString("online");
        Log.e("top_id", top_id);
        Log.e("bottom_id", bottom_id);
        chat_avaible = jsonobject.getString("success");
        if (jsonobject.getString("success").equals("0"))
        {
            break MISSING_BLOCK_LABEL_505;
        }
        int i = 0;
_L2:
        if (i >= s.length())
        {
            return;
        }
        JSONObject jsonobject1 = s.getJSONObject(i);
        ListModel listmodel = new ListModel();
        listmodel.setId_msg(jsonobject1.getString("id"));
        listmodel.setId_from(jsonobject1.getString("id_from"));
        listmodel.setFrom_name(jsonobject1.getString("from_name"));
        listmodel.setFrom_photo(jsonobject1.getString("from_photo"));
        listmodel.setId_to(jsonobject1.getString("id_to"));
        listmodel.setTo_name(jsonobject1.getString("to_name"));
        listmodel.setTo_photo(jsonobject1.getString("to_photo"));
        listmodel.setLast_message(jsonobject1.getString("message"));
        listmodel.setExt(jsonobject1.getString("ext"));
        listmodel.setKordinat(jsonobject1.getString("ext").substring(jsonobject1.getString("ext").lastIndexOf("Intele%7C") + 1).replace("ntele%7C", ""));
        listmodel.setMessage_type(jsonobject1.getString("message_type"));
        listmodel.setMsg_date(jsonobject1.getString("post_date"));
        listmodel.setMe_message(jsonobject1.getString("me"));
        listmodel.setUrl_thumb(url_thumb);
        listmodel.setImg_height(jsonobject1.getString("height"));
        listmodel.setImg_width(jsonobject1.getString("width"));
        if (!db.checkMSGIfExist(jsonobject1.getString("id")))
        {
            db.addMSG(jsonobject1.getString("id"), jsonobject1.getString("id_from"), jsonobject1.getString("from_name"), jsonobject1.getString("from_photo"), jsonobject1.getString("id_to"), jsonobject1.getString("to_name"), jsonobject1.getString("to_photo"), jsonobject1.getString("message"), jsonobject1.getString("ext"), jsonobject1.getString("message_type"), last_seen, jsonobject1.getString("me"), jsonobject1.getString("post_date"), jsonobject1.getString("width"), jsonobject1.getString("height"));
        }
        listpMessageArrayList.add(listmodel);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s.printStackTrace();
    }


















}
