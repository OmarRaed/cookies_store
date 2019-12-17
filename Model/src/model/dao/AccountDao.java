package model.dao;

import model.dto.AccountDto;

public interface AccountDao {
    
    public boolean updateUser(AccountDto account);
}
