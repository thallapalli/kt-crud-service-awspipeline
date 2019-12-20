package com.demo.crud.crudservice.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.crud.crudservice.constants.Constants;
import com.demo.crud.crudservice.model.Note;

@Repository
public class CrudRepository {
	@Autowired
	JdbcTemplate Jdbctemplate;

	public List<Note> retrivenotes() {
		return Jdbctemplate.query(Constants.SQL_SELECT,
				(rs, rowNum) -> new Note(rs.getInt("ID"), rs.getString("NAME")));

	}

	public int createNote(Note note) {
		return Jdbctemplate.update(Constants.SQL_CREATE,
				new Object[] { Integer.valueOf(note.getId()), note.getName() });
	}

	public int updateNote(Note note) {
		return Jdbctemplate.update(Constants.SQL_UPDATE,
				new Object[] { note.getName(), Integer.valueOf(note.getId()) });
	}
	public void deleteNote(int id) {
		Jdbctemplate.update(Constants.SQL_DELETE, id);
	}

	
}
