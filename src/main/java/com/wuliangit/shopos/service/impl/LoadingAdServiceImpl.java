package com.wuliangit.shopos.service.impl;

import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.dao.SettingMapper;
import com.wuliangit.shopos.dto.LoadingPicDTO;
import com.wuliangit.shopos.service.LoadingAdService;
import com.wuliangit.shopos.service.SettingService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuliang01 on 2017/7/1.
 */
@Service
public class LoadingAdServiceImpl implements LoadingAdService {

    @Autowired
    private SettingMapper settingMapper;

    @Override
    public List<LoadingPicDTO> getLoadingAdListDate() {
        String val = settingMapper.getSetting(CoreConstants.LOADING_AD);
        JSONArray jsonArray = new JSONArray().fromObject(val);
        List<LoadingPicDTO> loadingPicDTOS = new ArrayList<LoadingPicDTO>();
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            loadingPicDTOS.add((LoadingPicDTO) JSONObject.toBean(jsonObject,LoadingPicDTO.class));
        }
        return loadingPicDTOS;
    }

    @Override
    public Integer getLoadingAdNumber() {
        String val = settingMapper.getSetting(CoreConstants.LOADING_AD);
        JSONArray jsonArray = new JSONArray().fromObject(val);
        return jsonArray.size();
    }

    @Override
    public Integer addLoadingPic(String img) {
        String val = settingMapper.getSetting(CoreConstants.LOADING_AD);
        JSONArray jsonArray = new JSONArray().fromObject(val);
        LoadingPicDTO loadingPicDTO = new LoadingPicDTO(jsonArray.size()+1,img,false);
        jsonArray.add(loadingPicDTO);
        Integer result = settingMapper.updateSetting(CoreConstants.LOADING_AD,jsonArray.toString());
        return result;
    }

    @Override
    public Integer deleteLoadingAd(Integer id) {
        String val = settingMapper.getSetting(CoreConstants.LOADING_AD);
        JSONArray jsonArray = new JSONArray().fromObject(val);
        JSONArray jsonArray1 = new JSONArray();
        for(int i=0;i<id-1;i++){
            jsonArray1.add(jsonArray.getJSONObject(i));
        }
        jsonArray.remove(id-1);
        for(int i=id-1;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            jsonObject.put("id",id);
            jsonArray1.add(jsonObject);
        }
        return settingMapper.updateSetting(CoreConstants.LOADING_AD,jsonArray1.toString());
    }

    @Override
    public Integer modifyStatus(Integer id, Boolean open) {
        String val = settingMapper.getSetting(CoreConstants.LOADING_AD);
        JSONArray jsonArray = new JSONArray().fromObject(val);
        JSONObject jsonObject = jsonArray.getJSONObject(id-1);
        if(open == true){
            jsonArray.getJSONObject(id-1).put("open",false);
        }else{
            jsonArray.getJSONObject(id-1).put("open",true);
        }
        return settingMapper.updateSetting(CoreConstants.LOADING_AD,jsonArray.toString());
    }

    @Override
    public String getLoadingPic() {
        String img = null;
        String val = settingMapper.getSetting(CoreConstants.LOADING_AD);
        JSONArray jsonArray = new JSONArray().fromObject(val);
        for(int i=0;i<jsonArray.size();i++){
            if((Boolean) jsonArray.getJSONObject(i).get("open")==true){
                img = (String) jsonArray.getJSONObject(i).get("img");
            }
        }
        return img;
    }

}
