package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {
    private String userId;
    private ActivityType type;
    private Map<String,Object> additionalMetrices;
    private Integer Duration;
    private Integer CaloriesBurned;
    private LocalDateTime startTime;// end update time nahi lenge


}
