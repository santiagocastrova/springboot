package com.crud.santiago.repositories;

import com.crud.santiago.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE lower(u.name) LIKE lower(concat('%', :keyword, '%')) OR lower(u.email) LIKE lower(concat('%', :keyword, '%'))")
    List<User> searchUsers(@Param("keyword") String keyword);
}
