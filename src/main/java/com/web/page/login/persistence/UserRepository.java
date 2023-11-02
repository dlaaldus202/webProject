package com.web.page.login.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.page.login.domin.UserVo;


public interface UserRepository extends JpaRepository<UserVo, String> {

}
