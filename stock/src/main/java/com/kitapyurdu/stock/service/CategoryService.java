package com.kitapyurdu.stock.service;
import com.kitapyurdu.stock.dto.CategoryDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.exception.CategoryAddException;
import com.kitapyurdu.stock.exception.CategoryFindException;
import com.kitapyurdu.stock.mapper.CategoryMapper;
import com.kitapyurdu.stock.repository.CategoryRepository;
import com.kitapyurdu.stock.response.CategoryResponse;
import com.kitapyurdu.stock.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class

CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryResponse addCategory(CategoryDto categoryDto) throws CategoryAddException{
        Category category=categoryMapper.toEntity(categoryDto);
        category=categoryRepository.save(category);
        if (category==null){
            throw new CategoryAddException();
        }
        return generatedCategoryResult(categoryMapper.toResource(category));
    }
    private CategoryResponse generatedCategoryResult(CategoryDto toResource) {
        CategoryResponse categoryResponse=new CategoryResponse();
        categoryResponse.categoryDto=toResource;
        return categoryResponse;
    }


    //TODO FIND CATEGORY

    public CategoryDto findCategoryByDto (int categoryId) throws CategoryFindException{
        Category category=findCategory(categoryId);
        if (category==null){
            throw new CategoryFindException();
        }
        return Helper.INSTANCE.MAPPER.fromEntity(category);
    }
    public Category findCategory(int categoryId) throws CategoryFindException {
        Category category=categoryRepository.findCategoryByCategoryId(categoryId);
        return  category;
    }




    //TODO GETALL CATEGORY
    public List<CategoryDto> getAllCategory() {
        return categoryMapper.toResourse(getCategoryList());
    }
    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }
}
