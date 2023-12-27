package kr.co.service;


import kr.co.domain.Book;
import kr.co.domain.Order;
import kr.co.repository.BookRepository;
import kr.co.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    public void confirmOrder(String bookId, long quantity) {  
        Book bookById = bookRepository.getBookById(bookId);
        if(bookById.getUnitsInStock() < quantity){
            throw new IllegalArgumentException("ǰ���Դϴ�. ��밡���� ����� :"+ bookById.getUnitsInStock());
        }
        bookById.setUnitsInStock(bookById.getUnitsInStock() - quantity);
    }  

    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    } 
}
