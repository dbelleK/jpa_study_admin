package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository; //기본적인 crud 제공
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //select * from user where account = ? << test03, test04..
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    //select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account,String email);
}
