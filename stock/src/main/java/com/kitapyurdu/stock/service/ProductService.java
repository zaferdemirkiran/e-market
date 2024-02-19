package com.kitapyurdu.stock.service;

import com.kitapyurdu.stock.dto.ProductDto;
import com.kitapyurdu.stock.entity.Category;
import com.kitapyurdu.stock.entity.Product;
import com.kitapyurdu.stock.exception.ProductAddException;
import com.kitapyurdu.stock.exception.ProductFindException;
import com.kitapyurdu.stock.mapper.ProductMapper;
import com.kitapyurdu.stock.repository.ProductRepository;
import com.kitapyurdu.stock.response.ProductResponse;
import com.kitapyurdu.stock.util.Helper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;



    public Product deleteProduct(int productId){
        Product product=productRepository.findProductByProductId(productId);
        return product;
    }

    public Product productFind(int productId) {
        Product product = productRepository.findProductByProductId(productId);
        return product;
    }
    public List<Product> getProductByCategoryId(int categoryId){
        return productRepository.findAllByCategoryCategoryId(categoryId);
    }

    public ProductDto findProductByDto(int productId)throws ProductFindException {
        Product product=productFind(productId);
        if (product==null){
            throw new ProductFindException();
        }
        return Helper.INSTANCE.MAPPER.productFromEntity(product);
    }

    @SneakyThrows
    public ProductResponse addProduct(ProductDto dto) throws ProductAddException{

        Product product=productMapper.toEntity(dto);
        Category category=categoryService.findCategory(dto.catergoryId);
        product.setCategory(category);
        product=productRepository.save(product);
        if (product==null){
            throw new ProductAddException();
        }

        return generatedProductResult(productMapper.toResource(product));
    }

    public ProductDto findProduct (int productId){
        Product  product= productRepository.findProductByProductId(productId);
        ProductDto productDto = productMapper.toResource(product);
        return  productDto;
    }
    private ProductResponse generatedProductResult(ProductDto toResource) {

        ProductResponse productResponse=new ProductResponse();
        productResponse.productDto=toResource;
        return productResponse;
    }
}
