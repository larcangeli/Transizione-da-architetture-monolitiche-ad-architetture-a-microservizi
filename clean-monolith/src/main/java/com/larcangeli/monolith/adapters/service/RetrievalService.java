package com.larcangeli.monolith.adapters.service;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.adapters.persistence.implementation.Review;
import com.larcangeli.monolith.adapters.persistence.repository.IProductCompositeRepository;
import com.larcangeli.monolith.drivers.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.drivers.mapper.RecommendationMapper;
import com.larcangeli.monolith.drivers.mapper.ReviewMapper;
import com.larcangeli.monolith.core.entity.recommendation.impl.RecommendationEntity;
import com.larcangeli.monolith.core.entity.review.impl.ReviewEntity;
import com.larcangeli.monolith.core.entity.product.IProductEntity;
import com.larcangeli.monolith.core.usecase.retrieval.RetrievalOutputBoundary;
import com.larcangeli.monolith.drivers.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RetrievalService implements RetrievalOutputBoundary {

    private final IProductCompositeRepository productRepository;
    private final ProductAggregateMapper productMapper;
    private final RecommendationMapper recommendationMapper;
    private final ReviewMapper reviewMapper;

    public RetrievalService(IProductCompositeRepository productRepository, ProductAggregateMapper productMapper, RecommendationMapper recommendationMapper, ReviewMapper reviewMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.recommendationMapper = recommendationMapper;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public IProductEntity getProduct(Long productId) {
        Optional<Product> p = productRepository.findById(productId);
        if(p.isPresent()){
            return productMapper.productAggregateToProductEntity(p.get());
        }else throw new NotFoundException();

    }

    @Override
    public List<IProductEntity> getAllProducts() {
        List<Product> products = productRepository.findAll().stream().toList();
        return new ArrayList<>(productMapper.productAggregatesToProductEntities(products));
    }

    @Override
    public Set<RecommendationEntity> findRecommendationsByProductId(Long productId) {
        if(productRepository.findById(productId).isPresent()){
            Set<Recommendation> set = productRepository.findRecommendationsByProductId(productId);
            return recommendationMapper.recommendationsToRecommendationEntities(set);
        }else throw new NoSuchElementException();
    }

    @Override
    public Set<ReviewEntity> findReviewsByProductId(Long productId) {
        if(productRepository.findById(productId).isPresent()){
            Set<Review> set = productRepository.findReviewsByProductId(productId);
            return reviewMapper.reviewsToReviewEntities(set);
        }else throw new NoSuchElementException();
    }
}

