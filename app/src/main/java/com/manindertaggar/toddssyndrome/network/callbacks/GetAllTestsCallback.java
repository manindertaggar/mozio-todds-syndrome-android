package com.manindertaggar.toddssyndrome.network.callbacks;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.manindertaggar.toddssyndrome.SyndromTest;
import com.manindertaggar.toddssyndrome.network.core.RequestCallback;
import com.manindertaggar.toddssyndrome.network.core.ShowableException;
import com.manindertaggar.toddssyndrome.storage.Dao;
import com.manindertaggar.toddssyndrome.storage.Pref;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Maninder Taggar on 10/12/16.
 */

public class GetAllTestsCallback extends RequestCallback {

    private static final String TAG = GetAllTestsCallback.class.getCanonicalName();
    private Context context;

    public GetAllTestsCallback(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        showError(e);
    }

    private void showError(final Exception e) {
        Log.e(TAG, e.toString());
        Toast.makeText(context, "Sync Failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(Call call, Response rawResponse) throws IOException {
        //this response is raw incoming object
        final String response = rawResponse.body().string();
        Log.d(TAG, "onResponse: " + response);

        try {
            JSONObject responseObject = new JSONObject(response);
            if (!responseObject.getBoolean("isError")) {
                onResponse(responseObject.getJSONObject("data"));
            } else {
                showError(new ShowableException(responseObject.getString("message")));
            }
        } catch (JSONException e) {
            Log.e(TAG, "parsing error");
            showError(e);
            return;
        }

    }


    private void onResponse(JSONObject dataObject) {
        try {
            JSONArray records = dataObject.getJSONArray("records");

            int length = records.length();
            for (int i = 0; i < length; i++) {
                SyndromTest syndromTest = new Gson().fromJson(records.get(i).toString(), SyndromTest.class);
                syndromTest.setId(null);
                Dao.getSyndromeDao().insert(syndromTest);
            }
            Pref.getInstance().setDataSynced(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
