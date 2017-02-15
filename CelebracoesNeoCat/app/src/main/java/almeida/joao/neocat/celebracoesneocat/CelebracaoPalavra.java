package almeida.joao.neocat.celebracoesneocat;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CelebracaoPalavra extends Activity {

    private ArrayList<String> parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebracao_palavra);
    }

    protected void enviarCelb(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
        shareIntent.setType("text/html");
        shareIntent.setData(Uri.parse("mailto:"));
        prepareParameters();
        String body = HtmlBodyBuilder.getHtmlBody(1, parameters);
        String[] emails = {"joaopedrolealalmeida@gmail.com"};
        shareIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "celebrações test");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                Html.fromHtml(body));
        try {
            startActivity(Intent.createChooser(shareIntent, "Enviar email..."));
        }catch(ActivityNotFoundException ex) {
            Toast.makeText(this, "Aplicação para enviar email inexistente", Toast.LENGTH_SHORT).show();
        }
    }

    private void prepareParameters() {
        parameters = new ArrayList<String>();
        parameters.add(((EditText)findViewById(R.id.admAmbText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.cantEntText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.prLeitText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.prAdmText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.prCantText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.segLeitText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.segAdmText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.segCantText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.terLeitText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.terAdmText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.terCantText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.envText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.envAdmText)).getText().toString());
        parameters.add(((EditText)findViewById(R.id.cantFinalText)).getText().toString());
    }
}
