package almeida.joao.neocat.celebracoesneocat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void celbPalavra(View view) {
        Intent intent = new Intent(this, CelebracaoPalavra.class);
        startActivity(intent);
    }

    protected void eucaristia(View view) {
        Intent intent = new Intent(this, Eucaristia.class);
        startActivity(intent);
    }
}
