package cn.wpin.mall.product.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductCategoryParam;
import cn.wpin.mall.product.dto.ProductCategoryWithChildrenItem;
import cn.wpin.mall.product.entity.ProductCategory;
import cn.wpin.mall.product.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类模块Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "商品分类管理")
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @ApiOperation("添加产品分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody ProductCategoryParam productCategoryParam) {
        return productCategoryService.create(productCategoryParam);
    }

    @ApiOperation("修改商品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id,
                      @RequestBody ProductCategoryParam productCategoryParam) {
        return productCategoryService.update(id, productCategoryParam);
    }

    @ApiOperation("分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    public CommonPage<ProductCategory> getList(@PathVariable Long parentId,
                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ProductCategory> productCategoryList = productCategoryService.getList(parentId, pageSize, pageNum);
        return CommonPage.restPage(productCategoryList);
    }

    @ApiOperation("根据id获取商品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductCategory getItem(@PathVariable Long id) {
        return productCategoryService.getItem(id);
    }

    @ApiOperation("删除商品分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public int delete(@PathVariable Long id) {
        return productCategoryService.delete(id);
    }

    @ApiOperation("修改导航栏显示状态")
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    public int updateNavStatus(@RequestParam("ids") List<Long> ids,
                               @RequestParam("navStatus") Integer navStatus) {
        return productCategoryService.updateNavStatus(ids, navStatus);
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public int updateShowStatus(@RequestParam("ids") List<Long> ids,
                                @RequestParam("showStatus") Integer showStatus) {
        return productCategoryService.updateShowStatus(ids, showStatus);
    }

    @ApiOperation("查询所有一级分类及子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    public List<ProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryService.listWithChildren();
    }
}
