package com.example.demo.Reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;


@Repository
public interface UserReponsitory extends JpaRepository<User, Long> {

}
