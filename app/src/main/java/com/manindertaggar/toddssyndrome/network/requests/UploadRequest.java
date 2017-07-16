package com.manindertaggar.toddssyndrome.network.requests;

import android.content.Context;

import com.manindertaggar.toddssyndrome.BaseApplication;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.network.NetworkConstants;
import com.manindertaggar.toddssyndrome.network.callbacks.UploadCallback;
import com.manindertaggar.toddssyndrome.network.core.HttpRequest;
import com.manindertaggar.toddssyndrome.network.core.RequestCallback;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class UploadRequest extends HttpRequest {

    private Context context;

    public UploadRequest(Context context) {
        super(context);
        this.context = context;
    }


    public UploadRequest send(SyndromTest syndromTest) {
        RequestBody formBody = new FormBody.Builder()
                .add("action", NetworkConstants.ACTION_UPLOAD)
                .add("deviceId", BaseApplication.getDeviceId())
                .add("data", syndromTest.toString())
                .build();

        RequestCallback callback = new UploadCallback(context,syndromTest);
        super.send(NetworkConstants.BASE_URL, HttpRequest.POST, formBody, callback);
        return this;
    }
}

