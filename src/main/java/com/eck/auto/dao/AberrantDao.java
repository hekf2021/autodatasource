package com.eck.auto.dao;





import com.eck.auto.model.Aberrant;

import java.util.List;

public interface AberrantDao{

    List<Aberrant> findAll();
    public int update();
}
