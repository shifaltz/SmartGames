package smartgames.app.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import smartgames.app.MainActivity;
import smartgames.app.modelo.Jogo;

public class CarregarListaJogos extends AsyncTask{

    private String dados = "";
    private ProgressDialog progressDialog;
    private Context context;
    private ArrayAdapter<Jogo> adapter;
    private List<Jogo> jogos;

    // *** O CONTRUTOR É O PRIMEIRO MÉTODO A SER EXECUTADO
    public CarregarListaJogos(Context context){
        this.context = context;
    }

    // *** O MÉTODO ONPREEXECUTE É O SEGUNDO MÉTODO A SER EXECUTADO
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Carregando dados");
        progressDialog.setMessage("Carregando . . .");
        progressDialog.show();

    }

    // *** O MÉTODO doInBackGround É O TERCEITO MÉTODO A SER EXECUTADO
    @Override
    protected Object doInBackground(Object[] objects) {

        try {

            // *** DETERMINAR A URL DO RECURSO A SER UTILIZADO
            URL url = new URL("http://192.168.15.5:8080/jogos");

            // *** CRIAR A CONEXÂO HTTP COM O WEBSERVICE
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();


            // *** TRATRAR O FLUXO DE DADOS QUE ESTÃO CHEGANDO DO SERVIDOR PARA APLICAÇÃO MOBILE
            InputStream dadosStream = conexao.getInputStream();

            // *** CRIAR UM OBJETO CAPAZ DE LER OS DADOS QUE ESTÃO NO STREAM DE ENTRADA (dadosStream)
            InputStreamReader leitorStream = new InputStreamReader(dadosStream);

            // *** CRIAR UM BUFFER (local na memoria para armazenar algo por um curto espaço de tempo)
            BufferedReader bufferedReader = new BufferedReader(leitorStream);

            // *** CRIAR UMA VARIAVEL STRING PARA EXTRAIR O CONTEUDO DO BUFFER
            String registro = "";

            // *** CONSOME O BUFFER E A CADA INTERAÇÃO CARREGAR A VARIAVEL REGISTRO
            while(registro != null){
                registro = bufferedReader.readLine();
                dados = dados + registro;
            }

            // *** CRIAR UM ARRAY LIST PARA CARREGAR TODOS OS CONTATOS DO BANCO
            Jogo jogo;
            jogos = new ArrayList<>();

            // *** TRANSFORMAR O "DADOS" EM UM ARRAY
            JSONArray dadosArray = new JSONArray(dados);

            // *** CONSUMIR O ARRAY PARA CRIAR OS OBJETOS CONTATO QUE SERÃO INSERIDOS NO ARRAYLIST
            for(int i = 0; i < dadosArray.length(); i++){

                JSONObject jsonObject = (JSONObject) dadosArray.get(i);
                jogo= new Jogo();

                jogo.setId_jogo(jsonObject.getInt("id_jogo"));
                jogo.setNome_jogo(jsonObject.getString("nome_jogo"));
                jogo.setPreco_jogo(jsonObject.getString("preco_jogo"));
                jogo.setId_desenvolvedor(jsonObject.getString("id_desenvolvedor"));
                jogo.setId_plataforma(jsonObject.getString("id_plataforma"));
                jogo.setId_loja(jsonObject.getString("id_loja"));
                jogo.setId_genero(jsonObject.getString("id_genero"));
                jogo.setImagem_jogo(jsonObject.getString("imagem_jogo"));

                jogos.add(jogo);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    // *** O MÉTODO ONPOSTEXECUTE É O QUARTO MÉTODO A SER EXECUTADO
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        adapter = new ArrayAdapter<Jogo>(context, android.R.layout.simple_list_item_1, jogos);
        MainActivity.listViewJogos.setAdapter(adapter);
        progressDialog.dismiss();


    }
}
