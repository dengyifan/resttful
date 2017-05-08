package com.yifan.restful.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yifan.restful.demo.domain.FavUser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by yifan on 2017/5/8.
 */
@RestController
public class FavRestfulController {

    @RequestMapping(value="/getUserName",method= RequestMethod.POST)
    public String getUserName(@RequestParam(value="name") String name){
        return name;
    }

    @RequestMapping("getFavUser")
    public FavUser getFavUser(@RequestParam("userName") String userName, String userId, int userAge){
        FavUser favUser = new FavUser();
        favUser.setUserId(userId);
        favUser.setUserName(userName);
        favUser.setUserAge(userAge);
        return favUser;
    }

    @RequestMapping("getFavUserBody")
    public FavUser getFavUserBody(@RequestBody String body){
        ObjectMapper mapper = new ObjectMapper();
        FavUser favUser = null;
        try {
            favUser = mapper.readValue(body,  FavUser.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favUser;
    }

    @RequestMapping(value="buildRestUser")
    public FavUser buildRestUser(){
        FavUser favUser = new FavUser();
        favUser.setUserId("mm");
        favUser.setUserName("美眉");
        favUser.setUserAge(18);
        favUser.setCreateDate(new Date());
        return favUser;
    }
}
