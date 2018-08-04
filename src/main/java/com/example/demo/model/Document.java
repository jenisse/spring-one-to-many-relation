/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
/**
 *
 * @author TOSHIBA
 */

@Data
@Table
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Document {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private Date date;
    @OneToMany(mappedBy="document", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<DetailDocument> details= new ArrayList<>();
    private BigDecimal total;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
    

    public void addDetailDocument(DetailDocument detail) {
        details.add(detail);
        detail.setDocument(this);
    }
 
}
