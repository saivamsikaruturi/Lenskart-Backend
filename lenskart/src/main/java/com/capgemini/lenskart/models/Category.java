package com.capgemini.lenskart.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class Category implements Serializable {

    /**
     * Serial Version Id
     */
    private static final long serialVersionUID = -2675540393594972260L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long categoryId;

    @Getter
    @Setter
    @Column(name="category_name")
    private String categoryName;
    
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private List<Product> product = new ArrayList<>();

    
}
