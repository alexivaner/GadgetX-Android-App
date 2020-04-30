// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.v2.LoginActivity;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.details:
//            Hal2Spek

class this._cls1
    implements android.content.e.OnClickListener
{

    final ener this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/details/Hal2Spek$33

/* anonymous class */
    class Hal2Spek._cls33
        implements android.view.View.OnClickListener
    {

        final Hal2Spek this$0;

        public void onClick(final View dialog)
        {
            if (userFunction.isUserLoggedIn(getActivity()))
            {
                dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(1);
                dialog.setCancelable(true);
                dialog.setContentView(0x7f03001b);
                lineColor = (LinearLayout)dialog.findViewById(0x7f0b0065);
                lineColor.setBackgroundColor(getResources().getColor(0x7f080044));
                txtCountKomen = (TextView)dialog.findViewById(0x7f0b0067);
                edtUser = (EditText)dialog.findViewById(0x7f0b0064);
                edtUser.setText(username);
                edtComment = (EditText)dialog.findViewById(0x7f0b0066);
                btnSubmit = (Button)dialog.findViewById(0x7f0b0069);
                btnCancel = (Button)dialog.findViewById(0x7f0b0068);
                btnCancel.setOnClickListener(new Hal2Spek._cls33._cls1());
                edtComment.addTextChangedListener(new Hal2Spek._cls33._cls2());
                btnSubmit.setOnClickListener(new Hal2Spek._cls33._cls3());
                dialog.show();
                return;
            } else
            {
                dialog = new android.app.AlertDialog.Builder(wrapper);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Untuk memberi komentar anda harus login terlebih dahulu");
                dialog.setPositiveButton("Login", new Hal2Spek._cls33._cls4());
                dialog.setNeutralButton("Register", new Hal2Spek._cls33._cls5());
                dialog.setNegativeButton("Tutup", new Hal2Spek._cls33._cls6());
                dialog.show();
                return;
            }
        }


            
            {
                this$0 = Hal2Spek.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$33$1

/* anonymous class */
        class Hal2Spek._cls33._cls1
            implements android.view.View.OnClickListener
        {

            final Hal2Spek._cls33 this$1;
            private final Dialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
                ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

                    
                    {
                        this$1 = Hal2Spek._cls33.this;
                        dialog = dialog1;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$33$2

/* anonymous class */
        class Hal2Spek._cls33._cls2
            implements TextWatcher
        {

            final Hal2Spek._cls33 this$1;

            public void afterTextChanged(Editable editable)
            {
                if (edtUser.getText().toString().length() == 0 || edtComment.getText().toString().length() == 0 || edtComment.getText().toString().trim().equals(""))
                {
                    btnSubmit.setEnabled(false);
                    txtCountKomen.setText("512");
                    return;
                } else
                {
                    btnSubmit.setEnabled(true);
                    charCount = 512 - edtComment.getText().toString().length();
                    txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (edtUser.getText().toString().length() == 0 || edtComment.getText().toString().length() == 0 || edtComment.getText().toString().trim().equals(""))
                {
                    btnSubmit.setEnabled(false);
                    txtCountKomen.setText("512");
                    return;
                } else
                {
                    btnSubmit.setEnabled(true);
                    charCount = 512 - edtComment.getText().toString().length();
                    txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (edtUser.getText().toString().length() == 0 || edtComment.getText().toString().length() == 0 || edtComment.getText().toString().trim().equals(""))
                {
                    btnSubmit.setEnabled(false);
                    txtCountKomen.setText("512");
                    return;
                } else
                {
                    btnSubmit.setEnabled(true);
                    charCount = 512 - edtComment.getText().toString().length();
                    txtCountKomen.setText(String.valueOf(charCount));
                    return;
                }
            }

                    
                    {
                        this$1 = Hal2Spek._cls33.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$33$3

/* anonymous class */
        class Hal2Spek._cls33._cls3
            implements android.view.View.OnClickListener
        {

            final Hal2Spek._cls33 this$1;
            private final Dialog val$dialog;

            public void onClick(View view)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal2Spek.PostKomen(this$0)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                } else
                {
                    (new Hal2Spek.PostKomen(this$0)).execute(new Void[0]);
                }
                dialog.dismiss();
            }

                    
                    {
                        this$1 = Hal2Spek._cls33.this;
                        dialog = dialog1;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$33$4

/* anonymous class */
        class Hal2Spek._cls33._cls4
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls33 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/LoginActivity);
                getActivity().startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls33.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/details/Hal2Spek$33$5

/* anonymous class */
        class Hal2Spek._cls33._cls5
            implements android.content.DialogInterface.OnClickListener
        {

            final Hal2Spek._cls33 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = new Intent(getActivity(), com/inponsel/android/v2/RegisterActivity);
                getActivity().startActivityForResult(dialoginterface, 0);
                getActivity().overridePendingTransition(0x7f040003, 0x7f040004);
            }

                    
                    {
                        this$1 = Hal2Spek._cls33.this;
                        super();
                    }
        }

    }

}
