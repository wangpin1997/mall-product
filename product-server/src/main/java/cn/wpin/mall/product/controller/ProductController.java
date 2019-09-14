package cn.wpin.mall.product.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductParam;
import cn.wpin.mall.product.dto.ProductQueryParam;
import cn.wpin.mall.product.dto.ProductResult;
import cn.wpin.mall.product.entity.Product;
import cn.wpin.mall.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "商品管理")
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("创建商品")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody ProductParam productParam) {
        return productService.create(productParam);
    }

    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    public ProductResult getUpdateInfo(@PathVariable Long id) {
        return productService.getUpdateInfo(id);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable Long id, @RequestBody ProductParam productParam) {
        return productService.update(id, productParam);
    }

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<Product> getList(@RequestBody ProductQueryParam productQueryParam,
                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Product> productList = productService.list(productQueryParam, pageSize, pageNum);
        return CommonPage.restPage(productList);
    }

    @ApiOperation("根据商品名称或货号模糊查询")
    @RequestMapping(value = "/simpleList", method = RequestMethod.GET)
    public List<Product> getList(String keyword) {
        return productService.list(keyword);
    }

    @ApiOperation("批量修改审核状态")
    @RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
    public int updateVerifyStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("verifyStatus") Integer verifyStatus,
                                  @RequestParam("detail") String detail) {
        return productService.updateVerifyStatus(ids, verifyStatus, detail);
    }

    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    public int updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("publishStatus") Integer publishStatus) {
        return productService.updatePublishStatus(ids, publishStatus);
    }

    @ApiOperation("批量推荐商品")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    public int updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                     @RequestParam("recommendStatus") Integer recommendStatus) {
        return productService.updateRecommendStatus(ids, recommendStatus);
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus", method = RequestMethod.POST)
    public int updateNewStatus(@RequestParam("ids") List<Long> ids,
                               @RequestParam("newStatus") Integer newStatus) {
        return productService.updateNewStatus(ids, newStatus);
    }

    @ApiOperation("批量修改删除状态")
    @RequestMapping(value = "/update/deleteStatus", method = RequestMethod.POST)
    public int updateDeleteStatus(@RequestParam("ids") List<Long> ids,
                                  @RequestParam("deleteStatus") Integer deleteStatus) {
        return productService.updateDeleteStatus(ids, deleteStatus);
    }
}
