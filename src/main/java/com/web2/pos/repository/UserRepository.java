package com.web2.pos.repository;

import com.web2.pos.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
