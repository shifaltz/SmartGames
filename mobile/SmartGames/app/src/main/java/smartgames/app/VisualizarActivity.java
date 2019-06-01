package smartgames.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import smartgames.app.modelo.Jogo;


public class VisualizarActivity extends AppCompatActivity{

    private TextView txtNome;
    private TextView txtPreco;
    private TextView txtDesenvolvedor;
    private TextView txtPlataforma;
    private TextView txtGenero;
    private TextView txtLoja;
    private TextView txtImagem;
    private Jogo jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar_activity);

        txtNome = findViewById(R.id.txt_nome);
        txtPreco = findViewById(R.id.txt_preco);
        txtDesenvolvedor = findViewById(R.id.txt_desenvolvedor);
        txtPlataforma = findViewById(R.id.txt_plataforma);
        txtGenero = findViewById(R.id.txt_genero);
        txtLoja = findViewById(R.id.txt_loja);
        txtImagem = findViewById(R.id.txt_imagem);

        Intent intent = getIntent();

        if(intent.getSerializableExtra("jogo") != null){

            jogo = (Jogo) intent.getSerializableExtra("jogo");
            txtNome.setText(jogo.getNome_jogo());
            txtPreco.setText(jogo.getPreco_jogo());
            txtDesenvolvedor.setText(jogo.getId_desenvolvedor());
            txtPlataforma.setText(jogo.getId_plataforma());
            txtGenero.setText(jogo.getId_genero());
            txtLoja.setText(jogo.getId_loja());
            txtImagem.setText(jogo.getImagem_jogo());


        }

    }
}
