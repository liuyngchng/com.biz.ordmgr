package com.biz.ordmgr.mapper;


import com.biz.ordmgr.model.Order;

import java.util.List;

public interface OrderMapper {

    void insertOrder(Order order);

    void deleteOrder(int id);

    void updateOrder(Order order);

    Order selectOrder(String id);

//    List<Order> getOrderListByLoc(String loc);
}
