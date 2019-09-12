package cn.wpin.mall.product.controller;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.BrandParam;
import cn.wpin.mall.product.entity.Brand;
import cn.wpin.mall.product.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌功能Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "商品品牌管理")
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<Brand> getList() {
        return brandService.listAllBrand();
    }

    @ApiOperation(value = "添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public int create(@RequestBody BrandParam pmsBrand) {
        return brandService.createBrand(pmsBrand);
    }

    @ApiOperation(value = "更新品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public int update(@PathVariable("id") Long id,
                      @RequestBody BrandParam pmsBrandParam) {
        return brandService.updateBrand(id, pmsBrandParam);
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public int delete(@PathVariable("id") Long id) {
        return brandService.deleteBrand(id);
    }

    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonPage<Brand> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<Brand> brandList = brandService.listBrand(keyword, pageNum, pageSize);
        return CommonPage.restPage(brandList);
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Brand getItem(@PathVariable("id") Long id) {
        return brandService.getBrand(id);
    }

    @ApiOperation(value = "批量删除品牌")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    public int deleteBatch(@RequestParam("ids") List<Long> ids) {
        return brandService.deleteBrand(ids);

    }

    @ApiOperation(value = "批量更新显示状态")
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public int updateShowStatus(@RequestParam("ids") List<Long> ids,
                                @RequestParam("showStatus") Integer showStatus) {
        return brandService.updateShowStatus(ids, showStatus);
    }

    @ApiOperation(value = "批量更新厂家制造商状态")
    @RequestMapping(value = "/update/factoryStatus", method = RequestMethod.POST)
    public int updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                                   @RequestParam("factoryStatus") Integer factoryStatus) {
        return brandService.updateFactoryStatus(ids, factoryStatus);
    }
}
