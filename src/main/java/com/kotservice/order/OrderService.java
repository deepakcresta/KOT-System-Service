/*************************************************************************
 * 
 * AADIM INNOVATION CONFIDENTIAL __________________ _ _ _____ _ _ /\ | (_) |_ _| | | (_) / \ __ _
 * __| |_ _ __ ___ | | _ __ _ __ _____ ____ _| |_ _ ___ _ __ / /\ \ / _` |/ _` | | '_ ` _ \ | | | '_
 * \| '_ \ / _ \ \ / / _` | __| |/ _ \| '_ \ / ____ \ (_| | (_| | | | | | | | _| |_| | | | | | | (_)
 * \ V / (_| | |_| | (_) | | | | /_/ \_\__,_|\__,_|_|_| |_| |_| |_____|_| |_|_| |_|\___/ \_/
 * \__,_|\__|_|\___/|_| |_|
 *
 * 
 * All Rights Reserved.
 * 
 * NOTICE: All information contained here in is, and remains the property of Aadim Innovation and
 * its suppliers, if any. The intellectual and technical concepts contained here in are proprietary
 * to Aadim Innovation. Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Aadim Innovation.
 * 
 */
package com.kotservice.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kotservice.contact.Contact;
import com.kotservice.contact.ContactResponseDto;
import com.kotservice.user.Customer;
import com.kotservice.user.CustomerResponseDto;
import com.kotservice.user.CustomerResponseListDto;

/**
 * <<Description Here>>
 * 
 * @author vsordrs
 * @version
 * @since , Nov 5, 2022
 */
@Service
public class OrderService {

  @Autowired
  private OrderRepository orderRepository;

  public OrderResponseDto addOrder(OrdederCreateDto orderCreateDto) {
    Order order = new Order();
    order.setOrderName(orderCreateDto.getOrderName());
    order.setQuantity(orderCreateDto.getQuantity());
    order.setTabledNo(orderCreateDto.getTabledNo());
    order.setTime(orderCreateDto.getTime());

    Order savedOrder = orderRepository.save(order);
    return getOrderResponseDto(savedOrder);

  }

  private OrderResponseDto getOrderResponseDto(Order order) {
    OrderResponseDto response = new OrderResponseDto();
    response.setOrderName(order.getOrderName());
    response.setQuantity(order.getQuantity());
    response.setTabledNo(order.getTabledNo());
    response.setTime(order.getTime());
    return response;
  }
//Getting all the contents of the database
  public OrderResponseListDto getAll() {
    List<OrderResponseDto> orderResponseList = new ArrayList<>();
    List<Order> order = (List<Order>) orderRepository.findAll();
    for (Order ordes : order) {
      orderResponseList.add(getOrderResponseDto(ordes));
    }

    OrderResponseListDto response = new OrderResponseListDto();
   response.setOrders(orderResponseList);
    response.setTotal((long)order.size());
    return response;
  }
  //Getting the contents by the id
  public OrderResponseDto getById(Long id) {
    Optional<Order> optionalOrder =orderRepository.findById(id);
    if (optionalOrder.isPresent())
    {
      return getOrderResponseDto(optionalOrder.get());
  }
 return null;
}
  //Getting the  order by the name
  public OrderResponseDto findByOrderName( String orderName) {
    Optional<Order> optionalOrder =orderRepository.findByOrderName(orderName);
    if(optionalOrder.isPresent()) {
      return getOrderResponseDto(optionalOrder.get());
    }
    return null;
  }

  //Deleting the contents
@Transactional
//Deleting the content by id
public void deleteOrderById(Long id ) {
   orderRepository.deleteById(id);
 }

//Deleting the content by their name;
@Transactional
public void deleteByOrderName(String orderName) {
  orderRepository.deleteByOrderName(orderName);
}
}



