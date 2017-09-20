package com.wangcg.controller;

import com.wangcg.dto.InfoUserLogin;
import com.wangcg.dto.InfoUserUpdate;
import com.wangcg.util.Convert.ObjectConvert;
import com.wangcg.util.JsonResultModel;
import com.wangcg.util.annotation.Authorization;
import com.wangcg.model.InfoUser;
import com.wangcg.service.InfoUserService;
import com.wangcg.util.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

@RestController
@RequestMapping("/infouser")
public class InfoUserController {

    @Autowired
    private InfoUserService infoUserService;

    @RequestMapping("/getone")
    public InfoUser GetUser(long id) throws Exception{
        InfoUser user = infoUserService.selectByPrimaryKey(id);
        if(user==null) return null;
       /* ObjectMapper map = new ObjectMapper();
        String json = map.writeValueAsString(user);*/
        return user;
    }

    @RequestMapping(value={"/update"},method= RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public int saveHander(InfoUserUpdate user){
        int result=infoUserService.updateNickNameByPrimaryKey(user.getId(),user.getNickName());
        return result;
    }

    @RequestMapping(value={"/login"},method= RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public InfoUser UserLogin(InfoUserLogin user){
        InfoUser result=infoUserService.userLogin(user.getId());
        if(result!=null) {
            try {
                infoUserService.updateUserLogin(user.getId(), RequestHelper.getRemoteAddr());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Authorization
    @RequestMapping(value={"/getself"},method= RequestMethod.GET)
    public JsonResultModel<HashMap<String,Object>> getSelf(){
        Long userId = RequestHelper.GetCurrentUserId();
        InfoUser user = infoUserService.selectByPrimaryKey(userId);
        HashMap<String,Object> map = new HashMap<String, Object>();
        if(user!=null){
            try {
                map = ObjectConvert.beanToHashMap(user);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return JsonResultModel.returnSuccess(map);
    }
}
