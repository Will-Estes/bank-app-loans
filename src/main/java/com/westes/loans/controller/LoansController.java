package com.westes.loans.controller;

import com.westes.loans.model.Loan;
import com.westes.loans.repository.LoanRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoansController {

  private final LoanRepository loanRepository;

  @GetMapping("/loans/{customerId}")
  public List<Loan> getLoansDetails(@PathVariable int customerId) {
    List<Loan> loans = loanRepository.findAllByCustomerIdOrderByStartDtDesc(customerId);
    if (loans != null) {
      return loans;
    } else {
      return null;
    }

  }
}
