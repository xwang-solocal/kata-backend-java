package com.solocal.dsp.kata.dao.repository;

import com.solocal.dsp.kata.model.business.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
