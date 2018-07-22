package com.eck.auto.service;

import com.eck.auto.model.Aberrant;

import java.util.List;

/**
 * Created by Administrator on 2018/7/21.
 */
public interface DataService {
    public List<Aberrant> find(Integer id);
    public void upate();
}
