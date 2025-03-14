package com.Hotel.Repossitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Hotel.Entity.CustomerEntity;
import java.util.Optional;

public interface CustomerRepossitory extends JpaRepository<CustomerEntity, Long> {

   
   
}
