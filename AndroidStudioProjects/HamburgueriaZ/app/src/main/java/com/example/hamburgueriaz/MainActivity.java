package com.example.hamburgueriaz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int quantidade = 1;
    private final int precoBaseHamburguer = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtNomeCliente = findViewById(R.id.etNomeCliente);
        CheckBox checkBacon = findViewById(R.id.cbBacon);
        CheckBox checkQueijo = findViewById(R.id.cbQueijo);
        CheckBox checkOnionRings = findViewById(R.id.cbOnion);
        TextView txtQuantidade = findViewById(R.id.tvQuantidade);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnSubtrair = findViewById(R.id.btnSubtrair);
        Button btnEnviarPedido = findViewById(R.id.btnFazerPedido);
        TextView txtResumoPedido = findViewById(R.id.tvPrecoTotal);

        btnAdicionar.setOnClickListener(v -> {
            quantidade++;
            txtQuantidade.setText(String.valueOf(quantidade));
        });

        btnSubtrair.setOnClickListener(v -> {
            if (quantidade > 0) {
                quantidade--;
                txtQuantidade.setText(String.valueOf(quantidade));
            }
        });

        btnEnviarPedido.setOnClickListener(v -> {
            String nomeCliente = edtNomeCliente.getText().toString();
            boolean temBacon = checkBacon.isChecked();
            boolean temQueijo = checkQueijo.isChecked();
            boolean temOnionRings = checkOnionRings.isChecked();
            int precoFinal = calcularPreco(temBacon, temQueijo, temOnionRings, quantidade);

            String mensagemPedido = "Nome do cliente: " + nomeCliente +
                    "\nTem Bacon? " + (temBacon ? "Sim" : "Não") +
                    "\nTem Queijo? " + (temQueijo ? "Sim" : "Não") +
                    "\nTem Onion Rings? " + (temOnionRings ? "Sim" : "Não") +
                    "\nQuantidade: " + quantidade +
                    "\nPreço final: R$ " + precoFinal;

            // Mostra resumo no TextView (opcional)
            txtResumoPedido.setText(mensagemPedido);

            // Envia o pedido por e-mail
            enviarPedido(nomeCliente, mensagemPedido);
        });
    }

    private int calcularPreco(boolean temBacon, boolean temQueijo, boolean temOnionRings, int quantidade) {
        int adicional = 0;
        if (temBacon) adicional += 2;
        if (temQueijo) adicional += 2;
        if (temOnionRings) adicional += 3;

        return (precoBaseHamburguer + adicional) * quantidade;
    }

    private void enviarPedido(String nomeCliente, String mensagemPedido) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Apenas apps de e-mail responderão
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"destinatario@email.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido de " + nomeCliente);
        intent.putExtra(Intent.EXTRA_TEXT, mensagemPedido);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Escolha o app de e-mail"));
        } else {
            Toast.makeText(MainActivity.this, "Nenhum app de e-mail disponível.", Toast.LENGTH_LONG).show();
        }
    }
}