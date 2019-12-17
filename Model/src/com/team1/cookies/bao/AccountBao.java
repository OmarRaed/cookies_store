package com.team1.cookies.bao;

import com.team1.cookies.dto.CustomerDto;

public interface AccountBao {
    public int sign_in(CustomerDto customer);
    public boolean sign_up(CustomerDto customer);
}
