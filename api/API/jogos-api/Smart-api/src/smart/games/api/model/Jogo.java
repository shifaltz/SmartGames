package smart.games.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "tbl_jogo")
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_jogo;
	private String nome_jogo;
	private Float preco_jogo;
	private Long id_desenvolvedor;
	private Long id_plataforma;
	private Long id_loja;
	private Long id_genero;
	private String imagem_jogo;
	
	public Long getId_jogo() {
		return id_jogo;
	}
	public void setId_jogo(Long id_jogo) {
		this.id_jogo = id_jogo;
	}
	public String getNome_jogo() {
		return nome_jogo;
	}
	public void setNome_jogo(String nome_jogo) {
		this.nome_jogo = nome_jogo;
	}
	public Float getPreco_jogo() {
		return preco_jogo;
	}
	public void setPreco_jogo(Float preco_jogo) {
		this.preco_jogo = preco_jogo;
	}
	public Long getId_desenvolvedor() {
		return id_desenvolvedor;
	}
	public void setId_desenvolvedor(Long id_desenvolvedor) {
		this.id_desenvolvedor = id_desenvolvedor;
	}
	public Long getId_plataforma() {
		return id_plataforma;
	}
	public void setId_plataforma(Long id_plataforma) {
		this.id_plataforma = id_plataforma;
	}
	public Long getId_loja() {
		return id_loja;
	}
	public void setId_loja(Long id_loja) {
		this.id_loja = id_loja;
	}
	public Long getId_genero() {
		return id_genero;
	}
	public void setId_genero(Long id_genero) {
		this.id_genero = id_genero;
	}
	public String getImagem_jogo() {
		return imagem_jogo;
	}
	public void setImagem_jogo(String imagem_jogo) {
		this.imagem_jogo = imagem_jogo;
	}
	
	@Override
	public String toString() {
		return "Jogo [id_jogo=" + id_jogo + ", nome_jogo=" + nome_jogo + ", preco_jogo=" + preco_jogo + ", id_desenvolvedor="
				+ id_desenvolvedor + ", id_plataforma=" + id_plataforma + ", id_loja=" + id_loja + ", id_genero="
				+ id_genero + ", imagem_jogo=" + imagem_jogo + "]";
	}
	
}
