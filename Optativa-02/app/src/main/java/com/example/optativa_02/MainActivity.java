package com.example.optativa_02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnGetFact;

    private static final String BASE_URL = "https://catfact.ninja/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txtResultado);
        btnGetFact = findViewById(R.id.btnGetFact);

        btnGetFact.setOnClickListener(v -> obtenerDatoDeGato());
    }

    private void obtenerDatoDeGato() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CatFactService service = retrofit.create(CatFactService.class);
        Call<CatFact> call = service.getCatFact();

        call.enqueue(new Callback<CatFact>() {
            @Override
            public void onResponse(Call<CatFact> call, Response<CatFact> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String fact = response.body().getFact();
                    txtResultado.setText(fact);
                    Log.d("CAT_FACT", fact);
                } else {
                    txtResultado.setText("Error: respuesta no válida");
                }
            }

            @Override
            public void onFailure(Call<CatFact> call, Throwable t) {
                txtResultado.setText("Error en la solicitud: " + t.getMessage());
                Log.e("RETROFIT_ERROR", t.getMessage(), t);
            }
        });
    }
}

