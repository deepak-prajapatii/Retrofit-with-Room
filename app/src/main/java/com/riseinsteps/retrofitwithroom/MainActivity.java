package com.riseinsteps.retrofitwithroom;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView page, perPage, total, totalPage;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        fetchDataViaRetrofit();

//        BT bt = new BT();
//        new Thread().start();

    }

    private void initComponents() {
        page = findViewById(R.id.page);
        perPage = findViewById(R.id.perPage);
        total = findViewById(R.id.total);
        totalPage = findViewById(R.id.totalPages);
    }

    private void fetchDataViaRetrofit() {
        ApiClient apiClient = ApiClient.getInstance();
        Call<Model> call = apiClient.getModels();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Error Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                model = response.body();

                page.setText("Page: " + model.getPage().toString());
                perPage.setText("Per Page: " + model.getPer_page().toString());
                total.setText("Total: " + model.getTotal().toString());
                totalPage.setText("Total Pages: " + model.getTotal_pages().toString());

                BackgroundThread backgroundThread = new BackgroundThread(model);
                new Thread(backgroundThread).start();

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class BackgroundThread implements Runnable {
        private Model model;

        public BackgroundThread(Model model) {
            this.model = model;
        }

        @Override
        public void run() {
            Repository repository = new Repository(getApplication());
            repository.insert(model);
            Log.d(TAG, "Display Data: " + model.getPer_page());
        }
    }


    private class BT implements Runnable {

        @Override
        public void run() {

        }
    }
}