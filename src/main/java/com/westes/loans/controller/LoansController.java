package com.westes.loans.controller;

import com.westes.loans.config.LoansServiceConfig;
import com.westes.loans.model.Loan;
import com.westes.loans.model.Properties;
import com.westes.loans.repository.LoanRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoansController {

  private final LoansServiceConfig loansServiceConfig;
  private final LoanRepository loanRepository;

  @GetMapping("/loans/{customerId}")
  public List<Loan> getLoansDetails(@PathVariable int customerId) {
    log.info("getCustomerDetails started");
    return loanRepository.findAllByCustomerIdOrderByStartDtDesc(customerId);
  }

  @GetMapping("/loans/properties")
  public Properties getPropertyDetails() {
    return new Properties(loansServiceConfig.getMsg(),
        loansServiceConfig.getBuildVersion(),
        loansServiceConfig.getMailDetails(), loansServiceConfig.getActiveBranches());
  }
}
