package com.capgemini.lenskart.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

    /**
     * Serial Version Id
     */
    private static final long serialVersionUID = 770945351909626253L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long productId;
    
    @Getter
    @Setter
    @Column(name="product_name")
    @Size(min=2, message="Name should have at least 2 chars")
    private String productName;


    @Getter
    @Setter
    @Column(name="product_description")
    private String productDescription;

//    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JsonIgnore
//    @JoinColumn(name = "category_id")
//    private Category category;
}
