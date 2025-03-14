package com.Hotel.Repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Hotel.Entity.CustomerEntity;


public interface CustomerRepossitory extends JpaRepository<CustomerEntity, Long> {

   
   
}
