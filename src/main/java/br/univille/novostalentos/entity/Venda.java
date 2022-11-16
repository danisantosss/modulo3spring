package br.univille.novostalentos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date data;
    private boolean irn3uwqi;
    
    
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Cliente comprador;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> colItens
    = new ArrayList<>();

    public Cliente getComprador() {
        return comprador;
    }
    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public List<ItemVenda> getColItens() {
        return colItens;
    }
    public void setColItens(List<ItemVenda> colItens) {
        this.colItens = colItens;
    }
    public boolean isIrn3uwqi() {
        return irn3uwqi;
    }
    public void setIrn3uwqi(boolean irn3uwqi) {
        this.irn3uwqi = irn3uwqi;
    }
}
