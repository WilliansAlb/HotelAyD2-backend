package com.ayd2.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "htl_food")
@Getter
@Setter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foodIdGenerator")
    @SequenceGenerator(name = "foodIdGenerator", sequenceName = "SEQ_HTL_FOOD", initialValue = 15000, allocationSize = 1)
    @Column(name = "food_id")
    private Long foodId;

    @JoinColumn(name = "cat_food_type")
    @ManyToOne(fetch = FetchType.LAZY)
    private AdmCategory catMenuItemType;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_description")
    private String foodDescription;

    @Column(name = "food_price")
    private BigDecimal foodPrice;

    @Column(name = "food_ingredients")
    private String foodIngredients;

    @Column(name = "attachment_url")
    private String attachmentUrl;
}
