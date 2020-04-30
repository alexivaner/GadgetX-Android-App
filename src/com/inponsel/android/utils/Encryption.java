// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.os.AsyncTask;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.inponsel.android.utils:
//            Log

public class Encryption
{
    public static class Builder
    {

        private String mAlgorithm;
        private int mBase64Mode;
        private String mCharsetName;
        private String mDigestAlgorithm;
        private int mIterationCount;
        private byte mIv[];
        private IvParameterSpec mIvParameterSpec;
        private String mKey;
        private int mKeyLength;
        private String mSalt;
        private String mSecretKeyType;
        private SecureRandom mSecureRandom;
        private String mSecureRandomAlgorithm;

        private String getAlgorithm()
        {
            return mAlgorithm;
        }

        private int getBase64Mode()
        {
            return mBase64Mode;
        }

        private String getCharsetName()
        {
            return mCharsetName;
        }

        public static Builder getDefaultBuilder(String s, String s1, byte abyte0[])
        {
            return (new Builder()).setIv(abyte0).setKey(s).setSalt(s1).setKeyLength(128).setCharsetName("UTF8").setIterationCount(0x10000).setDigestAlgorithm("SHA1").setBase64Mode(0).setAlgorithm("AES/CBC/PKCS5Padding").setSecureRandomAlgorithm("SHA1PRNG").setSecretKeyType("PBKDF2WithHmacSHA1");
        }

        private String getDigestAlgorithm()
        {
            return mDigestAlgorithm;
        }

        private int getIterationCount()
        {
            return mIterationCount;
        }

        private byte[] getIv()
        {
            return mIv;
        }

        private IvParameterSpec getIvParameterSpec()
        {
            return mIvParameterSpec;
        }

        private String getKey()
        {
            return mKey;
        }

        private int getKeyLength()
        {
            return mKeyLength;
        }

        private String getSalt()
        {
            return mSalt;
        }

        private String getSecretKeyType()
        {
            return mSecretKeyType;
        }

        private SecureRandom getSecureRandom()
        {
            return mSecureRandom;
        }

        private String getSecureRandomAlgorithm()
        {
            return mSecureRandomAlgorithm;
        }

        public Encryption build()
            throws NoSuchAlgorithmException
        {
            setSecureRandom(SecureRandom.getInstance(getSecureRandomAlgorithm()));
            setIvParameterSpec(new IvParameterSpec(getIv()));
            return new Encryption(this, null);
        }

        public Builder setAlgorithm(String s)
        {
            mAlgorithm = s;
            return this;
        }

        public Builder setBase64Mode(int i)
        {
            mBase64Mode = i;
            return this;
        }

        public Builder setCharsetName(String s)
        {
            mCharsetName = s;
            return this;
        }

        public Builder setDigestAlgorithm(String s)
        {
            mDigestAlgorithm = s;
            return this;
        }

        public Builder setIterationCount(int i)
        {
            mIterationCount = i;
            return this;
        }

        public Builder setIv(byte abyte0[])
        {
            mIv = abyte0;
            return this;
        }

        public Builder setIvParameterSpec(IvParameterSpec ivparameterspec)
        {
            mIvParameterSpec = ivparameterspec;
            return this;
        }

        public Builder setKey(String s)
        {
            mKey = s;
            return this;
        }

        public Builder setKeyLength(int i)
        {
            mKeyLength = i;
            return this;
        }

        public Builder setSalt(String s)
        {
            mSalt = s;
            return this;
        }

        public Builder setSecretKeyType(String s)
        {
            mSecretKeyType = s;
            return this;
        }

        public Builder setSecureRandom(SecureRandom securerandom)
        {
            mSecureRandom = securerandom;
            return this;
        }

        public Builder setSecureRandomAlgorithm(String s)
        {
            mSecureRandomAlgorithm = s;
            return this;
        }












        public Builder()
        {
        }
    }

    public static interface Callback
    {

        public abstract void onError(Exception exception);

        public abstract void onSuccess(String s);
    }


    private static final String TAG = "Encryption";
    private final Builder mBuilder;

    private Encryption(Builder builder)
    {
        mBuilder = builder;
    }

    Encryption(Builder builder, Encryption encryption)
    {
        this(builder);
    }

    public static Encryption getDefault(String s, String s1, byte abyte0[])
    {
        try
        {
            s = Builder.getDefaultBuilder(s, s1, abyte0).build();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Encryption", s.getMessage());
            return null;
        }
        return s;
    }

    private SecretKey getSecretKey(char ac[])
        throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeySpecException
    {
        return new SecretKeySpec(SecretKeyFactory.getInstance(mBuilder.getSecretKeyType()).generateSecret(new PBEKeySpec(ac, mBuilder.getSalt().getBytes(mBuilder.getCharsetName()), mBuilder.getIterationCount(), mBuilder.getKeyLength())).getEncoded(), mBuilder.getAlgorithm());
    }

    private char[] hashTheKey(String s)
        throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        MessageDigest messagedigest = MessageDigest.getInstance(mBuilder.getDigestAlgorithm());
        messagedigest.update(s.getBytes(mBuilder.getCharsetName()));
        return Base64.encodeToString(messagedigest.digest(), 1).toCharArray();
    }

    public String decrypt(String s)
        throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
    {
        if (s == null)
        {
            return null;
        } else
        {
            s = Base64.decode(s, mBuilder.getBase64Mode());
            SecretKey secretkey = getSecretKey(hashTheKey(mBuilder.getKey()));
            Cipher cipher = Cipher.getInstance(mBuilder.getAlgorithm());
            cipher.init(2, secretkey, mBuilder.getIvParameterSpec(), mBuilder.getSecureRandom());
            return new String(cipher.doFinal(s));
        }
    }

    public void decryptAsync(String s, final Callback callback)
    {
        if (callback == null)
        {
            return;
        } else
        {
            (new AsyncTask() {

                final Encryption this$0;
                private final Callback val$callback;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((String[])aobj);
                }

                protected transient String doInBackground(String as[])
                {
                    try
                    {
                        as = decrypt(as[0]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        callback.onError(as);
                        return null;
                    }
                    if (as != null)
                    {
                        break MISSING_BLOCK_LABEL_33;
                    }
                    callback.onError(new Exception("Decrypt return null, it normally occurs when you send a null data"));
                    return as;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s1)
                {
                    super.onPostExecute(s1);
                    if (s1 != null)
                    {
                        callback.onSuccess(s1);
                    }
                }

            
            {
                this$0 = Encryption.this;
                callback = callback1;
                super();
            }
            }).execute(new String[] {
                s
            });
            return;
        }
    }

    public String decryptOrNull(String s)
    {
        try
        {
            s = decrypt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Encryption", s.getMessage());
            return null;
        }
        return s;
    }

    public String encrypt(String s)
        throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException
    {
        if (s == null)
        {
            return null;
        } else
        {
            SecretKey secretkey = getSecretKey(hashTheKey(mBuilder.getKey()));
            s = s.getBytes(mBuilder.getCharsetName());
            Cipher cipher = Cipher.getInstance(mBuilder.getAlgorithm());
            cipher.init(1, secretkey, mBuilder.getIvParameterSpec(), mBuilder.getSecureRandom());
            return Base64.encodeToString(cipher.doFinal(s), mBuilder.getBase64Mode());
        }
    }

    public void encryptAsync(String s, final Callback callback)
    {
        if (callback == null)
        {
            return;
        } else
        {
            (new AsyncTask() {

                final Encryption this$0;
                private final Callback val$callback;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((String[])aobj);
                }

                protected transient String doInBackground(String as[])
                {
                    try
                    {
                        as = encrypt(as[0]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        callback.onError(as);
                        return null;
                    }
                    if (as != null)
                    {
                        break MISSING_BLOCK_LABEL_33;
                    }
                    callback.onError(new Exception("Encrypt return null, it normally occurs when you send a null data"));
                    return as;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s1)
                {
                    super.onPostExecute(s1);
                    if (s1 != null)
                    {
                        callback.onSuccess(s1);
                    }
                }

            
            {
                this$0 = Encryption.this;
                callback = callback1;
                super();
            }
            }).execute(new String[] {
                s
            });
            return;
        }
    }

    public String encryptOrNull(String s)
    {
        try
        {
            s = encrypt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Encryption", s.getMessage());
            return null;
        }
        return s;
    }
}
