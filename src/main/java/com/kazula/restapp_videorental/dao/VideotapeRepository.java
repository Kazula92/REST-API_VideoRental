package com.kazula.restapp_videorental.dao;

import com.kazula.restapp_videorental.dao.entity.Videotapes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideotapeRepository extends CrudRepository<Videotapes, Long> {

}
