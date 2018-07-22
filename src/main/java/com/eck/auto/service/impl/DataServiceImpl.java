package com.eck.auto.service.impl;

import com.eck.auto.dao.AberrantDao;
import com.eck.auto.dao.DataDao;
import com.eck.auto.exception.MyException;
import com.eck.auto.model.Aberrant;
import com.eck.auto.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/7/21.
 */
@Service
public class DataServiceImpl implements DataService {

    //@Autowired
    private DataDao dataDao;

    @Autowired
    private AberrantDao aberrantDao;


    public List<Aberrant> find(Integer id){
        List<Aberrant> list = aberrantDao.findAll();
        return list;
    }

    /**
     * 测试事务
     */
    @Transactional
    public void upate()  {
        aberrantDao.update();
        if(1==1){
            throw new MyException(HttpStatus.OK.value(),"xxxxx","主动异常");
        }
    }

}
