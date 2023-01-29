package com.westes.loans.repository;

import com.westes.loans.model.Loan;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
  List<Loan> findAllByCustomerIdOrderByStartDtDesc(int customerId);
}
