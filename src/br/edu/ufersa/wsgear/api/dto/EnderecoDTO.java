package br.edu.ufersa.wsgear.api.dto;

public class EnderecoDTO {
	private String cpf_morador; // Morador que reside no endereco
	private String cep; // CEP
	private String rua; // Rua
	private String bairro; // Bairro
	private String complemento; // Complemento
	private int numero; // Numero

	public EnderecoDTO() {
		setCep("");
		setRua("");
		setBairro("");
		setComplemento("");
		setNumero(0);
	}

	public EnderecoDTO(String cep, String rua, String bairro, String complemento, int numero) {
		setCep(cep);
		setRua(rua);
		setBairro(bairro);
		setComplemento(complemento);
		setNumero(numero);
	}

	public void setCpf_morador(String cpf_morador) {
		if (!cpf_morador.isBlank() || !cpf_morador.isEmpty())
			this.cpf_morador = cpf_morador;
		else
			this.cpf_morador = "Morador não identificado";
	}

	public void setCep(String cep) {
		if (!cep.isBlank() || !cep.isEmpty())
			this.cep = cep;
		else
			this.cep = "n/a";
	}

	public void setRua(String rua) {
		if (!rua.isBlank() || !rua.isEmpty())
			this.rua = rua;
		else
			this.rua = "n/a";
	}

	public void setBairro(String bairro) {
		if (!bairro.isBlank() || !bairro.isEmpty())
			this.bairro = bairro;
		else
			this.bairro = "n/a";
	}

	public void setComplemento(String complemento) {
		if (!complemento.isBlank() || !complemento.isEmpty())
			this.complemento = complemento;
		else
			this.complemento = "n/a";
	}

	public void setNumero(int numero) {
		if (numero > 0)
			this.numero = numero;
		else
			this.numero = 0;
	}

	public int getNumero() {
		return this.numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public String getRua() {
		return this.rua;
	}

	public String getBairro() {
		return this.bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public String getCpf_morador() {
		return cpf_morador;
	}
}
