package com.light.seckill.service;

import com.light.seckill.db.dao.SeckillActivityDao;
import com.light.seckill.db.po.SeckillActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillOverSellService {


    @Autowired
    private SeckillActivityDao seckillActivityDao;
    public String processSeckill(long activityID){
        SeckillActivity activity = seckillActivityDao.querySeckillActivityById(activityID);
        int availableStock = activity.getAvailableStock();
        String result;

        if(availableStock > 0){
            result = "success";
            System.out.println(result);
            availableStock--;
            activity.setAvailableStock(availableStock);
            seckillActivityDao.updateSeckillActivity(activity);

        }
        else{
            result = "fail";
            System.out.println(result);
        }
        return result;
    }
}
