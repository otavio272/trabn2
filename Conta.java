package trabn2;

public class Conta {

	private int id;
	private String NomeConta;
	private int idPagador;
	private int valor;
	

	public Conta() { }

	public Conta(int id, String NomeConta, int idPagador, int valor) {
		this.id = id;
		this.NomeConta = NomeConta;
		this.idPagador = idPagador;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPagador() {
		return idPagador;
	}

	public void setIdPagador(int idPagador) {
		this.idPagador = idPagador;
	}
	
	public String getNomeConta() {
		return NomeConta;
	}

	public void setNomeConta(String NomeConta) {
		this.NomeConta = NomeConta;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return"id="+ id + "NomeConta = " + NomeConta + "idPagador = " + idPagador + "valor = " + valor   ; 
	}

}