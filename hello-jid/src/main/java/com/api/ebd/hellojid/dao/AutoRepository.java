package com.api.ebd.hellojid.dao;

import com.api.ebd.hellojid.model.Auto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends CrudRepository<Auto, Integer> {
}
