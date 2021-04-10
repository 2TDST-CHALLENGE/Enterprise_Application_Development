package br.com.fiap.entity;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "PROD_ESTABELECIMENTO")
public class Produto {

    @Id
    @Column(name = "COD_PRODUTO", length = 5)
    private int codigo;

    @Column(name = "NOME_PROODUTO", nullable = false, length = 30)
    private String nomeProduto;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEG_PRODUTO", nullable = false)
    private Categoria categoria;

    @Column(name = "DESC_PRODUTO")
    private String descricao;

    @Column(name = "QTD_PRODUTO", nullable = false, length = 9)
    private int quantidadeProduto;

    @Column(name = "VALOR_PRODUTO", nullable = false)
    private double valor;

    @Temporal(TemporalType.DATE)
    @Column(name = "VALIDADE_PRODUTO")
    private Calendar validade;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ENTRADA", nullable = false)
    private Calendar dataEntrada;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_SAIDA")
    private Calendar dataSaida;

    public Produto(){}

    public Produto(int codigo, String nomeProduto, Categoria categoria, String descricao, int quantidadeProduto, double valor, Calendar validade, Calendar dataEntrada, Calendar dataSaida) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.descricao = descricao;
        this.quantidadeProduto = quantidadeProduto;
        this.valor = valor;
        this.validade = validade;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Calendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Calendar dataSaida) {
        this.dataSaida = dataSaida;
    }
}
