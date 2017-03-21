package com.iluwatar.business.delegate;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by starhq on 2017/3/21.
 */
public class BusinessDelegateTest {

    private EjbService ejbService;

    private JmsService jmsService;

    private BusinessLookup businessLookup;

    private BusinessDelegate businessDelegate;

    /**
     * This method sets up the instance variables of this test class. It is executed before the
     * execution of every test.
     */
    @Before
    public void setup() {
        ejbService = spy(new EjbService());
        jmsService = spy(new JmsService());

        businessLookup = spy(new BusinessLookup());
        businessLookup.setEjbService(ejbService);
        businessLookup.setJmsService(jmsService);

        businessDelegate = spy(new BusinessDelegate());
        businessDelegate.setLookupService(businessLookup);
    }

    /**
     * In this example the client ({@link Client}) utilizes a business delegate (
     * {@link BusinessDelegate}) to execute a task. The Business Delegate then selects the appropriate
     * service and makes the service call.
     */
    @Test
    public void testBusinessDelegate() {

        // setup a client object
        Client client = new Client(businessDelegate);

        // set the service type
        businessDelegate.setServiceType(ServiceType.EJB);

        // action
        client.doTask();

        // verifying that the businessDelegate was used by client during doTask() method.
        verify(businessDelegate).doTask();
        verify(ejbService).doProcessing();

        // set the service type
        businessDelegate.setServiceType(ServiceType.JMS);

        // action
        client.doTask();

        // verifying that the businessDelegate was used by client during doTask() method.
        verify(businessDelegate, times(2)).doTask();
        verify(jmsService).doProcessing();
    }
}
