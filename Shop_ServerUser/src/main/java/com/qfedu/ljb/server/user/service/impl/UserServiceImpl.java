package com.qfedu.ljb.server.user.service.impl;

import com.qfedu.ljb.common.config.ProjectConfig;
import com.qfedu.ljb.common.exception.UserException;
import com.qfedu.ljb.common.util.EncryptionUtil;
import com.qfedu.ljb.common.util.TimeUtil;
import com.qfedu.ljb.common.vo.R;
import com.qfedu.ljb.entity.*;
import com.qfedu.ljb.server.user.dao.*;
import com.qfedu.ljb.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPointsMapper userPointsMapper;
    @Autowired
    private UserDetailMapper detailMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private PointsMapper pointsMapper;
    @Override
    @Transactional(rollbackFor ={UserException.class})
    public R save(User user) throws UserException {
        try {
            user.setPassword(EncryptionUtil.RSAEnc(ProjectConfig.PASSRSAPRI,user.getPassword()));
            // 新增用户
            userMapper.insert(user);
            // 初始化用户详情
            detailMapper.insertInit(user.getId());
            // 初始化积分
            Points points=new Points();
            points.setUid(user.getId());
            points.getScore(ProjectConfig.INITNEWSCORE);
            points.setInfo("新用户，奖励"+ProjectConfig.INITNEWSCORE+"积分");
            points.setStartdate(new Date());
            points.setEnddate(TimeUtil.getDays(ProjectConfig.INITNEWSEXPIRE));
            pointsMapper.insert(points);
            //注册送积分
            UserPoints userPoints=new UserPoints();
            userPoints.setUid(user.getId());
            userPoints.getTotalscore(ProjectConfig.INITNEWSCORE);
            userPoints.setCurrscore(ProjectConfig.INITNEWSCORE);
            userPointsMapper.insert(userPoints);
            //初始化购物车
            Cart cart=new Cart();
            cart.setUid(user.getId());
            cart.setMaxcount(ProjectConfig.CARTMAXGOODS);
            cart.setCurrcount(0);
            cartMapper.insert(cart);
        }catch (Exception e){
            throw new UserException("用户注册异常："+e.getMessage());
        }
        return R.setERROR();
    }

    @Override
    public R all() {

        return R.setOK("OK", userMapper.all());
    }

    @Override
    public R checkPhone(String phone) {
        User user=userMapper.selectByPhone(phone);
        if (user!=null){
            return R.setERROR("手机号已经注册,请找回密码");
        }
        return R.setOk();
    }
}
