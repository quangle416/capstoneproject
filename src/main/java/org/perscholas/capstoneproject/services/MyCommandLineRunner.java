package org.perscholas.capstoneproject.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.perscholas.capstoneproject.dao.AddressRepoI;
import org.perscholas.capstoneproject.dao.CustomerRepoI;
import org.perscholas.capstoneproject.dao.ItemOrderRepoI;
import org.perscholas.capstoneproject.dao.ProductRepoI;
import org.perscholas.capstoneproject.models.Address;
import org.perscholas.capstoneproject.models.Customer;
import org.perscholas.capstoneproject.models.ItemOrder;
import org.perscholas.capstoneproject.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@FieldDefaults(level= AccessLevel.PRIVATE)
public class MyCommandLineRunner implements CommandLineRunner {

    CustomerRepoI customerRepoI;
    ItemOrderRepoI orderRepoI;
    ProductRepoI productRepoI;
    AddressRepoI addressRepoI;

    //Autowired Constructor to instantiate all objects above.
    @Autowired
    public MyCommandLineRunner(CustomerRepoI customerRepoI, ItemOrderRepoI orderRepoI, ProductRepoI productRepoI, AddressRepoI addressRepoI) {
        this.customerRepoI = customerRepoI;
        this.orderRepoI = orderRepoI;
        this.productRepoI = productRepoI;
        this.addressRepoI = addressRepoI;
    }

    @Override
    public void run(String... args) throws Exception {

        //creating dummy data to test Customer connection to db
        Customer customer1 = new Customer("Quang", "Le", "password1", "QLe@gmail.com");
        Customer customer2 = new Customer("Chanh", "Le", "password2", "CLe@gmail.com");
        Customer customer3 = new Customer("Steven", "Le", "password3", "SLe@gmail.com");

        customerRepoI.saveAndFlush(customer1);
        customerRepoI.saveAndFlush(customer2);
        customerRepoI.saveAndFlush(customer3);

        //creating dummy data to test Order connection to db
        ItemOrder order1 = new ItemOrder(new Date(2023/01/01), 99.99F);
        ItemOrder order2 = new ItemOrder(new Date(2023/01/02), 199.99F);
        ItemOrder order3 = new ItemOrder(new Date(2023/01/03), 299.99F);

        orderRepoI.saveAndFlush(order1);
        orderRepoI.saveAndFlush(order2);
        orderRepoI.saveAndFlush(order3);

        //creating dummy data to test Product connection to db
        // TO DO CHANGE IMAGE TO PROPER TYPE
        Product product1 = new Product("Suit", "hand made suits", 299.99F, 100, "image");
        Product product2 = new Product("Shirt", "button up shirt", 49.99F, 200, "image");
        Product product3 = new Product("Shoe", "real polished leather", 79.99F, 300, "image");

        productRepoI.saveAndFlush(product1);
        productRepoI.saveAndFlush(product2);
        productRepoI.saveAndFlush(product3);

//        //crating dummy data to test Address connection to db
//        Address address1 = new Address("123 abc street", "Chicago", "IL", 60438);
//        Address address2 = new Address("456 def avenue", "Detroit", "MI", 40383);
//        Address address3 = new Address("789 hig road", "San Diego", "CA", 96024);
//
//        addressRepoI.saveAndFlush(address1);
//        addressRepoI.saveAndFlush(address2);
//        addressRepoI.saveAndFlush(address3);

    }
}
