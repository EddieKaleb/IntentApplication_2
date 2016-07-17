package br.edu.ifpb.intentapplication_2;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void abrirConfig(View view){
        Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    public void abrirMaps(View view){
        String url = "https://www.google.com.br/maps";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void abrirMusica(View view){
        EditText mus = (EditText) findViewById(R.id.txtMus);

        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
        intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, mus.getText().toString());
        intent.putExtra(SearchManager.QUERY, mus.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void abrirSMS(View view){
        EditText nome = (EditText) findViewById(R.id.txtNome);
        EditText sms = (EditText) findViewById(R.id.txtSMS);
        Uri uri = Uri.parse("smsto:" + nome.getText().toString());
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", sms.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void criarAlarme(View view){
        EditText h = (EditText) findViewById(R.id.txtHora);
        EditText m = (EditText) findViewById(R.id.txtMin);
        String hora = h.getText().toString();
        String min = m.getText().toString();
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarme");
        intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hora));
        intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(min));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void buscaDireta(View view){
        EditText buscar = (EditText)findViewById(R.id.txtBusca);
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY,buscar.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
