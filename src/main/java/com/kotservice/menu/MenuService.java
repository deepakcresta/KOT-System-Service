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
package com.kotservice.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <<Description Here>>
 * @author vs
 * @version 
 * @since , Nov 24, 2022
 */
@Service
public class MenuService {
  @Autowired
  public MenuRepository menuRepository;
  
  public MenuResponseDto addMenu(MenuCreateDto menuCreateDto) {
    Menu menu =new Menu();
    menu.setFoodMenu(menuCreateDto.getFoodMenu());
    System.out.println("data"+menu);
    menu.setMenuId(menuCreateDto.getMenuId());
      
    Menu savedMenu = menuRepository.save(menu);
    return getMenuResponseDto(savedMenu);
  }
  
  private MenuResponseDto getMenuResponseDto(Menu menu) {
    MenuResponseDto response = new MenuResponseDto();
    response.setFoodMenu(menu.getFoodMenu());
    response.setMenuId(menu.getMenuId());
    return response;
  }
  
  //for getting the data
  public MenuResponseListDto getAll() {
    List<MenuResponseDto> menuResponseList = new ArrayList<>();
    List<Menu> menu = (List<Menu>)menuRepository.findAll();
    for(Menu menus:menu) {
      menuResponseList.add(getMenuResponseDto(menus));
    }
    MenuResponseListDto response = new MenuResponseListDto();
    response.setMenus(menuResponseList);
    response.setTotal((long)menu.size());
    return response;
 
  }
  //getting the data by id;
  public MenuResponseDto getMenuById(Long id) {
    Optional<Menu> optionalMenu = menuRepository.findById(id);
        if(optionalMenu.isPresent()) {
          return getMenuResponseDto(optionalMenu.get());
        }
        else {
          return null;
        }
  }

  //getting the data by food name
  public MenuResponseDto getByFoodMenu(String foodMenu) {
    Optional<Menu> optionalMenu = menuRepository.getByFoodMenu(foodMenu);
    if(optionalMenu.isPresent()) {
      return getMenuResponseDto(optionalMenu.get());
    }
    else {
      return null;
    }
  }
  
  //delte by id
  
@Transactional
  public void deleteById(Long id) {
    menuRepository.deleteById(id);
  }
  

@Transactional
public void deleteByFoodMenu(String orderName) {
  menuRepository.deleteByFoodMenu(orderName);
}
}
