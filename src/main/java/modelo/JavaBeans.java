package modelo;

public class JavaBeans {
	private String numeracao;
	private String datahora;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String numeracao, String datahora) {
		super();
		this.numeracao = numeracao;
		this.datahora = datahora;
	}
	
	public String getNumeracao() {
		return numeracao;
	}
	
	public void setNumeracao(String numeracao) {
		this.numeracao = numeracao;
	}
	
	public String getDatahora() {
		return datahora;
	}
	
	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}
}