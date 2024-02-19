package com.kitapyurdu.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Kategori")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Kategori_anahtarı",updatable = false, unique = true)
    private int categoryId;

    @Column(name = "Kategori_adı",unique = true)
    private String categoryName;

    @Column(name = "Kategori_açıklaması")
    private String categoryDescription;


    @OneToMany(mappedBy = "category")
    private List<Product> productList;

}
