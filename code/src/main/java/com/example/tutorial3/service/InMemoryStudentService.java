package com.example.tutorial3.service;

import java.util.List;
import java.util.ArrayList;
import com.example.tutorial3.model.StudentModel;;

public class InMemoryStudentService implements StudentService{
	
	private static List<StudentModel> studentList = new ArrayList<StudentModel>();

	@Override
	public StudentModel selectStudent(String npm) {
		int index=-1;
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getNpm().equals(npm)) {	
				index=i;
			}
		}
		if(index>-1) {
			return studentList.get(index);
		}else {
			return null;
		}	
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		return studentList;
	}

	@Override
	public void addStudent(StudentModel student) {
		studentList.add(student);
	}
	@Override
	public void deleteStudent(String npm) {
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getNpm().equals(npm)) {
				studentList.remove(i);
				break;
			}
		}
	}
	
	public boolean isExist(String npm) {
		boolean exist=false;
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getNpm().equals(npm)) {
				exist=true;
				break;
			}
		}
		return exist;
	}
	
}
