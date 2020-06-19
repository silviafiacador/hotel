package generation.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_quarto")
public class Quarto {
	
	@Column(name = "cd_quarto")
	@Id
	private int numeroQuarto;
	
	@Column(name = "qt_cama", nullable = false)
	private int qtdCama;

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public int getQtdCama() {
		return qtdCama;
	}

	public void setQtdCama(int qtdCama) {
		this.qtdCama = qtdCama;
	}
	
	
}
