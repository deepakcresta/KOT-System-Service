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

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kotservice.menu.Menu;
import com.kotservice.menu.MenuResponseDto;
import com.kotservice.menu.MenuResponseListDto;

/**
 * <<Description Here>>
 * @author vs
 * @version 
 * @since , Dec 7, 2022
 */
@Service
public class TodaySpecialService {
  
  @Autowired
  public TodaaySpecialRepository todaySpecialRepository;
  
  //for posting the today special dish
  public TodaySpecialResponseDto addTodaySpecial(TodaySpecialCreateDto todaySpecialCreateDto) {
     TodaySpecial todaySpecial = new TodaySpecial();
     todaySpecial.setTodaySpecialDish(todaySpecialCreateDto.getTodaySpecialDish());
     todaySpecial.setDishPhoto(todaySpecialCreateDto.getDishPhoto());
     todaySpecial.setPrice(todaySpecialCreateDto.getPrice());
     
     TodaySpecial saveTodaySpecial = todaySpecialRepository.save(todaySpecial);
     return getTodaySpecialResponseDto(saveTodaySpecial);  
  }
     
     private TodaySpecialResponseDto getTodaySpecialResponseDto(TodaySpecial todaySpecial) {
       TodaySpecialResponseDto response = new TodaySpecialResponseDto();
       response.setTodaySpecialDish(todaySpecial.getTodaySpecialDish());
       response.setDishPhoto(todaySpecial.getDishPhoto());
       response.setPrice(todaySpecial.getPrice());
      return response; 
     }
     
     
  //for getting  all today special
     public TodaySpecialResponseListDto getAll() {
       List<TodaySpecialResponseDto> todaySpecialResponseList = new ArrayList<>();
       List<TodaySpecial> todaySpecial = (List<TodaySpecial>)todaySpecialRepository.findAll();
       for(TodaySpecial todaySpecials:todaySpecial) {
         todaySpecialResponseList.add(getTodaySpecialResponseDto(todaySpecials));
       }
       TodaySpecialResponseListDto response = new TodaySpecialResponseListDto();
       response.setTodaySpecials(todaySpecialResponseList);
       response.setTotal((long)todaySpecial.size());
       return response;
     }
     
  
}
