package com.odde.assertionsample;

import org.assertj.core.internal.IgnoringFieldsComparator;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionSample {

    private CustomerRepo customerRepo = new CustomerRepo();

    @Test
    public void compare_customer() {
        Customer actual = customerRepo.get();

        //how to assert customer?
        assertThat(actual).isEqualToComparingFieldByField(new Customer() {{
            setId(2);
            setAge(18);
            setBirthday(LocalDate.of(1990, 1, 26));
        }});
    }

    @Test
    public void compare_customer_list() {
        List<Customer> actual = customerRepo.getAll();

        //how to assert customers?
        assertThat(actual).usingFieldByFieldElementComparator().containsExactly(
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

    @Test
    public void compare_composed_customer() {
        Customer actual = customerRepo.getComposedCustomer();

        //how to assert composed customer?
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(
                new Customer() {{
                    setAge(30);
                    setId(11);
                    setBirthday(LocalDate.of(1999, 9, 9));
                    setOrder(new Order() {{
                        setId(19);
                        setPrice(91);
                    }});
                }}
        );
    }

    @Test
    public void partialcompare_customer_birthday_and_order_price() {
        Customer actual = customerRepo.getComposedCustomer();

        Customer expected = new Customer() {{
            setBirthday(LocalDate.of(1999, 9, 9));
            setOrder(new Order() {{
                setPrice(91);
            }});
        }};

        //how to assert actual is equal to expected?
        assertThat(actual)
                .usingComparatorForFields((x, y) -> 0, "id", "age")
                .usingComparatorForType(new IgnoringFieldsComparator("id"), Order.class)
                .isEqualToComparingFieldByFieldRecursively(expected);
    }
}
