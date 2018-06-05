package com.odde.assertionsample;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class AssertionSample {

    private CustomerRepo customerRepo = new CustomerRepo();

    @Test
    public void compare_customer() {
        Customer actual = customerRepo.get();

        //how to assert customer?
    }

    @Test
    public void compare_customer_list()
    {
        List<Customer> actual = customerRepo.getAll();

        //how to assert customers?
    }

    @Test
    public void compare_composed_customer()
    {
        Customer actual = customerRepo.getComposedCustomer();

        //how to assert composed customer?
    }

    public void partialcompare_customer_birthday_and_order_price()
    {
        Customer actual = customerRepo.getComposedCustomer();

        Customer expected = new Customer(){{
           setBirthday(LocalDate.of(1999, 9,9));
           setOrder(new Order(){{
               setPrice(91);
           }});
        }};

        //how to assert actual is equal to expected?
    }
}
