package com.wipro.CustomerAccountTracker.DTO;

import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import com.wipro.CustomerAccountTracker.Bean.CustomerBean;

public class CustomerAccountDTO {
    private CustomerBean customerBean;
    private AccountBean accountBean;

    // Getters and Setters
    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public void setCustomerBean(CustomerBean customerBean) {
        this.customerBean = customerBean;
    }

    public AccountBean getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(AccountBean accountBean) {
        this.accountBean = accountBean;
    }
}
