package br.com.fiap.flyhigh.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "moeda", sequenceName = "SQ_MOEDA", allocationSize = 1)
public class Moeda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moeda")
    private int codigo;

    @NotBlank(message = "Nome obrigatório!")
    @Size(max = 50)
    private String nome;

    @Min(value=0, message = "Preço não pode ser negativo")
    private double preco;

    private boolean blockchain;

    @Past
    private LocalDate dataCriacao;

    @ManyToOne
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isBlockchain() {
        return blockchain;
    }

    public void setBlockchain(boolean blockchain) {
        this.blockchain = blockchain;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
