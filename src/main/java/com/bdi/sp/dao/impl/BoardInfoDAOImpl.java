package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.BoardInfoDAO;
import com.bdi.sp.vo.BoardInfo;

@Repository
public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<BoardInfo> getBoardInfoList(BoardInfo bi) {
		return ss.selectList("SQL.BOARDINFO.selectBoardInfoList",bi);
	}

	@Override
	public BoardInfo getBoardInfo(int binum) {
		// TODO Auto-generated method stub
		return ss.selectOne("SQL.BOARDINFO.selectBoardInfo",binum);
	}

	@Override
	public String insertBoardInfo(BoardInfo bi) {
		// TODO Auto-generated method stub
		return ss.insert("SQL.BOARDINFO.insertBoardInfo",bi) + "";
	}

	@Override
	public int updateBoardInfo(BoardInfo bi) {
		// TODO Auto-generated method stub
		return ss.update("SQL.BOARDINFO.updateBoardInfo",bi);
	}

	@Override
	public int deleteBoardInfo(int binum) {
		// TODO Auto-generated method stub
		return ss.delete("SQL.BOARDINFO.deleteBoardInfo",binum);
	}

}
