package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiEvaluateGoodsDTO;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.EvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.StoreEvaluateGoodsDetailDTO;
import com.wuliangit.shopos.exception.OptionException;

import java.util.List;

/**
 * Created by nilme on 2017/5/20.
 */
public interface EvaluateGoodsService {


    /**
     * 创建评价
     * @param evaluateGoodses
     * @return
     */
    int createEvaluateGoods(List<ApiEvaluateGoodsDTO> evaluateGoodses,Integer orderId) throws OptionException;

    /**
     * 获取商品评价
     *
     * @param page
     * @param pageSize
     *@param goodsId  @return
     */
    List<ApiEvaluateGoodsListDTO> getEvaluateGoodsList(Integer page, Integer pageSize, Integer goodsId);

    /**
     * @Description: 获取商品评价列表页面的数据
     * @Author: pangweichao
     * @Date: 17:21 2017/5/26
     * @Param: [searchKey, orderColumn, orderType, page, pageSize, storeId]
     * @return: java.util.List<com.wuliangit.shopos.dto.EvaluateGoodsListDTO>
     */
    List<EvaluateGoodsListDTO> getEvaluateGoodsListInfo(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, Integer storeId);

    /**
     * @Description: 获取某条评价详情
     * @Author: pangweichao
     * @Date: 22:21 2017/5/27
     * @Param: [evaluateGoodsId]
     * @return: com.wuliangit.shopos.dto.StoreEvaluateGoodsDetailDTO
     */
    StoreEvaluateGoodsDetailDTO getEvaluateGoodsDetail(Integer evaluateGoodsId);
}
