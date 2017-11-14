package almeida.joao.neocat.celebracoesneocat;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.support.v4.content.FileProvider.getUriForFile;

public class CelebracaoPalavra extends Activity {

    private ArrayList<String> parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebracao_palavra);
    }

    protected void enviarCelb(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
        shareIntent.setType("application/image");
        shareIntent.setData(Uri.parse("mailto:"));
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        shareIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        prepareParameters();
        Bitmap image = loadBitmapFromView((TableLayout)findViewById(R.id.activity_celebracao_palavra));
        File imageFile = saveImageFile(image);
        Uri contentUri = getUriForFile(this, "almeida.joao.neocat.fileprovider", imageFile);
        String body = HtmlBodyBuilder.getHtmlBody(1, parameters);
        String[] emails = {"joaopedrolealalmeida@gmail.com"};
        shareIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "celebrações test");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(body, 0)); //Html.fromHtml(body));
        shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
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

    public File saveImageFile(Bitmap image) {
        String path = "";
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        File f = new File(Environment.getExternalStorageDirectory()
                + File.separator + "test.jpg");
        try {
            image.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

//you can create a new file name "test.jpg" in sdcard folder.

            f.createNewFile();
//write the bytes in file
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            fo.close();
            path = f.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bytes != null) {
                    bytes.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return f;

// remember close de FileOutput

    }

    public static Bitmap loadBitmapFromView(TableLayout v) {
        /*Bitmap b = Bitmap.createBitmap(
                v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getWidth(), v.getHeight());
        v.draw(c);
        return b;*/
        //v.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        //int width = v.getMeasuredWidth();
        //int height = v.getMeasuredHeight();
        //v.layout(0, 0, width, height);
        v.setDrawingCacheEnabled(true);
        v.buildDrawingCache();
        Bitmap b = Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false);
        return b;
    }
}
