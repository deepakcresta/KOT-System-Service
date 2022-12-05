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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
  
  @Autowired
  public MenuService menuService;
  
//  @Autowired
  
  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  public MenuResponseDto addMenu(@RequestBody MenuCreateDto menuCreateDto) {
    return menuService.addMenu(menuCreateDto);
  }
  @GetMapping()
  @ResponseStatus(code = HttpStatus.OK)
  public  MenuResponseListDto getAll() {
    return menuService.getAll();
    } 
  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public MenuResponseDto getMenuById(@PathVariable ("id")Long id) {
    return menuService.getMenuById(id);
  }
  @GetMapping("/{foodMenu}")
  @ResponseStatus(code = HttpStatus.OK)
  public MenuResponseDto getByFoodMenu(@PathVariable ("foodMenu")String foodMenu) {
    return menuService.getByFoodMenu(foodMenu);
  }
  @DeleteMapping("/{id}")
  @ResponseStatus( code = HttpStatus.NO_CONTENT)
  public void deleteById (Long id) {
    menuService.deleteById(id);
  }
  @DeleteMapping("/{foodMenu}")
  @ResponseStatus( code = HttpStatus.NO_CONTENT)
  public void deleteByFoodMenu(String foodMenu) {
    menuService.deleteByFoodMenu(foodMenu);
  }

  
}
