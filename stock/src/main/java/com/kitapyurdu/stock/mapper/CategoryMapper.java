package com.kitapyurdu.stock.mapper;
import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.entity.Category;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CategoryMapper extends IEntityMapper<CategoryDto, Category> {
}
