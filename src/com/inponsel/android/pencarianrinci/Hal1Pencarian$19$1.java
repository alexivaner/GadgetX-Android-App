// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian

class this._cls1
    implements android.content.lickListener
{

    final ncVideoRecorder this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 47
    //                   1 80
    //                   2 113
    //                   3 146
    //                   4 179
    //                   5 212;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        dialoginterface.dismiss();
        return;
_L2:
        btnPencVideoRecorder.setText(video_hp[0]);
        Hal1Pencarian.strPencVideoRecorder = "nil";
        continue; /* Loop/switch isn't completed */
_L3:
        btnPencVideoRecorder.setText(video_hp[1]);
        Hal1Pencarian.strPencVideoRecorder = "1";
        continue; /* Loop/switch isn't completed */
_L4:
        btnPencVideoRecorder.setText(video_hp[2]);
        Hal1Pencarian.strPencVideoRecorder = "2";
        continue; /* Loop/switch isn't completed */
_L5:
        btnPencVideoRecorder.setText(video_hp[3]);
        Hal1Pencarian.strPencVideoRecorder = "720";
        continue; /* Loop/switch isn't completed */
_L6:
        btnPencVideoRecorder.setText(video_hp[4]);
        Hal1Pencarian.strPencVideoRecorder = "1080";
        continue; /* Loop/switch isn't completed */
_L7:
        btnPencVideoRecorder.setText(video_hp[5]);
        Hal1Pencarian.strPencVideoRecorder = "2160";
        if (true) goto _L1; else goto _L8
_L8:
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$19

/* anonymous class */
    class Hal1Pencarian._cls19
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setTitle("Pilih Video Recorder :");
            view.setSingleChoiceItems(video_hp, -1, new Hal1Pencarian._cls19._cls1());
            view.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }
    }

}
