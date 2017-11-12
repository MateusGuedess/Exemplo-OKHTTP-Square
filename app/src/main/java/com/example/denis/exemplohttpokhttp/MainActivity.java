package com.example.denis.exemplohttpokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnSendRequest;

    private EditText etJsonResponse;

    private TextView textView;

    private OkHttpClient okHttpClient;

    private Request request;

    private String url = "http://www.mocky.io/v2/5a07ccb62f0000b111e610f6";

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendRequest = findViewById(R.id.btnSendRequest);

        textView = findViewById(R.id.textView);

        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okHttpClient = new OkHttpClient();

                request = new Request.Builder().url(url).build();

                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i(TAG, "onFailure: "+e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i(TAG, "onResponse: "+response.body().string());

                    }
                });

            }
        });

    }
}
