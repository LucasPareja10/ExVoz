package com.example.exvoz;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private EditText edTexto;
    private Button btOuvir, btFalar;
    private TextToSpeech textoFala;
    private ListView lstv;
    private Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoFala = new TextToSpeech(MainActivity.this, MainActivity.this);
        edTexto = (EditText) findViewById(R.id.edtTexto);
        botoes();
    }

    private void botoes() {
        btFalar = (Button) findViewById(R.id.btnFalar);
        btFalar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = edTexto.getText().toString();
                textoFala.speak(texto, TextToSpeech.QUEUE_FLUSH, Bundle.EMPTY, "1");
            }
        });
    }
        @Override
        public void onInit ( int status){
            locale = new Locale("pt", "BR");
            textoFala.setLanguage(locale);
        }
    }