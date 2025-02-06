package com.willystw.librarysystem.repository;

import com.willystw.librarysystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Query(value = "SELECT * FROM users u where u.id= :id", nativeQuery = true )
  User findUserById(@Param("id") Long id);
}
