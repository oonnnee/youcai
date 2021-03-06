package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Category;
import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.dataobject.PricelistKey;
import com.agriculture.youcai.dataobject.Product;
import com.agriculture.youcai.dto.excel.pricelist.CategoryExport;
import com.agriculture.youcai.dto.excel.pricelist.Export;
import com.agriculture.youcai.dto.excel.pricelist.ProductExport;
import com.agriculture.youcai.repository.PricelistRepository;
import com.agriculture.youcai.service.CategoryService;
import com.agriculture.youcai.service.PricelistService;
import com.agriculture.youcai.service.ProductService;
import com.agriculture.youcai.utils.comparator.DateComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<Pricelist> findById_GuestId(String guestId) {
        List<Pricelist> pricelists = pricelistRepository.findById_GuestId(guestId);
        return pricelists;
    }

    @Override
    public void save(List<Pricelist> pricelists) {
        for (Pricelist pricelist : pricelists){
            pricelistRepository.save(pricelist);
        }
    }

    @Override
    public void delete(String guestId, Date pdate) {
        pricelistRepository.deleteById_GuestIdAndId_Pdate(guestId, pdate);
    }

    @Override
    public List<Pricelist> findById_GuestIdAndId_pdate(String guestId, Date pdate) {
        return pricelistRepository.findById_GuestIdAndId_Pdate(guestId, pdate);
    }

    @Override
    public List<Date> findPdatesByGuestId(String guestId) {
        List<Date> dates = pricelistRepository.findDistinctId_PdateById_GuestId(guestId);
        return dates;
    }

    @Override
    public Map<String, Pricelist> findProductIdMap(String guestId, Date pdate) {
        List<Pricelist> pricelists = this.findById_GuestIdAndId_pdate(guestId, pdate);
        Map<String, Pricelist> map = new HashMap<>();
        for (Pricelist pricelist : pricelists){
            map.put(pricelist.getId().getProductId(), pricelist);
        }
        return map;
    }

    @Override
    public Export getExcelExport(String guestId, Date pdate) {
        List<Category> categories = categoryService.findAll();
        List<Pricelist> pricelists = pricelistRepository.findById_GuestIdAndId_Pdate(guestId, pdate);
        Map<String, Product> productMap = productService.findMap();

        Export export = new Export();
        export.setExpire(10);
        export.setPdate(pdate);

        List<CategoryExport> categoryExports = new ArrayList<>();
        for (Category category : categories){
            CategoryExport categoryExport = new CategoryExport();
            categoryExport.setCategoryName(category.getName());
            List<ProductExport> productExports = new ArrayList<>();
            for (Pricelist pricelist : pricelists){
                Product product = productMap.get(pricelist.getId().getProductId());
                if (product.getPCode().equals(category.getCode())){
                    ProductExport productExport = new ProductExport();
                    productExport.setName(product.getName());
                    productExport.setPrice(pricelist.getPrice());
                    productExports.add(productExport);
                }
            }
            categoryExport.setProductExports(productExports);
            categoryExports.add(categoryExport);
        }

        export.setCategoryExports(categoryExports);

        return export;
    }
}
