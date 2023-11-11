package com.coursenet;

import java.util.List;

import com.coursenet.model.OrderDTO;

public interface OrderController {
    void createNewOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderList();

    OrderDTO getOrder(Long orderId);

    void deleteOrder(Long orderId);

    void updateOrder(long orderId, OrderDTO orderDTO);

    void updateOrder(long orderId, String descriptionData);
}
