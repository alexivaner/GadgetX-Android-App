// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi
{

    private final ShareContent shareContent;

    public ShareApi(ShareContent sharecontent)
    {
        shareContent = sharecontent;
    }

    private static void handleImagesOnAction(Bundle bundle)
    {
        String s = bundle.getString("image");
        if (s == null) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = new JSONArray(s);
        int i = 0;
_L11:
        if (i >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject = jsonarray.optJSONObject(i);
        if (jsonobject == null) goto _L6; else goto _L5
_L5:
        putImageInBundleWithArrayFormat(bundle, i, jsonobject);
          goto _L7
_L6:
        JSONException jsonexception;
        String s1 = jsonarray.getString(i);
        bundle.putString(String.format(Locale.ROOT, "image[%d][url]", new Object[] {
            Integer.valueOf(i)
        }), s1);
          goto _L7
_L9:
        putImageInBundleWithArrayFormat(bundle, 0, new JSONObject(s));
        bundle.remove("image");
_L2:
        return;
_L4:
        try
        {
            bundle.remove("image");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception) { }
        if (true) goto _L9; else goto _L8
_L8:
        bundle;
        return;
_L7:
        i++;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle, int i, JSONObject jsonobject)
        throws JSONException
    {
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", new Object[] {
    Integer.valueOf(i), s
}), jsonobject.get(s).toString()))
        {
            s = (String)iterator.next();
        }

    }

    public static void share(ShareContent sharecontent, FacebookCallback facebookcallback)
    {
        (new ShareApi(sharecontent)).share(facebookcallback);
    }

    private void shareLinkContent(ShareLinkContent sharelinkcontent, final FacebookCallback callback)
    {
        callback = new com.facebook.GraphRequest.Callback() {

            final ShareApi this$0;
            final FacebookCallback val$callback;

            public void onCompleted(GraphResponse graphresponse)
            {
                Object obj = graphresponse.getJSONObject();
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((JSONObject) (obj)).optString("id");
                }
                ShareInternalUtility.invokeCallbackWithResults(callback, ((String) (obj)), graphresponse);
            }

            
            {
                this$0 = ShareApi.this;
                callback = facebookcallback;
                super();
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("link", Utility.getUriString(sharelinkcontent.getContentUrl()));
        bundle.putString("picture", Utility.getUriString(sharelinkcontent.getImageUrl()));
        bundle.putString("name", sharelinkcontent.getContentTitle());
        bundle.putString("description", sharelinkcontent.getContentDescription());
        bundle.putString("ref", sharelinkcontent.getRef());
        (new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/feed", bundle, HttpMethod.POST, callback)).executeAsync();
    }

    private void shareOpenGraphContent(final ShareOpenGraphContent action, final FacebookCallback callback)
    {
        final com.facebook.GraphRequest.Callback requestCallback = new com.facebook.GraphRequest.Callback() {

            final ShareApi this$0;
            final FacebookCallback val$callback;

            public void onCompleted(GraphResponse graphresponse)
            {
                Object obj = graphresponse.getJSONObject();
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((JSONObject) (obj)).optString("id");
                }
                ShareInternalUtility.invokeCallbackWithResults(callback, ((String) (obj)), graphresponse);
            }

            
            {
                this$0 = ShareApi.this;
                callback = facebookcallback;
                super();
            }
        };
        action = action.getAction();
        final Bundle parameters = action.getBundle();
        stageOpenGraphAction(parameters, new com.facebook.internal.CollectionMapper.OnMapperCompleteListener() {

            final ShareApi this$0;
            final ShareOpenGraphAction val$action;
            final FacebookCallback val$callback;
            final Bundle val$parameters;
            final com.facebook.GraphRequest.Callback val$requestCallback;

            public void onComplete()
            {
                try
                {
                    ShareApi.handleImagesOnAction(parameters);
                    (new GraphRequest(AccessToken.getCurrentAccessToken(), (new StringBuilder()).append("/me/").append(URLEncoder.encode(action.getActionType(), "UTF-8")).toString(), parameters, HttpMethod.POST, requestCallback)).executeAsync();
                    return;
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    ShareInternalUtility.invokeCallbackWithException(callback, unsupportedencodingexception);
                }
            }

            public void onError(FacebookException facebookexception)
            {
                ShareInternalUtility.invokeCallbackWithException(callback, facebookexception);
            }

            
            {
                this$0 = ShareApi.this;
                parameters = bundle;
                action = shareopengraphaction;
                requestCallback = callback1;
                callback = facebookcallback;
                super();
            }
        });
    }

    private void sharePhotoContent(SharePhotoContent sharephotocontent, FacebookCallback facebookcallback)
    {
        Mutable mutable;
        AccessToken accesstoken;
        ArrayList arraylist;
        com.facebook.GraphRequest.Callback callback;
        mutable = new Mutable(Integer.valueOf(0));
        accesstoken = AccessToken.getCurrentAccessToken();
        arraylist = new ArrayList();
        callback = new com.facebook.GraphRequest.Callback() {

            final ShareApi this$0;
            final FacebookCallback val$callback;
            final ArrayList val$errorResponses;
            final Mutable val$requestCount;
            final ArrayList val$results;

            public void onCompleted(GraphResponse graphresponse)
            {
                JSONObject jsonobject = graphresponse.getJSONObject();
                if (jsonobject != null)
                {
                    results.add(jsonobject);
                }
                if (graphresponse.getError() != null)
                {
                    errorResponses.add(graphresponse);
                }
                requestCount.value = Integer.valueOf(((Integer)requestCount.value).intValue() - 1);
                if (((Integer)requestCount.value).intValue() == 0)
                {
                    if (!errorResponses.isEmpty())
                    {
                        ShareInternalUtility.invokeCallbackWithResults(callback, null, (GraphResponse)errorResponses.get(0));
                    } else
                    if (!results.isEmpty())
                    {
                        String s = ((JSONObject)results.get(0)).optString("id");
                        ShareInternalUtility.invokeCallbackWithResults(callback, s, graphresponse);
                        return;
                    }
                }
            }

            
            {
                this$0 = ShareApi.this;
                results = arraylist;
                errorResponses = arraylist1;
                requestCount = mutable;
                callback = facebookcallback;
                super();
            }
        };
        sharephotocontent = sharephotocontent.getPhotos().iterator();
_L3:
        android.graphics.Bitmap bitmap;
        Object obj;
        if (!sharephotocontent.hasNext())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        obj = (SharePhoto)sharephotocontent.next();
        bitmap = ((SharePhoto) (obj)).getBitmap();
        obj = ((SharePhoto) (obj)).getImageUrl();
        if (bitmap == null) goto _L2; else goto _L1
_L1:
        arraylist.add(ShareInternalUtility.newUploadPhotoRequest(accesstoken, bitmap, callback));
          goto _L3
        try
        {
            mutable.value = Integer.valueOf(((Integer)mutable.value).intValue() + arraylist.size());
            sharephotocontent = arraylist.iterator();
            while (sharephotocontent.hasNext()) 
            {
                ((GraphRequest)sharephotocontent.next()).executeAsync();
            }
        }
        // Misplaced declaration of an exception variable
        catch (SharePhotoContent sharephotocontent)
        {
            ShareInternalUtility.invokeCallbackWithException(facebookcallback, sharephotocontent);
        }
        return;
_L2:
        if (obj == null) goto _L3; else goto _L4
_L4:
        arraylist.add(ShareInternalUtility.newUploadPhotoRequest(accesstoken, ((android.net.Uri) (obj)), callback));
          goto _L3
    }

    private void shareVideoContent(ShareVideoContent sharevideocontent, final FacebookCallback callback)
    {
        Object obj = new com.facebook.GraphRequest.Callback() {

            final ShareApi this$0;
            final FacebookCallback val$callback;

            public void onCompleted(GraphResponse graphresponse)
            {
                Object obj1 = null;
                String s = obj1;
                if (graphresponse != null)
                {
                    JSONObject jsonobject = graphresponse.getJSONObject();
                    s = obj1;
                    if (jsonobject != null)
                    {
                        s = jsonobject.optString("id");
                    }
                }
                ShareInternalUtility.invokeCallbackWithResults(callback, s, graphresponse);
            }

            
            {
                this$0 = ShareApi.this;
                callback = facebookcallback;
                super();
            }
        };
        try
        {
            obj = ShareInternalUtility.newUploadVideoRequest(AccessToken.getCurrentAccessToken(), sharevideocontent.getVideo().getLocalUrl(), ((com.facebook.GraphRequest.Callback) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (ShareVideoContent sharevideocontent)
        {
            ShareInternalUtility.invokeCallbackWithException(callback, sharevideocontent);
            return;
        }
        callback = ((GraphRequest) (obj)).getParameters();
        callback.putString("title", sharevideocontent.getContentTitle());
        callback.putString("description", sharevideocontent.getContentDescription());
        callback.putString("ref", sharevideocontent.getRef());
        ((GraphRequest) (obj)).setParameters(callback);
        ((GraphRequest) (obj)).executeAsync();
    }

    private static void stageArrayList(ArrayList arraylist, com.facebook.internal.CollectionMapper.OnMapValueCompleteListener onmapvaluecompletelistener)
    {
        JSONArray jsonarray = new JSONArray();
        stageCollectionValues(new com.facebook.internal.CollectionMapper.Collection(arraylist, jsonarray) {

            final ArrayList val$arrayList;
            final JSONArray val$stagedObject;

            public Object get(Integer integer)
            {
                return arrayList.get(integer.intValue());
            }

            public volatile Object get(Object obj)
            {
                return get((Integer)obj);
            }

            public Iterator keyIterator()
            {
                int i = arrayList.size();
                return i. new Iterator() {

                    final _cls6 this$0;
                    final Mutable val$current;
                    final int val$size;

                    public boolean hasNext()
                    {
                        return ((Integer)current.value).intValue() < size;
                    }

                    public Integer next()
                    {
                        Integer integer = (Integer)current.value;
                        Mutable mutable = current;
                        mutable.value = Integer.valueOf(((Integer)mutable.value).intValue() + 1);
                        return integer;
                    }

                    public volatile Object next()
                    {
                        return next();
                    }

                    public void remove()
                    {
                    }

            
            {
                this$0 = final__pcls6;
                current = mutable;
                size = I.this;
                super();
            }
                };
            }

            public void set(Integer integer, Object obj, com.facebook.internal.CollectionMapper.OnErrorListener onerrorlistener)
            {
                try
                {
                    stagedObject.put(integer.intValue(), obj);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Integer integer)
                {
                    obj = integer.getLocalizedMessage();
                }
                integer = ((Integer) (obj));
                if (obj == null)
                {
                    integer = "Error staging object.";
                }
                onerrorlistener.onError(new FacebookException(integer));
            }

            public volatile void set(Object obj, Object obj1, com.facebook.internal.CollectionMapper.OnErrorListener onerrorlistener)
            {
                set((Integer)obj, obj1, onerrorlistener);
            }

            
            {
                arrayList = arraylist;
                stagedObject = jsonarray;
                super();
            }
        }, new com.facebook.internal.CollectionMapper.OnMapperCompleteListener(onmapvaluecompletelistener, jsonarray) {

            final com.facebook.internal.CollectionMapper.OnMapValueCompleteListener val$onArrayListStagedListener;
            final JSONArray val$stagedObject;

            public void onComplete()
            {
                onArrayListStagedListener.onComplete(stagedObject);
            }

            public void onError(FacebookException facebookexception)
            {
                onArrayListStagedListener.onError(facebookexception);
            }

            
            {
                onArrayListStagedListener = onmapvaluecompletelistener;
                stagedObject = jsonarray;
                super();
            }
        });
    }

    private static void stageCollectionValues(com.facebook.internal.CollectionMapper.Collection collection, com.facebook.internal.CollectionMapper.OnMapperCompleteListener onmappercompletelistener)
    {
        CollectionMapper.iterate(collection, new com.facebook.internal.CollectionMapper.ValueMapper() {

            public void mapValue(Object obj, com.facebook.internal.CollectionMapper.OnMapValueCompleteListener onmapvaluecompletelistener)
            {
                if (obj instanceof ArrayList)
                {
                    ShareApi.stageArrayList((ArrayList)obj, onmapvaluecompletelistener);
                    return;
                }
                if (obj instanceof ShareOpenGraphObject)
                {
                    ShareApi.stageOpenGraphObject((ShareOpenGraphObject)obj, onmapvaluecompletelistener);
                    return;
                }
                if (obj instanceof SharePhoto)
                {
                    ShareApi.stagePhoto((SharePhoto)obj, onmapvaluecompletelistener);
                    return;
                } else
                {
                    onmapvaluecompletelistener.onComplete(obj);
                    return;
                }
            }

        }, onmappercompletelistener);
    }

    private static void stageOpenGraphAction(Bundle bundle, com.facebook.internal.CollectionMapper.OnMapperCompleteListener onmappercompletelistener)
    {
        stageCollectionValues(new com.facebook.internal.CollectionMapper.Collection(bundle) {

            final Bundle val$parameters;

            public volatile Object get(Object obj)
            {
                return get((String)obj);
            }

            public Object get(String s)
            {
                return parameters.get(s);
            }

            public Iterator keyIterator()
            {
                return parameters.keySet().iterator();
            }

            public volatile void set(Object obj, Object obj1, com.facebook.internal.CollectionMapper.OnErrorListener onerrorlistener)
            {
                set((String)obj, obj1, onerrorlistener);
            }

            public void set(String s, Object obj, com.facebook.internal.CollectionMapper.OnErrorListener onerrorlistener)
            {
                if (!Utility.putJSONValueInBundle(parameters, s, obj))
                {
                    onerrorlistener.onError(new FacebookException((new StringBuilder()).append("Unexpected value: ").append(obj.toString()).toString()));
                }
            }

            
            {
                parameters = bundle;
                super();
            }
        }, onmappercompletelistener);
    }

    private static void stageOpenGraphObject(ShareOpenGraphObject shareopengraphobject, com.facebook.internal.CollectionMapper.OnMapValueCompleteListener onmapvaluecompletelistener)
    {
        String s1 = shareopengraphobject.getString("type");
        String s = s1;
        if (s1 == null)
        {
            s = shareopengraphobject.getString("og:type");
        }
        if (s == null)
        {
            onmapvaluecompletelistener.onError(new FacebookException("Open Graph objects must contain a type value."));
            return;
        } else
        {
            JSONObject jsonobject = new JSONObject();
            stageCollectionValues(new com.facebook.internal.CollectionMapper.Collection(shareopengraphobject, jsonobject) {

                final ShareOpenGraphObject val$object;
                final JSONObject val$stagedObject;

                public volatile Object get(Object obj)
                {
                    return get((String)obj);
                }

                public Object get(String s2)
                {
                    return object.get(s2);
                }

                public Iterator keyIterator()
                {
                    return object.keySet().iterator();
                }

                public volatile void set(Object obj, Object obj1, com.facebook.internal.CollectionMapper.OnErrorListener onerrorlistener)
                {
                    set((String)obj, obj1, onerrorlistener);
                }

                public void set(String s2, Object obj, com.facebook.internal.CollectionMapper.OnErrorListener onerrorlistener)
                {
                    try
                    {
                        stagedObject.put(s2, obj);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s2)
                    {
                        obj = s2.getLocalizedMessage();
                    }
                    s2 = ((String) (obj));
                    if (obj == null)
                    {
                        s2 = "Error staging object.";
                    }
                    onerrorlistener.onError(new FacebookException(s2));
                }

            
            {
                object = shareopengraphobject;
                stagedObject = jsonobject;
                super();
            }
            }, new com.facebook.internal.CollectionMapper.OnMapperCompleteListener(jsonobject, s, new com.facebook.GraphRequest.Callback(onmapvaluecompletelistener) {

                final com.facebook.internal.CollectionMapper.OnMapValueCompleteListener val$onOpenGraphObjectStagedListener;

                public void onCompleted(GraphResponse graphresponse)
                {
                    Object obj = graphresponse.getError();
                    if (obj != null)
                    {
                        String s2 = ((FacebookRequestError) (obj)).getErrorMessage();
                        obj = s2;
                        if (s2 == null)
                        {
                            obj = "Error staging Open Graph object.";
                        }
                        onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(graphresponse, ((String) (obj))));
                        return;
                    }
                    obj = graphresponse.getJSONObject();
                    if (obj == null)
                    {
                        onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(graphresponse, "Error staging Open Graph object."));
                        return;
                    }
                    obj = ((JSONObject) (obj)).optString("id");
                    if (obj == null)
                    {
                        onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(graphresponse, "Error staging Open Graph object."));
                        return;
                    } else
                    {
                        onOpenGraphObjectStagedListener.onComplete(obj);
                        return;
                    }
                }

            
            {
                onOpenGraphObjectStagedListener = onmapvaluecompletelistener;
                super();
            }
            }, onmapvaluecompletelistener) {

                final String val$ogType;
                final com.facebook.internal.CollectionMapper.OnMapValueCompleteListener val$onOpenGraphObjectStagedListener;
                final com.facebook.GraphRequest.Callback val$requestCallback;
                final JSONObject val$stagedObject;

                public void onComplete()
                {
                    String s2 = stagedObject.toString();
                    Object obj = new Bundle();
                    ((Bundle) (obj)).putString("object", s2);
                    try
                    {
                        (new GraphRequest(AccessToken.getCurrentAccessToken(), (new StringBuilder()).append("/me/objects/").append(URLEncoder.encode(ogType, "UTF-8")).toString(), ((Bundle) (obj)), HttpMethod.POST, requestCallback)).executeAsync();
                        return;
                    }
                    catch (UnsupportedEncodingException unsupportedencodingexception)
                    {
                        obj = unsupportedencodingexception.getLocalizedMessage();
                    }
                    unsupportedencodingexception = ((UnsupportedEncodingException) (obj));
                    if (obj == null)
                    {
                        unsupportedencodingexception = "Error staging Open Graph object.";
                    }
                    onOpenGraphObjectStagedListener.onError(new FacebookException(unsupportedencodingexception));
                }

                public void onError(FacebookException facebookexception)
                {
                    onOpenGraphObjectStagedListener.onError(facebookexception);
                }

            
            {
                stagedObject = jsonobject;
                ogType = s;
                requestCallback = callback;
                onOpenGraphObjectStagedListener = onmapvaluecompletelistener;
                super();
            }
            });
            return;
        }
    }

    private static void stagePhoto(SharePhoto sharephoto, com.facebook.internal.CollectionMapper.OnMapValueCompleteListener onmapvaluecompletelistener)
    {
        Object obj = sharephoto.getBitmap();
        android.net.Uri uri = sharephoto.getImageUrl();
        if (obj != null || uri != null)
        {
            sharephoto = new com.facebook.GraphRequest.Callback(onmapvaluecompletelistener, sharephoto) {

                final com.facebook.internal.CollectionMapper.OnMapValueCompleteListener val$onPhotoStagedListener;
                final SharePhoto val$photo;

                public void onCompleted(GraphResponse graphresponse)
                {
                    Object obj1 = graphresponse.getError();
                    if (obj1 != null)
                    {
                        String s1 = ((FacebookRequestError) (obj1)).getErrorMessage();
                        obj1 = s1;
                        if (s1 == null)
                        {
                            obj1 = "Error staging photo.";
                        }
                        onPhotoStagedListener.onError(new FacebookGraphResponseException(graphresponse, ((String) (obj1))));
                        return;
                    }
                    graphresponse = graphresponse.getJSONObject();
                    if (graphresponse == null)
                    {
                        onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                        return;
                    }
                    graphresponse = graphresponse.optString("uri");
                    if (graphresponse == null)
                    {
                        onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                        return;
                    }
                    obj1 = new JSONObject();
                    try
                    {
                        ((JSONObject) (obj1)).put("url", graphresponse);
                        ((JSONObject) (obj1)).put("user_generated", photo.getUserGenerated());
                    }
                    // Misplaced declaration of an exception variable
                    catch (GraphResponse graphresponse)
                    {
                        String s = graphresponse.getLocalizedMessage();
                        graphresponse = s;
                        if (s == null)
                        {
                            graphresponse = "Error staging photo.";
                        }
                        onPhotoStagedListener.onError(new FacebookException(graphresponse));
                        return;
                    }
                    onPhotoStagedListener.onComplete(obj1);
                }

            
            {
                onPhotoStagedListener = onmapvaluecompletelistener;
                photo = sharephoto;
                super();
            }
            };
            if (obj != null)
            {
                ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), ((android.graphics.Bitmap) (obj)), sharephoto).executeAsync();
                return;
            }
            try
            {
                ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), uri, sharephoto).executeAsync();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SharePhoto sharephoto)
            {
                obj = sharephoto.getLocalizedMessage();
            }
            sharephoto = ((SharePhoto) (obj));
            if (obj == null)
            {
                sharephoto = "Error staging photo.";
            }
            onmapvaluecompletelistener.onError(new FacebookException(sharephoto));
            return;
        } else
        {
            onmapvaluecompletelistener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
            return;
        }
    }

    public boolean canShare()
    {
        Object obj;
        if (getShareContent() != null)
        {
            if ((obj = AccessToken.getCurrentAccessToken()) != null && (obj = ((AccessToken) (obj)).getPermissions()) != null)
            {
                return ((Set) (obj)).contains("publish_actions");
            }
        }
        return false;
    }

    public ShareContent getShareContent()
    {
        return shareContent;
    }

    public void share(FacebookCallback facebookcallback)
    {
        if (!canShare())
        {
            ShareInternalUtility.invokeCallbackWithError(facebookcallback, "Insufficient permissions for sharing content via Api.");
        } else
        {
            Object obj = getShareContent();
            try
            {
                ShareContentValidation.validateForApiShare(((ShareContent) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ShareInternalUtility.invokeCallbackWithException(facebookcallback, ((Exception) (obj)));
                return;
            }
            if (obj instanceof ShareLinkContent)
            {
                shareLinkContent((ShareLinkContent)obj, facebookcallback);
                return;
            }
            if (obj instanceof SharePhotoContent)
            {
                sharePhotoContent((SharePhotoContent)obj, facebookcallback);
                return;
            }
            if (obj instanceof ShareVideoContent)
            {
                shareVideoContent((ShareVideoContent)obj, facebookcallback);
                return;
            }
            if (obj instanceof ShareOpenGraphContent)
            {
                shareOpenGraphContent((ShareOpenGraphContent)obj, facebookcallback);
                return;
            }
        }
    }




}
