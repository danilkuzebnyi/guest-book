package org.danylo.guestbook.repository;

import org.danylo.guestbook.model.GuestBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class GuestBookRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void save(GuestBook book) {
        String sql = "INSERT INTO books(name, message, rating) VALUES(:name, :message, :rating)";
        SqlParameterSource namedParameters = new MapSqlParameterSource().
                addValue("name", book.getName()).
                addValue("message", book.getMessage()).
                addValue("rating", book.getRating());

        namedParameterJdbcTemplate.execute(sql, namedParameters, PreparedStatement::execute);
    }

    public List<GuestBook> showAll() {
        String sql = "SELECT name, message, rating FROM books ORDER BY id desc";
        return namedParameterJdbcTemplate.query(sql, new GuestBookRowMapper());
    }

    public List<GuestBook> paginate(int page, int itemsPerPage, int booksPages) {
        List<GuestBook> splittedBooks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < booksPages; i++) {
            if (page == i) {
                String sql = "SELECT name, message, rating FROM books ORDER BY id desc OFFSET :skip LIMIT :itemsPerPage";
                SqlParameterSource namedParameters = new MapSqlParameterSource().
                        addValue("skip", i * itemsPerPage).
                        addValue("itemsPerPage", itemsPerPage);
                splittedBooks = namedParameterJdbcTemplate.query(sql, namedParameters, new GuestBookRowMapper());
            }
        }
        return splittedBooks;
    }
}
