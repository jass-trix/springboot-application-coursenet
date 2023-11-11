package com.coursenet;

import com.coursenet.model.OrderDTO;

public class OrderCustomResponse {
    private OrderDTO order;
    private String message;
    private int status;
    private boolean success;

    public OrderCustomResponse(OrderDTO order, String message, int status, boolean success) {
        this.order = order;
        this.message = message;
        this.status = status;
        this.success = success;
    }

    public OrderCustomResponse() {
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
