package com.web2.pos.repository;

import com.web2.pos.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Boolean existsByUsername(String username);
    List<User> findByUsername(String username);
}
