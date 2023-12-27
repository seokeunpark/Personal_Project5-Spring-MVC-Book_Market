package kr.co.validator;


import kr.co.domain.Book;
import kr.co.exception.BookIdException;
import kr.co.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookIdValidator implements ConstraintValidator<BookId, String>{

    @Autowired
    private BookService bookService;

    public void initialize(BookId constraintAnnotation) {  // @BookId ���� �ʱ�ȭ �޼���  
    }  
    public boolean isValid(String value, ConstraintValidatorContext context) {  // ��ȿ�� �˻� �޼���  
        Book book;
        try {
            book = bookService.getBookById(value);
        } catch (BookIdException e) {
            return true;
        }
        if(book!= null) {
            return false;
        }
        return true;
    } 
}
