// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal1PencPonsel

class this._cls0
    implements android.widget.ActionListener
{

    final Hal1PencPonsel this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (i != 3) goto _L2; else goto _L1
_L1:
        grup_header_footer.setVisibility(8);
        if (edtAuto.getText().toString().trim().length() != 0) goto _L4; else goto _L3
_L3:
        txt_empty.setText("Masukan ponsel yang ingin dicari");
        layout_empty.setVisibility(8);
        listPencarianHp.setVisibility(0);
_L9:
        flag = true;
_L2:
        return flag;
_L4:
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L6; else goto _L5
_L5:
        progressbar_middle.setVisibility(0);
        txt_empty.setText(0x7f0c0053);
        textview = edtAuto.getText().toString();
        keyevent = URLEncoder.encode(textview, "utf-8");
        textview = keyevent;
_L7:
        Log.e("key", textview);
        page = 0;
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_hp").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&kat=1").append("&key=").append(textview).append("&page=").append(page).append("&t=").append(t).toString();
        SearchTask();
        continue; /* Loop/switch isn't completed */
        keyevent;
        keyevent.printStackTrace();
        if (true) goto _L7; else goto _L6
_L6:
        Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
        if (true) goto _L9; else goto _L8
_L8:
    }

    w()
    {
        this$0 = Hal1PencPonsel.this;
        super();
    }
}
