package cn.wpin.mall.product.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductAttributeCategoryItem;
import cn.wpin.mall.product.entity.ProductAttributeCategory;
import cn.wpin.mall.product.service.ProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性分类Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "商品属性分类管理")
@RequestMapping("/productAttribute/category")
public class ProductAttributeCategoryController {
    @Autowired
    private ProductAttributeCategoryService productAttributeCategoryService;

    @ApiOperation("添加商品属性分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestParam String name) {
        return productAttributeCategoryService.create(name);
    }

    @ApiOperation("修改商品属性分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestParam String name) {
        return productAttributeCategoryService.update(id, name);
    }

    @ApiOperation("删除单个商品属性分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public int delete(@PathVariable Long id) {
        return productAttributeCategoryService.delete(id);
    }

    @ApiOperation("获取单个商品属性分类信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductAttributeCategory getItem(@PathVariable Long id) {
        return productAttributeCategoryService.getItem(id);
    }

    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<ProductAttributeCategory> getList(@RequestParam(defaultValue = "5") Integer pageSize,
                                                        @RequestParam(defaultValue = "1") Integer pageNum) {
        List<ProductAttributeCategory> productAttributeCategoryList = productAttributeCategoryService.getList(pageSize, pageNum);
        return CommonPage.restPage(productAttributeCategoryList);
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    public List<ProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryService.getListWithAttr();
    }
}
