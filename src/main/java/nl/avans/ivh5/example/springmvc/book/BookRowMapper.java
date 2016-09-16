package nl.avans.ivh5.example.springmvc.book;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class BookRowMapper implements RowMapper<Book>
{
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        // Book maakt gebruik van het Builder Design Pattern.
        // Zie de code van Book.
        //
        Book book = new Book.Builder(
                rs.getLong("ISBN"),
                rs.getString("Title"),
                rs.getString("Author"))
                .shortDescription(rs.getString("ShortDescription"))
                .edition(rs.getString("Edition"))
                .imageUrl(rs.getString("ImageURL"))
                .build();

        return book;
    }
}