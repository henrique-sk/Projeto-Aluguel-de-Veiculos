package model;

import util.Contador;

public class Veiculo implements Banco {
	
	private Integer id;
	private String modelo;
	private String marca;
	private String cor;
	private String placa;
	private Tipo tipo;
	private double valorLocacao;
	private Status status;
	
	public Veiculo(String modelo, String marca, String cor, String placa, String tipo, double valorLocacao) {
		this.id = Contador.proximoId();
		this.modelo = modelo;
		this.marca = marca;
		this.cor = cor;
		this.placa = placa;
		this.tipo = Tipo.valueOf(tipo.toUpperCase());
		this.valorLocacao = valorLocacao;
		this.status = Status.LIVRE;
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

	@Override
	public String toString() {
		return this.id
				+ " - " + this.tipo
				+ " - " + this.marca
				+ " " +	this.modelo
				+ " " +	this.cor
				+ " - Diária: R$ " +	this.valorLocacao + "0";
	}



	private static enum Tipo {
		CARRO,
		MOTO,
		CAMINHAO;
	}
	
	public static enum Status {
		LIVRE,
		ALUGADO;
	}

}
