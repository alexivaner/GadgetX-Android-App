// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls1
    implements android.content.ckListener
{

    final er this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    l.email()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$33

/* anonymous class */
    class ProfileActivity._cls33
        implements com.android.volley.Response.Listener
    {

        final ProfileActivity this$0;
        private final String val$email;

        public volatile void onResponse(Object obj)
        {
            onResponse((JSONObject)obj);
        }

        public void onResponse(JSONObject jsonobject)
        {
            JSONObject jsonobject2;
            int i;
            try
            {
                JSONObject jsonobject1 = new JSONObject(jsonobject.toString());
                Log.e("UpdateEmail", jsonobject.toString());
                jsonobject = jsonobject1.getJSONArray("InPonsel");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                return;
            }
            i = 0;
            if (i >= jsonobject.length())
            {
                jsonobject = new android.app.AlertDialog.Builder(ProfileActivity.this);
                jsonobject.setTitle("Perhatian");
                jsonobject.setMessage(message);
                jsonobject.setPositiveButton("OK", new ProfileActivity._cls33._cls1());
                jsonobject.show();
                ProfileActivity.access$16(ProfileActivity.this, email, gen_key);
                return;
            }
            jsonobject2 = jsonobject.getJSONObject(i);
            success = jsonobject2.getString("success");
            message = jsonobject2.getString("message");
            gen_key = jsonobject2.getString("gen_key");
            i++;
            if (false)
            {
            } else
            {
                break MISSING_BLOCK_LABEL_30;
            }
        }

            
            {
                this$0 = final_profileactivity;
                email = String.this;
                super();
            }
    }

}
