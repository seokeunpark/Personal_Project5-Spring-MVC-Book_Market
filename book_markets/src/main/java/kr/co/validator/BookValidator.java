package kr.co.validator;

import kr.co.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

public class BookValidator implements Validator{

    @Autowired
    private javax.validation.Validator beanValidator;  // bean validation�� �ν��Ͻ� ����

    private Set<Validator> springValidators;  //spring validation�� �ν��Ͻ� ����
    public BookValidator() {   //������ 
        springValidators = new HashSet<Validator>();
    }  

    public void setSpringValidators(Set<Validator> springValidators) {  // springValidators�� setter() �޼��� 
        this.springValidators = springValidators;
    } 

    public boolean supports(Class<?> clazz) {  // Book Ŭ������ ��ȿ�� �˻縦 ���� ���� �޼��� 
        return Book.class.isAssignableFrom(clazz);
    }  
    public void validate(Object target, Errors errors) {  // Book Ŭ������ ��ȿ�� �˻� �޼��� 
        Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);  // Bean Validation ����
        for (ConstraintViolation<Object> violation : violations) {  // bean validation ���� ����
            String propertyPath = violation.getPropertyPath().toString();  // ���� �߻� �ʵ� ����
            String message = violation.getMessage();  // ���� �߻� �޽��� ����
            errors.rejectValue(propertyPath, "", message);  // ���� �߻��� �ʵ�� �޽����� Errors ��ü�� ����
        }  
        for(Validator validator: springValidators) {  // spring validation ���� ���� 
            validator.validate(target, errors);  // �߻��� ���� ������ ����
        }  
    }  
}
