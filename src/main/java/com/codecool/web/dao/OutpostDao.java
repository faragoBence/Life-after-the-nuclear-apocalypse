package com.codecool.web.dao;

import com.codecool.web.model.locations.Outpost;

import java.sql.SQLException;
import java.util.List;

public interface OutpostDao {

    void insertOutpost(String name) throws SQLException;

    Outpost findOutpost(int id) throws SQLException;

    Outpost findOutpost(String name) throws SQLException;

    List<Outpost> findAll() throws SQLException;


}
