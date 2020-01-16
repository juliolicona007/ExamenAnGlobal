package com.anglobal.julio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.anglobal.julio.model.Owner;

@Repository
public interface IOwnerDao extends JpaRepository<Owner, Long> {

}
