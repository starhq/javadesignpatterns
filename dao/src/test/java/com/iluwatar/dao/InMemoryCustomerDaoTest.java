package com.iluwatar.dao;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

/**
 * Created by starhq on 2017/3/22.
 */
@RunWith(HierarchicalContextRunner.class)
public class InMemoryCustomerDaoTest {

    private InMemoryCustomerDao dao;
    private static final Customer CUSTOMER = new Customer(1, "Freddy", "Krueger");

    @Before
    public void setUp() throws Exception {
        dao = new InMemoryCustomerDao();
        assertTrue(dao.add(CUSTOMER));
    }

    /**
     * Represents the scenario when the DAO operations are being performed on a non existent
     * customer.
     */
    public class NonExistingCustomer {

        @Test
        public void addingShouldResultInSuccess() throws Exception {
            try (Stream<Customer> allCustomers = dao.getAll()) {
                assumeTrue(allCustomers.count() == 1);
            }

            final Customer nonExistingCustomer = new Customer(2, "Robert", "Englund");
            boolean result = dao.add(nonExistingCustomer);
            assertTrue(result);

            assertCustomerCountIs(2);
            assertEquals(nonExistingCustomer, dao.getById(nonExistingCustomer.getId()).get());
        }

        @Test
        public void deletionShouldBeFailureAndNotAffectExistingCustomers() throws Exception {
            final Customer nonExistingCustomer = new Customer(2, "Robert", "Englund");
            boolean result = dao.delete(nonExistingCustomer);

            assertFalse(result);
            assertCustomerCountIs(1);
        }

        @Test
        public void updationShouldBeFailureAndNotAffectExistingCustomers() throws Exception {
            final int nonExistingId = getNonExistingCustomerId();
            final String newFirstname = "Douglas";
            final String newLastname = "MacArthur";
            final Customer customer = new Customer(nonExistingId, newFirstname, newLastname);
            boolean result = dao.update(customer);

            assertFalse(result);
            assertFalse(dao.getById(nonExistingId).isPresent());
        }

        @Test
        public void retrieveShouldReturnNoCustomer() throws Exception {
            assertFalse(dao.getById(getNonExistingCustomerId()).isPresent());
        }
    }

    /**
     * Represents the scenario when the DAO operations are being performed on an already existing
     * customer.
     */
    public class ExistingCustomer {

        @Test
        public void addingShouldResultInFailureAndNotAffectExistingCustomers() throws Exception {
            boolean result = dao.add(CUSTOMER);

            assertFalse(result);
            assertCustomerCountIs(1);
            assertEquals(CUSTOMER, dao.getById(CUSTOMER.getId()).get());
        }

        @Test
        public void deletionShouldBeSuccessAndCustomerShouldBeNonAccessible() throws Exception {
            boolean result = dao.delete(CUSTOMER);

            assertTrue(result);
            assertCustomerCountIs(0);
            assertFalse(dao.getById(CUSTOMER.getId()).isPresent());
        }

        @Test
        public void updationShouldBeSuccessAndAccessingTheSameCustomerShouldReturnUpdatedInformation() throws
                Exception {
            final String newFirstname = "Bernard";
            final String newLastname = "Montgomery";
            final Customer customer = new Customer(CUSTOMER.getId(), newFirstname, newLastname);
            boolean result = dao.update(customer);

            assertTrue(result);

            final Customer cust = dao.getById(CUSTOMER.getId()).get();
            assertEquals(newFirstname, cust.getFirstName());
            assertEquals(newLastname, cust.getLastName());
        }

        @Test
        public void retriveShouldReturnTheCustomer() throws Exception {
            Optional<Customer> optionalCustomer = dao.getById(CUSTOMER.getId());

            assertTrue(optionalCustomer.isPresent());
            assertEquals(CUSTOMER, optionalCustomer.get());
        }
    }

    /**
     * An arbitrary number which does not correspond to an active Customer id.
     *
     * @return an int of a customer id which doesn't exist
     */
    private int getNonExistingCustomerId() {
        return 999;
    }

    private void assertCustomerCountIs(int count) throws Exception {
        try (Stream<Customer> allCustomers = dao.getAll()) {
            assertTrue(allCustomers.count() == count);
        }
    }
}
