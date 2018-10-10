package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.JapanDAO;
import com.bdi.sp.vo.Japan;

@Repository
public class JapanDAOImpl implements JapanDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Japan> getJapanList(Japan j) {
		// TODO Auto-generated method stub
		return ss.selectList("SQL.JAPAN.selectJapanList",j);
	}

	@Override
	public int deleteJapan(int jpnum) {
		// TODO Auto-generated method stub
		return ss.delete("SQL.JAPAN.deleteJapan",jpnum);
	}

	@Override
	public int updateJapan(Japan j) {
		// TODO Auto-generated method stub
		return ss.update("SQL.JAPAN.updateJapan",j);
	}

	@Override
	public String insertJapan(Japan jp) {
		return ss.insert("SQL.JAPAN.insertJapan",jp)+"";
	}

	@Override
	public Japan getJapan(int jpnum) {
		// TODO Auto-generated method stub
		return ss.selectOne("SQL.JAPAN.selectJapan",jpnum);
	}


}
