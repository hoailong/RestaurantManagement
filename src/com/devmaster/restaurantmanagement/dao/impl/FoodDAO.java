package com.devmaster.restaurantmanagement.dao.impl;

import java.util.List;

import com.devmaster.restaurantmanagement.dao.IFoodDAO;
import com.devmaster.restaurantmanagement.mapper.FoodMapper;
import com.devmaster.restaurantmanagement.model.FoodModel;

public class FoodDAO extends AbstractDAO<FoodModel> implements IFoodDAO{

	@Override
	public List<FoodModel> findAll() {
		String sql = "Select * From tblFood";
		List<FoodModel> list = query(sql, new FoodMapper());
		return list;
	}

	@Override
	public List<FoodModel> findByGroupCode(String groupCode) {
		String sql = "Select f.FoodId,f.FoodName,f.FoodImage,f.FoodCost,f.GroupId From tblFood f, tblFoodGroup fg where f.GroupId = fg.GroupId AND fg.GroupCode LIKE '"+groupCode+"'" ;
		List<FoodModel> list = query(sql, new FoodMapper());
		return list;
	}

	@Override
	public List<FoodModel> findTopByGroupCode(String groupCode, int count) {
		String sql = "Select TOP (?) f.FoodId,f.FoodName,f.FoodImage,f.FoodCost,f.GroupId From tblFood f, tblFoodGroup fg where f.GroupId = fg.GroupId AND fg.GroupCode LIKE '"+groupCode+"'" ;
		List<FoodModel> list = query(sql, new FoodMapper(),count);
		return list;
	}

}