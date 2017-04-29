package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.dto.TuikePageListDTO;
import com.wuliangit.shopos.service.TuikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 26229 on 2017/4/27.
 */

@Controller
@RequestMapping("/admin/tuike")
public class AdminTuikeController {

    @Autowired
    private TuikeService tuikeService;

    /**
     * 获取审核列表页面
     * @return
     */
    @RequestMapping("/checkListPage")
    public String checkListPage() {
        return "admin/tuike/checklist";
    }

    /**
     * 获取推客管理列表页面
     * @return
     */
    @RequestMapping("/tuikeListPage")
    public String tuikeListPage() {
        return "admin/tuike/tuikelist";
    }

    /**
     * 获得审核列表数据
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getCheckList")
    @ResponseBody
    public Object getCheckList(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                               @RequestParam(value = "orderType", required = false) String orderType,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<TuikeCheckListDTO> tuikeCheckListDTO = tuikeService.getCheckList(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<TuikeCheckListDTO>(tuikeCheckListDTO,draw);
    }

    /**
     * 审核推客
     * @param memberId
     * @param state
     * @return
     */
    @RequestMapping("/checkOperation")
    @ResponseBody
    public RestResult checkOperation(Integer memberId, String state){
        RestResult result = new RestResult();
        Integer info = tuikeService.checkOperation(memberId,state);
        if(info != 1){
            result.put("code",RestResult.CODE_SERVERERROR);
            result.put("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * 获得推客管理列表数据
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getTuikeList")
    @ResponseBody
    public Object getTuikeList(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                               @RequestParam(value = "orderType", required = false) String orderType,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<TuikePageListDTO> tuikePageListDTOS = tuikeService.getTuikeList(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<TuikePageListDTO>(tuikePageListDTOS,draw);
    }

    /**
     * 禁用推客
     * @param tuikeId
     * @param state
     * @return
     */
    @RequestMapping("/forbiddenTuike")
    @ResponseBody
    public RestResult forbiddenTuike(Integer tuikeId, String state){
        RestResult result = new RestResult();
        Integer info = tuikeService.forbiddenTuike(tuikeId,state);
        if(info != 1){
            result.put("code",RestResult.CODE_SERVERERROR);
            result.put("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

}
