package kr.co.validator;

import kr.co.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UnitsInStockValidator implements Validator{
    public boolean supports(Class<?> clazz) {  // Book Ŭ������ ��ȿ�� �˻� ���θ� ���� �޼��� 
        return Book.class.isAssignableFrom(clazz);
    }  

    public void validate(Object target, Errors errors) {  // Book Ŭ������ ��ȿ�� �˻� �޼��� 
        Book book = (Book) target;
        if(book.getUnitPrice()>=10000 && book.getUnitsInStock()>99) {
            errors.rejectValue("unitsInStock", "UnitsInStockValidator.message");  // ���� ��ü�� �Ӽ��� �޽��� ����
        }
    } 
}
