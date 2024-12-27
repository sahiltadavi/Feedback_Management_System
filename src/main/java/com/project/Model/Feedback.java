package com.project.Model;

import lombok.Data;

public class Feedback {
    private String customerName;
    private String customerCity;
    private String feedbackMessage;
    private int rating;
    private double averageRating; // To store the average rating for the product

    // Constructor
    public Feedback(String customerName, String customerCity, String feedbackMessage, int rating, double averageRating) {
        this.customerName = customerName;
        this.customerCity = customerCity;
        this.feedbackMessage = feedbackMessage;
        this.rating = rating;
        this.averageRating = averageRating;
    }

    // Getters
    public String getCustomerName() { return customerName; }
    public String getCustomerCity() { return customerCity; }
    public String getFeedbackMessage() { return feedbackMessage; }
    public int getRating() { return rating; }
    public double getAverageRating() { return averageRating; }

    @Override
    public String toString() {
        return "Customer: " + customerName + " | City: " + customerCity + " | Feedback: " + feedbackMessage + " | Rating: " + rating;
    }
}
