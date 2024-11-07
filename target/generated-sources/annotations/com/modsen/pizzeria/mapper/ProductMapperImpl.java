package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.domain.Product;
import com.modsen.pizzeria.dto.request.CreateProductRequest;
import com.modsen.pizzeria.dto.request.UpdateProductRequest;
import com.modsen.pizzeria.dto.response.ProductResponse;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T15:46:06+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toProductResponse(Product product) {
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

    @Override
    public Product toProduct(ProductResponse productResponse) {
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

    @Override
    public Product toProduct(CreateProductRequest createProductRequest) {
        if ( createProductRequest == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( createProductRequest.name() );
        product.description( createProductRequest.description() );
        if ( createProductRequest.price() != null ) {
            product.price( BigDecimal.valueOf( createProductRequest.price() ) );
        }
        product.category( createProductRequest.category() );

        return product.build();
    }

    @Override
    public Product toProduct(UpdateProductRequest updateProductRequest) {
        if ( updateProductRequest == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( updateProductRequest.name() );
        product.description( updateProductRequest.description() );
        if ( updateProductRequest.price() != null ) {
            product.price( BigDecimal.valueOf( updateProductRequest.price() ) );
        }
        product.category( updateProductRequest.category() );

        return product.build();
    }

    @Override
    public void updateProductFromRequest(UpdateProductRequest updateProductRequest, Product product) {
        if ( updateProductRequest == null ) {
            return;
        }

        product.setName( updateProductRequest.name() );
        product.setDescription( updateProductRequest.description() );
        if ( updateProductRequest.price() != null ) {
            product.setPrice( BigDecimal.valueOf( updateProductRequest.price() ) );
        }
        else {
            product.setPrice( null );
        }
        product.setCategory( updateProductRequest.category() );
    }
}
