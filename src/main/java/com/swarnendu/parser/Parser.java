package com.swarnendu.parser;

import com.swarnendu.repository.BorrowerRepository;
import com.swarnendu.repository.Repository;

public class Parser implements CommandRunner {

    private Repository repository;

    public Parser(Repository repository) {
        this.repository = repository;
    }

    public void execute(String command) {
        String[] splitCommand = command.split(" ");
        if(splitCommand.length < 4) {
            return;
        }
        switch (splitCommand[0]) {
            case "LOAN":
                if(splitCommand.length == 6) {
                    String bankName = splitCommand[1];
                    String borrowerName = splitCommand[2];
                    double principal = Double.parseDouble(splitCommand[3]);
                    int term = Integer.parseInt(splitCommand[4]);
                    double rate = Double.parseDouble(splitCommand[5]);
                    processLoan(bankName, borrowerName, principal, term, rate);
                } else return;
                break;
            case "PAYMENT":
                if(splitCommand.length == 5) {
                    String bankName = splitCommand[1];
                    String borrowerName = splitCommand[2];
                    double lumpSum = Double.parseDouble(splitCommand[3]);
                    int emiNo = Integer.parseInt(splitCommand[4]);
                    processPayment(bankName, borrowerName, lumpSum, emiNo);
                } else return;
                break;
            case "BALANCE":
                if(splitCommand.length == 4) {
                    String bankName = splitCommand[1];
                    String borrowerName = splitCommand[2];
                    int emiNo = Integer.parseInt(splitCommand[3]);
                    processBalance(bankName, borrowerName, emiNo);
                } else return;
                break;
            default:
                return;
        }
    }

    private void processLoan(String bankName, String borrowerName, double principal, int term, double rate) {
        repository.newLoan(borrowerName, bankName, principal, term, rate);
    }

    private void processPayment(String bankName, String borrowerName, double lumpSum, int emiNo) {
        repository.processPayment(borrowerName, bankName, lumpSum, emiNo);
    }

    private void processBalance(String bankName, String borrowerName, int emiNo) {
        repository.processBalance(borrowerName, bankName, emiNo);
    }
}
