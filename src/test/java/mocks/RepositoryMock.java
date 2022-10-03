package mocks;

import com.swarnendu.repository.Repository;

public class RepositoryMock implements Repository {
    
    public String result = "";
    @Override
    public void newLoan(String borrowerName, String bankName, double principal, int term, double rate) {
        result = "NewLoan";
    }

    @Override
    public void processPayment(String borrowerName, String bankName, double lumpSum, int emiNo) {
        result = "ProcessPayment";
    }

    @Override
    public void processBalance(String borrowerName, String bankName, int emiNo) {
        result = "ProcessBalance";
    }
}
