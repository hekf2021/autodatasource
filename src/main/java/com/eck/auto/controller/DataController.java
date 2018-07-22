package com.eck.auto.controller;


import com.eck.auto.config.DataSourceHolder;
import com.eck.auto.model.Aberrant;
import com.eck.auto.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class DataController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value="/cc",method = RequestMethod.GET)
    public List<Aberrant> cc(Integer id) {
        List<Aberrant> list = dataService.find(id);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value="/cc1",method = RequestMethod.GET)
    public List<Aberrant> cc1(Integer id) {
        DataSourceHolder.setDataSource("1");
        List<Aberrant> list = dataService.find(id);
        System.out.println(list);
        return list;
    }
    @RequestMapping(value="/cc2",method = RequestMethod.GET)
    public List<Aberrant> cc2(Integer id) {
        DataSourceHolder.setDataSource("2");
        List<Aberrant> list = dataService.find(id);
        System.out.println(list);
        return list;
    }
    @RequestMapping(value="/cc3",method = RequestMethod.GET)
    public List<Aberrant> cc3(Integer id) {
        DataSourceHolder.setDataSource("3");
        List<Aberrant> list = dataService.find(id);
        System.out.println(list);
        return list;
    }

    @RequestMapping(value="/update",method = RequestMethod.GET)
    public String update(Integer id) {
        dataService.upate();
        return "ok";
    }

}
