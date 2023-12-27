package kr.co.repository;


import kr.co.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
