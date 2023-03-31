package toraes.dos.santos.lorena.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        //Definição da ação do click do botão.

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtendo dados digitados pelo usuário
                EditText etEmail = (EditText) findViewById(R.id.etEmail); //FindView é usado para localizar um elemento pelo id
                String email = etEmail.getText().toString();
                EditText etAssunto = (EditText) findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();
                EditText etTexto = (EditText) findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString(); // Retornando o texto por meio do id

                Intent i = new Intent(Intent.ACTION_SENDTO); // Passando o parâmetro de ação para enviar para alguma pessoa
                i.setData(Uri.parse("mailto:")); // Indicando que eu quero que respondandam pelo sendto e pela url ( mailto = relacionado a email)
                String[] emails = new String[] {email}; // Nova array de email
                i.putExtra(Intent.EXTRA_EMAIL, emails); // O putExtra adicionan valores ao bundle interno da intent
                i.putExtra(Intent.EXTRA_SUBJECT,assunto);
                i.putExtra(Intent.EXTRA_TEXT,texto);

                try {
                    startActivity(Intent.createChooser(i, "Escolha o app")); // Executando o Intent
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que possa realizar essa operação" , Toast.LENGTH_LONG).show();
                }
        }});
        }
        }