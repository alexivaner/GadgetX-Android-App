// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.GraphUtil;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.share.internal:
//            ResultProcessor, OpenGraphJSONUtility

public final class ShareInternalUtility
{

    private static final String MY_ACTION_FORMAT = "me/%s";
    private static final String MY_FEED = "me/feed";
    private static final String MY_OBJECTS_FORMAT = "me/objects/%s";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String MY_VIDEOS = "me/videos";
    private static final String OBJECT_PARAM = "object";
    private static final String PICTURE_PARAM = "picture";
    private static final String STAGING_PARAM = "file";

    private ShareInternalUtility()
    {
    }

    private static AppCall getAppCallFromActivityResult(int i, int j, Intent intent)
    {
        intent = NativeProtocol.getCallIdFromIntent(intent);
        if (intent == null)
        {
            return null;
        } else
        {
            return AppCall.finishPendingCall(intent, i);
        }
    }

    private static com.facebook.internal.NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, SharePhoto sharephoto)
    {
        Bitmap bitmap = sharephoto.getBitmap();
        Uri uri = sharephoto.getImageUrl();
        sharephoto = null;
        if (bitmap != null)
        {
            sharephoto = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        } else
        if (uri != null)
        {
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        }
        return sharephoto;
    }

    public static Pair getFieldNameAndNamespaceFromFullName(String s)
    {
        String s1 = null;
        int i = s.indexOf(':');
        if (i != -1 && s.length() > i + 1)
        {
            s1 = s.substring(0, i);
            s = s.substring(i + 1);
        }
        return new Pair(s1, s);
    }

    public static com.facebook.share.widget.LikeView.ObjectType getMostSpecificObjectType(com.facebook.share.widget.LikeView.ObjectType objecttype, com.facebook.share.widget.LikeView.ObjectType objecttype1)
    {
        if (objecttype != objecttype1)
        {
            if (objecttype == com.facebook.share.widget.LikeView.ObjectType.UNKNOWN)
            {
                return objecttype1;
            }
            if (objecttype1 != com.facebook.share.widget.LikeView.ObjectType.UNKNOWN)
            {
                return null;
            }
        }
        return objecttype;
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle)
    {
        if (bundle.containsKey("completionGesture"))
        {
            return bundle.getString("completionGesture");
        } else
        {
            return bundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
        }
    }

    public static boolean getNativeDialogDidComplete(Bundle bundle)
    {
        if (bundle.containsKey("didComplete"))
        {
            return bundle.getBoolean("didComplete");
        } else
        {
            return bundle.getBoolean("com.facebook.platform.extra.DID_COMPLETE", false);
        }
    }

    public static List getPhotoUrls(SharePhotoContent sharephotocontent, UUID uuid)
    {
label0:
        {
            if (sharephotocontent != null)
            {
                sharephotocontent = sharephotocontent.getPhotos();
                if (sharephotocontent != null)
                {
                    break label0;
                }
            }
            return null;
        }
        sharephotocontent = Utility.map(sharephotocontent, new com.facebook.internal.Utility.Mapper(uuid) {

            final UUID val$appCallId;

            public com.facebook.internal.NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharephoto)
            {
                return ShareInternalUtility.getAttachment(appCallId, sharephoto);
            }

            public volatile Object apply(Object obj)
            {
                return apply((SharePhoto)obj);
            }

            
            {
                appCallId = uuid;
                super();
            }
        });
        uuid = Utility.map(sharephotocontent, new com.facebook.internal.Utility.Mapper() {

            public volatile Object apply(Object obj)
            {
                return apply((com.facebook.internal.NativeAppCallAttachmentStore.Attachment)obj);
            }

            public String apply(com.facebook.internal.NativeAppCallAttachmentStore.Attachment attachment)
            {
                return attachment.getAttachmentUrl();
            }

        });
        NativeAppCallAttachmentStore.addAttachments(sharephotocontent);
        return uuid;
    }

    public static String getShareDialogPostId(Bundle bundle)
    {
        if (bundle.containsKey("postId"))
        {
            return bundle.getString("postId");
        }
        if (bundle.containsKey("com.facebook.platform.extra.POST_ID"))
        {
            return bundle.getString("com.facebook.platform.extra.POST_ID");
        } else
        {
            return bundle.getString("post_id");
        }
    }

    public static ResultProcessor getShareResultProcessor(FacebookCallback facebookcallback)
    {
        return new ResultProcessor(facebookcallback, facebookcallback) {

            final FacebookCallback val$callback;

            public void onCancel(AppCall appcall)
            {
                ShareInternalUtility.invokeOnCancelCallback(callback);
            }

            public void onError(AppCall appcall, FacebookException facebookexception)
            {
                ShareInternalUtility.invokeOnErrorCallback(callback, facebookexception);
            }

            public void onSuccess(AppCall appcall, Bundle bundle)
            {
label0:
                {
                    if (bundle != null)
                    {
                        appcall = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                        if (appcall != null && !"post".equalsIgnoreCase(appcall))
                        {
                            break label0;
                        }
                        appcall = ShareInternalUtility.getShareDialogPostId(bundle);
                        ShareInternalUtility.invokeOnSuccessCallback(callback, appcall);
                    }
                    return;
                }
                if ("cancel".equalsIgnoreCase(appcall))
                {
                    ShareInternalUtility.invokeOnCancelCallback(callback);
                    return;
                } else
                {
                    ShareInternalUtility.invokeOnErrorCallback(callback, new FacebookException("UnknownError"));
                    return;
                }
            }

            
            {
                callback = facebookcallback1;
                super(facebookcallback);
            }
        };
    }

    public static boolean handleActivityResult(int i, int j, Intent intent, ResultProcessor resultprocessor)
    {
        boolean flag = true;
        AppCall appcall = getAppCallFromActivityResult(i, j, intent);
        if (appcall == null)
        {
            flag = false;
        } else
        {
            NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appcall.getCallId());
            if (resultprocessor != null)
            {
                FacebookException facebookexception = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
                if (facebookexception != null)
                {
                    if (facebookexception instanceof FacebookOperationCanceledException)
                    {
                        resultprocessor.onCancel(appcall);
                        return true;
                    } else
                    {
                        resultprocessor.onError(appcall, facebookexception);
                        return true;
                    }
                } else
                {
                    resultprocessor.onSuccess(appcall, NativeProtocol.getSuccessResultsFromIntent(intent));
                    return true;
                }
            }
        }
        return flag;
    }

    public static void invokeCallbackWithError(FacebookCallback facebookcallback, String s)
    {
        invokeOnErrorCallback(facebookcallback, s);
    }

    public static void invokeCallbackWithException(FacebookCallback facebookcallback, Exception exception)
    {
        if (exception instanceof FacebookException)
        {
            invokeOnErrorCallback(facebookcallback, (FacebookException)exception);
            return;
        } else
        {
            invokeCallbackWithError(facebookcallback, (new StringBuilder()).append("Error preparing share content: ").append(exception.getLocalizedMessage()).toString());
            return;
        }
    }

    public static void invokeCallbackWithResults(FacebookCallback facebookcallback, String s, GraphResponse graphresponse)
    {
        Object obj = graphresponse.getError();
        if (obj != null)
        {
            obj = ((FacebookRequestError) (obj)).getErrorMessage();
            s = ((String) (obj));
            if (Utility.isNullOrEmpty(((String) (obj))))
            {
                s = "Unexpected error sharing.";
            }
            invokeOnErrorCallback(facebookcallback, graphresponse, s);
            return;
        } else
        {
            invokeOnSuccessCallback(facebookcallback, s);
            return;
        }
    }

    private static void invokeOnCancelCallback(FacebookCallback facebookcallback)
    {
        logShareResult("cancelled", null);
        if (facebookcallback != null)
        {
            facebookcallback.onCancel();
        }
    }

    private static void invokeOnErrorCallback(FacebookCallback facebookcallback, FacebookException facebookexception)
    {
        logShareResult("error", facebookexception.getMessage());
        if (facebookcallback != null)
        {
            facebookcallback.onError(facebookexception);
        }
    }

    private static void invokeOnErrorCallback(FacebookCallback facebookcallback, GraphResponse graphresponse, String s)
    {
        logShareResult("error", s);
        if (facebookcallback != null)
        {
            facebookcallback.onError(new FacebookGraphResponseException(graphresponse, s));
        }
    }

    private static void invokeOnErrorCallback(FacebookCallback facebookcallback, String s)
    {
        logShareResult("error", s);
        if (facebookcallback != null)
        {
            facebookcallback.onError(new FacebookException(s));
        }
    }

    private static void invokeOnSuccessCallback(FacebookCallback facebookcallback, String s)
    {
        logShareResult("succeeded", null);
        if (facebookcallback != null)
        {
            facebookcallback.onSuccess(new com.facebook.share.Sharer.Result(s));
        }
    }

    private static void logShareResult(String s, String s1)
    {
        AppEventsLogger appeventslogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        Bundle bundle = new Bundle();
        bundle.putString("fb_share_dialog_outcome", s);
        if (s1 != null)
        {
            bundle.putString("error_message", s1);
        }
        appeventslogger.logSdkEvent("fb_share_dialog_result", null, bundle);
    }

    public static GraphRequest newPostOpenGraphActionRequest(AccessToken accesstoken, JSONObject jsonobject, com.facebook.GraphRequest.Callback callback)
    {
        if (jsonobject == null)
        {
            throw new FacebookException("openGraphAction cannot be null");
        }
        String s = jsonobject.optString("type");
        if (Utility.isNullOrEmpty(s))
        {
            throw new FacebookException("openGraphAction must have non-null 'type' property");
        } else
        {
            return GraphRequest.newPostRequest(accesstoken, String.format("me/%s", new Object[] {
                s
            }), jsonobject, callback);
        }
    }

    public static GraphRequest newPostOpenGraphObjectRequest(AccessToken accesstoken, String s, String s1, String s2, String s3, String s4, JSONObject jsonobject, com.facebook.GraphRequest.Callback callback)
    {
        return newPostOpenGraphObjectRequest(accesstoken, GraphUtil.createOpenGraphObjectForPost(s, s1, s2, s3, s4, jsonobject, null), callback);
    }

    public static GraphRequest newPostOpenGraphObjectRequest(AccessToken accesstoken, JSONObject jsonobject, com.facebook.GraphRequest.Callback callback)
    {
        if (jsonobject == null)
        {
            throw new FacebookException("openGraphObject cannot be null");
        }
        if (Utility.isNullOrEmpty(jsonobject.optString("type")))
        {
            throw new FacebookException("openGraphObject must have non-null 'type' property");
        }
        if (Utility.isNullOrEmpty(jsonobject.optString("title")))
        {
            throw new FacebookException("openGraphObject must have non-null 'title' property");
        } else
        {
            String s = String.format("me/objects/%s", new Object[] {
                jsonobject.optString("type")
            });
            Bundle bundle = new Bundle();
            bundle.putString("object", jsonobject.toString());
            return new GraphRequest(accesstoken, s, bundle, HttpMethod.POST, callback);
        }
    }

    public static GraphRequest newStatusUpdateRequest(AccessToken accesstoken, String s, com.facebook.GraphRequest.Callback callback)
    {
        return newStatusUpdateRequest(accesstoken, s, (String)null, null, callback);
    }

    private static GraphRequest newStatusUpdateRequest(AccessToken accesstoken, String s, String s1, List list, com.facebook.GraphRequest.Callback callback)
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", s);
        if (s1 != null)
        {
            bundle.putString("place", s1);
        }
        if (list != null && list.size() > 0)
        {
            bundle.putString("tags", TextUtils.join(",", list));
        }
        return new GraphRequest(accesstoken, "me/feed", bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newStatusUpdateRequest(AccessToken accesstoken, String s, JSONObject jsonobject, List list, com.facebook.GraphRequest.Callback callback)
    {
        ArrayList arraylist = null;
        if (list != null)
        {
            ArrayList arraylist1 = new ArrayList(list.size());
            list = list.iterator();
            do
            {
                arraylist = arraylist1;
                if (!list.hasNext())
                {
                    break;
                }
                arraylist1.add(((JSONObject)list.next()).optString("id"));
            } while (true);
        }
        if (jsonobject == null)
        {
            jsonobject = null;
        } else
        {
            jsonobject = jsonobject.optString("id");
        }
        return newStatusUpdateRequest(accesstoken, s, ((String) (jsonobject)), ((List) (arraylist)), callback);
    }

    public static GraphRequest newUpdateOpenGraphObjectRequest(AccessToken accesstoken, String s, String s1, String s2, String s3, String s4, JSONObject jsonobject, com.facebook.GraphRequest.Callback callback)
    {
        return newUpdateOpenGraphObjectRequest(accesstoken, GraphUtil.createOpenGraphObjectForPost(null, s1, s2, s3, s4, jsonobject, s), callback);
    }

    public static GraphRequest newUpdateOpenGraphObjectRequest(AccessToken accesstoken, JSONObject jsonobject, com.facebook.GraphRequest.Callback callback)
    {
        if (jsonobject == null)
        {
            throw new FacebookException("openGraphObject cannot be null");
        }
        String s = jsonobject.optString("id");
        if (s == null)
        {
            throw new FacebookException("openGraphObject must have an id");
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("object", jsonobject.toString());
            return new GraphRequest(accesstoken, s, bundle, HttpMethod.POST, callback);
        }
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accesstoken, Bitmap bitmap, com.facebook.GraphRequest.Callback callback)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", bitmap);
        return new GraphRequest(accesstoken, "me/photos", bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accesstoken, Uri uri, com.facebook.GraphRequest.Callback callback)
        throws FileNotFoundException
    {
        if (Utility.isFileUri(uri))
        {
            return newUploadPhotoRequest(accesstoken, new File(uri.getPath()), callback);
        }
        if (!Utility.isContentUri(uri))
        {
            throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
        } else
        {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("picture", uri);
            return new GraphRequest(accesstoken, "me/photos", bundle, HttpMethod.POST, callback);
        }
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accesstoken, File file, com.facebook.GraphRequest.Callback callback)
        throws FileNotFoundException
    {
        file = ParcelFileDescriptor.open(file, 0x10000000);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", file);
        return new GraphRequest(accesstoken, "me/photos", bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accesstoken, Bitmap bitmap, com.facebook.GraphRequest.Callback callback)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", bitmap);
        return new GraphRequest(accesstoken, "me/staging_resources", bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accesstoken, Uri uri, com.facebook.GraphRequest.Callback callback)
        throws FileNotFoundException
    {
        if (Utility.isFileUri(uri))
        {
            return newUploadStagingResourceWithImageRequest(accesstoken, new File(uri.getPath()), callback);
        }
        if (!Utility.isContentUri(uri))
        {
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        } else
        {
            uri = new com.facebook.GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", uri);
            return new GraphRequest(accesstoken, "me/staging_resources", bundle, HttpMethod.POST, callback);
        }
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accesstoken, File file, com.facebook.GraphRequest.Callback callback)
        throws FileNotFoundException
    {
        file = new com.facebook.GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 0x10000000), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", file);
        return new GraphRequest(accesstoken, "me/staging_resources", bundle, HttpMethod.POST, callback);
    }

    public static GraphRequest newUploadVideoRequest(AccessToken accesstoken, Uri uri, com.facebook.GraphRequest.Callback callback)
        throws FileNotFoundException
    {
        if (Utility.isFileUri(uri))
        {
            return newUploadVideoRequest(accesstoken, new File(uri.getPath()), callback);
        }
        if (!Utility.isContentUri(uri))
        {
            throw new FacebookException("The video Uri must be either a file:// or content:// Uri");
        } else
        {
            Object obj = FacebookSdk.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            int i = ((Cursor) (obj)).getColumnIndex("_display_name");
            ((Cursor) (obj)).moveToFirst();
            String s = ((Cursor) (obj)).getString(i);
            ((Cursor) (obj)).close();
            obj = new Bundle(1);
            ((Bundle) (obj)).putParcelable(s, uri);
            return new GraphRequest(accesstoken, "me/videos", ((Bundle) (obj)), HttpMethod.POST, callback);
        }
    }

    public static GraphRequest newUploadVideoRequest(AccessToken accesstoken, File file, com.facebook.GraphRequest.Callback callback)
        throws FileNotFoundException
    {
        ParcelFileDescriptor parcelfiledescriptor = ParcelFileDescriptor.open(file, 0x10000000);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(file.getName(), parcelfiledescriptor);
        return new GraphRequest(accesstoken, "me/videos", bundle, HttpMethod.POST, callback);
    }

    public static void registerSharerCallback(int i, CallbackManager callbackmanager, FacebookCallback facebookcallback)
    {
        if (!(callbackmanager instanceof CallbackManagerImpl))
        {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        } else
        {
            ((CallbackManagerImpl)callbackmanager).registerCallback(i, new com.facebook.internal.CallbackManagerImpl.Callback(i, facebookcallback) {

                final FacebookCallback val$callback;
                final int val$requestCode;

                public boolean onActivityResult(int j, Intent intent)
                {
                    return ShareInternalUtility.handleActivityResult(requestCode, j, intent, ShareInternalUtility.getShareResultProcessor(callback));
                }

            
            {
                requestCode = i;
                callback = facebookcallback;
                super();
            }
            });
            return;
        }
    }

    public static void registerStaticShareCallback(int i)
    {
        CallbackManagerImpl.registerStaticCallback(i, new com.facebook.internal.CallbackManagerImpl.Callback(i) {

            final int val$requestCode;

            public boolean onActivityResult(int j, Intent intent)
            {
                return ShareInternalUtility.handleActivityResult(requestCode, j, intent, ShareInternalUtility.getShareResultProcessor(null));
            }

            
            {
                requestCode = i;
                super();
            }
        });
    }

    public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jsonarray, boolean flag)
        throws JSONException
    {
        JSONArray jsonarray1 = new JSONArray();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            Object obj1 = jsonarray.get(i);
            Object obj;
            if (obj1 instanceof JSONArray)
            {
                obj = removeNamespacesFromOGJsonArray((JSONArray)obj1, flag);
            } else
            {
                obj = obj1;
                if (obj1 instanceof JSONObject)
                {
                    obj = removeNamespacesFromOGJsonObject((JSONObject)obj1, flag);
                }
            }
            jsonarray1.put(obj);
            i++;
        }
        return jsonarray1;
    }

    public static JSONObject removeNamespacesFromOGJsonObject(JSONObject jsonobject, boolean flag)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        jsonobject = null;
_L8:
        return jsonobject;
_L2:
        Object obj;
        JSONObject jsonobject1;
        JSONObject jsonobject2;
        Object obj2;
        int i;
        Object obj1;
        JSONArray jsonarray;
        String s;
        try
        {
            jsonobject1 = new JSONObject();
            jsonobject2 = new JSONObject();
            jsonarray = jsonobject.names();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new FacebookException("Failed to create json object from share content");
        }
        i = 0;
_L9:
        if (i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_223;
        }
        s = jsonarray.getString(i);
        obj1 = jsonobject.get(s);
        if (!(obj1 instanceof JSONObject)) goto _L4; else goto _L3
_L3:
        obj = removeNamespacesFromOGJsonObject((JSONObject)obj1, true);
_L6:
        obj2 = getFieldNameAndNamespaceFromFullName(s);
        obj1 = (String)((Pair) (obj2)).first;
        obj2 = (String)((Pair) (obj2)).second;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        if (((String) (obj1)).equals("fbsdk"))
        {
            jsonobject1.put(s, obj);
            break MISSING_BLOCK_LABEL_245;
        }
        break MISSING_BLOCK_LABEL_161;
_L4:
        obj = obj1;
        if (!(obj1 instanceof JSONArray)) goto _L6; else goto _L5
_L5:
        obj = removeNamespacesFromOGJsonArray((JSONArray)obj1, true);
          goto _L6
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        if (!((String) (obj1)).equals("og"))
        {
            break MISSING_BLOCK_LABEL_200;
        }
        jsonobject1.put(((String) (obj2)), obj);
        break MISSING_BLOCK_LABEL_245;
        jsonobject2.put(((String) (obj2)), obj);
        break MISSING_BLOCK_LABEL_245;
        jsonobject1.put(((String) (obj2)), obj);
        break MISSING_BLOCK_LABEL_245;
        jsonobject = jsonobject1;
        if (jsonobject2.length() <= 0) goto _L8; else goto _L7
_L7:
        jsonobject1.put("data", jsonobject2);
        return jsonobject1;
        i++;
          goto _L9
    }

    public static JSONObject toJSONObjectForCall(UUID uuid, ShareOpenGraphAction shareopengraphaction)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        uuid = OpenGraphJSONUtility.toJSONObject(shareopengraphaction, new OpenGraphJSONUtility.PhotoJSONProcessor(uuid, arraylist) {

            final ArrayList val$attachments;
            final UUID val$callId;

            public JSONObject toJSONObject(SharePhoto sharephoto)
            {
                Object obj = ShareInternalUtility.getAttachment(callId, sharephoto);
                if (obj != null) goto _L2; else goto _L1
_L1:
                obj = null;
_L4:
                return ((JSONObject) (obj));
_L2:
                attachments.add(obj);
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("url", ((com.facebook.internal.NativeAppCallAttachmentStore.Attachment) (obj)).getAttachmentUrl());
                }
                // Misplaced declaration of an exception variable
                catch (SharePhoto sharephoto)
                {
                    throw new FacebookException("Unable to attach images", sharephoto);
                }
                obj = jsonobject;
                if (!sharephoto.getUserGenerated()) goto _L4; else goto _L3
_L3:
                jsonobject.put("user_generated", true);
                return jsonobject;
            }

            
            {
                callId = uuid;
                attachments = arraylist;
                super();
            }
        });
        NativeAppCallAttachmentStore.addAttachments(arraylist);
        return uuid;
    }

    public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareopengraphcontent)
        throws JSONException
    {
        return OpenGraphJSONUtility.toJSONObject(shareopengraphcontent.getAction(), new OpenGraphJSONUtility.PhotoJSONProcessor() {

            public JSONObject toJSONObject(SharePhoto sharephoto)
            {
                sharephoto = sharephoto.getImageUrl();
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("url", sharephoto.toString());
                }
                // Misplaced declaration of an exception variable
                catch (SharePhoto sharephoto)
                {
                    throw new FacebookException("Unable to attach images", sharephoto);
                }
                return jsonobject;
            }

        });
    }




}
