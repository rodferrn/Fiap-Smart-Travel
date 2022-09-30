package br.com.fiap.flyhigh.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "travel", sequenceName = "SQ_TRAVEL", allocationSize = 1)
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "travel")
    private int codigo;

    @NotBlank(message = "usuário precisa estar logado!!")
    @Size(max = 11)
    private String usuario;

    @NotBlank(message = "Escolha a origem")
    @Size(max = 250)
    private String origem;

    @NotBlank(message = "Escolha o destino")
    @Size(max = 250)
    private String destino;

    private LocalDate dataReserva;

    private LocalDate dataEmbarque;

    private LocalDate dataChegada;

    @ManyToOne
    private Moeda moeda;

    @Min(value=0, message = "Valor não pode ser negativo")
    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataEmbarque() {
        return dataEmbarque;
    }

    public void setDataEmbarque(LocalDate dataEmbarque) {
        this.dataEmbarque = dataEmbarque;
    }

    public LocalDate getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}


