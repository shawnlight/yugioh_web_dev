package com.light.seckill;

import com.light.seckill.db.dao.SeckillActivityDao;
import com.light.seckill.db.dao.UserDao;
import com.light.seckill.db.mappers.SeckillActivityMapper;
import com.light.seckill.db.mappers.UserMapper;
import com.light.seckill.db.po.SeckillActivity;
import com.light.seckill.db.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class DaoTest {
    @Resource
    private SeckillActivityMapper seckillActivityMapper;
    @Autowired
    private SeckillActivityDao seckillActivityDao;

    @Autowired
    private UserDao userDao;

    @Resource
    private UserMapper userMapper;

    @Test
    void SeckillActivityTest() {
        SeckillActivity seckillActivity = new SeckillActivity();
        seckillActivity.setName("测试");
        seckillActivity.setCommodityId(999L);
        seckillActivity.setTotalStock(100L);
        seckillActivity.setSeckillPrice(new BigDecimal(99));
        seckillActivity.setActivityStatus(1);
        seckillActivity.setOldPrice(new BigDecimal(99));
        seckillActivity.setAvailableStock(100);
        seckillActivity.setLockStock(0L);
        seckillActivityMapper.insert(seckillActivity);
        System.out.println("====>>>>" +
                seckillActivityMapper.selectByPrimaryKey(1L));
    }

    @Test
    void setSeckillActivityQuery() {
        List<SeckillActivity> seckillActivitys =
                seckillActivityDao.querySeckillActivitysByStatus(0);
        System.out.println(seckillActivitys.size());
        seckillActivitys.stream().forEach(seckillActivity ->
                System.out.println(seckillActivity.toString()));
    }


    @Test
    void userTest(){
        User user = new User();
        user.setUserName("test@test.com");
        user.setPassword("abcdefg");
        user.setFirstName("test");
        user.setLastName("123456");
        userMapper.insert(user);


    }
}