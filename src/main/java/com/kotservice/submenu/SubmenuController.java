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
package com.kotservice.submenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RequestMapping("api/v1/menu/submenu")
@RestController
public class SubmenuController {
  
  @Autowired
  private SubmenuService submenuService;
  
  //post mapping for the  sub menu
  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  public SubmenuResponseDto addSubmenu(@RequestBody SubmenuCreateDto submenuCreateDto) {
      return submenuService.addSubmenu(submenuCreateDto);
  }
  @GetMapping()
  @ResponseStatus(code = HttpStatus.OK)
  public SubmenuResponseListDto getAll() {
    return submenuService.getAll();
    } 
  
//  @DeleteMapping("/submenu")
//  public void deleteContacts( @RequestBody List<Long> submenusIds) {
//      submenuService.delet  eSubmenu( submenusIds);
//  }
//  
//  @DeleteMapping("/{userId}/submenus")
//  public void deleteSubmenu(@PathVariable Long userId, @RequestBody List<Long> submenuIds) {
//      submenuService.deleteSubmenu(MenuId, submenusIds);
//  }
//  
//  @DeleteMapping("/{userId}/delete-contact")
//  public void deleteSubmenus(@PathVariable Long submenuId) {
//      submenuService.deleteSubmenu(submenuId);
//  }
 

}
