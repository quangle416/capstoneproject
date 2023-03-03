package org.perscholas.capstoneproject.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Table(name= "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    String firstName;
    @NonNull
    String lastName;
    @NonNull
    String password;
    @NonNull
    String email;

    @ManyToMany(mappedBy = "customers", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.getCustomers().add(this);
        log.debug("Address added");
    }
    public void removeAddress(Address address) {
        addresses.remove(address);
        address.getCustomers().remove(this);
        log.debug("Address removed");

    }@ToString.Exclude
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private List<ItemOrder> orders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && password.equals(customer.password) && email.equals(customer.email) && Objects.equals(addresses, customer.addresses) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, password, email, addresses, orders);
    }
}
