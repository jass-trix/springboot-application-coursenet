package com.coursenet;

import com.coursenet.model.Order;
import com.coursenet.model.OrderDTO;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

@Test
public class TestOrderServiceImpl {
    @Mock
    private OrderRepositoryJPA orderRepositoryJPA;

    @BeforeMethod(alwaysRun = true)
    void beforeMethod() {
        MockitoAnnotations.openMocks(this);
        Mockito.reset(orderRepositoryJPA);
    }

    public void getOrder_orderIdNotFound_expectReturnNull() {
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepositoryJPA);
        OrderDTO result = orderService.getOrder(1L);
        Assert.assertNull(result);
    }

    public void getOrder_orderIdFound_expectReturnResult() {
        Mockito.when(orderRepositoryJPA.findById(Mockito.anyLong())).thenReturn(
                Optional.of(new Order(1L, "mock-1", "description mock"))
        );

        OrderServiceImpl orderService = new OrderServiceImpl(orderRepositoryJPA);
        OrderDTO result = orderService.getOrder(1L);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getName(), "mock-1 1");
        Assert.assertEquals(result.getDescription(), "description mock");
    }

    public void getOrderList_getAllOrders_expectReturnAllInList() {
        Mockito.when(orderRepositoryJPA.findAll()).thenReturn(
                List.of(
                        new Order(1L, "mock-1", "description mock"),
                        new Order(2L, "mock-2", "description mock")
                )
        );

        OrderServiceImpl orderService = new OrderServiceImpl(orderRepositoryJPA);
        List<OrderDTO> result = orderService.getOrderList();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 2);
        Assert.assertEquals(result.get(0).getName(), "mock-1 1");
        Assert.assertEquals(result.get(0).getDescription(), "description mock");
        Assert.assertEquals(result.get(1).getName(), "mock-2 2");
        Assert.assertEquals(result.get(1).getDescription(), "description mock");
    }

    public void createNewOrder_createNormalOrder_expectOrderRepositorySaveCalledOnce() {
        OrderServiceImpl orderService = new OrderServiceImpl(orderRepositoryJPA);
        orderService.createNewOrder("mock-1", "mock-user");
        Mockito.verify(orderRepositoryJPA, Mockito.times(1)).save(
                Mockito.any(Order.class)
        );
    }

}
