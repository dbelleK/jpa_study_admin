package com.example.study.service;

import com.example.study.controller.ifs.CrudInterface;
import com.example.study.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;

public abstract class BaseService<Req,Res,Entity>  implements CrudInterface<Req,Res> {

    //JpaRepository 찾기 위해 설정
    @Autowired(required = false)
    protected JpaRepository<Entity, Long> baseRepository;
            //JpaRepository<Item,Long>

}
