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
package com.kotservice.todaySpecial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vaadin.flow.component.page.BodySize;

/**
 * <<Description Here>>
 * @author vs
 * @version 
 * @since , Dec 7, 2022
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/special")
public class TodaySpecialController {
  
  @Autowired
  private TodaySpecialService todaySpecialService;
  
  @PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
  public TodaySpecialResponseDto addTodaySpecial(@RequestBody TodaySpecialCreateDto todaySpecailCreateDto) {
    return todaySpecialService.addTodaySpecial(todaySpecailCreateDto);
  }
  
@GetMapping
@ResponseStatus(code = HttpStatus.OK)
public TodaySpecialResponseListDto getAll() {
  return todaySpecialService.getAll();
  
}

}
