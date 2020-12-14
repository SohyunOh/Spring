package com.simple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	
//	private ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		
//	@Override
//	public void boardRegist(BoardVO vo) {
//		
//		list.add(vo);
//		System.out.println(list.toString());
//		
//	}
//
//	@Override
//	public ArrayList<BoardVO> getList() {
//		
//		return list;
//	}
//
//	@Override
//	public void boardDelete(int num) {
//		
//		list.remove(num);
//	}

	//=====================JDBC템플릿 으로 변경=====================
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public void boardRegist(BoardVO vo) {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {vo.getName(), vo.getTitle(), vo.getContent()});
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		String sql = "select * from board order by num desc";
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BoardVO vo = new BoardVO();
				vo.setNum( rs.getInt("num") );
				vo.setName( rs.getString("name") );
				vo.setTitle( rs.getString("title") );
				vo.setContent( rs.getString("content"));
				
				return vo;
			}
			
		});
		
		return (ArrayList<BoardVO>)list;
	}

	@Override
	public void boardDelete(int num) {
		
		String sql = "delete from board where num = ?";
		jdbcTemplate.update(sql, new Object[] {num});
		
	}
}
