package com.wipro.CustomerAccountTracker.Dao;

import com.wipro.CustomerAccountTracker.Bean.CustomerBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends CrudRepository<CustomerBean, Integer> {
    Optional<CustomerBean> findByAccountNumber(long accountNumber);
    void deleteByAccountNumber(Long accountNumber);
}
