package generation.hotel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import generation.hotel.exception.UsuarioException;
import generation.hotel.model.Usuario;
import generation.hotel.model.UsuarioLogado;
import generation.hotel.model.UsuarioLogin;
import generation.hotel.repository.UsuarioRepository;
import generation.hotel.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	//http://localhost:8080/usuario -- Obtém todos os usuários
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//http://localhost:8080/usuario/{codigo} -- substitua {código} pelo número
	@GetMapping("/{codigo}")
	//public ResponseEntity<Object> GetById(@PathVariable long codigo){
	public ResponseEntity<Usuario> GetById(@PathVariable long codigo){
		Optional<Usuario> usuario = repository.findById(codigo);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		}
		throw new UsuarioException("Usuário não encontrado!");
		}
	
	//http://localhost:8080/usuario/nome/{nome} -- substitua {nome} pelo nome do usuário
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> GetByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping("/login") 
		public ResponseEntity<Object> Logar(@RequestBody UsuarioLogin usuarioLogin)
		{
		Optional<UsuarioLogado> usuarioLogado = usuarioService.Logar(usuarioLogin);
		
		if (usuarioLogado.isPresent())
			return ResponseEntity.ok(usuarioLogado.get());
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado!");
		}
	
	//http://localhost:8080/usuario
	@PostMapping
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}
	
	//http://localhost:8080/usuario
	@PutMapping
	public ResponseEntity<Usuario> Put(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.CadastrarUsuario(usuario));
	}
	
	//http://localhost:8080/usuario/{codigo} -- substitua {código} pelo número
	@DeleteMapping("/{codigo}")
	public void Delete(@PathVariable long codigo) {
		repository.deleteById(codigo);
	}
}





