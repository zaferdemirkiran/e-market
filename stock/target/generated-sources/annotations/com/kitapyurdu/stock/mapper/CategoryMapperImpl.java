package com.kitapyurdu.stock.mapper;

import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T11:19:28+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toResource(Category e) {
        if ( e == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        return categoryDto;
    }

    @Override
    public Category toEntity(CategoryDto r) {
        if ( r == null ) {
            return null;
        }

        Category category = new Category();

        return category;
    }

    @Override
    public List<CategoryDto> toResourse(List<Category> eList) {
        if ( eList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( eList.size() );
        for ( Category category : eList ) {
            list.add( toResource( category ) );
        }

        return list;
    }

    @Override
    public List<Category> toEntity(List<CategoryDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( rList.size() );
        for ( CategoryDto categoryDto : rList ) {
            list.add( toEntity( categoryDto ) );
        }

        return list;
    }
}
