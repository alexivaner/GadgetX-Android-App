// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.nostra13.universalimageloader.core.download:
//            ImageDownloader

public class BaseImageDownloader
    implements ImageDownloader
{

    private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[];
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    protected static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()
    {
        int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[ImageDownloader.Scheme.values().length];
        try
        {
            ai[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[ImageDownloader.Scheme.FILE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme = ai;
        return ai;
    }

    public BaseImageDownloader(Context context1)
    {
        this(context1, 5000, 20000);
    }

    public BaseImageDownloader(Context context1, int i, int j)
    {
        context = context1.getApplicationContext();
        connectTimeout = i;
        readTimeout = j;
    }

    private InputStream getVideoThumbnailStream(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            s = ThumbnailUtils.createVideoThumbnail(s, 2);
            if (s != null)
            {
                ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                s.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, bytearrayoutputstream);
                return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
            }
        }
        return null;
    }

    private boolean isVideoContentUri(Uri uri)
    {
        uri = context.getContentResolver().getType(uri);
        return uri != null && uri.startsWith("video/");
    }

    private boolean isVideoFileUri(String s)
    {
        s = MimeTypeMap.getFileExtensionFromUrl(s);
        s = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
        return s != null && s.startsWith("video/");
    }

    protected HttpURLConnection createConnection(String s, Object obj)
        throws IOException
    {
        s = (HttpURLConnection)(new URL(Uri.encode(s, "@#&=*+-_.,:!?()/~'%"))).openConnection();
        s.setConnectTimeout(connectTimeout);
        s.setReadTimeout(readTimeout);
        return s;
    }

    protected InputStream getContactPhotoStream(Uri uri)
    {
        ContentResolver contentresolver = context.getContentResolver();
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri, true);
        } else
        {
            return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri);
        }
    }

    public InputStream getStream(String s, Object obj)
        throws IOException
    {
        switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[ImageDownloader.Scheme.ofUri(s).ordinal()])
        {
        default:
            return getStreamFromOtherSource(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            return getStreamFromNetwork(s, obj);

        case 3: // '\003'
            return getStreamFromFile(s, obj);

        case 4: // '\004'
            return getStreamFromContent(s, obj);

        case 5: // '\005'
            return getStreamFromAssets(s, obj);

        case 6: // '\006'
            return getStreamFromDrawable(s, obj);
        }
    }

    protected InputStream getStreamFromAssets(String s, Object obj)
        throws IOException
    {
        s = ImageDownloader.Scheme.ASSETS.crop(s);
        return context.getAssets().open(s);
    }

    protected InputStream getStreamFromContent(String s, Object obj)
        throws FileNotFoundException
    {
        obj = context.getContentResolver();
        Uri uri = Uri.parse(s);
        if (isVideoContentUri(uri))
        {
            s = android.provider.MediaStore.Video.Thumbnails.getThumbnail(((ContentResolver) (obj)), Long.valueOf(uri.getLastPathSegment()).longValue(), 1, null);
            if (s != null)
            {
                obj = new ByteArrayOutputStream();
                s.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, ((java.io.OutputStream) (obj)));
                return new ByteArrayInputStream(((ByteArrayOutputStream) (obj)).toByteArray());
            }
        } else
        if (s.startsWith("content://com.android.contacts/"))
        {
            return getContactPhotoStream(uri);
        }
        return ((ContentResolver) (obj)).openInputStream(uri);
    }

    protected InputStream getStreamFromDrawable(String s, Object obj)
    {
        int i = Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(s));
        return context.getResources().openRawResource(i);
    }

    protected InputStream getStreamFromFile(String s, Object obj)
        throws IOException
    {
        obj = ImageDownloader.Scheme.FILE.crop(s);
        if (isVideoFileUri(s))
        {
            return getVideoThumbnailStream(((String) (obj)));
        } else
        {
            return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(((String) (obj))), 32768), (int)(new File(((String) (obj)))).length());
        }
    }

    protected InputStream getStreamFromNetwork(String s, Object obj)
        throws IOException
    {
        s = createConnection(s, obj);
        int i = 0;
        do
        {
            if (s.getResponseCode() / 100 != 3 || i >= 5)
            {
                try
                {
                    obj = s.getInputStream();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    IoUtils.readAndCloseStream(s.getErrorStream());
                    throw obj;
                }
                if (!shouldBeProcessed(s))
                {
                    IoUtils.closeSilently(((java.io.Closeable) (obj)));
                    throw new IOException((new StringBuilder("Image request failed with response code ")).append(s.getResponseCode()).toString());
                } else
                {
                    return new ContentLengthInputStream(new BufferedInputStream(((InputStream) (obj)), 32768), s.getContentLength());
                }
            }
            s = createConnection(s.getHeaderField("Location"), obj);
            i++;
        } while (true);
    }

    protected InputStream getStreamFromOtherSource(String s, Object obj)
        throws IOException
    {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] {
            s
        }));
    }

    protected boolean shouldBeProcessed(HttpURLConnection httpurlconnection)
        throws IOException
    {
        return httpurlconnection.getResponseCode() == 200;
    }
}
