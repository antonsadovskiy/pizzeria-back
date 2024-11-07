package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.response.OrderItemResponse;
import com.modsen.pizzeria.dto.response.ProductResponse;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T14:21:43+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemResponse toOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        Long id = null;
        ProductResponse product = null;
        Integer quantity = null;

        id = orderItem.getId();
        product = productToProductResponse( orderItem.getProduct() );
        quantity = orderItem.getQuantity();

        OrderItemResponse orderItemResponse = new OrderItemResponse( id, product, quantity );

        return orderItemResponse;
    }

    @Override
    public OrderItem toOrderItem(OrderItemResponse orderItemResponse) {
        if ( orderItemResponse == null ) {
            return null;
        }

        OrderItem.OrderItemBuilder orderItem = OrderItem.builder();

        orderItem.id( orderItemResponse.id() );
        orderItem.product( productResponseToProduct( orderItemResponse.product() ) );
        orderItem.quantity( orderItemResponse.quantity() );

        return orderItem.build();
    }

    protected ProductResponse productToProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Double price = null;
        String description = null;
        Category category = null;

        id = product.getId();
        name = product.getName();
        if ( product.getPrice() != null ) {
            price = product.getPrice().doubleValue();
        }
        description = product.getDescription();
        category = product.getCategory();

        ProductResponse productResponse = new ProductResponse( id, name, price, description, category );

        return productResponse;
    }

    protected Product productResponseToProduct(ProductResponse productResponse) {
        if ( productResponse == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productResponse.id() );
        product.name( productResponse.name() );
        product.description( productResponse.description() );
        if ( productResponse.price() != null ) {
            product.price( BigDecimal.valueOf( productResponse.price() ) );
        }
        product.category( productResponse.category() );

        return product.build();
    }
}
