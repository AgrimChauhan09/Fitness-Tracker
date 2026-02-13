package com.project.fitness.service;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.exception.UserNotFoundException;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;
    public Recommendation genrateRecommendation(RecommendationRequest request){

        User user= userRepository.findById(request.getUserId())
                .orElseThrow(()->new RuntimeException("User Not Found:"+request.getUserId()));

        Activity activity= activityRepository.findById(request.getActivityId())
                .orElseThrow(()->new RuntimeException("Activity Not Found:"+request.getActivityId()));

        Recommendation recommendation=Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions((request.getSuggestions()))
                .safety(request.getSafety())
                .build();

        return recommendationRepository.save(recommendation);

    }

    public List<Recommendation> getUserRecommendation(String userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User not found for this id");
        }
        List<Recommendation> recommendations =
                recommendationRepository.findByUserId(userId);
        return recommendations;
    }

    public List<Recommendation> getActivityRecommendation(String activityId){
        return recommendationRepository.findByActivityId(activityId);
    }
}
