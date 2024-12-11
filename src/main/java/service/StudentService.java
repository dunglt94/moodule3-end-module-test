package service;

import DAO.IStudentDAO;
import DAO.StudentDAO;
import model.Student;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentDAO studentDAO = new StudentDAO();

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public void add(Student object) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void update(Student object) {

    }

    @Override
    public void remove(int id) {

    }
}
