package br.com.credsystem.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cards")
public class Card {
	
	@Id
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "cartao")
	private String cartao;

	@Column(name = "limite_utilizado")
	private double limiteUtilizado;

	@Column(name = "senha")
	private String senha;

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getLimiteUtilizado() {
		return limiteUtilizado;
	}

	public void setLimiteUtilizado(double limiteUtilizado) {
		this.limiteUtilizado = limiteUtilizado;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
