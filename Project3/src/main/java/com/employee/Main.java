package com.employee;

public class Main {
    public static void main(String[] args) {
        System.out.println("------ START OF PROGRAM ------");

        String response = "<work>\n" +
                "\t<id type=\"integer\">2361393</id>\n" +
                "\t<books_count type=\"integer\">813</books_count>\n" +
                "\t<ratings_count type=\"integer\">1,16,315</ratings_count>\n" +
                "\t<text_reviews_count type=\"integer\">3439</text_reviews_count> <original_publication_year type=\"integer\">1854</original_publication_year> <original_publication_month type=\"integer\" nil=\"true\"/> <original_publication_day type=\"integer\" nil=\"true\"/> <average_rating>3.79</average_rating>\n" +
                "\t<best_book type=\"Book\">\n" +
                "\t<id type=\"integer\">16902</id> <title>Walden</title> <author>\n" +
                "\t<id type=\"integer\">10264</id>\n" +
                "\t<name>Henry David Thoreau</name> </author>\n" +
                "\t   <image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>\n" +
                "\t   <small_image_url>http://images.gr-assets.com/books/1465675526s/16902.jpg</small\n" +
                "\t   _image_url>\n" +
                "\t      </best_book>\n" +
                " </work>";

        Book book = APIResponseParser.parse(response);
        Book book1 = APIResponseParser.parseAll(response);

        System.out.println("------ BOOK INFORMATION from Method \"Method1 : Parse \" -------");
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Author: " + book.getAuthor());
        System.out.println("Book Publication Year: " + book.getPublicationYear());
        System.out.println("Book Average Rating: " + book.getAverageRating());
        System.out.println("Book Ratings Count : " + book.getRatingsCount());
        System.out.println("Book Image Url : " + book.getImageUrl());


        System.out.println("------ BOOK INFORMATION from Method \"Method2 : ParseAll \" -------");
        System.out.println("Book Title: " + book1.getTitle());
        System.out.println("Book Author: " + book1.getAuthor());
        System.out.println("Book Publication Year: " + book1.getPublicationYear());
        System.out.println("Book Average Rating: " + book1.getAverageRating());
        System.out.println("Book Ratings Count : " + book1.getRatingsCount());
        System.out.println("Book Image Url : " + book1.getImageUrl());



        System.out.println("------ END OF PROGRAM ------");

    }
}