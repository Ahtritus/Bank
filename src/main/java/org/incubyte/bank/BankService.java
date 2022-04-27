package org.incubyte.bank;

import jakarta.inject.Singleton;
import java.util.Optional;
import org.incubyte.response.ResponseWrapper;

@Singleton
public class BankService {

  private final BranchRepository branchRepository;

  public BankService(BranchRepository branchRepository) {
    this.branchRepository = branchRepository;
  }

  public String welcomeMessage() {
    return "<b>Hello World</b>";
  }

  public Branch save(Branch branch) {
    return branchRepository.save(branch);
  }

  public ResponseWrapper getBranchById(Long id) {
    Optional<Branch> branchMaybe = branchRepository.findById(id);
    if (branchMaybe.isPresent()) {
      return new ResponseWrapper<Branch>(branchMaybe.get(), "Success");
    }
    return new ResponseWrapper<String>("", "Branch not found");
  }

  public Iterable<Branch> getAllBranches() {
    return branchRepository.findAll();
  }
}
