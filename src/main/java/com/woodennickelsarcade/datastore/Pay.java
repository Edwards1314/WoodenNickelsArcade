package com.woodennickelsarcade.datastore;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pay_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pay.findAll", query = "SELECT p FROM Pay p")
    , @NamedQuery(name = "Pay.findById", query = "SELECT p FROM Pay p WHERE p.id = :id")
    , @NamedQuery(name = "Pay.findByCardnumber", query = "SELECT p FROM Pay p WHERE p.cardnumber = :cardnumber")
    , @NamedQuery(name = "Pay.findByCardtype", query = "SELECT p FROM Pay p WHERE p.cardtype = :cardtype")
    , @NamedQuery(name = "Pay.findByAmount", query = "SELECT p FROM Pay p WHERE p.amount = :amount")})
public class Pay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "name")
    private String name;
    @Column(name = "cardnumber")
    private BigInteger cardnumber;
    @Size(max = 45)
    @Column(name = "cardtype")
    private String cardtype;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;

    public Pay() {
    }

    public Pay(Integer id) {
        this.id = id;
    }

    public Pay(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(BigInteger cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pay)) {
            return false;
        }
        Pay other = (Pay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.woodennickelsarcade.datastore.Pay[ id=" + id + " ]";
    }
    
}
