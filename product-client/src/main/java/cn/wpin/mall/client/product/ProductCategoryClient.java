package cn.wpin.mall.client.product;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductCategoryParam;
import cn.wpin.mall.product.dto.ProductCategoryWithChildrenItem;
import cn.wpin.mall.product.entity.ProductCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("product")
public interface ProductCategoryClient {


    /**
     * 添加产品分类
     */
    @RequestMapping(value = "productCategory/create", method = RequestMethod.POST)
    int create(@RequestBody ProductCategoryParam productCategoryParam);


    /**
     * 修改商品分类
     */
    @RequestMapping(value = "productCategory/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id,
               @RequestBody ProductCategoryParam productCategoryParam);


    /**
     * 分页查询商品分类
     */
    @RequestMapping(value = "productCategory/list/{parentId}", method = RequestMethod.GET)
    CommonPage<ProductCategory> getList(@PathVariable Long parentId,
                                        @RequestParam Integer pageSize,
                                        @RequestParam Integer pageNum);


    /**
     * 根据id获取商品分类
     */
    @RequestMapping(value = "productCategory/{id}", method = RequestMethod.GET)
    ProductCategory getItem(@PathVariable Long id);


    /**
     * 删除商品分类
     */
    @RequestMapping(value = "productCategory/delete/{id}", method = RequestMethod.POST)
    int delete(@PathVariable Long id);


    /**
     * 修改导航栏显示状态
     */
    @RequestMapping(value = "productCategory/update/navStatus", method = RequestMethod.POST)
    int updateNavStatus(@RequestParam("ids") List<Long> ids,
                        @RequestParam("navStatus") Integer navStatus);


    /**
     * 修改显示状态
     */
    @RequestMapping(value = "productCategory/update/showStatus", method = RequestMethod.POST)
    int updateShowStatus(@RequestParam("ids") List<Long> ids,
                         @RequestParam("showStatus") Integer showStatus);

    /**
     * 查询所有一级分类及子分类
     */
    @RequestMapping(value = "productCategory/list/withChildren", method = RequestMethod.GET)
    List<ProductCategoryWithChildrenItem> listWithChildren();
}
