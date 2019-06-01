<?php

   $link = null;
   $preco = null;
   $nome = null;
   $imagem = null;
   $rs = null;
   $plataforma = "Procure seus jogos na Smart Games";
   $imagem_plat = "imagens_plataformas/procurar_icon.png";

   require_once('bd/conexao.php');
   $conexao = conexaoMysql();

   /* PESQUISA DE ACORDO COM CONSOLE/GENERO/LOJA */
   if(isset($_GET['modo'])){
	  $modo = $_GET['modo'];
	   
	  	/* CONSOLE */
	  if($modo == "play"){
		$id = '1';
		$plataforma = "Playstation";
		$imagem_plat = "imagens_plataformas/playstation_icon.png";
		$busca = 'plataforma';
		  
	  }else if($modo == "xbox"){
		 $id = '2';
		 $plataforma = "Xbox";
		 $imagem_plat = "imagens_plataformas/xbox_icon.png";
		 $busca = 'plataforma';
		 
	  }else if($modo == "nintendo"){
		 $id = '3';
		 $plataforma = "Nintendo";
		 $imagem_plat = "imagens_plataformas/nintendo_icon.png";
		 $busca = 'plataforma';
		 
		/* GENERO */
	  }else if($modo == "tiro"){
		 $id = '1';
		 $plataforma = "Tiro";
		 $imagem_plat = "imagens_genero/guerra.png";
		 $busca ='genero';
		 
	  }else if($modo == "esporte"){
		 $id = '6';
		 $plataforma = "Esporte";
		 $imagem_plat = "imagens_genero/esporte.png";
		 $busca ='genero';
		 
	  }else if($modo == "acao"){
		 $id = '2';
		 $plataforma = "Ação";
		 $imagem_plat = "imagens_genero/acao.png";
		 $busca ='genero';
		 
	  }else if($modo == "aventura"){
		 $id = '3';
		 $plataforma = "Aventura";
		 $imagem_plat = "imagens_genero/aventura.png";
		 $busca ='genero';
	  
		 /* LOJA*/
	  }else if($modo == "lojaa"){
		 $id = '1';
		 $plataforma = "Smart Games A";
		 $busca ='loja';
		 
	  }else if($modo == "lojab"){
		 $id = '2';
		 $plataforma = "Smart Games B";
		 $busca ='loja';
		 
	  }else if($modo == "lojac"){
		 $id = '3';
		 $plataforma = "Smart Games C";
		 $busca ='loja';
	  }
   }


   

   
   
   

?>


<html>
  	<head>
		<meta charset="utf-8">
		<title>
			Smart Games LTDA.
		</title>
		<link rel="stylesheet" type="text/css"  href="css/style.css">
		<script src="js/jquery.js" ></script>
		<script src="js/link.js" ></script>
		<script src="funcoes/funcoes.js"></script>

  	</head>
	<body>
		
		<!-- Container da Modal -->
		<div id="container">
			<div id="modal">
				
			</div>         
		</div>
		
		<!-- Cabeçalho do site -->
		<header>
			<div id="caixa_logo_empresa" class="center">
				<div id="imagem_logo">
					<img src="imagens/logo2.png">
				</div>
			</div>
			
			<!-- Menu do site -->  
			<div id="caixa_menu" class="center">
				<ul id="menu">
					<li class="li"> 
						Consoles
						<ul class="subMenu">
							<a href="index.php?modo=play">
							   <li>Playstation</li>
						   	</a>
						   	<a href="index.php?modo=xbox">
							   	<li>Xbox</li>
						   	</a>
						   	<a href="index.php?modo=nintendo">
							   <li>Nintendo</li>
						   	</a>
						</ul>
					</li>
					
					<li class="li"> 
						Gênero
						<ul class="subMenu">
							<a href="index.php?modo=tiro">
							   <li>Tiro</li>
						   	</a>
						   	<a href="index.php?modo=esporte">
							   <li>Esporte</li>
						   	</a>
						   	<a href="index.php?modo=acao">
							   <li>Ação</li>
						   	</a>
						   	<a href="index.php?modo=aventura">
							   <li>Aventura</li>
						   	</a>
						</ul>
					</li>
					
					<li class="li"> 
						Lojas
					   <ul class="subMenu">
						  <a href="index.php?modo=lojaa">
							 <li>Smart Games A</li>
						  </a>
						  <a href="index.php?modo=lojab">
							 <li>Smart Games B</li>
						  </a>
						  <a href="index.php?modo=lojac">
							 <li>Smart Games C</li>
						  </a>
						</ul>
					</li>
				</ul>
			</div>
		</header>
		
		<!-- Plataformas e Jogos -->
		<div id="conteudo" class="center">
		   <div id="plataforma_genero">
			  <span class="plataforma">
				 <?php echo($plataforma)?>
			  </span>
			  <div class="imagem_plataforma">
				 <img src="<?php echo($imagem_plat);?>">
			  </div>
		   </div>
		 	   
		   <?php
			
   			if(isset($_GET['modo'])){
			   $modo = $_GET['modo'];

				$sql = "SELECT * FROM tbl_jogo";
			   
			   if($busca == 'plataforma'){
				  $sql = "SELECT * FROM tbl_jogo WHERE id_plataforma=".$id;
				 
			   }else if($busca == 'genero'){
				  $sql = "SELECT * FROM tbl_jogo WHERE id_genero=".$id;
			   }else if($busca == 'loja'){
				    $sql = "SELECT * FROM tbl_jogo WHERE id_loja=".$id;
			   }

				  $select = mysqli_query($conexao, $sql);
			   
				  while($rs = mysqli_fetch_array($select)){
					 $imagem = $rs['imagem_jogo'];
					 $nome = $rs['nome_jogo'];
					 $preco = $rs['preco_jogo'];
		   ?>
		   <div class="jogos">
			  <div class="imagem_jogo">
				 <img src="jogos/<?php echo($imagem)?>">
			  </div>
			  <div class="inf_jogo">
				 <div class="titulo_game">
					<span><?php echo($nome);?></span>
				 </div>

				 <div class="valor">
					<div class="preco">
					   R$ <?php echo($preco); ?>
					</div>
					<div class="parcelas">
					   <span>10x</span>de<span>R$ 22,99</span>sem juros
					</div>
				 </div>
				 <div class="detalhes">
					<a class="visualizar" onclick="verMais(<?php echo($rs['id_jogo']); ?>)">ver mais</a>
				 </div>
			  </div>
		   </div>
		   <?php

			   }

			}else{
				
			$sql = "SELECT * FROM tbl_jogo";
			$select = mysqli_query($conexao, $sql);
				
				 while($rs = mysqli_fetch_array($select)){
					 $imagem = $rs['imagem_jogo'];
					 $nome = $rs['nome_jogo'];
					 $preco = $rs['preco_jogo'];
		   
		   ?>
			
			 <div class="jogos">
			  <div class="imagem_jogo">
				 <img src="jogos/<?php echo($imagem)?>">
			  </div>
			  <div class="inf_jogo">
				 <div class="titulo_game">
					<span><?php echo($nome);?></span>
				 </div>

				 <div class="valor">
					<div class="preco">
					   R$ <?php echo($preco); ?>
					</div>
					<div class="parcelas">
					   <span>10x</span>de<span>R$ 22,99</span>sem juros
					</div>
				 </div>
				 <div class="detalhes">
					<a class="visualizar" onclick="verMais(<?php echo($rs['id_jogo']); ?>)">ver mais</a>
				 </div>
			  </div>
		   </div>
			
			<?php
			
				 }
			}
			
			?>
		</div>
		
		
		<!-- RODAPÉ -->
		<footer>
			<div id="caixa_footer" class="center">
				
				<div class="conteudo_footer">
					<div id="sobre_nos">
						<h1>Sobre nós</h1>
					</div>
					<div id="texto_sobre">
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
					</div>
				</div>

				<div class="conteudo_footer">
					<div id="logo_footer">
						<img src="imagens/logo2.png">
					</div>
				</div>

				<div class="conteudo_footer">
					<div id="midias">
						<h1>Mídias Sociais</h1>
					</div>
					<div id="redes_sociais">
				
					</div>
				</div>
			</div>
		</footer>
		
	</body>
</html>