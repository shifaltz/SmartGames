<?php

	$nome_modal = null;
	$genero_modal = null;
	$plataforma_modal = null;
	$desenvolvedor_modal = null;
	$iframe_modal = null;
	$loja_modal = null;

	require_once('bd/conexao.php');
	$conexao = conexaoMysql();

   if(isset($_GET['id_jogo'])){
	  $id = $_GET ['id_jogo'];
	  
	  
	   $sql = "SELECT tbl_jogo.*, tbl_genero.*, tbl_loja.*, tbl_desenvolvedor.*, tbl_plataforma.* FROM  tbl_jogo
	   INNER JOIN tbl_genero ON tbl_jogo.id_genero = tbl_genero.id_genero 
	   INNER JOIN tbl_desenvolvedor ON tbl_jogo.id_desenvolvedor = tbl_desenvolvedor.id_desenvolvedor 
	   INNER JOIN tbl_loja ON tbl_jogo.id_loja = tbl_loja.id_loja
	   INNER JOIN tbl_plataforma ON tbl_jogo.id_plataforma = tbl_plataforma.id_plataforma
	   WHERE id_jogo=".$id;
	 
	   
	  $select = mysqli_query($conexao, $sql);
	  
	  if($rs = mysqli_fetch_array($select)){
		 $nome_modal = $rs['nome_jogo'];
		 $genero_modal = $rs['nome_genero'];
		 $plataforma_modal = $rs['nome_plataforma'];
		 $desenvolvedor_modal = $rs['nome_desenvolvedor'];
		 $iframe_modal = $rs['iframe'];
		 $loja_modal = $rs['nome_loja'];
		 $imagem_modal = $rs['imagem_jogo'];
		 
	  }
   }






?>

<script src="funcoes/funcoes.js"></script>

<div id="caixa_fechar">
	<a href="#" id="fechar">
		<img src="imagens_modal/close.png" alt="close" 	title="fechar">
	</a>
</div>
<div id="titulo_modal">
	<?php
	echo($nome_modal);
	?>
</div>
<div id="foto_modal">
	<img src="jogos/<?php echo($imagem_modal);?>">
</div>
				
<div id="inf_modal">
	<div class="titulos_inf">
		Gênero:
	</div>
	<div class="texto_inf">
		<?php
		echo($genero_modal);
		?>
	</div>
	<div class="titulos_inf">
		Plataforma:
	</div>
	<div class="texto_inf">
		<?php
		echo($plataforma_modal);
		?>
	</div>
	<div class="titulos_inf">
		Desenvolvedores:
	</div>
	<div class="texto_inf">
		<?php
		echo($desenvolvedor_modal);
		?>
	</div>
	<div id="lojas_disponiveis">
		<div id="titulo_loja">
			Disponivel nas lojas:
		</div>
		
		<?php
			if(isset($_GET['id_jogo'])){
				$id = $_GET ['id_jogo'];
				$sql = "SELECT tbl_jogo.id_jogo, tbl_loja.* FROM tbl_jogo INNER JOIN tbl_loja ON tbl_jogo.id_loja = tbl_loja.id_loja WHERE id_jogo=".$id;
				
				$select = mysqli_query($conexao, $sql);
				
				while($rs = mysqli_fetch_array($select)){
					$nome_loja = $rs['nome_loja'];
				
		?>
		<div class="inf_loja">
			<div class="nome_loja">
				<?php
					echo($nome_loja);
				?>
			</div>
			<div class="localizacao_loja" onclick="abrirMapa('<?php echo($iframe_modal)?>')">
				Localização
			</div>
		</div>
		<?php
				}
			}
		?>
		
		
	</div>
					
</div>
				
<div id="mapa_modal">
	<?php
	if($iframe_modal == null){		   
					
	?>
	CLIQUE EM LOCALIZAÇÃO PARA ABRIR O MAPA<br>
	<img src="imagens_modal/local.png">
	<?php
	}
	?>
				
</div>	