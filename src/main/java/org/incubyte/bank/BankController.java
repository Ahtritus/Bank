package org.incubyte.bank;

import io.micronaut.http.annotation.*;
import org.incubyte.response.ResponseWrapper;

@Controller("/bank")
public class BankController {

    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @Get(uri="/", produces="text/html")
    public String index() {
        return bankService.welcomeMessage();
    }

    @Post()
    public Branch save(@Body Branch branch) {
        return bankService.save(branch);
    }

    @Get(uri="/branchid/{id}")
    public ResponseWrapper getBranchById(@PathVariable(value = "id")Long id) {
        return bankService.getBranchById(id);
    }

    @Get(uri="/branches")
    public Iterable<Branch> getAllBranches() {
        return bankService.getAllBranches();
    }
}