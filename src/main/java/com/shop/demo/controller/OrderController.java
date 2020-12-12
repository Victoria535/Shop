package com.shop.demo.controller;

import com.shop.demo.dto.OrderDTO;
import com.shop.demo.entity.Order;
import com.shop.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;


@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/createOrder")
    public Order saveOrder(@RequestBody OrderDTO orderDTO){
        Order order = new Order();
        order.setAddress(orderDTO.getAddress());
        order.setPhone(orderDTO.getPhone());
        order.setName(orderDTO.getName());
        order.setProductAndCount(orderDTO.getProductAndCount());
        order.setStatus("New");

        return orderRepository.save(order);
    }
}
