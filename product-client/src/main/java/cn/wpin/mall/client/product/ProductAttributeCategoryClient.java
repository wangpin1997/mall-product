package cn.wpin.mall.client.product;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductAttributeCategoryItem;
import cn.wpin.mall.product.entity.ProductAttributeCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("product")
public interface ProductAttributeCategoryClient {

    /**
     * 添加商品属性分类
     */
    @RequestMapping(value = "/productAttribute/category/create", method = RequestMethod.POST)
    int create(@RequestParam String name);

    /**
     * 修改商品属性分类
     */
    @RequestMapping(value = "/productAttribute/category/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestParam String name);

    /**
     * 删除单个商品属性分类
     */
    @RequestMapping(value = "/productAttribute/category/delete/{id}", method = RequestMethod.GET)
    int delete(@PathVariable Long id);

    /**
     * 获取单个商品属性分类信息
     */
    @RequestMapping(value = "/productAttribute/category/{id}", method = RequestMethod.GET)
    ProductAttributeCategory getItem(@PathVariable Long id);

    /**
     * 分页获取所有商品属性分类
     */
    @RequestMapping(value = "/productAttribute/category/list", method = RequestMethod.GET)
    CommonPage<ProductAttributeCategory> getList(@RequestParam(defaultValue = "5") Integer pageSize,
                                                 @RequestParam(defaultValue = "1") Integer pageNum);

    /**
     * 获取所有商品属性分类及其下属性
     */
    @RequestMapping(value = "/productAttribute/category/list/withAttr", method = RequestMethod.GET)
    List<ProductAttributeCategoryItem> getListWithAttr();
}
