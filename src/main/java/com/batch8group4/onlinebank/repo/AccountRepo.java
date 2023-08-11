package com.batch8group4.onlinebank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch8group4.onlinebank.model.Account;

@Repository
public interface AccountRepo  extends JpaRepository<Account, String>{

}
