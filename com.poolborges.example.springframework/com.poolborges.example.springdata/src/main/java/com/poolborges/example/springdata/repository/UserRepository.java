package com.poolborges.example.springdata.repository;

import com.poolborges.example.springdata.domain.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Borges
 */
public interface UserRepository extends CrudRepository<User, Long> {
  List<User> findByLastname(String lastname);
}
