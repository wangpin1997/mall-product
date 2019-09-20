package cn.wpin.mall.product.service;

import cn.wpin.mall.content.entity.Subject;
import cn.wpin.mall.product.dao.HomeDao;
import cn.wpin.mall.product.dto.FlashPromotionProduct;
import cn.wpin.mall.product.entity.Brand;
import cn.wpin.mall.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页内容管理Service实现类
 *
 * @author wangpin
 */
@Service
public class HomeService {


    @Autowired
    private HomeDao homeDao;

    /**
     * 获取推荐品牌
     */
    public List<Brand> getRecommendBrandList(Integer offset, Integer limit) {
        return homeDao.getRecommendBrandList(offset, limit);
    }

    /**
     * 获取秒杀商品
     */
    public List<FlashPromotionProduct> getFlashProductList(Long flashPromotionId, Long sessionId) {
        return homeDao.getFlashProductList(flashPromotionId, sessionId);
    }


    /**
     * 获取新品推荐
     */
    public List<Product> getNewProductList(Integer offset, Integer limit) {
        return homeDao.getNewProductList(offset, limit);
    }

    /**
     * 获取人气推荐
     */
    public List<Product> getHotProductList(Integer offset, Integer limit) {
        return homeDao.getHotProductList(offset, limit);
    }

    /**
     * 获取推荐专题
     */
    public List<Subject> getRecommendSubjectList(Integer offset, Integer limit) {
        return homeDao.getRecommendSubjectList(offset, limit);
    }


}
