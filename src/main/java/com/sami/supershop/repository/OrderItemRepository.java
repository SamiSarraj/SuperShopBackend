package com.sami.supershop.repository;

import com.sami.supershop.domain.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    List<OrderItem> findAllByBasketId(Long id);
    OrderItem findAllById(Long id);

}
