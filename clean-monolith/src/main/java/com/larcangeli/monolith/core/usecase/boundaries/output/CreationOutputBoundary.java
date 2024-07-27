package com.larcangeli.monolith.core.usecase.boundaries.output;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

public interface CreationOutputBoundary {

    IProductEntity saveProduct(IProductEntity product);

    IRecommendationEntity saveRecommendation(IRecommendationEntity recommendation);

    IReviewEntity saveReview(IReviewEntity review);

}
