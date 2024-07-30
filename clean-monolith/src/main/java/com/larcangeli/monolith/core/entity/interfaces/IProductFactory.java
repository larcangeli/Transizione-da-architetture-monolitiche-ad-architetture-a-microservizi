package com.larcangeli.monolith.core.entity.interfaces;


import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;

import java.util.Set;

public interface IProductFactory {
    //IProductEntity createProduct(Long id, Integer version, String name, int weight);
    IProductEntity createProduct(Long id, Integer version, String name, int weight, Set<RecommendationEntity> recommendations, Set<ReviewEntity> reviews);
}
