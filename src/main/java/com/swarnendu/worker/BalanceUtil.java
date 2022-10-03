package com.swarnendu.worker;

import com.swarnendu.model.Borrower;

public class BalanceUtil {
    public static void computeBalance(Borrower borrower, int emiNo) {
        double amountPaid = 0;
        for(Integer lumpSumEmi: borrower.getLumpSums().keySet()) {
            if(lumpSumEmi > emiNo) {
                break;
            }
            amountPaid += borrower.getLumpSums().get(lumpSumEmi);
        }
        amountPaid += borrower.getEmi() * emiNo;
        amountPaid = Math.min(amountPaid, borrower.getAmount());
        int emisLeft = amountPaid < borrower.getAmount() ? 
                (int)Math.ceil((borrower.getAmount() - amountPaid) / borrower.getEmi()) 
                : 0;
        String output = borrower.getBankName() + " " + borrower.getName() + " " + (int)Math.ceil(amountPaid) + " " + emisLeft;
        System.out.println(output);
    }
}
