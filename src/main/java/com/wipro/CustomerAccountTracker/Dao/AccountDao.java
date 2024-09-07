package com.wipro.CustomerAccountTracker.Dao;

import com.wipro.CustomerAccountTracker.Bean.AccountBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDao extends CrudRepository<AccountBean, Integer> {
	Optional<AccountBean> findByAccountNumber(long accountNumber);
}
