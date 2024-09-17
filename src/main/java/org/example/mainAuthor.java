package org.example;

import org.example.entities.Author;
import org.example.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mainAuthor {
    public static void main(String[] args){

        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/book",
                    "postgres",
                    "1234");
            Statement stmt = con.createStatement();
            ResultSet rsBook = stmt.executeQuery("select * from book b join author a on a.id = b.author_id");
            List<Book> books = new ArrayList<>();

            while(rsBook.next()){
                books.add(mapFullBook(rsBook));
            }
            con.close();
            books.forEach(System.out::println);

        }catch(Exception e){};
    }

    public static Book mapBook(ResultSet rsBook) throws SQLException {
        return new Book(
                rsBook.getString("isbn"),
                rsBook.getString("title"),
                rsBook.getString("description"),
                rsBook.getDate("release_date").toLocalDate(),
                rsBook.getInt("author_id")
        );
    }

    public static Author mapAuthor(ResultSet rsAuthor) throws SQLException {
        return new Author(
                rsAuthor.getInt("id"),
                rsAuthor.getString("prenom"),
                rsAuthor.getString("nom"),
                rsAuthor.getDate("birthdate").toLocalDate()
        );
    }

    public static Book mapFullBook(ResultSet rsFullBook) throws SQLException {
        Book livre = mapBook(rsFullBook);
        livre.setAuthor(mapAuthor(rsFullBook));
        return livre;
    }
}
