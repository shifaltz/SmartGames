package smartgames.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import smartgames.app.modelo.Jogo;
import smartgames.app.task.CarregarListaJogos;

public class MainActivity extends AppCompatActivity {

    public static ListView listViewJogos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewJogos = findViewById(R.id.main_lista_jogo);

        listViewJogos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Jogo jogo = (Jogo) listViewJogos.getItemAtPosition(position);

                Intent visulizarJogo = new Intent(MainActivity.this, VisualizarActivity.class);
                visulizarJogo.putExtra("jogo", jogo);
                startActivity(visulizarJogo);

            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();

        CarregarListaJogos carregarListaJogos = new CarregarListaJogos(this);
        carregarListaJogos.execute();

    }

}
