package kr.co.service;


import kr.co.domain.Order;

public interface OrderService {
    void confirmOrder(String  bookId, long quantity);
    Long saveOrder(Order order);
}
