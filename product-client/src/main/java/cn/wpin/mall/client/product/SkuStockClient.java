package cn.wpin.mall.client.product;

import cn.wpin.mall.product.entity.SkuStock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("product")
public interface SkuStockClient {

    /**
     * 根据商品编号及编号模糊搜索sku库存
     */
    @RequestMapping(value = "sku/{pid}", method = RequestMethod.GET)
    List<SkuStock> getList(@PathVariable Long pid,
                           @RequestParam(value = "keyword", required = false) String keyword);

    /**
     * 批量更新库存信息
     */
    @RequestMapping(value = "sku/update/{pid}", method = RequestMethod.POST)
    int update(@PathVariable Long pid, @RequestBody List<SkuStock> skuStockList);


    @PostMapping("updateSku")
    int updateByPrimaryKeySelective(@RequestBody SkuStock skuStock);

    @GetMapping("selectByKey")
    SkuStock selectByPrimaryKey(@RequestParam Long id);
}
