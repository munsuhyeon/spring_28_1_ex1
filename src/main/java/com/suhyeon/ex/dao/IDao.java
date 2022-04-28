package com.suhyeon.ex.dao;

import java.util.ArrayList;

import com.suhyeon.ex.dto.ContentDto;

public interface IDao {

		public ArrayList<ContentDto> listDao();
		public void writeDao(String mwirter, String mcontent);
		public ContentDto viewDao(String mid);
		public void deleteDao(String mid);
}
