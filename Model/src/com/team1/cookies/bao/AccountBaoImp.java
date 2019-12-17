package com.team1.cookies.bao;

import com.team1.cookies.dao.AccountDao;
import com.team1.cookies.dao.AccountDaoImp;
import com.team1.cookies.dto.CustomerDto;

public class AccountBaoImp implements AccountBao {
    AccountDao account=new AccountDaoImp();
    public AccountBaoImp() {
        super();
    }

    @Override
    public int sign_in(CustomerDto customer) {
        return account.sign_in(customer);
      
    }

    @Override
    public boolean sign_up(CustomerDto customer) {
        return account.sign_up(customer);
    }
}
