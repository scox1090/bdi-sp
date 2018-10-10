package com.bdi.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.dao.BoardInfoDAO;
import com.bdi.sp.vo.BoardInfo;

@Controller
public class BoardInfoController {
	
	@Autowired
	private BoardInfoDAO bidao;

	@RequestMapping(value="/bi", method=RequestMethod.GET)
		public @ResponseBody List<BoardInfo> boardInfoList(@ModelAttribute BoardInfo bi){
		return bidao.getBoardInfoList(bi);
	}
	
	@RequestMapping(value="/bi/{binum}", method=RequestMethod.GET)
	public @ResponseBody BoardInfo boardInfo(@PathVariable int binum){
	return bidao.getBoardInfo(binum);
}
	
	@RequestMapping(value="/bi", method=RequestMethod.POST)
	public @ResponseBody String insertBoardInfo(@RequestBody BoardInfo bi){
	return bidao.insertBoardInfo(bi);
}
	
	@RequestMapping(value="/bi", method=RequestMethod.PUT)
	public @ResponseBody String updateBoardInfo(@RequestBody BoardInfo bi){
	return bidao.updateBoardInfo(bi) + "";
}
	
	@RequestMapping(value="/bi/{binum}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteJapan(@PathVariable int binum) { 
		return bidao.deleteBoardInfo(binum) + "";
	}
	
}
