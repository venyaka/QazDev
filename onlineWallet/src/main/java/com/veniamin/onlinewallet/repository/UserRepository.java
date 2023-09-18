package com.veniamin.onlinewallet.repository;

import com.veniamin.onlinewallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String phone);
    User findByVerificationCode(String code);
    boolean existsByPhone(String phone);
//    UserDetails loadUserByUsername(String login);
}
