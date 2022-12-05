package com.kotservice.menu;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {


  Optional<Menu> getByFoodMenu(String foodMenu);

 
  void deleteByFoodMenu(String foodMneu);


}
