package com.employee;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double averageRating;
    private int ratingsCount;
    private String imageUrl;

    //Getters and Setters for each field :

    //For Title -->
    //Getter:
    public String getTitle() {
        return title;
    }

    //Setter:
    public void setTitle(String title) {
        this.title = title;
    }

    //For Author -->
    //Getter:
    public String getAuthor() {
        return author;
    }

    //Setter:
    public void setAuthor(String author) {
        this.author = author;
    }

    //For PublicationYear -->
    //Getter:
    public int getPublicationYear() {
        return publicationYear;
    }

    //Setter:
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    //For AverageRating:
    //Getter:
    public double getAverageRating() {
        return averageRating;
    }

    //Setter:
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    //For RatingsCount -->
    //Getter:
    public int getRatingsCount() {
        return ratingsCount;
    }

    //Setter:
    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    //For ImageUrl -->
    //Getter:
    public String getImageUrl() {
        return imageUrl;
    }

    //Setter:
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
