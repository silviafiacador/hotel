package generation.hotel.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_hospedagem")
public class Hospedagem {
	
	@Column(name = "cd_hospedagem")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoHospedagem;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_quarto", referencedColumnName = "cd_quarto")
	private Quarto quarto;
	
	@Column(name = "dt_checkin", nullable = false)
	private Date dataCheckin = new java.sql.Date(System.currentTimeMillis());

	public int getCodigoHospedagem() {
		return codigoHospedagem;
	}

	public void setCodigoHospedagem(int codigoHospedagem) {
		this.codigoHospedagem = codigoHospedagem;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Date getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}
	
	
	
	
}
