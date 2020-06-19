package generation.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Column(name = "cd_usuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	@Column(name = "nm_usuario", nullable = false, length = 80)
	@NotNull
	@Size(min = 2, max = 80, message = "Precisa ter entre 2 e 80 caracteres")
	private String nome;
	
	@Column(name = "nm_email", nullable = false, length = 100)
	@NotNull
	@Email
	private String email;
	
	@Column(name = "nm_senha", nullable = false, length = 256)
	@NotNull
	@Size(min = 6, max =256)
	private String senha;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
