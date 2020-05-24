package cn.wpin.mall.product.service;

import cn.wpin.mall.product.dao.PortalProductDao;
import cn.wpin.mall.product.entity.CartProduct;
import cn.wpin.mall.product.entity.PromotionProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangpin
 */
@Service
public class PortalProductService {

    @Autowired
    private PortalProductDao portalProductDao;

    public CartProduct getCartProduct(Long id) {
        return portalProductDao.getCartProduct(id);
    }

    public List<PromotionProduct> getPromotionProductList(List<Long> ids) {
        return portalProductDao.getPromotionProductList(ids);
    }

}
