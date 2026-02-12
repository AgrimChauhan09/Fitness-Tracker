package com.project.fitness.controller;

import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> genrateRecommendation(@RequestBody RecommendationRequest request){
        Recommendation recommendation=recommendationService.genrateRecommendation(request);
                return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Recommendation>>getUserRecommendation(@PathVariable String userid){
        List<Recommendation> recommendationList=recommendationService.getUserRecommendation(userid);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityid}")
    public ResponseEntity<List<Recommendation>>getActivityRecommendation(@PathVariable String activityid){
        List<Recommendation>recommendationList=recommendationService.getActivityRecommendation(activityid);
        return ResponseEntity.ok(recommendationList);
    }
}
