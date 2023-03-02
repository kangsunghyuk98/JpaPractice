package com.jpablog.repository;

import com.jpablog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 자동으로 bean에 등록됨 (JpaRepository 상속 받았기 때문)
public interface UserRepository extends JpaRepository<User, Integer> {

}
