package org.perscholas.capstoneproject.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@Table(name= "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NonNull
    String productName;
    @NonNull
    String description;
    @NonNull
    float price;
    @NonNull
    Integer quantity;
    @NonNull
    String image;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "order_id")
    private ItemOrder order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && Objects.equals(id, product.id) && productName.equals(product.productName) && description.equals(product.description) && quantity.equals(product.quantity) && image.equals(product.image) && Objects.equals(order, product.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, description, price, quantity, image, order);
    }
}
