package com.manindertaggar.toddssyndrome.network.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by Maninder Taggar on 12/4/16.
 */
public abstract class HttpRequest {
    public static final String POST = "post";
    public static final String PUT = "put";
    public static final String GET = "get";
    public static final String DELETE = "delete";
    public static final String PATCH = "patch";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_TEXT_JSON = "text/json";
    private static final String TAG = HttpRequest.class.getCanonicalName();
    private static MediaType JSON = null;
    protected final Context context;
    private Call call;


    public HttpRequest(Context context) {
        this.context = context;

    }

    public void cancel() {
        try {
            if (call != null && !call.isCanceled()) {
                call.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String url, String requestType, RequestBody requestBody, RequestCallback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response originalResponse = chain.proceed(chain.request());
                        return originalResponse.newBuilder()
                                .body(new ProgressResponseBody(originalResponse.body(), HttpRequest.this))
                                .build();
                    }
                })
                .build();

        Request.Builder requestBuilder = new Request.Builder()
                .addHeader(HEADER_CONTENT_TYPE, HEADER_TEXT_JSON)
                .url(url);

        Request httpRequest = getHttpRequest(requestBuilder, requestType, requestBody);

        if (callback != null)
            client.newCall(httpRequest).enqueue(callback);
        else
            client.newCall(httpRequest);

    }

    private Request getHttpRequest(Request.Builder requestBuilder, String requestType, RequestBody body) {

        Request request = null;

        switch (requestType) {
            case POST:
                request = requestBuilder.post(body).build();
                break;
            case PUT:
                request = requestBuilder.put(body).build();
                break;
            case PATCH:
                request = requestBuilder.patch(body).build();
                break;
            case GET:
                request = requestBuilder.get().build();
                break;
            case DELETE:
                request = requestBuilder.delete().build();
                break;
        }

        return request;
    }


    private class ProgressResponseBody extends ResponseBody {

        private final ResponseBody responseBody;
        private BufferedSource bufferedSource;
        private HttpRequest httpRequest;
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        ProgressResponseBody(ResponseBody responseBody, HttpRequest httpRequest) {
            this.responseBody = responseBody;
            this.httpRequest = httpRequest;
        }

        @Override
        public MediaType contentType() {
            return responseBody.contentType();
        }

        @Override
        public long contentLength() {
            return responseBody.contentLength();
        }

        @Override
        public BufferedSource source() {
            if (bufferedSource == null) {
                bufferedSource = Okio.buffer(source(responseBody.source()));
            }
            return bufferedSource;
        }

        private Source source(Source source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0L;

                @Override
                public long read(Buffer sink, long byteCount) throws IOException {
                    final long bytesRead = super.read(sink, byteCount);
                    // read() returns the number of bytes read, or -1 if this source is exhausted.
                    totalBytesRead += bytesRead != -1 ? bytesRead : 0;

                    return bytesRead;
                }
            };
        }
    }
}
