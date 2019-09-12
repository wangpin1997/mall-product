package cn.wpin.mall.product.service;

import cn.wpin.mall.product.dao.SkuStockDao;
import cn.wpin.mall.product.entity.SkuStock;
import cn.wpin.mall.product.example.SkuStockExample;
import cn.wpin.mall.product.mapper.SkuStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 商品sku库存管理Service实现类
 * @author wangpin
 */
@Service
public class SkuStockService {
    @Autowired
    private SkuStockMapper skuStockMapper;
    @Autowired
    private SkuStockDao skuStockDao;

    
    public List<SkuStock> getList(Long pid, String keyword) {
        SkuStockExample example = new SkuStockExample();
        SkuStockExample.Criteria criteria = example.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return skuStockMapper.selectByExample(example);
    }

    
    public int update(Long pid, List<SkuStock> skuStockList) {
        return skuStockDao.replaceList(skuStockList);
    }
}
