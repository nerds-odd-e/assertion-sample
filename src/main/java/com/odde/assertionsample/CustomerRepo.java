package com.odde.assertionsample;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CustomerRepo {

    public Customer get() {
        return new Customer() {{
            setId(2);
            setAge(18);
            setBirthday(LocalDate.of(1990, 1, 26));
        }};
    }

    public List<Customer> getAll() {
        return Arrays.asList(
                new Customer() {{
                    setId(3);
                    setAge(20);
                    setBirthday(LocalDate.of(1993, 1, 2));
                }},
                new Customer() {{
                    setId(4);
                    setAge(21);
                    setBirthday(LocalDate.of(1993, 1, 3));
                }});
    }

    public Customer getComposedCustomer() {
        return new Customer() {{
            setAge(30);
            setId(11);
            setBirthday(LocalDate.of(1999, 9, 9));
            setOrder(new Order(){{
                setId(19);
                setPrice(91);
            }});
        }};
    }
}
