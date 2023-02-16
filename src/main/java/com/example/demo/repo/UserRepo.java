package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value="SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    User findUserById(int id);

    @Query(value="SELECT * FROM user WHERE id = ?1 and address=?2", nativeQuery = true)
    User findUserByIdAndAddress(String id, String address);
}
