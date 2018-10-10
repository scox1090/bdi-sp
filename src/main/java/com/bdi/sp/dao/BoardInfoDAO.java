package com.bdi.sp.dao;

import java.util.List;

import com.bdi.sp.vo.BoardInfo;

public interface BoardInfoDAO {
	
	public List<BoardInfo> getBoardInfoList(BoardInfo bi);
	public BoardInfo getBoardInfo(int binum);
	public String insertBoardInfo(BoardInfo bi);
	public int updateBoardInfo(BoardInfo bi);
	public int deleteBoardInfo(int binum);
}
