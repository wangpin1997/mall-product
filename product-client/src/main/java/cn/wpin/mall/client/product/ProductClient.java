package cn.wpin.mall.client.product;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductParam;
import cn.wpin.mall.product.dto.ProductQueryParam;
import cn.wpin.mall.product.dto.ProductResult;
import cn.wpin.mall.product.entity.Product;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("product")
public interface ProductClient {

   
    /**
     * 创建商品
     */
    @RequestMapping(value = "product/create", method = RequestMethod.POST)
    int create(@RequestBody ProductParam productParam);

   
    /**
     * 根据商品id获取商品编辑信息
     */
    @RequestMapping(value = "product/updateInfo/{id}", method = RequestMethod.GET)
    ProductResult getUpdateInfo(@PathVariable Long id);

   
    /**
     * 更新商品
     */
    @RequestMapping(value = "product/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable Long id, @RequestBody ProductParam productParam);

   
    /**
     * 查询商品
     */
    @RequestMapping(value = "product/list", method = RequestMethod.GET)
    CommonPage<Product> getList(@RequestBody ProductQueryParam productQueryParam,
                                @RequestParam(value = "pageSize") Integer pageSize,
                                @RequestParam(value = "pageNum") Integer pageNum);

   
    /**
     * 根据商品名称或货号模糊查询
     */
    @RequestMapping(value = "product/simpleList", method = RequestMethod.GET)
    List<Product> getList(String keyword);

   
    /**
     * 批量修改审核状态
     */
    @RequestMapping(value = "product/update/verifyStatus", method = RequestMethod.POST)
    int updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                           @RequestParam("verifyStatus") Integer verifyStatus,
                           @RequestParam("detail") String detail);

   
    /**
     * 批量上下架
     */
    @RequestMapping(value = "product/update/publishStatus", method = RequestMethod.POST)
    int updatePublishStatus(@RequestParam("ids") List<Long> ids,
                            @RequestParam("publishStatus") Integer publishStatus);

   
    /**
     * 批量推荐商品
     */
    @RequestMapping(value = "product/update/recommendStatus", method = RequestMethod.POST)
    int updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                              @RequestParam("recommendStatus") Integer recommendStatus);

   
    /**
     * 批量设为新品
     */
    @RequestMapping(value = "product/update/newStatus", method = RequestMethod.POST)
    int updateNewStatus(@RequestParam("ids") List<Long> ids,
                        @RequestParam("newStatus") Integer newStatus);

   
    /**
     * 批量修改删除状态
     */
    @RequestMapping(value = "product/update/deleteStatus", method = RequestMethod.POST)
    int updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                           @RequestParam("deleteStatus") Integer deleteStatus);
}
