package com.coursenet;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class TestOrderLogicImpl {
    public void getFinalProductQtyAfterAdd_add2Qty_expectReturnFinalQtyAdded2() {
        OrderLogicImpl orderLogic = new OrderLogicImpl();
        int finalQty = orderLogic.getFinalProductQtyAfterAdd("1", 2);
        Assert.assertEquals(finalQty, 12);
    }

    public void getFinalProductQtyAfterAdd_add110Qty_expectReturnFinalQty100() {
        OrderLogicImpl orderLogic = new OrderLogicImpl();
        int finalQty = orderLogic.getFinalProductQtyAfterAdd("1", 110);
        Assert.assertEquals(finalQty, 100);
    }

    public void isProductQtyEnough_reduce11QtyOnProductId1_expectFalse() {
        OrderLogicImpl orderLogic = new OrderLogicImpl();
        boolean isEnough = orderLogic.isProductQtyEnough("1", 11);
        Assert.assertFalse(isEnough); // Assert.assertEquals(isEnough, false);
    }

    public void isProductQtyEnough_reduce1QtyOnProductId1_expectTrue() {
        OrderLogicImpl orderLogic = new OrderLogicImpl();
        boolean isEnough = orderLogic.isProductQtyEnough("1", 1);
        Assert.assertTrue(isEnough); // Assert.assertEquals(isEnough, true);
    }

    // assert Throws
    public void errorMethod_errorTrue_expectThrowIOException() throws IOException {
        OrderLogicImpl orderLogic = new OrderLogicImpl();
        Assert.assertThrows(new Assert.ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                orderLogic.errorMethod(true);
            }
        });
    }

    public void errorMethod_errorFalse_expectDoNothing() throws IOException {
        OrderLogicImpl orderLogic = new OrderLogicImpl();
        orderLogic.errorMethod(false);
    }

}
