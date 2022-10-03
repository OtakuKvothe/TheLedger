package com.swarnendu.model;

import com.swarnendu.worker.BalanceUtil;

import java.util.TreeMap;

public class Borrower {
    private final String name;
    private final String bankName;
    private final double principal;
    private final double rate;
    private final int term;
    private double amount;
    private int emi;

    private TreeMap<Integer, Double> lumpSums;

    public Borrower(String name, String bankName, double principal, double rate, int term) {
        this.name = name;
        this.bankName = bankName;
        this.principal = principal;
        this.rate = rate;
        this.term = term;
        this.amount = generateAmount();
        this.emi = generateEMI();
        this.lumpSums = new TreeMap<Integer, Double>();
    }

    private double generateAmount() {
        return Math.ceil(principal * term * (rate / 100)) + principal;
    }

    private int generateEMI() {
        return (int)Math.ceil(amount / (term * 12));
    }

    public void registerLumpSumPayment(int emiNo, double amount) {
        lumpSums.put(emiNo, lumpSums.getOrDefault(emiNo, 0.0) + amount);
    }

    public void printBalanceForEmiNo(int emiNo) {
        BalanceUtil.computeBalance(this, emiNo);
    }

    public String getName() {
        return name;
    }

    public String getBankName() {
        return bankName;
    }

    public double getAmount() {
        return amount;
    }

    public int getEmi() {
        return emi;
    }

    public TreeMap<Integer, Double> getLumpSums() {
        return lumpSums;
    }
}
