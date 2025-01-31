package com.employee;

import com.employee.Book;

public class APIResponseParser {
    public static Book parse(String response){
        Book book = new Book();
        //Getting the TITLE and setting it.
        String startRule = "<title>";
        String endRule = "<";
        String title = parse(response,startRule,endRule);
        System.out.println("TITLE : "+title);
        book.setTitle(title);

        //Getting the AUTHOR and setting it.
        startRule = "<name>";
        endRule = "<";
        String name = parse(response,startRule,endRule);
        System.out.println("AUTHOR NAME : "+name);
        book.setAuthor(name);

        //Getting the PUBLICATION_YEAR_STRING, parsing it to INT and setting it.
        startRule = "<original_publication_year type=\"integer\">";
        endRule = "<";
        String publicationYearString = parse(response,startRule,endRule);
        int publicationYear = Integer.parseInt(publicationYearString);
        System.out.println("PUBLICATION YEAR : "+publicationYear);
        book.setPublicationYear(publicationYear);

        //Getting the AVERAGE_RATING , parsing it to DOUBLE and setting it.
        startRule = "<average_rating>";
        endRule = "<";
        String averageRatingString = parse(response,startRule,endRule);
        double averageRating = Double.parseDouble(averageRatingString);
        System.out.println("AVERAGE RATING : "+averageRating);
        book.setAverageRating(averageRating);

        //Getting the RATINGS_COUNT , parsing it to INT and setting it.
        startRule = "<ratings_count type=\"integer\">";
        endRule = "<";
        String[] ratingsCountStringArray = parse(response,startRule,endRule).split(",");
        String ratingsCountString = ratingsCountStringArray[0];
        for(int i=1;i<ratingsCountStringArray.length;i++){
            ratingsCountString=ratingsCountString.concat(ratingsCountStringArray[i]);
        }
        int ratingsCount = Integer.parseInt(ratingsCountString);
        System.out.println("RATINGS COUNT : "+ratingsCount);
        book.setRatingsCount(ratingsCount);

        //Getting the IMAGE_URL and setting it.
        startRule = "<image_url>";
        endRule = "<";
        String imageUrl = parse(response,startRule,endRule);
        System.out.println("IMAGE URL : "+imageUrl);
        book.setImageUrl(imageUrl);

        //Returning the book :
        return book;

    }

    private static String parse(String response, String startRule, String endRule){
        int startIndex = response.indexOf(startRule);
        int endIndex = response.indexOf(endRule,startIndex+1);
        return response.substring(startIndex + startRule.length(),endIndex);
    }
}
