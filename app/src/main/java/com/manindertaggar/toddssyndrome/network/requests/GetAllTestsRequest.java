package com.manindertaggar.toddssyndrome.network.requests;

import android.content.Context;

import com.manindertaggar.toddssyndrome.BaseApplication;
import com.manindertaggar.toddssyndrome.network.NetworkConstants;
import com.manindertaggar.toddssyndrome.network.callbacks.GetAllTestsCallback;
import com.manindertaggar.toddssyndrome.network.core.HttpRequest;
import com.manindertaggar.toddssyndrome.network.core.RequestCallback;

import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class GetAllTestsRequest extends HttpRequest {

    private Context context;

    public GetAllTestsRequest(Context context) {
        super(context);
        this.context = context;
    }

    public void send() {
        RequestBody formBody = new FormBody.Builder()
                .add("action", NetworkConstants.ACTION_GET_ALL)
                .add("deviceId", BaseApplication.getDeviceId())
                .build();

        RequestCallback callback = new GetAllTestsCallback(context);
        super.send(NetworkConstants.BASE_URL, HttpRequest.POST, formBody, callback);
    }

}

