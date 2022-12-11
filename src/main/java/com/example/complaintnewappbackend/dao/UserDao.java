package com.example.complaintnewappbackend.dao;

import com.example.complaintnewappbackend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository <User,Integer> {

@Query(value = "SELECT `id`, `address`, `confirm`, `email`, `name`, `password`, `phone`, `username` FROM `user_detail` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
List<User> UserLogin(@Param("email") String email, @Param("password") String password);


@Query(value = "SELECT `id`, `address`, `confirm`, `email`, `name`, `password`, `phone`, `username` FROM `user_detail` WHERE `id`= :id",nativeQuery = true)
    List<User> UserById(@Param("id") Integer id);
}
