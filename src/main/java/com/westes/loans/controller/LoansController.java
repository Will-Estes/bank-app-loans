package com.westes.loans.controller;

import com.westes.loans.config.LoansServiceConfig;
import com.westes.loans.model.Loan;
import com.westes.loans.model.Properties;
import com.westes.loans.repository.LoanRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoansController {

  private final LoansServiceConfig loansServiceConfig;
  private final LoanRepository loanRepository;

  @GetMapping("/loans/{customerId}")
  public List<Loan> getLoansDetails(@RequestHeader("westes-correlation-id") String correlationId,
      @PathVariable int customerId) {
    return loanRepository.findAllByCustomerIdOrderByStartDtDesc(customerId);
  }

  @GetMapping("/loans/properties")
  public Properties getPropertyDetails() {
    return new Properties(loansServiceConfig.getMsg(),
        loansServiceConfig.getBuildVersion(),
        loansServiceConfig.getMailDetails(), loansServiceConfig.getActiveBranches());
  }
}
