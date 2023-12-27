package kr.co.repository;


import kr.co.domain.Book;
import kr.co.exception.BookIdException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public BookRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Book> getAllBookList() {
        return sqlSessionTemplate.selectList("BookMapper.getAllBookList");
    }

    public List<Book> getBookListByCategory(String category) {
        return sqlSessionTemplate.selectList("BookMapper.getBookListByCategory", category);
    }

    public Set<Book> getBookListByFilter(Map<String, List<String>> filter) {
        return sqlSessionTemplate.selectOne("BookMapper.getBookListByFilter", filter);
    }

    public Book getBookById(String bookId) {
        Book book = sqlSessionTemplate.selectOne("BookMapper.getBookById", bookId);

        if (book == null) {
            throw new BookIdException(bookId);
        }

        return book;
    }

    public void setNewBook(Book book) {
        sqlSessionTemplate.insert("BookMapper.setNewBook", book);
    }

    public void setUpdateBook(Book book) {
        sqlSessionTemplate.update("BookMapper.setUpdateBook", book);
    }

    public void setDeleteBook(String bookId) {
        sqlSessionTemplate.delete("BookMapper.setDeleteBook", bookId);
    }
}
