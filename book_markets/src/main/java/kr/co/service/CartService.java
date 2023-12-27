package kr.co.service;


import kr.co.domain.Cart;

public interface CartService {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
    Cart validateCart(String cartId);
}
