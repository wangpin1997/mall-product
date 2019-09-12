package cn.wpin.mall.client.product;

import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.product.dto.BrandParam;
import cn.wpin.mall.product.entity.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("product")
public interface BrandClient {

    /**
     * 获取全部品牌列表
     */
    @RequestMapping(value = "brand/listAll", method = RequestMethod.GET)
    List<Brand> getList();

    /**
     * 添加品牌
     *
     * @param pmsBrand
     * @return
     */
    @RequestMapping(value = "brand/create", method = RequestMethod.POST)
    int create(@RequestBody BrandParam pmsBrand);

    /**
     * 更新品牌
     *
     * @param id
     * @param pmsBrandParam
     * @return
     */
    @RequestMapping(value = "brand/update/{id}", method = RequestMethod.POST)
    int update(@PathVariable("id") Long id,
               @RequestBody BrandParam pmsBrandParam);


    /**
     * 删除品牌
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "brand/delete/{id}", method = RequestMethod.GET)
    int delete(@PathVariable("id") Long id);

    /**
     * 根据品牌名称分页获取品牌列表
     *
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "brand/list", method = RequestMethod.GET)
    CommonPage<Brand> getList(@RequestParam(value = "keyword", required = false) String keyword,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize);


    /**
     * 根据编号查询品牌信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "brand/{id}", method = RequestMethod.GET)
    CommonResult<Brand> getItem(@PathVariable("id") Long id);

    /**
     * 批量删除品牌
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "brand/delete/batch", method = RequestMethod.POST)
    int deleteBatch(@RequestParam("ids") List<Long> ids);

    /**
     * 批量更新显示状态
     *
     * @param ids
     * @param showStatus
     * @return
     */
    @RequestMapping(value = "brand/update/showStatus", method = RequestMethod.POST)
    int updateShowStatus(@RequestParam("ids") List<Long> ids,
                         @RequestParam("showStatus") Integer showStatus);

    /**
     * 批量更新厂家制造商状态
     *
     * @param ids
     * @param factoryStatus
     * @return
     */
    @RequestMapping(value = "brand/update/factoryStatus", method = RequestMethod.POST)
    int updateFactoryStatus(@RequestParam("ids") List<Long> ids,
                            @RequestParam("factoryStatus") Integer factoryStatus);
}
