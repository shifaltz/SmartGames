package smartgames.app.modelo;

import java.io.Serializable;

public class Jogo implements Serializable {

    private int id_jogo;
    private String nome_jogo;
    private String preco_jogo;
    private String id_desenvolvedor;
    private String id_loja;
    private String id_genero;
    private String id_plataforma;
    private String imagem_jogo;

    public int getId_jogo() {
        return id_jogo;
    }

    public void setId_jogo(int id_jogo) {
        this.id_jogo = id_jogo;
    }

    public String getNome_jogo() {
        return nome_jogo;
    }

    public void setNome_jogo(String nome_jogo) {
        this.nome_jogo = nome_jogo;
    }

    public String getPreco_jogo() {
        return preco_jogo;
    }

    public void setPreco_jogo(String preco_jogo) {
        this.preco_jogo = preco_jogo;
    }

    public String getId_desenvolvedor() {
        return id_desenvolvedor;
    }

    public void setId_desenvolvedor(String id_desenvolvedor) {
        this.id_desenvolvedor = id_desenvolvedor;
    }

    public String getId_loja() {
        return id_loja;
    }

    public void setId_loja(String id_loja) {
        this.id_loja = id_loja;
    }

    public String getId_genero() {
        return id_genero;
    }

    public void setId_genero(String id_genero) {
        this.id_genero = id_genero;
    }

    public String getId_plataforma() {
        return id_plataforma;
    }

    public void setId_plataforma(String id_plataforma) {
        this.id_plataforma = id_plataforma;
    }

    public String getImagem_jogo() {
        return imagem_jogo;
    }

    public void setImagem_jogo(String imagem_jogo) {
        this.imagem_jogo = imagem_jogo;
    }

    @Override
    public String toString() {
        return nome_jogo;
    }
}



