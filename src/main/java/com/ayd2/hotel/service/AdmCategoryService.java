package com.ayd2.hotel.service;

import com.ayd2.hotel.model.AdmCategory;
import com.ayd2.hotel.repository.AdmCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdmCategoryService {

    private final AdmCategoryRepository categoryRepository;

    public AdmCategory findByInternalId(Long internalId) {
        return categoryRepository.findByInternalId(internalId);
    }

    public List<AdmCategory> findByParentInternalId(Long parentInternalId) {
        return categoryRepository.findByParentInternalId(parentInternalId);
    }
}
