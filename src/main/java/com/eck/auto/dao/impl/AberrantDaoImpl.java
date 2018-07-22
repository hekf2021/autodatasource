package com.eck.auto.dao.impl;


import com.eck.auto.dao.AberrantDao;
import com.eck.auto.model.Aberrant;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AberrantDaoImpl  implements AberrantDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Aberrant> findAll() {

        String hql="from Aberrant where aberrantId=:aberrantId ";
        Query query=entityManager.createQuery(hql.toString());
        query.setParameter("aberrantId",1);
        List<Aberrant> lists=query.getResultList();
        if(lists.size()>0){
            return query.getResultList();
        }else{
            return null;
        }
    }


    public int update(){
        String hql="update Aberrant set orderNo=88 where aberrantId=:aberrantId ";
        Query query=entityManager.createQuery(hql.toString());
        query.setParameter("aberrantId",1);
        return query.executeUpdate();
    }


}
