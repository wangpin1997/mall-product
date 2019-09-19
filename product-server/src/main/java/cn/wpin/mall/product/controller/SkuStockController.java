package cn.wpin.mall.product.controller;

import cn.wpin.mall.product.entity.SkuStock;
import cn.wpin.mall.product.service.SkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * sku库存Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "sku商品库存管理")
@RequestMapping("/sku")
public class SkuStockController {

    @Autowired
    private SkuStockService skuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public List<SkuStock> getList(@PathVariable Long pid, @RequestParam(value = "keyword", required = false) String keyword) {
        return skuStockService.getList(pid, keyword);
    }

    @ApiOperation("批量更新库存信息")
    @RequestMapping(value = "/update/{pid}", method = RequestMethod.POST)
    public int update(@PathVariable Long pid, @RequestBody List<SkuStock> skuStockList) {
        return skuStockService.update(pid, skuStockList);
    }

    @PostMapping("updateSku")
    public int updateByPrimaryKeySelective(@RequestBody SkuStock skuStock) {
        return skuStockService.updateByPrimaryKeySelective(skuStock);
    }

    @GetMapping("selectByKey")
    public SkuStock selectByPrimaryKey(@RequestParam Long id) {
        return skuStockService.selectByPrimaryKey(id);
    }
}
