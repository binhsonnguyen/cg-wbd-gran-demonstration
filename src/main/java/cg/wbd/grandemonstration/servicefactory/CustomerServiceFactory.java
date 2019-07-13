package cg.wbd.grandemonstration.servicefactory;

import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static CustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}
