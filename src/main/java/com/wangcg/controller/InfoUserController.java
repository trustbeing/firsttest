package com.wangcg.controller;

import com.wangcg.dto.InfoUser.InfoUserLogin;
import com.wangcg.dto.InfoUser.InfoUserUpdate;
import com.wangcg.util.annotation.Authorization;
import com.wangcg.model.InfoUser;
import com.wangcg.service.InfoUserService;
import com.wangcg.util.RequestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        int result=infoUserService.updateNickNameByPrimaryKey(user);
        return result;
    }

    @RequestMapping(value={"/login"},method= RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public InfoUser UserLogin(InfoUserLogin user){
        InfoUser result=infoUserService.userLogin(user);
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
    @RequestMapping(value={"/logout"},method= RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Long logOut(){
        Long userId = RequestHelper.GetCurrentUserId();
        return userId;
    }
}
