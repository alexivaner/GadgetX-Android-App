// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzkj;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;
import java.lang.ref.WeakReference;

public abstract class com.google.android.gms.common.images.zza
{
    static final class zza
    {

        public final Uri uri;

        public boolean equals(Object obj)
        {
            if (!(obj instanceof zza))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            } else
            {
                return zzw.equal(((zza)obj).uri, uri);
            }
        }

        public int hashCode()
        {
            return zzw.hashCode(new Object[] {
                uri
            });
        }

        public zza(Uri uri1)
        {
            uri = uri1;
        }
    }

    public static final class zzb extends com.google.android.gms.common.images.zza
    {

        private WeakReference zzOJ;

        private void zza(ImageView imageview, Drawable drawable, boolean flag, boolean flag1, boolean flag2)
        {
            boolean flag3;
            int j;
            if (!flag1 && !flag2)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (!flag3 || !(imageview instanceof zzkl)) goto _L2; else goto _L1
_L1:
            j = ((zzkl)imageview).zziK();
            if (zzOC == 0 || j != zzOC) goto _L2; else goto _L3
_L3:
            return;
_L2:
            flag = zzc(flag, flag1);
            if (zzOD && drawable != null)
            {
                drawable = drawable.getConstantState().newDrawable();
            }
            Object obj = drawable;
            if (flag)
            {
                obj = zza(imageview.getDrawable(), drawable);
            }
            imageview.setImageDrawable(((Drawable) (obj)));
            if (imageview instanceof zzkl)
            {
                drawable = (zzkl)imageview;
                int i;
                if (flag2)
                {
                    imageview = zzOA.uri;
                } else
                {
                    imageview = null;
                }
                drawable.zzi(imageview);
                if (flag3)
                {
                    i = zzOC;
                } else
                {
                    i = 0;
                }
                drawable.zzaE(i);
            }
            if (flag)
            {
                ((zzkj)obj).startTransition(250);
                return;
            }
            if (true) goto _L3; else goto _L4
_L4:
        }

        public boolean equals(Object obj)
        {
            if (!(obj instanceof zzb))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            Object obj1 = (zzb)obj;
            obj = (ImageView)zzOJ.get();
            obj1 = (ImageView)((zzb) (obj1)).zzOJ.get();
            boolean flag;
            if (obj1 != null && obj != null && zzw.equal(obj1, obj))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }

        public int hashCode()
        {
            return 0;
        }

        protected void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
        {
            ImageView imageview = (ImageView)zzOJ.get();
            if (imageview != null)
            {
                zza(imageview, drawable, flag, flag1, flag2);
            }
        }

        public zzb(ImageView imageview, int i)
        {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzh(imageview);
            zzOJ = new WeakReference(imageview);
        }

        public zzb(ImageView imageview, Uri uri)
        {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzh(imageview);
            zzOJ = new WeakReference(imageview);
        }
    }

    public static final class zzc extends com.google.android.gms.common.images.zza
    {

        private WeakReference zzOK;

        public boolean equals(Object obj)
        {
            if (!(obj instanceof zzc))
            {
                return false;
            }
            if (this == obj)
            {
                return true;
            }
            obj = (zzc)obj;
            ImageManager.OnImageLoadedListener onimageloadedlistener = (ImageManager.OnImageLoadedListener)zzOK.get();
            ImageManager.OnImageLoadedListener onimageloadedlistener1 = (ImageManager.OnImageLoadedListener)((zzc) (obj)).zzOK.get();
            boolean flag;
            if (onimageloadedlistener1 != null && onimageloadedlistener != null && zzw.equal(onimageloadedlistener1, onimageloadedlistener) && zzw.equal(((zzc) (obj)).zzOA, zzOA))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }

        public int hashCode()
        {
            return zzw.hashCode(new Object[] {
                zzOA
            });
        }

        protected void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2)
        {
            if (!flag1)
            {
                ImageManager.OnImageLoadedListener onimageloadedlistener = (ImageManager.OnImageLoadedListener)zzOK.get();
                if (onimageloadedlistener != null)
                {
                    onimageloadedlistener.onImageLoaded(zzOA.uri, drawable, flag2);
                }
            }
        }

        public zzc(ImageManager.OnImageLoadedListener onimageloadedlistener, Uri uri)
        {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzh(onimageloadedlistener);
            zzOK = new WeakReference(onimageloadedlistener);
        }
    }


    final zza zzOA;
    protected int zzOB;
    protected int zzOC;
    protected boolean zzOD;
    protected ImageManager.OnImageLoadedListener zzOE;
    private boolean zzOF;
    private boolean zzOG;
    private boolean zzOH;
    protected int zzOI;

    public com.google.android.gms.common.images.zza(Uri uri, int i)
    {
        zzOB = 0;
        zzOC = 0;
        zzOD = false;
        zzOF = true;
        zzOG = false;
        zzOH = true;
        zzOA = new zza(uri);
        zzOC = i;
    }

    private Drawable zza(Context context, zzkm zzkm1, int i)
    {
        Resources resources = context.getResources();
        if (zzOI > 0)
        {
            com.google.android.gms.internal.zzkm.zza zza1 = new com.google.android.gms.internal.zzkm.zza(i, zzOI);
            Drawable drawable = (Drawable)zzkm1.get(zza1);
            context = drawable;
            if (drawable == null)
            {
                Drawable drawable1 = resources.getDrawable(i);
                context = drawable1;
                if ((zzOI & 1) != 0)
                {
                    context = zza(resources, drawable1);
                }
                zzkm1.put(zza1, context);
            }
            return context;
        } else
        {
            return resources.getDrawable(i);
        }
    }

    protected Drawable zza(Resources resources, Drawable drawable)
    {
        return zzkk.zza(resources, drawable);
    }

    protected zzkj zza(Drawable drawable, Drawable drawable1)
    {
        Drawable drawable2;
        if (drawable != null)
        {
            drawable2 = drawable;
            if (drawable instanceof zzkj)
            {
                drawable2 = ((zzkj)drawable).zziI();
            }
        } else
        {
            drawable2 = null;
        }
        return new zzkj(drawable2, drawable1);
    }

    void zza(Context context, Bitmap bitmap, boolean flag)
    {
        com.google.android.gms.common.internal.zzb.zzh(bitmap);
        Bitmap bitmap1 = bitmap;
        if ((zzOI & 1) != 0)
        {
            bitmap1 = zzkk.zza(bitmap);
        }
        context = new BitmapDrawable(context.getResources(), bitmap1);
        if (zzOE != null)
        {
            zzOE.onImageLoaded(zzOA.uri, context, true);
        }
        zza(((Drawable) (context)), flag, false, true);
    }

    void zza(Context context, zzkm zzkm1)
    {
        if (zzOH)
        {
            Drawable drawable = null;
            if (zzOB != 0)
            {
                drawable = zza(context, zzkm1, zzOB);
            }
            zza(drawable, false, true, false);
        }
    }

    void zza(Context context, zzkm zzkm1, boolean flag)
    {
        Drawable drawable = null;
        if (zzOC != 0)
        {
            drawable = zza(context, zzkm1, zzOC);
        }
        if (zzOE != null)
        {
            zzOE.onImageLoaded(zzOA.uri, drawable, false);
        }
        zza(drawable, flag, false, false);
    }

    protected abstract void zza(Drawable drawable, boolean flag, boolean flag1, boolean flag2);

    public void zzaC(int i)
    {
        zzOC = i;
    }

    protected boolean zzc(boolean flag, boolean flag1)
    {
        return zzOF && !flag1 && (!flag || zzOG);
    }
}
