package almeida.joao.neocat.celebracoesneocat;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

public class CelebracaoPalavra extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebracao_palavra);
    }

    protected void enviarCelb(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/html");
        shareIntent.putExtra(Intent.EXTRA_EMAIL, "joaopedrolealalmeida@gmail.com");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "celebrações test");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                Html.fromHtml(new StringBuilder()
                        .append("<p><b>Some Content</b></p>")
                        .append("<small><p>More content</p></small>")
                        .toString()));
        try {
            startActivity(Intent.createChooser(shareIntent, "Enviar email..."));
        }catch(ActivityNotFoundException ex) {
            Toast.makeText(this, "Aplicação para enviar email inexistente", Toast.LENGTH_SHORT).show();
        }
    }
}
