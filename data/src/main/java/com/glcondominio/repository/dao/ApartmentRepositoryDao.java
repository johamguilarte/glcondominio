package com.glcondominio.repository.dao;

import org.springframework.data.repository.CrudRepository;
import com.glcondominio.entity.ApartmentEntity;

public interface ApartmentRepositoryDao extends CrudRepository<ApartmentEntity, Long> {
    
  
}
