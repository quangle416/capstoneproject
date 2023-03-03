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
@Table(name= "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String addressOne;
    @NonNull
    String city;
    @NonNull
    String state;
    @NonNull
    Integer zipCode;

    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "address_customers",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "customers_id"))
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.getAddresses().add(this);
        log.debug("customer added");
    }
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.getAddresses().remove(this);
        log.debug("customer removed");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(id, address1.id) && Objects.equals(addressOne, address1.addressOne) && city.equals(address1.city) && state.equals(address1.state) && zipCode.equals(address1.zipCode) && Objects.equals(customers, address1.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressOne, city, state, zipCode, customers);
    }
}