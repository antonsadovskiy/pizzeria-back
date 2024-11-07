package com.modsen.pizzeria.mapper;

import com.modsen.pizzeria.domain.Category;
import com.modsen.pizzeria.dto.request.CreateCategoryRequest;
import com.modsen.pizzeria.dto.request.UpdateCategoryRequest;
import com.modsen.pizzeria.dto.response.CategoryResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-07T15:46:06+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryResponse toCategoryResponse(Category category) {
        if ( category == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = category.getId();
        name = category.getName();

        CategoryResponse categoryResponse = new CategoryResponse( id, name );

        return categoryResponse;
    }

    @Override
    public Category toCategory(CategoryResponse categoryResponse) {
        if ( categoryResponse == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.id( categoryResponse.id() );
        category.name( categoryResponse.name() );

        return category.build();
    }

    @Override
    public Category toCategory(CreateCategoryRequest createCategoryRequest) {
        if ( createCategoryRequest == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( createCategoryRequest.name() );

        return category.build();
    }

    @Override
    public Category toCategory(UpdateCategoryRequest updateCategoryRequest) {
        if ( updateCategoryRequest == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( updateCategoryRequest.name() );

        return category.build();
    }

    @Override
    public void updateCategoryFromRequest(UpdateCategoryRequest updateCategoryRequest, Category category) {
        if ( updateCategoryRequest == null ) {
            return;
        }

        category.setName( updateCategoryRequest.name() );
    }
}
