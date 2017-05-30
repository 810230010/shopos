package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiEvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.EvaluateGoodsListDTO;
import com.wuliangit.shopos.dto.StoreEvaluateGoodsDetailDTO;
import com.wuliangit.shopos.entity.EvaluateGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateGoodsMapper extends BaseMapper<EvaluateGoods, Integer> {


    /**
     * 获取商品评价
     * @param goodsId
     * @return
     */
    List<EvaluateGoods> getEvaluateGoodsList(Integer goodsId);

    /**
     * @Description: 获取商品评价列表页面的数据
     * @Author: pangweichao
     * @Date: 17:21 2017/5/26
     * @Param: [searchKey, orderColumn, orderType, storeId]
     * @return: java.util.List<com.wuliangit.shopos.dto.EvaluateGoodsListDTO>
     */
    List<EvaluateGoodsListDTO> getEvaluateGoodsListInfo(@Param("searchKey") String searchKey,@Param("orderColumn") String orderColumn,@Param("orderType") String orderType,@Param("storeId") Integer storeId);

    /**
     * @Description: 获取某条评价详情
     * @Author: pangweichao
     * @Date: 22:21 2017/5/27
     * @Param: [evaluateGoodsId]
     * @return: com.wuliangit.shopos.dto.StoreEvaluateGoodsDetailDTO
     */
    StoreEvaluateGoodsDetailDTO getEvaluateGoodsDetail(Integer evaluateGoodsId);
}