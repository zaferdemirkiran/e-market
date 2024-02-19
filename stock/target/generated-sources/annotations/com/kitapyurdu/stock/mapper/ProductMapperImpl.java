package com.kitapyurdu.stock.mapper;

import com.kitapyurdu.stock.dto.ProductDto;
import com.kitapyurdu.stock.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-12T11:19:29+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toResource(Product e) {
        if ( e == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        return productDto;
    }

    @Override
    public Product toEntity(ProductDto r) {
        if ( r == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }

    @Override
    public List<ProductDto> toResourse(List<Product> eList) {
        if ( eList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( eList.size() );
        for ( Product product : eList ) {
            list.add( toResource( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toEntity(List<ProductDto> rList) {
        if ( rList == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( rList.size() );
        for ( ProductDto productDto : rList ) {
            list.add( toEntity( productDto ) );
        }

        return list;
    }
}
