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

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <<Description Here>>
 * @author vs
 * @version 
 * @since , Nov 5, 2022
 */
@Getter
@Setter
public class OrderResponseDto {
//  private String foodName;
  private String orderName;

  private int quantity;
  private String tabledNo;
  private String time;
  /**
   *<<Add description here>>
   * @param createDteTime
   * @author
   * @since , Modified In: @version, By @author
   */
  public void setCreateDateTime(LocalDateTime createDteTime) {
    // TODO Auto-generated method stub
    
  }

  
}
