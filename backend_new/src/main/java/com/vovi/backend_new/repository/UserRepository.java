package com.vovi.backend_new.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vovi.backend_new.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByLogin(String login);
    Boolean existsByLoginAndPassword(String login, String password);
}
