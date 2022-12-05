
package com.kotservice.submenu;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Service;
import lombok.Getter;
import lombok.Setter;

/**
 * <<Description Here>>
 * @author vs
 * @version 
 * @since , Nov 25, 2022
 */
@Getter
@Setter
@Entity
public class Submenu implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long submenuId;
  
  private  String submenuName;
  
  private double price;

}
