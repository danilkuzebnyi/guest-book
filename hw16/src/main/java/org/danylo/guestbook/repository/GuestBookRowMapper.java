package org.danylo.guestbook.repository;

import org.danylo.guestbook.model.GuestBook;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class GuestBookRowMapper implements RowMapper<GuestBook> {
    @Override
    public GuestBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        GuestBook book = new GuestBook();
        book.setName(rs.getString("name"));
        book.setMessage(rs.getString("message"));
        book.setRating(rs.getInt("rating"));

        return book;
    }
}
