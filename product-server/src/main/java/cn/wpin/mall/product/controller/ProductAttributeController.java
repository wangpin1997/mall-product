package cn.wpin.mall.product.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductAttrInfo;
import cn.wpin.mall.product.dto.ProductAttributeParam;
import cn.wpin.mall.product.entity.ProductAttribute;
import cn.wpin.mall.product.service.ProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "商品属性管理")
@RequestMapping("productAttribute")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @ApiOperation("根据分类查询属性列表或参数列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type", value = "0表示属性，1表示参数", required = true, paramType = "query", dataType = "integer")})
    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    public CommonPage<ProductAttribute> getList(@PathVariable Long cid,
                                                @RequestParam(value = "type") Integer type,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ProductAttribute> productAttributeList = productAttributeService.getList(cid, type, pageSize, pageNum);
        return CommonPage.restPage(productAttributeList);
    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody ProductAttributeParam productAttributeParam) {
        return productAttributeService.create(productAttributeParam);
    }

    @ApiOperation("修改商品属性信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody ProductAttributeParam productAttributeParam) {
        return productAttributeService.update(id, productAttributeParam);
    }

    @ApiOperation("查询单个商品属性")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductAttribute getItem(@PathVariable Long id) {
        return productAttributeService.getItem(id);
    }

    @ApiOperation("批量删除商品属性")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public int delete(@RequestParam("ids") List<Long> ids) {
        return productAttributeService.delete(ids);
    }

    @ApiOperation("根据商品分类的id获取商品属性及属性分类")
    @RequestMapping(value = "/attrInfo/{productCategoryId}", method = RequestMethod.GET)
    public List<ProductAttrInfo> getAttrInfo(@PathVariable Long productCategoryId) {
        return productAttributeService.getProductAttrInfo(productCategoryId);
    }
}
