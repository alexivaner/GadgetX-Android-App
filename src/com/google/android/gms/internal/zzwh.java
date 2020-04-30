// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;

// Referenced classes of package com.google.android.gms.internal:
//            zzwi

public class zzwh
    implements Payments
{

    public zzwh()
    {
    }

    public void changeMaskedWallet(GoogleApiClient googleapiclient, String s, String s1, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, s, s1, i) {

            final zzwh zzaET;
            final String zzaEW;
            final String zzaEX;
            final int zzalq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzwi)zza1);
            }

            protected void zza(zzwi zzwi1)
            {
                zzwi1.zze(zzaEW, zzaEX, zzalq);
                setResult(Status.zzNo);
            }

            
            {
                zzaET = zzwh.this;
                zzaEW = s;
                zzaEX = s1;
                zzalq = i;
                super(googleapiclient);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, i) {

            final zzwh zzaET;
            final int zzalq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzwi)zza1);
            }

            protected void zza(zzwi zzwi1)
            {
                zzwi1.zzhG(zzalq);
                setResult(Status.zzNo);
            }

            
            {
                zzaET = zzwh.this;
                zzalq = i;
                super(googleapiclient);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleapiclient, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, i) {

            final zzwh zzaET;
            final int zzalq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzwi)zza1);
            }

            protected void zza(zzwi zzwi1)
            {
                zzwi1.zzhH(zzalq);
                setResult(Status.zzNo);
            }

            
            {
                zzaET = zzwh.this;
                zzalq = i;
                super(googleapiclient);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleapiclient, FullWalletRequest fullwalletrequest, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, fullwalletrequest, i) {

            final zzwh zzaET;
            final FullWalletRequest zzaEV;
            final int zzalq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzwi)zza1);
            }

            protected void zza(zzwi zzwi1)
            {
                zzwi1.zza(zzaEV, zzalq);
                setResult(Status.zzNo);
            }

            
            {
                zzaET = zzwh.this;
                zzaEV = fullwalletrequest;
                zzalq = i;
                super(googleapiclient);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleapiclient, MaskedWalletRequest maskedwalletrequest, int i)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, maskedwalletrequest, i) {

            final zzwh zzaET;
            final MaskedWalletRequest zzaEU;
            final int zzalq;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzwi)zza1);
            }

            protected void zza(zzwi zzwi1)
            {
                zzwi1.zza(zzaEU, zzalq);
                setResult(Status.zzNo);
            }

            
            {
                zzaET = zzwh.this;
                zzaEU = maskedwalletrequest;
                zzalq = i;
                super(googleapiclient);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleapiclient, NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        googleapiclient.zza(new com.google.android.gms.wallet.Wallet.zzb(googleapiclient, notifytransactionstatusrequest) {

            final zzwh zzaET;
            final NotifyTransactionStatusRequest zzaEY;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
                throws RemoteException
            {
                zza((zzwi)zza1);
            }

            protected void zza(zzwi zzwi1)
            {
                zzwi1.zza(zzaEY);
                setResult(Status.zzNo);
            }

            
            {
                zzaET = zzwh.this;
                zzaEY = notifytransactionstatusrequest;
                super(googleapiclient);
            }
        });
    }
}
