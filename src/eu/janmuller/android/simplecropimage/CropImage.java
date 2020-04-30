// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package eu.janmuller.android.simplecropimage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package eu.janmuller.android.simplecropimage:
//            MonitoredActivity, HighlightView, Util, CropImageView, 
//            BitmapManager, RotateBitmap

public class CropImage extends MonitoredActivity
{

    public static final String ACTION_INLINE_DATA = "inline-data";
    public static final String ASPECT_X = "aspectX";
    public static final String ASPECT_Y = "aspectY";
    public static final int CANNOT_STAT_ERROR = -2;
    public static final String CIRCLE_CROP = "circleCrop";
    public static final String IMAGE_PATH = "image-path";
    public static final int NO_STORAGE_ERROR = -1;
    public static final String ORIENTATION_IN_DEGREES = "orientation_in_degrees";
    public static final String OUTPUT_X = "outputX";
    public static final String OUTPUT_Y = "outputY";
    public static final String RETURN_DATA = "return-data";
    public static final String RETURN_DATA_AS_BITMAP = "data";
    public static final String SCALE = "scale";
    public static final String SCALE_UP_IF_NEEDED = "scaleUpIfNeeded";
    private static final String TAG = "CropImage";
    final int IMAGE_MAX_SIZE = 2048;
    private int mAspectX;
    private int mAspectY;
    private Bitmap mBitmap;
    private boolean mCircleCrop;
    private ContentResolver mContentResolver;
    HighlightView mCrop;
    private final BitmapManager.ThreadSet mDecodingThreads = new BitmapManager.ThreadSet();
    private boolean mDoFaceDetection;
    private final Handler mHandler = new Handler();
    private String mImagePath;
    private CropImageView mImageView;
    private android.graphics.Bitmap.CompressFormat mOutputFormat;
    private int mOutputX;
    private int mOutputY;
    Runnable mRunFaceDetection;
    private Uri mSaveUri;
    boolean mSaving;
    private boolean mScale;
    private boolean mScaleUp;
    boolean mWaitingToPick;

    public CropImage()
    {
        mOutputFormat = android.graphics.Bitmap.CompressFormat.JPEG;
        mSaveUri = null;
        mDoFaceDetection = true;
        mCircleCrop = false;
        mScaleUp = true;
        mRunFaceDetection = new Runnable() {

            android.media.FaceDetector.Face mFaces[];
            Matrix mImageMatrix;
            int mNumFaces;
            float mScale;
            final CropImage this$0;

            private void handleFace(android.media.FaceDetector.Face face)
            {
                Object obj = new PointF();
                int i = (int)(face.eyesDistance() * mScale) * 2;
                face.getMidPoint(((PointF) (obj)));
                obj.x = ((PointF) (obj)).x * mScale;
                obj.y = ((PointF) (obj)).y * mScale;
                int j = (int)((PointF) (obj)).x;
                int k = (int)((PointF) (obj)).y;
                face = new HighlightView(mImageView);
                obj = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
                RectF rectf = new RectF(j, k, j, k);
                rectf.inset(-i, -i);
                if (rectf.left < 0.0F)
                {
                    rectf.inset(-rectf.left, -rectf.left);
                }
                if (rectf.top < 0.0F)
                {
                    rectf.inset(-rectf.top, -rectf.top);
                }
                if (rectf.right > (float)((Rect) (obj)).right)
                {
                    rectf.inset(rectf.right - (float)((Rect) (obj)).right, rectf.right - (float)((Rect) (obj)).right);
                }
                if (rectf.bottom > (float)((Rect) (obj)).bottom)
                {
                    rectf.inset(rectf.bottom - (float)((Rect) (obj)).bottom, rectf.bottom - (float)((Rect) (obj)).bottom);
                }
                Matrix matrix = mImageMatrix;
                boolean flag1 = mCircleCrop;
                boolean flag;
                if (mAspectX != 0 && mAspectY != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                face.setup(matrix, ((Rect) (obj)), rectf, flag1, flag);
                mImageView.add(face);
            }

            private void makeDefault()
            {
                boolean flag1 = false;
                HighlightView highlightview = new HighlightView(mImageView);
                int j1 = mBitmap.getWidth();
                int i1 = mBitmap.getHeight();
                Rect rect = new Rect(0, 0, j1, i1);
                int k = (Math.min(j1, i1) * 4) / 5;
                int l = k;
                int i = l;
                int j = k;
                if (mAspectX != 0)
                {
                    i = l;
                    j = k;
                    RectF rectf;
                    Matrix matrix;
                    boolean flag;
                    boolean flag2;
                    if (mAspectY != 0)
                    {
                        if (mAspectX > mAspectY)
                        {
                            i = (mAspectY * k) / mAspectX;
                            j = k;
                        } else
                        {
                            j = (mAspectX * l) / mAspectY;
                            i = l;
                        }
                    }
                }
                k = (j1 - j) / 2;
                l = (i1 - i) / 2;
                rectf = new RectF(k, l, k + j, l + i);
                matrix = mImageMatrix;
                flag2 = mCircleCrop;
                flag = flag1;
                if (mAspectX != 0)
                {
                    flag = flag1;
                    if (mAspectY != 0)
                    {
                        flag = true;
                    }
                }
                highlightview.setup(matrix, rect, rectf, flag2, flag);
                mImageView.mHighlightViews.clear();
                mImageView.add(highlightview);
            }

            private Bitmap prepareBitmap()
            {
                if (mBitmap == null)
                {
                    return null;
                }
                if (mBitmap.getWidth() > 256)
                {
                    mScale = 256F / (float)mBitmap.getWidth();
                }
                Matrix matrix = new Matrix();
                matrix.setScale(mScale, mScale);
                return Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, true);
            }

            public void run()
            {
                mImageMatrix = mImageView.getImageMatrix();
                Bitmap bitmap = prepareBitmap();
                mScale = 1.0F / mScale;
                if (bitmap != null && mDoFaceDetection)
                {
                    mNumFaces = (new FaceDetector(bitmap.getWidth(), bitmap.getHeight(), mFaces.length)).findFaces(bitmap, mFaces);
                }
                if (bitmap != null && bitmap != mBitmap)
                {
                    bitmap.recycle();
                }
                mHandler.post(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        int i;
                        CropImage cropimage = _fld0;
                        boolean flag;
                        if (mNumFaces > 1)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        cropimage.mWaitingToPick = flag;
                        if (mNumFaces <= 0)
                        {
                            break MISSING_BLOCK_LABEL_182;
                        }
                        i = 0;
_L3:
                        if (i < mNumFaces) goto _L2; else goto _L1
_L1:
                        mImageView.invalidate();
                        if (mImageView.mHighlightViews.size() == 1)
                        {
                            mCrop = (HighlightView)mImageView.mHighlightViews.get(0);
                            mCrop.setFocus(true);
                        }
                        if (mNumFaces > 1)
                        {
                            Toast.makeText(_fld0, "Multi face crop help", 0).show();
                        }
                        return;
_L2:
                        handleFace(mFaces[i]);
                        i++;
                          goto _L3
                        makeDefault();
                          goto _L1
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }




            
            {
                this$0 = CropImage.this;
                super();
                mScale = 1.0F;
                mFaces = new android.media.FaceDetector.Face[3];
            }
        };
    }

    public static int calculatePicturesRemaining(Activity activity)
    {
        try
        {
            if ("mounted".equals(Environment.getExternalStorageState()))
            {
                activity = Environment.getExternalStorageDirectory().toString();
            } else
            {
                activity = activity.getFilesDir().toString();
            }
            activity = new StatFs(activity);
            return (int)(((float)activity.getAvailableBlocks() * (float)activity.getBlockSize()) / 400000F);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return -2;
        }
    }

    private Bitmap getBitmap(String s)
    {
        Object obj = getImageUri(s);
        android.graphics.BitmapFactory.Options options;
        InputStream inputstream = mContentResolver.openInputStream(((Uri) (obj)));
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        inputstream.close();
        int i = 1;
        Object obj2;
        if (options.outHeight > 2048 || options.outWidth > 2048)
        {
            i = (int)Math.pow(2D, (int)Math.round(Math.log(2048D / (double)Math.max(options.outHeight, options.outWidth)) / Math.log(0.5D)));
        }
        obj2 = new android.graphics.BitmapFactory.Options();
        obj2.inSampleSize = i;
        obj = mContentResolver.openInputStream(((Uri) (obj)));
        obj2 = BitmapFactory.decodeStream(((InputStream) (obj)), null, ((android.graphics.BitmapFactory.Options) (obj2)));
        ((InputStream) (obj)).close();
        return ((Bitmap) (obj2));
        Object obj1;
        obj1;
        Log.e("CropImage", (new StringBuilder("file ")).append(s).append(" not found").toString());
_L2:
        return null;
        obj1;
        Log.e("CropImage", (new StringBuilder("file ")).append(s).append(" not found").toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Uri getImageUri(String s)
    {
        return Uri.fromFile(new File(s));
    }

    private void onSaveClicked()
        throws Exception
    {
_L2:
        return;
        if (mSaving || mCrop == null) goto _L2; else goto _L1
_L1:
        Rect rect;
        int i;
        int k;
        mSaving = true;
        rect = mCrop.getCropRect();
        i = rect.width();
        k = rect.height();
        final Object b;
        if (!mCircleCrop)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        b = android.graphics.Bitmap.Config.ARGB_8888;
_L3:
        Object obj = Bitmap.createBitmap(i, k, ((android.graphics.Bitmap.Config) (b)));
        if (obj != null)
        {
            b = new Canvas(((Bitmap) (obj)));
            Rect rect1 = new Rect(0, 0, i, k);
            ((Canvas) (b)).drawBitmap(mBitmap, rect, rect1, null);
            if (mCircleCrop)
            {
                b = new Canvas(((Bitmap) (obj)));
                Path path = new Path();
                path.addCircle((float)i / 2.0F, (float)k / 2.0F, (float)i / 2.0F, android.graphics.Path.Direction.CW);
                ((Canvas) (b)).clipPath(path, android.graphics.Region.Op.DIFFERENCE);
                ((Canvas) (b)).drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            }
            b = obj;
            if (mOutputX != 0)
            {
                b = obj;
                if (mOutputY != 0)
                {
                    if (mScale)
                    {
                        Bitmap bitmap = Util.transform(new Matrix(), ((Bitmap) (obj)), mOutputX, mOutputY, mScaleUp);
                        b = bitmap;
                        if (obj != bitmap)
                        {
                            ((Bitmap) (obj)).recycle();
                            b = bitmap;
                        }
                    } else
                    {
                        b = Bitmap.createBitmap(mOutputX, mOutputY, android.graphics.Bitmap.Config.RGB_565);
                        Canvas canvas = new Canvas(((Bitmap) (b)));
                        Rect rect2 = mCrop.getCropRect();
                        Rect rect3 = new Rect(0, 0, mOutputX, mOutputY);
                        int j = (rect2.width() - rect3.width()) / 2;
                        int l = (rect2.height() - rect3.height()) / 2;
                        rect2.inset(Math.max(0, j), Math.max(0, l));
                        rect3.inset(Math.max(0, -j), Math.max(0, -l));
                        canvas.drawBitmap(mBitmap, rect2, rect3, null);
                        ((Bitmap) (obj)).recycle();
                    }
                }
            }
            obj = getIntent().getExtras();
            if (obj != null && (((Bundle) (obj)).getParcelable("data") != null || ((Bundle) (obj)).getBoolean("return-data")))
            {
                obj = new Bundle();
                ((Bundle) (obj)).putParcelable("data", ((android.os.Parcelable) (b)));
                setResult(-1, (new Intent()).setAction("inline-data").putExtras(((Bundle) (obj))));
                finish();
                return;
            } else
            {
                Util.startBackgroundJob(this, null, getString(R.string.saving_image), new Runnable() {

                    final CropImage this$0;
                    private final Bitmap val$b;

                    public void run()
                    {
                        saveOutput(b);
                    }

            
            {
                this$0 = CropImage.this;
                b = bitmap;
                super();
            }
                }, mHandler);
                return;
            }
        }
          goto _L2
        try
        {
            b = android.graphics.Bitmap.Config.RGB_565;
        }
        // Misplaced declaration of an exception variable
        catch (final Object b)
        {
            throw b;
        }
          goto _L3
    }

    private void saveOutput(Bitmap bitmap)
    {
        if (mSaveUri == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        java.io.OutputStream outputstream = mContentResolver.openOutputStream(mSaveUri);
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        obj = outputstream;
        obj1 = outputstream;
        bitmap.compress(mOutputFormat, 90, outputstream);
        Util.closeSilently(outputstream);
        obj = new Bundle();
        obj1 = new Intent(mSaveUri.toString());
        ((Intent) (obj1)).putExtras(((Bundle) (obj)));
        ((Intent) (obj1)).putExtra("image-path", mImagePath);
        ((Intent) (obj1)).putExtra("orientation_in_degrees", Util.getOrientationInDegree(this));
        setResult(-1, ((Intent) (obj1)));
_L4:
        bitmap.recycle();
        finish();
        return;
        bitmap;
        obj1 = obj;
        Log.e("CropImage", (new StringBuilder("Cannot open file: ")).append(mSaveUri).toString(), bitmap);
        obj1 = obj;
        setResult(0);
        obj1 = obj;
        finish();
        Util.closeSilently(((java.io.Closeable) (obj)));
        return;
        bitmap;
        Util.closeSilently(((java.io.Closeable) (obj1)));
        throw bitmap;
_L2:
        Log.e("CropImage", "not defined image url");
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void showStorageToast(Activity activity)
    {
        showStorageToast(activity, calculatePicturesRemaining(activity));
    }

    public static void showStorageToast(Activity activity, int i)
    {
        String s = null;
        if (i != -1) goto _L2; else goto _L1
_L1:
        if (Environment.getExternalStorageState().equals("checking"))
        {
            s = activity.getString(R.string.preparing_card);
        } else
        {
            s = activity.getString(R.string.no_storage_card);
        }
_L4:
        if (s != null)
        {
            Toast.makeText(activity, s, 5000).show();
        }
        return;
_L2:
        if (i < 1)
        {
            s = activity.getString(R.string.not_enough_space);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void startFaceDetection()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            mImageView.setImageBitmapResetBase(mBitmap, true);
            Util.startBackgroundJob(this, null, "Please wait\u2026", new Runnable() {

                final CropImage this$0;

                public void run()
                {
                    CountDownLatch countdownlatch = new CountDownLatch(1);
                    final Bitmap b = mBitmap;
                    mHandler.post(countdownlatch. new Runnable() {

                        final _cls6 this$1;
                        private final Bitmap val$b;
                        private final CountDownLatch val$latch;

                        public void run()
                        {
                            if (b != mBitmap && b != null)
                            {
                                mImageView.setImageBitmapResetBase(b, true);
                                mBitmap.recycle();
                                mBitmap = b;
                            }
                            if (mImageView.getScale() == 1.0F)
                            {
                                mImageView.center(true, true);
                            }
                            latch.countDown();
                        }

            
            {
                this$1 = final__pcls6;
                b = bitmap;
                latch = CountDownLatch.this;
                super();
            }
                    });
                    try
                    {
                        countdownlatch.await();
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        throw new RuntimeException(interruptedexception);
                    }
                    mRunFaceDetection.run();
                }


            
            {
                this$0 = CropImage.this;
                super();
            }
            }, mHandler);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
label1:
            {
                super.onCreate(bundle);
                mContentResolver = getContentResolver();
                requestWindowFeature(1);
                setContentView(R.layout.cropimage);
                mImageView = (CropImageView)findViewById(R.id.image);
                showStorageToast(this);
                bundle = getIntent().getExtras();
                if (bundle != null)
                {
                    if (bundle.getString("circleCrop") != null)
                    {
                        if (android.os.Build.VERSION.SDK_INT > 11)
                        {
                            mImageView.setLayerType(1, null);
                        }
                        mCircleCrop = true;
                        mAspectX = 1;
                        mAspectY = 1;
                    }
                    mImagePath = bundle.getString("image-path");
                    mSaveUri = getImageUri(mImagePath);
                    mBitmap = getBitmap(mImagePath);
                    if (!bundle.containsKey("aspectX") || !(bundle.get("aspectX") instanceof Integer))
                    {
                        break label1;
                    }
                    mAspectX = bundle.getInt("aspectX");
                    if (!bundle.containsKey("aspectY") || !(bundle.get("aspectY") instanceof Integer))
                    {
                        break label0;
                    }
                    mAspectY = bundle.getInt("aspectY");
                    mOutputX = bundle.getInt("outputX");
                    mOutputY = bundle.getInt("outputY");
                    mScale = bundle.getBoolean("scale", true);
                    mScaleUp = bundle.getBoolean("scaleUpIfNeeded", true);
                }
                if (mBitmap == null)
                {
                    Log.d("CropImage", "finish!!!");
                    finish();
                    return;
                } else
                {
                    getWindow().addFlags(1024);
                    findViewById(R.id.discard).setOnClickListener(new android.view.View.OnClickListener() {

                        final CropImage this$0;

                        public void onClick(View view)
                        {
                            setResult(0);
                            finish();
                        }

            
            {
                this$0 = CropImage.this;
                super();
            }
                    });
                    findViewById(R.id.save).setOnClickListener(new android.view.View.OnClickListener() {

                        final CropImage this$0;

                        public void onClick(View view)
                        {
                            try
                            {
                                onSaveClicked();
                                return;
                            }
                            // Misplaced declaration of an exception variable
                            catch (View view)
                            {
                                finish();
                            }
                        }

            
            {
                this$0 = CropImage.this;
                super();
            }
                    });
                    findViewById(R.id.rotateLeft).setOnClickListener(new android.view.View.OnClickListener() {

                        final CropImage this$0;

                        public void onClick(View view)
                        {
                            mImageView.mHighlightViews.clear();
                            mBitmap = Util.rotateImage(mBitmap, -90F);
                            view = new RotateBitmap(mBitmap);
                            mImageView.setImageRotateBitmapResetBase(view, true);
                            mRunFaceDetection.run();
                        }

            
            {
                this$0 = CropImage.this;
                super();
            }
                    });
                    findViewById(R.id.rotateRight).setOnClickListener(new android.view.View.OnClickListener() {

                        final CropImage this$0;

                        public void onClick(View view)
                        {
                            mImageView.mHighlightViews.clear();
                            mBitmap = Util.rotateImage(mBitmap, 90F);
                            view = new RotateBitmap(mBitmap);
                            mImageView.setImageRotateBitmapResetBase(view, true);
                            mRunFaceDetection.run();
                        }

            
            {
                this$0 = CropImage.this;
                super();
            }
                    });
                    startFaceDetection();
                    return;
                }
            }
            throw new IllegalArgumentException("aspect_x must be integer");
        }
        throw new IllegalArgumentException("aspect_y must be integer");
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mBitmap != null)
        {
            mBitmap.recycle();
        }
    }

    protected void onPause()
    {
        super.onPause();
        BitmapManager.instance().cancelThreadDecoding(mDecodingThreads);
    }










}
