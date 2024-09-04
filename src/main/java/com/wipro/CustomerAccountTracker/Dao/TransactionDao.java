package com.wipro.CustomerAccountTracker.Dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wipro.CustomerAccountTracker.Bean.TransactionBean;

@Repository
public interface TransactionDao extends CrudRepository<TransactionBean, Integer> {
    List<TransactionBean> findByBeneficiaryAccountNumber(long beneficiaryAccountNumber);
}
