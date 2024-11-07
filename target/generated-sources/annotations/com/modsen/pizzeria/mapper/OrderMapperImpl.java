package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.domain.OrderItem;
import com.modsen.pizzeria.domain.OrderStatus;
import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.CreateOrderRequest;
import com.modsen.pizzeria.dto.request.OrderItemRequest;
import com.modsen.pizzeria.dto.request.ProductRequest;
import com.modsen.pizzeria.dto.request.UpdateOrderRequest;
import com.modsen.pizzeria.dto.response.OrderItemResponse;
import com.modsen.pizzeria.dto.response.OrderResponse;
import com.modsen.pizzeria.dto.response.ProductResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T15:46:06+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        Long id = null;
        OrderStatus status = null;
        List<OrderItemResponse> orderItems = null;

        id = order.getId();
        status = order.getStatus();
        orderItems = orderItemListToOrderItemResponseList( order.getOrderItems() );

        OrderResponse orderResponse = new OrderResponse( id, status, orderItems );

        return orderResponse;
    }

    @Override
    public Order toOrder(OrderResponse orderResponse) {
        if ( orderResponse == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.id( orderResponse.id() );
        order.status( orderResponse.status() );
        order.orderItems( orderItemResponseListToOrderItemList( orderResponse.orderItems() ) );

        return order.build();
    }

    @Override
    public Order toOrder(UpdateOrderRequest updateOrderRequest) {
        if ( updateOrderRequest == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.status( updateOrderRequest.status() );
        List<OrderItem> list = updateOrderRequest.orderItems();
        if ( list != null ) {
            order.orderItems( new ArrayList<OrderItem>( list ) );
        }

        return order.build();
    }

    @Override
    public Order toOrder(CreateOrderRequest createOrderRequest) {
        if ( createOrderRequest == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.orderItems( orderItemRequestListToOrderItemList( createOrderRequest.orderItems() ) );

        return order.build();
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

    protected OrderItemResponse orderItemToOrderItemResponse(OrderItem orderItem) {
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

    protected List<OrderItemResponse> orderItemListToOrderItemResponseList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemResponse> list1 = new ArrayList<OrderItemResponse>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemResponse( orderItem ) );
        }

        return list1;
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

    protected OrderItem orderItemResponseToOrderItem(OrderItemResponse orderItemResponse) {
        if ( orderItemResponse == null ) {
            return null;
        }

        OrderItem.OrderItemBuilder orderItem = OrderItem.builder();

        orderItem.id( orderItemResponse.id() );
        orderItem.product( productResponseToProduct( orderItemResponse.product() ) );
        orderItem.quantity( orderItemResponse.quantity() );

        return orderItem.build();
    }

    protected List<OrderItem> orderItemResponseListToOrderItemList(List<OrderItemResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemResponse orderItemResponse : list ) {
            list1.add( orderItemResponseToOrderItem( orderItemResponse ) );
        }

        return list1;
    }

    protected Category createCategoryRequestToCategory(CreateCategoryRequest createCategoryRequest) {
        if ( createCategoryRequest == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( createCategoryRequest.name() );

        return category.build();
    }

    protected Product productRequestToProduct(ProductRequest productRequest) {
        if ( productRequest == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( productRequest.id() );
        product.name( productRequest.name() );
        product.description( productRequest.description() );
        if ( productRequest.price() != null ) {
            product.price( BigDecimal.valueOf( productRequest.price() ) );
        }
        product.category( createCategoryRequestToCategory( productRequest.category() ) );

        return product.build();
    }

    protected OrderItem orderItemRequestToOrderItem(OrderItemRequest orderItemRequest) {
        if ( orderItemRequest == null ) {
            return null;
        }

        OrderItem.OrderItemBuilder orderItem = OrderItem.builder();

        orderItem.product( productRequestToProduct( orderItemRequest.product() ) );
        orderItem.quantity( orderItemRequest.quantity() );

        return orderItem.build();
    }

    protected List<OrderItem> orderItemRequestListToOrderItemList(List<OrderItemRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemRequest orderItemRequest : list ) {
            list1.add( orderItemRequestToOrderItem( orderItemRequest ) );
        }

        return list1;
    }
}
