package com.project.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


public class ProductFeedback {
    private String productName;
    private double averageRating;
    private List<Feedback> feedbackList;

    // Constructor
    public ProductFeedback(String productName, double averageRating) {
        this.productName = productName;
        this.averageRating = averageRating;
        this.feedbackList = new ArrayList<>();
    }

    // Method to add feedback to the list
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    // Getters
    public String getProductName() { return productName; }
    public double getAverageRating() { return averageRating; }
    public List<Feedback> getFeedbackList() { return feedbackList; }

    @Override
    public String toString() {
        return "Product: " + productName + " | Average Rating: " + averageRating + " | Feedbacks: " + feedbackList;
    }
}
