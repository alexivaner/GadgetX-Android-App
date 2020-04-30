// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.StrictMode;
import android.text.format.DateFormat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import com.inponsel.android.adapter.ListAdapter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.inponsel.android.utils:
//            Log, Base64

public class Utility
{

    public static String BASE_FORMAT = ".php";
    public static String GA_UID = "UA-39928332-1";
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    static Activity context;

    public Utility()
    {
    }

    public static float aspectratio(float f, float f1)
    {
        if (f >= f1)
        {
            f2 = f;
            f = f1;
            f1 = f2;
        }
        f1 %= f;
        do
        {
            float f2 = f;
            if (f1 <= 0.0F)
            {
                return f2;
            }
            f = f1;
            f1 = f2 % f;
        } while (true);
    }

    public static boolean connectGoogle()
    {
        boolean flag = false;
        int i;
        try
        {
            StrictMode.setThreadPolicy((new android.os.StrictMode.ThreadPolicy.Builder()).permitAll().build());
            HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL("http://www.google.com")).openConnection();
            httpurlconnection.setRequestProperty("User-Agent", "Test");
            httpurlconnection.setRequestProperty("Connection", "close");
            httpurlconnection.setConnectTimeout(10000);
            httpurlconnection.connect();
            i = httpurlconnection.getResponseCode();
        }
        catch (IOException ioexception)
        {
            Log.e("eror", "IOException in connectGoogle())");
            return false;
        }
        if (i == 200)
        {
            flag = true;
        }
        return flag;
    }

    public static String convertDate(String s)
    {
        Object obj;
label0:
        {
            obj = Calendar.getInstance();
            int i = ((Calendar) (obj)).get(1);
            int j = ((Calendar) (obj)).get(2);
            int k = ((Calendar) (obj)).get(5);
            Date date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(s);
            new SimpleDateFormat("dd MMMM yyyy HH:mm");
            obj = new SimpleDateFormat("yyyy-MM-dd");
            Object obj1 = ((SimpleDateFormat) (obj)).format(date);
            String s1 = (new StringBuilder(String.valueOf(String.valueOf(i)))).append("-").append(String.valueOf(j + 1)).append("-").append(String.valueOf(k)).toString();
            obj1 = ((SimpleDateFormat) (obj)).parse(((String) (obj1)));
            if (((Date) (obj1)).equals(((SimpleDateFormat) (obj)).parse(s1)))
            {
                obj = new SimpleDateFormat("HH:mm", Locale.US);
            } else
            {
                if (!((String)DateFormat.format("yyyy", ((Date) (obj1)))).equals(String.valueOf(i)))
                {
                    break label0;
                }
                obj = new SimpleDateFormat("dd MMMM, HH:mm", Locale.US);
            }
        }
_L1:
        return ((SimpleDateFormat) (obj)).format(date).replace("January", "Jan").replace("February", "Feb").replace("March", "Mar").replace("April", "Apr").replace("May", "Mei").replace("June", "Jun").replace("July", "Jul").replace("August", "Ags").replace("September", "Sep").replace("October", "Okt").replace("November", "Nov").replace("December", "Des");
        try
        {
            obj = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.US);
        }
        catch (ParseException parseexception)
        {
            parseexception.printStackTrace();
            return s;
        }
          goto _L1
    }

    public static String convertDateUnix(String s)
    {
        Object obj;
label0:
        {
            obj = Calendar.getInstance();
            int i = ((Calendar) (obj)).get(1);
            int j = ((Calendar) (obj)).get(2);
            int k = ((Calendar) (obj)).get(5);
            Date date = new Date(Long.parseLong(s) * 1000L);
            new SimpleDateFormat("dd MMMM yyyy HH:mm");
            obj = new SimpleDateFormat("yyyy-MM-dd");
            Object obj1 = ((SimpleDateFormat) (obj)).format(date);
            String s1 = (new StringBuilder(String.valueOf(String.valueOf(i)))).append("-").append(String.valueOf(j + 1)).append("-").append(String.valueOf(k)).toString();
            obj1 = ((SimpleDateFormat) (obj)).parse(((String) (obj1)));
            if (((Date) (obj1)).equals(((SimpleDateFormat) (obj)).parse(s1)))
            {
                obj = new SimpleDateFormat("HH:mm", Locale.US);
            } else
            {
                if (!((String)DateFormat.format("yyyy", ((Date) (obj1)))).equals(String.valueOf(i)))
                {
                    break label0;
                }
                obj = new SimpleDateFormat("dd MMMM, HH:mm", Locale.US);
            }
        }
_L1:
        return ((SimpleDateFormat) (obj)).format(date).replace("January", "Jan").replace("February", "Feb").replace("March", "Mar").replace("April", "Apr").replace("May", "Mei").replace("June", "Jun").replace("July", "Jul").replace("August", "Ags").replace("September", "Sep").replace("October", "Okt").replace("November", "Nov").replace("December", "Des");
        try
        {
            obj = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.US);
        }
        catch (ParseException parseexception)
        {
            parseexception.printStackTrace();
            return s;
        }
          goto _L1
    }

    public static String convertDateYMD(String s)
    {
        Object obj;
label0:
        {
            obj = Calendar.getInstance();
            int i = ((Calendar) (obj)).get(1);
            int j = ((Calendar) (obj)).get(2);
            int k = ((Calendar) (obj)).get(5);
            Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse(s);
            new SimpleDateFormat("dd MMMM yyyy");
            obj = new SimpleDateFormat("yyyy-MM-dd");
            Object obj1 = ((SimpleDateFormat) (obj)).format(date);
            String s1 = (new StringBuilder(String.valueOf(String.valueOf(i)))).append("-").append(String.valueOf(j + 1)).append("-").append(String.valueOf(k)).toString();
            obj1 = ((SimpleDateFormat) (obj)).parse(((String) (obj1)));
            if (((Date) (obj1)).equals(((SimpleDateFormat) (obj)).parse(s1)))
            {
                obj = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
            } else
            {
                if (!((String)DateFormat.format("yyyy", ((Date) (obj1)))).equals(String.valueOf(i)))
                {
                    break label0;
                }
                obj = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
            }
        }
_L1:
        return ((SimpleDateFormat) (obj)).format(date).replace("January", "Jan").replace("February", "Feb").replace("March", "Mar").replace("April", "Apr").replace("May", "Mei").replace("June", "Jun").replace("July", "Jul").replace("August", "Ags").replace("September", "Sep").replace("October", "Okt").replace("November", "Nov").replace("December", "Des");
        try
        {
            obj = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
        }
        catch (ParseException parseexception)
        {
            parseexception.printStackTrace();
            return s;
        }
          goto _L1
    }

    public static float convertDpToPixel(float f, Context context1)
    {
        return f * ((float)context1.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static float convertPixelsToDp(float f, Context context1)
    {
        return f / ((float)context1.getResources().getDisplayMetrics().densityDpi / 160F);
    }

    public static void deleteCache(Context context1)
    {
        try
        {
            context1 = context1.getCacheDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            return;
        }
        if (context1 == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        if (context1.isDirectory())
        {
            deleteDir(context1);
        }
    }

    public static boolean deleteDir(File file)
    {
        if (file == null || !file.isDirectory()) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        as = file.list();
        i = 0;
_L5:
        if (i < as.length) goto _L3; else goto _L2
_L2:
        return file.delete();
_L3:
        if (!deleteDir(new File(file, as[i])))
        {
            return false;
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static int dpToPx(int i)
    {
        return (int)((float)i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getBmapHeight(Context context1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)context1).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int j = displaymetrics.heightPixels;
        int k = displaymetrics.widthPixels;
        int i = displaymetrics.densityDpi;
        float f;
        float f1;
        float f2;
        float f3;
        if (i == 640)
        {
            i = 50;
        } else
        if (i == 480)
        {
            i = 50;
        } else
        if (i == 320)
        {
            i = 50;
        } else
        if (i == 240)
        {
            i = 43;
        } else
        if (i == 160)
        {
            i = 30;
        } else
        if (i == 120)
        {
            i = 21;
        } else
        {
            i = 0;
        }
        Log.e("minheight", String.valueOf(i));
        f3 = 625 - i;
        f1 = (float)k / 1200F;
        f2 = (float)j / f3;
        f = f1;
        if (f2 < f1)
        {
            f = f2;
        }
        return (int)(f3 * f);
    }

    public static int getBmapHeightNoMar(Context context1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)context1).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = displaymetrics.heightPixels;
        int j = displaymetrics.widthPixels;
        int k = displaymetrics.densityDpi;
        float f;
        float f1;
        float f2;
        float f3;
        char c;
        if (k == 640)
        {
            c = '2';
        } else
        if (k == 480)
        {
            c = '2';
        } else
        if (k == 320)
        {
            c = '2';
        } else
        if (k == 240)
        {
            c = '+';
        } else
        if (k == 160)
        {
            c = '\036';
        } else
        if (k == 160 && (context1.getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            c = '\202';
        } else
        if (k == 120)
        {
            c = '\025';
        } else
        {
            c = '\0';
        }
        Log.e("minheight", String.valueOf(c));
        if (k == 160 && (context1.getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            f = 350F;
        } else
        {
            f = 625 - c;
        }
        f2 = (float)j / 1200F;
        f3 = (float)i / f;
        f1 = f2;
        if (f3 < f2)
        {
            f1 = f3;
        }
        return (int)(f * f1);
    }

    public static int getBmapWidth(Context context1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)context1).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = displaymetrics.heightPixels;
        float f1 = (float)displaymetrics.widthPixels / 1200F;
        float f2 = (float)i / 600F;
        float f = f1;
        if (f2 < f1)
        {
            f = f2;
        }
        return (int)(1200F * f);
    }

    public static int getBmapWidthNoMar(Context context1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Activity)context1).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int i = displaymetrics.heightPixels;
        float f1 = (float)displaymetrics.widthPixels / 1200F;
        float f2 = (float)i / 625F;
        float f = f1;
        if (f2 < f1)
        {
            f = f2;
        }
        return (int)(1200F * f);
    }

    public static int getHeight(Context context1)
    {
        context1 = ((WindowManager)context1.getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT > 12)
        {
            Point point = new Point();
            context1.getSize(point);
            return point.y;
        } else
        {
            return context1.getHeight();
        }
    }

    public static int getWidth(Context context1)
    {
        context1 = ((WindowManager)context1.getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT > 12)
        {
            Point point = new Point();
            context1.getSize(point);
            return point.x;
        } else
        {
            return context1.getWidth();
        }
    }

    public static boolean hasActiveInternetConnection(Context context1)
    {
        if (isNetworkAvailable(context1))
        {
            return true;
        } else
        {
            Log.e("status", "No network available! (in hasActiveInternetConnection())");
            return false;
        }
    }

    public static boolean isNetworkAvailable(Context context1)
    {
        return ((ConnectivityManager)context1.getSystemService("connectivity")).getActiveNetworkInfo() != null;
    }

    public static boolean isTablet(Context context1)
    {
        boolean flag;
        boolean flag1;
        if ((context1.getResources().getConfiguration().screenLayout & 0xf) == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((context1.getResources().getConfiguration().screenLayout & 0xf) == 3)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag || flag1;
    }

    public static boolean isTabletMDPI(Context context1)
    {
label0:
        {
            boolean flag4 = false;
            int i = context1.getResources().getDisplayMetrics().densityDpi;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if ((context1.getResources().getConfiguration().screenLayout & 0xf) == 4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if ((context1.getResources().getConfiguration().screenLayout & 0xf) == 3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (i == 160)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (!flag)
            {
                flag3 = flag4;
                if (!flag1)
                {
                    break label0;
                }
            }
            flag3 = flag4;
            if (flag2)
            {
                flag3 = true;
            }
        }
        return flag3;
    }

    public static boolean isXXHDPI(Context context1)
    {
        return context1.getResources().getDisplayMetrics().densityDpi == 480;
    }

    public static String nextsession(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-16");
            s = s.getBytes();
            messagedigest.update(s, 0, s.length);
            s = (new BigInteger(3, messagedigest.digest())).toString(16);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static String parseTweet(String s)
    {
        Matcher matcher = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]").matcher(s);
_L5:
        if (matcher.find()) goto _L2; else goto _L1
_L1:
        matcher = Pattern.compile("(?:\\s|\\A)[##]+([A-Za-z0-9-_]+)").matcher(s);
_L6:
        if (matcher.find()) goto _L4; else goto _L3
_L3:
        matcher = Pattern.compile("(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)").matcher(s);
_L7:
        if (!matcher.find())
        {
            return s;
        }
        break MISSING_BLOCK_LABEL_190;
_L2:
        String s1 = matcher.group().replace(" ", "");
        String s4 = s1.replace("http", "http");
        s = s.replace(s1, (new StringBuilder("<a href='")).append(s4).append("'>").append(s1).append("</a>").toString());
          goto _L5
_L4:
        String s2 = matcher.group().replace(" ", "");
        String s5 = s2.replace("#", "");
        s = s.replace(s2, (new StringBuilder("<a href='https://twitter.com/search?q=")).append(s5).append("'>").append(s2).append("</a>").toString());
          goto _L6
        String s3 = matcher.group().replace(" ", "");
        String s6 = s3.replace("@", "");
        s = s.replace(s3, (new StringBuilder("<a href='https://twitter.com/")).append(s6).append("'>").append(s3).append("</a>").toString());
          goto _L7
    }

    public static String parseUrl(String s)
    {
        Matcher matcher = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]").matcher(s);
        do
        {
            if (!matcher.find())
            {
                return s;
            }
            String s1 = matcher.group().replace(" ", "");
            String s2 = s1.replace("http", "http");
            s = s.replace(s1, (new StringBuilder("<a href='")).append(s2).append("'>").append(s1).append("</a>").toString());
        } while (true);
    }

    public static int pxToDp(int i)
    {
        return (int)((float)i / Resources.getSystem().getDisplayMetrics().density);
    }

    public static void removeMSGNotif(Context context1, int i)
    {
        ((NotificationManager)context1.getSystemService("notification")).cancel(i);
    }

    public static double screen_inch(Activity activity)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float f1 = displaymetrics.xdpi;
        float f = displaymetrics.ydpi;
        int i = displaymetrics.widthPixels;
        int j = displaymetrics.heightPixels;
        f1 = (float)i / f1;
        f = (float)j / f;
        double d = Math.sqrt(f1 * f1 + f * f);
        if (d >= 10D)
        {
            Log.e("diagonalInches", String.valueOf(d));
            return d;
        }
        if (d >= 7D)
        {
            Log.e("diagonalInches", String.valueOf(d));
            return d;
        } else
        {
            Log.e("diagonalInches", String.valueOf(d));
            return d;
        }
    }

    public static String session(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            s = s.getBytes();
            messagedigest.update(s, 0, s.length);
            s = (new BigInteger(1, messagedigest.digest())).toString(16);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static void setListViewHeightBasedOnChildren(ListView listview)
    {
        ListAdapter listadapter = (ListAdapter)listview.getAdapter();
        if (listadapter == null)
        {
            return;
        }
        int j = 0;
        int k = android.view.View.MeasureSpec.makeMeasureSpec(listview.getWidth(), 0x80000000);
        int i = 0;
        do
        {
            if (i >= listadapter.getCount())
            {
                android.view.ViewGroup.LayoutParams layoutparams = listview.getLayoutParams();
                layoutparams.height = listview.getDividerHeight() * (listadapter.getCount() - 1) + j;
                listview.setLayoutParams(layoutparams);
                listview.requestLayout();
                return;
            }
            View view = listadapter.getView(i, null, listview);
            view.measure(k, 0);
            j += view.getMeasuredHeight();
            i++;
        } while (true);
    }

    public static void show_dialog(final Activity ct)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(ct);
        builder.setTitle("Perhatian");
        builder.setMessage("Tidak ada koneksi internet.");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            private final Activity val$ct;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                ct.finish();
            }

            
            {
                ct = activity;
                super();
            }
        });
        builder.show();
    }

    public static String toSlug(String s)
    {
        s = Normalizer.normalize(WHITESPACE.matcher(s).replaceAll("-"), java.text.Normalizer.Form.NFD);
        return NONLATIN.matcher(s).replaceAll("").toLowerCase(Locale.ENGLISH);
    }

    public String BitMapToString(Bitmap bitmap)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        return Base64.encodeToString(bytearrayoutputstream.toByteArray(), 0);
    }

    public Bitmap StringToBitMap(String s)
    {
        try
        {
            s = Base64.decode(s, 0);
            s = BitmapFactory.decodeByteArray(s, 0, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
            return null;
        }
        return s;
    }

}
