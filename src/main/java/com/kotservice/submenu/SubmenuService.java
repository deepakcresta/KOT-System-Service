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
 * @since , Nov 25, 2022
 */
@Service
public class SubmenuService {
  
  @Autowired
  public SubmenuRepository submenuRepository;
  
  public SubmenuResponseDto addSubmenu(SubmenuCreateDto submenuCreateDto) {
    Submenu submenu =new Submenu();
    submenu.setSubmenuName(submenuCreateDto.getSubmenuName());
    submenu.setPrice(submenuCreateDto.getPrice());
      
    Submenu savedSubmenu = submenuRepository.save(submenu);
    return getSubmenuResponseDto(savedSubmenu);
  }
  
  private SubmenuResponseDto getSubmenuResponseDto(Submenu  submenu) {
    SubmenuResponseDto response = new SubmenuResponseDto();
   response.setPrice(submenu.getPrice());
   response.setSubmenuName(submenu.getSubmenuName());
    return response;
  }
  
  //for getting the data
  public SubmenuResponseListDto getAll() {
    List<SubmenuResponseDto> submmenuResponseList = new ArrayList<>();
    List<Submenu> submenu = (List<Submenu>)submenuRepository.findAll();
    for(Submenu submenus:submenu) {
      submmenuResponseList.add(getSubmenuResponseDto(submenus));
    }
    SubmenuResponseListDto response = new SubmenuResponseListDto();
    response.setSubmenus(submmenuResponseList);
    response.setTotal((long)submenu.size());
    return response;
 
  }
  //getting the data by id;
  public SubmenuResponseDto getSubmenuById(Long id) {
    Optional<Submenu> optionalSubmenu = submenuRepository.findById(id);
        if(optionalSubmenu.isPresent()) {
          return getSubmenuResponseDto(optionalSubmenu.get());
        }
        else {
          return null;
        }
  }


  
  
@Transactional
  public void deleteById(Long id) {
    submenuRepository.deleteById(id);
  }
  
}
