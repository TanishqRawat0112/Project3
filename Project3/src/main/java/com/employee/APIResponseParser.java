package com.employee;

import com.employee.Book;

public class APIResponseParser {
    public static Book parseAll(String response){
        Book book = new Book();
        String[] startRule = new String[6];
        startRule[0] = "<title>";
        startRule[1] = "<name>";
        startRule[2] = "<original_publication_year type=\"integer\">";
        startRule[3] = "<average_rating>";
        startRule[4] = "<ratings_count type=\"integer\">";
        startRule[5] = "<image_url>";
        String endRule = "<";

        String[] result = parse(response, startRule,endRule);
        //Setting the Title
        book.setTitle(result[0]);

        //Setting the Author:
        book.setAuthor(result[1]);

        //Setting the Publication Year:
        int publicationYear = Integer.parseInt(result[2]);
        book.setPublicationYear(publicationYear);

        //Setting the Average Rating:
        double averageRating = Double.parseDouble(result[3]);
        book.setAverageRating(averageRating);

        //Setting the Ratings Count:
        String[] ratingsCountStringArray = result[4].split(",");
        String ratingsCountString = ratingsCountStringArray[0];
        for(int i=1;i<ratingsCountStringArray.length;i++){
            ratingsCountString=ratingsCountString.concat(ratingsCountStringArray[i]);
        }
        int ratingsCount = Integer.parseInt(ratingsCountString);
        book.setRatingsCount(ratingsCount);

        //Setting the Image Url:
        book.setImageUrl(result[5]);

        return book;
    }

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

    private static String[] parse(String response, String[] startRule, String endRule){
        String[] result = new String[startRule.length];
        for(int i=0;i<startRule.length;i++){
            int startIndex = response.indexOf(startRule[i]);
            int endIndex = response.indexOf(endRule,startIndex+1);
            result[i]=response.substring(startIndex + startRule[i].length(),endIndex);
        }
        return result;
    }
}
