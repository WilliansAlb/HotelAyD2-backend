package com.ayd2.hotel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

@Entity
@Table(name = "htl_menu_food")
@Getter
@Setter
public class MenuFood {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menuFoodIdGenerator")
    @SequenceGenerator(name = "menuFoodIdGenerator", sequenceName = "SEQ_HTL_MENU_FOOD", initialValue = 15000, allocationSize = 1)
    @Column(name = "menu_food_id")
    private Long menuFoodId;

    @JsonBackReference(value = "menu")
    @JoinColumn(name = "menu_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    @JsonBackReference(value = "food")
    @JoinColumn(name = "food_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Food food;
}
