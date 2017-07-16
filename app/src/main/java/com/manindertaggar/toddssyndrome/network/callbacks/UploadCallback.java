package com.manindertaggar.toddssyndrome.network.callbacks;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.manindertaggar.toddssyndrome.network.core.RequestCallback;
import com.manindertaggar.toddssyndrome.network.core.ShowableException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class UploadCallback extends RequestCallback {

    private static final String TAG = UploadCallback.class.getCanonicalName();
    private Context context;

    public UploadCallback(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        showError(e);
    }

    private void showError(final Exception e) {
        Log.e(TAG, e.toString());
        getHandler().post(new Runnable() {
            @Override
            public void run() {
                if (e instanceof ShowableException) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onResponse(Call call, Response rawResponse) throws IOException {
        //this response is raw incoming object
        final String response = rawResponse.body().string();
        Log.d(TAG, "onResponse: " + response);

        getHandler().post(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject responseObject = new JSONObject(response);
                    if (responseObject.getBoolean("isError")) {
                        showError(new ShowableException(responseObject.getString("message")));
                    } else {
                        Log.d(TAG, "run: upload success");
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "parsing error");
                    showError(e);
                    return;
                }
            }
        });
    }


}
