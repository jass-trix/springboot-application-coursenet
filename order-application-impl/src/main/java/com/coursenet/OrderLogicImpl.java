package com.coursenet;

import java.io.IOException;

public class OrderLogicImpl {


    public int getFinalProductQtyAfterAdd(String productId, int qtyAdd) {
        int currentQty = getProductQty(productId);
        int finalQty = currentQty + qtyAdd;
        // jika final qty > 100, maka maksimal nya itu menjadi 100
        if (finalQty > 100) {
            finalQty = 100;
        }
        return finalQty;
    }

    public boolean isProductQtyEnough(String productId, int qtyReduce) {
        int currentQty = getProductQty(productId);
        int finalQty = currentQty - qtyReduce;
        if (finalQty < 0) {
            return false;
        }
        return true;
    }

    public void errorMethod(boolean error) throws IOException {
        if (error) {
            throw new IOException("Error");
        }

        System.out.println("TIDAK ERROR");
    }

    public int getFinalProductQtyAfterReduce(String productId, int qtyReduce) {
        int currentQty = getProductQty(productId);
        int finalQty = currentQty - qtyReduce;
        if (finalQty < 0) {
            finalQty = 0;
        }
        return finalQty;
    }

    private int getProductQty(String productId) {
        switch (productId) {
            case "1":
                return 10;
            case "2":
                return 20;
            case "3":
                return 30;
            case "4":
                return 40;
            default:
                return 0;
        }
    }
}
