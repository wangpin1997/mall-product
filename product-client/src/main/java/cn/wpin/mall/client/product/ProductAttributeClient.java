package cn.wpin.mall.client.product;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductAttrInfo;
import cn.wpin.mall.product.dto.ProductAttributeParam;
import cn.wpin.mall.product.entity.ProductAttribute;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("product")
public interface ProductAttributeClient {

    /**
     * 根据分类查询属性列表或参数列表
     */
    @RequestMapping(value = "productAttribute/list/{cid}", method = RequestMethod.GET)
    CommonPage<ProductAttribute> getList(@PathVariable Long cid,
                                         @RequestParam(value = "type") Integer type,
                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum);

    /**
     * 添加商品属性信息
     *
     * @param productAttributeParam
     * @return
     */
    @RequestMapping(value = "productAttribute/create", method = RequestMethod.POST)
    int create(@RequestBody ProductAttributeParam productAttributeParam);

    /**
     * 修改商品属性信息
     */
    @RequestMapping(value = "productAttribute/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody ProductAttributeParam productAttributeParam);

    /**
     * 查询单个商品属性
     */
    @RequestMapping(value = "productAttribute/{id}", method = RequestMethod.GET)
    ProductAttribute getItem(@PathVariable Long id);

    /**
     * 批量删除商品属性
     */
    @RequestMapping(value = "productAttribute/delete", method = RequestMethod.POST)
    int delete(@RequestParam("ids") List<Long> ids);

    /**
     * 根据商品分类的id获取商品属性及属性分类
     */
    @RequestMapping(value = "productAttribute/attrInfo/{productCategoryId}", method = RequestMethod.GET)
    List<ProductAttrInfo> getAttrInfo(@PathVariable Long productCategoryId);

}
