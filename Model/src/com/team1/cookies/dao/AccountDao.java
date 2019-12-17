package com.team1.cookies.dao;

import com.team1.cookies.dto.CustomerDto;

import com.team1.cookies.dto.AccountDto;

public interface AccountDao {
    
    public boolean updateUser(AccountDto account);
    public int sign_in(CustomerDto customer);
    public boolean sign_up(CustomerDto customer);
}
