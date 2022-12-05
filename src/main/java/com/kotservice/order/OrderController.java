/*************************************************************************
 * 

 * AADIM INNOVATION CONFIDENTIAL
 * __________________  
                    _ _             _____                             _   _             
     /\            | (_)           |_   _|                           | | (_)            
    /  \   __ _  __| |_ _ __ ___     | |  _ __  _ __   _____   ____ _| |_ _  ___  _ __  
   / /\ \ / _` |/ _` | | '_ ` _ \    | | | '_ \| '_ \ / _ \ \ / / _` | __| |/ _ \| '_ \ 
  / ____ \ (_| | (_| | | | | | | |  _| |_| | | | | | | (_) \ V / (_| | |_| | (_) | | | |
 /_/    \_\__,_|\__,_|_|_| |_| |_| |_____|_| |_|_| |_|\___/ \_/ \__,_|\__|_|\___/|_| |_|
                                                                                        
 *
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained here in is, and remains
 * the property of Aadim Innovation and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * here in are proprietary to Aadim Innovation. Dissemination of this
 * information or reproduction of this material is strictly forbidden unless
 * prior written permission is obtained from Aadim Innovation.
 * 
 */
package com.kotservice.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.kotservice.contact.ContactResponseDto;

/**
 * <<Description Here>>
 * @author vs
 * @version 
 * @since , Nov 5, 2022
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
  @Autowired
  public OrderService orderService;
  
  @PostMapping
  @ResponseStatus(code=HttpStatus.CREATED)
  public OrderResponseDto addOrder(@RequestBody OrdederCreateDto orderCreateDto) {
    return orderService.addOrder(orderCreateDto);
  }

  @GetMapping
  @ResponseStatus(code= HttpStatus.OK)
  public  OrderResponseListDto getAll() {
  return orderService.getAll();
}
  @GetMapping("/{id}")
  @ResponseStatus(code=HttpStatus.OK)
  public OrderResponseDto getById(@PathVariable("id")Long id) {
    return orderService.getById(id);
  }
  
  @GetMapping("/name/{orderName}")
  @ResponseStatus(code=HttpStatus.OK)
  public OrderResponseDto findByOrderName(@PathVariable ("orderName")String orderName) {
  return orderService.findByOrderName(orderName);
  }
  
  @DeleteMapping("/{id}")
  @ResponseStatus(code=HttpStatus.OK)
  public void deleteOrderById(@PathVariable("id")Long id) {
  orderService.deleteOrderById(id);
 }
  @DeleteMapping("/name/{orderName})")
  @ResponseStatus(code=HttpStatus.NO_CONTENT)
  public void deleteOrderByName(@PathVariable ("orderName")String orderName) {
    orderService.deleteByOrderName(orderName);
  }
}
