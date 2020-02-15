package com.game.demo.repositories;

import com.game.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select MAX(AttemptId) from user_my where userid= :userid", nativeQuery = true)
    Integer findMaximumAttempId(String userid);
}
