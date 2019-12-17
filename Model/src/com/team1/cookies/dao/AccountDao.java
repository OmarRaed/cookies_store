package com.team1.cookies.dao;

import com.team1.cookies.dto.CustomerDto;

import model.dto.AccountDto;

public interface AccountDao {
    
    public boolean updateUser(AccountDto account);
    public boolean sign_in(CustomerDto customer);
    public boolean sign_up(CustomerDto customer);
}
