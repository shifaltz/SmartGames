package smart.games.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import smart.games.api.model.Jogo;
import smart.games.api.repository.JogoRepository;

@RestController
@RequestMapping("/jogos")
public class JogoResource {

	@Autowired
	private JogoRepository jogoRepository;
	
	@GetMapping
	public List<Jogo> getJogos(){
		return jogoRepository.findAll();
	}
	
	@GetMapping("/{id_jogo}")
	public Optional<Jogo> getJogos(@PathVariable Long id_jogo){
		
		return jogoRepository.findById(id_jogo);
		
	}
	
}