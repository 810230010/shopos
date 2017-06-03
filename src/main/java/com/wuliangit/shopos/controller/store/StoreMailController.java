package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dto.StoreMailDTO;
import com.wuliangit.shopos.entity.Seller;
import com.wuliangit.shopos.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author boom
 * @description 消息相关接口
 * @create 2017-06-03 13:06
 **/
@Controller
@RequestMapping("/store/mail")
public class StoreMailController {

    @Autowired
    private MailService mailService;

    @RequestMapping("/mailListPage")
    public String mailListPage(Model model){
        return "/store/mail/list";
    }

    @RequestMapping("detailMail")
    public String detailMail(Model model,Integer messageId){
        Seller seller = WebUtil.getCurrentSeller();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StoreMailDTO storeMailDTO = mailService.detailMail(messageId,seller.getStoreId());
        model.addAttribute("title",storeMailDTO.getTitle());
        model.addAttribute("content",storeMailDTO.getContent());
        model.addAttribute("time",formatter.format(storeMailDTO.getCreateTime()));
        model.addAttribute("from",storeMailDTO.getSendUserName());
        model.addAttribute("id",storeMailDTO.getStoreMessageId());
        return "/store/mail/detail";
    }

    /**
     * @Description: 获取消息列表页面数据
     * @Author: pangweichao
     * @Date: 13:09 2017/6/3
     * @Param: [draw, searchKey, orderColumn, orderType, page, pageSize]
     * @return: java.lang.Object
     */
    @RequestMapping("/getMailListDate")
    @ResponseBody
    public Object getMailListDate(@RequestParam("draw") int draw,
                                  @RequestParam(value = "searchKey", required = false) String searchKey,
                                  @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                  @RequestParam(value = "orderType", required = false) String orderType,
                                  @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        Seller seller = WebUtil.getCurrentSeller();
        List<StoreMailDTO> storeMailDTOS = mailService.getMailListDate(searchKey,orderColumn,orderType,page,pageSize,seller.getStoreId());
        return new PageResult<StoreMailDTO>(storeMailDTOS,draw);
    }

    /**
     * @Description: 删除指定邮件
     * @Author: pangweichao
     * @Date: 14:22 2017/6/3
     * @Param: [storeMessageId]
     * @return: java.lang.Object
     */
    @RequestMapping("/deleteMessage/{storeMessageId}")
    @ResponseBody
    public Object deleteMessage(@PathVariable("storeMessageId") Integer storeMessageId){
        RestResult result = new RestResult();
        Integer info = mailService.deleteMessage(storeMessageId);
        return result;
    }

    /**
     * @Description: 更新是否阅读状态
     * @Author: pangweichao
     * @Date: 15:48 2017/6/3
     * @Param: [storeMessageId]
     * @return: java.lang.Object
     */
    @RequestMapping("updateReadFlag")
    @ResponseBody
    public Object updateReadFlag(String storeMessageId){
        RestResult result = new RestResult();
        Integer info = mailService.updateReadFlag(Integer.parseInt(storeMessageId));
        return result;
    }

}
