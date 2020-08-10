package cn.wpin.mall.product.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 商品离线统计任务，配合xxl-job
 *
 * @author wpin
 */
@Component
public class ProductHandler extends IJobHandler {


    /**
     * 创建一个简单的job
     *
     * @param s
     * @return
     * @throws Exception
     */
    @XxlJob("productJobHandler")
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at:" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        return ReturnT.SUCCESS;
    }
}
