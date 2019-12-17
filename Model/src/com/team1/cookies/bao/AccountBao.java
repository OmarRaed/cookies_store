package com.team1.cookies.bao;

import com.team1.cookies.dto.CustomerDto;

public interface AccountBao {
    public boolean sign_in(CustomerDto customer);
    public boolean sign_up(CustomerDto customer);
}
