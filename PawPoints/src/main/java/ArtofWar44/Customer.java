

package com.ArtofWar44;

public class Customer {
    private String name;
    private int purchases;

    public Customer(String name) {
        this.name = name;
        this.purchases = 0;
    }

    public String getName() {
        return name;
    }

    public int getPurchases() {
        return purchases;
    }

    public void addPurchase() {
        purchases++;
    }

    public boolean isEligibleForReward() {
        return purchases >= 10;
    }
}
