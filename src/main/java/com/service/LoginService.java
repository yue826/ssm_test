package com.service;

import com.bean.user;
import com.dao.userMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class LoginService {
    @Autowired
    private userMapper userMapper;
    
    public user selectuser(int id){

        return userMapper.selectByPrimaryKey(id);
    }

    public boolean checkuser(String username,String password){
        if(userMapper.selectuserByUsernameAndPassword(username)!=null){
            if(userMapper.selectuserByUsernameAndPassword(username).getAdminPwd().equals(password)) {
                return true;
            }else{
                return  false;
            }

        }else{
            return false;
        }

    }
}
