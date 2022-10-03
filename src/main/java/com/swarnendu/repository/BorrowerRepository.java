package com.swarnendu.repository;

import com.swarnendu.model.Borrower;

import java.util.HashMap;

public class BorrowerRepository implements Repository {

    private HashMap<String, Borrower> borrowers;

    public BorrowerRepository() {
        this.borrowers = new HashMap<String, Borrower>();
    }

    public void newLoan(String borrowerName, String bankName, double principal, int term, double rate) {
        String accountKey = bankName + "_" + borrowerName;
        Borrower newBorrower = new Borrower(borrowerName, bankName, principal, rate, term);
        borrowers.put(accountKey, newBorrower);
    }

    public void processPayment(String borrowerName, String bankName, double lumpSum, int emiNo) {
        String accountKey = bankName + "_" + borrowerName;
        if(!borrowers.containsKey(accountKey)) {
            return;
        }
        Borrower borrower = borrowers.get(accountKey);
        borrower.registerLumpSumPayment(emiNo, lumpSum);
    }

    public void processBalance(String borrowerName, String bankName, int emiNo) {
        String accountKey = bankName + "_" + borrowerName;
        if(!borrowers.containsKey(accountKey)) {
            return;
        }
        Borrower borrower = borrowers.get(accountKey);
        borrower.printBalanceForEmiNo(emiNo);
    }

    public boolean isRepositoryEmpty() {
        return borrowers.isEmpty();
    }
}
