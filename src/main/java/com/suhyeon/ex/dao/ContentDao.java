package com.suhyeon.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.suhyeon.ex.dto.ContentDto;

public class ContentDao implements IDao {
	
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public ArrayList<ContentDto> listDao() {
		
		String query = "SELECT * FROM board ORDER BY mid DESC";
		
		ArrayList<ContentDto> dtos = (ArrayList)template.query(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
		
		return dtos;
	}

	@Override
	public void writeDao(final String mwriter, final String mcontent) {
		// TODO Auto-generated method stub
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				String query = "INSERT INTO board (mid,mwriter,mcontent) VALUES(board_seq.nextval,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, mwriter);
				ps.setString(2, mcontent);
				
				return ps;
			}
		});
	}

	@Override
	public ContentDto viewDao(String strId) {
		
		String query = "SELECT * FROM board WHERE mid = " +strId;
		
		ContentDto dto = template.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
		
		return dto;
	}

	@Override
	public void deleteDao(final String mid) {
		
		String query = "DELETE FROM board WHERE mid = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(mid));
			}
		});
	}
	
}
