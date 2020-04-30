// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ScreenshootAdapter;
import com.inponsel.android.pencariangen.TabPencarian;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.HorizontalListView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            ImagePagerActivity

public class DetailAppsStore extends SherlockFragmentActivity
{

    String allcount;
    String appcover;
    String applastupdate;
    String appname;
    String apppackage;
    String appsize;
    String appurl;
    String appversion;
    String author;
    String avgrate;
    Button btn_apps_install;
    String category;
    String changelog;
    String contentrate;
    String desc;
    String developeraddr;
    String developeremail;
    String developerwebsite;
    String downloadcount;
    Bundle extras;
    String fivecount;
    String fourcount;
    String image[];
    ArrayList imgArray;
    String imgUrlFull;
    ImageView img_apps;
    ImageView img_det_apps;
    String lastupd;
    HorizontalListView listGalleryApps;
    String minandroidver;
    String onecount;
    ProgressBar prog_img_apps;
    ProgressBar progbar_1_star;
    ProgressBar progbar_2_star;
    ProgressBar progbar_3_star;
    ProgressBar progbar_4_star;
    ProgressBar progbar_5_star;
    RatingBar rbar_apps;
    ArrayList scpencarianArray;
    String screenshoot;
    ScreenshootAdapter screenshootAdapter;
    String threecount;
    String twocount;
    TextView txt_1_countuserrate;
    TextView txt_2_countuserrate;
    TextView txt_3_countuserrate;
    TextView txt_4_countuserrate;
    TextView txt_5_countuserrate;
    TextView txt_author_apps;
    TextView txt_bigrating_apps;
    TextView txt_details_apps;
    TextView txt_download_apps;
    TextView txt_lastupdate_apps;
    TextView txt_minversi_apps;
    TextView txt_new_apps;
    TextView txt_profiledeveloper_apps;
    TextView txt_ratingkonten_apps;
    TextView txt_size_apps;
    TextView txt_title_apps;
    TextView txt_total_userrate;
    TextView txt_version_apps;

    public DetailAppsStore()
    {
        scpencarianArray = null;
        imgArray = null;
        imgUrlFull = "";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03012d);
        extras = getIntent().getExtras();
        apppackage = extras.getString("apppackage");
        appname = extras.getString("appname");
        author = extras.getString("author");
        category = extras.getString("category");
        lastupd = extras.getString("lastupd");
        avgrate = extras.getString("avgrate").replace(",", ".");
        fivecount = extras.getString("fivecount");
        fourcount = extras.getString("fourcount");
        threecount = extras.getString("threecount");
        twocount = extras.getString("twocount");
        onecount = extras.getString("onecount");
        allcount = extras.getString("allcount");
        desc = extras.getString("desc");
        changelog = extras.getString("changelog");
        appsize = extras.getString("appsize");
        downloadcount = extras.getString("downloadcount");
        appversion = extras.getString("appversion");
        developerwebsite = extras.getString("developerwebsite");
        developeremail = extras.getString("developeremail");
        developeraddr = extras.getString("developeraddr");
        minandroidver = extras.getString("minandroidver");
        contentrate = extras.getString("contentrate");
        appcover = extras.getString("appcover");
        applastupdate = extras.getString("applastupdate");
        appurl = extras.getString("appurl");
        screenshoot = extras.getString("screenshoot");
        Log.e("avgrate", avgrate);
        bundle = screenshoot.replace("\\", "").replace("\"", "").replace("[", "").replace("]", "").split(",");
        Log.e("scr_total", bundle[0]);
        img_det_apps = (ImageView)findViewById(0x7f0b0870);
        img_det_apps.setVisibility(8);
        img_apps = (ImageView)findViewById(0x7f0b0871);
        prog_img_apps = (ProgressBar)findViewById(0x7f0b085e);
        prog_img_apps.setVisibility(8);
        txt_title_apps = (TextView)findViewById(0x7f0b0872);
        txt_author_apps = (TextView)findViewById(0x7f0b0873);
        txt_details_apps = (TextView)findViewById(0x7f0b0878);
        txt_new_apps = (TextView)findViewById(0x7f0b0879);
        txt_lastupdate_apps = (TextView)findViewById(0x7f0b0897);
        txt_size_apps = (TextView)findViewById(0x7f0b0898);
        txt_download_apps = (TextView)findViewById(0x7f0b0899);
        txt_version_apps = (TextView)findViewById(0x7f0b089a);
        txt_minversi_apps = (TextView)findViewById(0x7f0b089b);
        txt_profiledeveloper_apps = (TextView)findViewById(0x7f0b089c);
        txt_ratingkonten_apps = (TextView)findViewById(0x7f0b089d);
        txt_bigrating_apps = (TextView)findViewById(0x7f0b087b);
        txt_total_userrate = (TextView)findViewById(0x7f0b087d);
        txt_5_countuserrate = (TextView)findViewById(0x7f0b0882);
        txt_4_countuserrate = (TextView)findViewById(0x7f0b0887);
        txt_3_countuserrate = (TextView)findViewById(0x7f0b088c);
        txt_2_countuserrate = (TextView)findViewById(0x7f0b0891);
        txt_1_countuserrate = (TextView)findViewById(0x7f0b0896);
        rbar_apps = (RatingBar)findViewById(0x7f0b087c);
        progbar_5_star = (ProgressBar)findViewById(0x7f0b0881);
        progbar_4_star = (ProgressBar)findViewById(0x7f0b0886);
        progbar_3_star = (ProgressBar)findViewById(0x7f0b088b);
        progbar_2_star = (ProgressBar)findViewById(0x7f0b0890);
        progbar_1_star = (ProgressBar)findViewById(0x7f0b0895);
        listGalleryApps = (HorizontalListView)findViewById(0x7f0b0876);
        scpencarianArray = new ArrayList();
        imgArray = new ArrayList();
        int i = 0;
        do
        {
            if (i >= bundle.length)
            {
                Log.e("scpenc", String.valueOf(scpencarianArray.size()));
                screenshootAdapter = new ScreenshootAdapter(this, 0x7f030142, scpencarianArray);
                listGalleryApps.setAdapter(screenshootAdapter);
                btn_apps_install = (Button)findViewById(0x7f0b0874);
                btn_apps_install.setOnClickListener(new android.view.View.OnClickListener() {

                    final DetailAppsStore this$0;

                    public void onClick(View view)
                    {
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appurl)));
                    }

            
            {
                this$0 = DetailAppsStore.this;
                super();
            }
                });
                txt_title_apps.setText(appname);
                txt_author_apps.setText(author);
                txt_details_apps.setText(desc);
                txt_new_apps.setText(changelog);
                txt_lastupdate_apps.setText(lastupd);
                txt_size_apps.setText(appsize);
                txt_download_apps.setText(downloadcount);
                txt_version_apps.setText(appversion);
                txt_minversi_apps.setText(minandroidver);
                txt_profiledeveloper_apps.setText((new StringBuilder("Email : ")).append(developeremail.replace("mailto:", "")).append("\nWebsite : ").append(developerwebsite).append("\nAlamat : ").append(developeraddr).toString());
                txt_ratingkonten_apps.setText(contentrate);
                Picasso.with(this).load(appcover.trim()).into(img_apps, new Callback() {

                    final DetailAppsStore this$0;

                    public void onError()
                    {
                    }

                    public void onSuccess()
                    {
                    }

            
            {
                this$0 = DetailAppsStore.this;
                super();
            }
                });
                txt_1_countuserrate.setText(onecount);
                txt_2_countuserrate.setText(twocount);
                txt_3_countuserrate.setText(threecount);
                txt_4_countuserrate.setText(fourcount);
                txt_5_countuserrate.setText(fivecount);
                txt_bigrating_apps.setText(avgrate);
                txt_total_userrate.setText((new StringBuilder("Total ")).append(allcount).toString());
                progbar_1_star.setMax(Integer.parseInt(allcount.replace(",", "").replace(".", "")));
                progbar_2_star.setMax(Integer.parseInt(allcount.replace(",", "").replace(".", "")));
                progbar_3_star.setMax(Integer.parseInt(allcount.replace(",", "").replace(".", "")));
                progbar_4_star.setMax(Integer.parseInt(allcount.replace(",", "").replace(".", "")));
                progbar_5_star.setMax(Integer.parseInt(allcount.replace(",", "").replace(".", "")));
                progbar_1_star.setProgress(Integer.parseInt(onecount.replace(",", "").replace(".", "")));
                progbar_2_star.setProgress(Integer.parseInt(twocount.replace(",", "").replace(".", "")));
                progbar_3_star.setProgress(Integer.parseInt(threecount.replace(",", "").replace(".", "")));
                progbar_4_star.setProgress(Integer.parseInt(fourcount.replace(",", "").replace(".", "")));
                progbar_5_star.setProgress(Integer.parseInt(fivecount.replace(",", "").replace(".", "")));
                rbar_apps.setRating(Float.parseFloat(avgrate));
                listGalleryApps.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final DetailAppsStore this$0;

                    public void onItemClick(AdapterView adapterview, View view, int j, long l)
                    {
                        adapterview = new Intent(DetailAppsStore.this, com/inponsel/android/v2/ImagePagerActivity);
                        adapterview.putExtra("imgUrl", image);
                        adapterview.putExtra("pos", j);
                        startActivity(adapterview);
                    }

            
            {
                this$0 = DetailAppsStore.this;
                super();
            }
                });
                return;
            }
            Log.e("arrayImg", bundle[i]);
            ListModel listmodel = new ListModel();
            listmodel.setImg_screen(bundle[i]);
            scpencarianArray.add(listmodel);
            imgUrlFull = bundle[i].replace("=h310", "");
            imgArray.add(imgUrlFull);
            image = new String[imgArray.size()];
            image = (String[])imgArray.toArray(image);
            i++;
        } while (true);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getSupportMenuInflater().inflate(0x7f0f0002, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return true;

        case 16908332: 
            finish();
            return true;

        case 2131429682: 
            startActivity(new Intent(getApplicationContext(), com/inponsel/android/pencariangen/TabPencarian));
            break;
        }
        return true;
    }
}
