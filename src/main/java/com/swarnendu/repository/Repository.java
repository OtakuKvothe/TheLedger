package com.swarnendu.repository;

public interface Repository {
    void newLoan(String borrowerName, String bankName, double principal, int term, double rate);
    void processPayment(String borrowerName, String bankName, double lumpSum, int emiNo);
    void processBalance(String borrowerName, String bankName, int emiNo);
}
