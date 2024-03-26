package com.ayd2.hotel.repository;

import com.ayd2.hotel.model.AdmCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface AdmCategoryRepository extends JpaRepository<AdmCategory, Long> {

    AdmCategory findByInternalId(Long internalId);

    List<AdmCategory> findByParentCategoryId(Long parentCategoryId);

    default List<AdmCategory> findByParentInternalId(Long parentInternalId) {
        var parent = this.findByInternalId(parentInternalId);
        if (parent == null) return new ArrayList<>();

        System.out.println(parent.getCategoryId());
        return this.findByParentCategoryId(parent.getCategoryId());
    }
}
