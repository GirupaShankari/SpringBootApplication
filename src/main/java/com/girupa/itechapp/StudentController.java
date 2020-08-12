package com.girupa.itechapp;

import com.girupa.itechapp.model.Role;
import com.girupa.itechapp.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    List<Student> studentList = new ArrayList<>();

    @RequestMapping(value = "/student/all")
    public List<Student> getStudents() {
        List<Student> studentList = prepareData();
        return studentList;
    }

//    @RequestMapping(value="/student/{id}")
//    public Student getStudent(@PathVariable("id") Integer id)
//    {
//        List<Student> studentList=prepareData();
//        for(Student student: studentList)
//        {
//            if(student.getId()==id) {
//                return student;
//            }
//        }
//        return null;
//    }

    @RequestMapping(value = "/student/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") Integer id) {
        List<Student> studentList = prepareData();
        for (Student student : studentList) {
            if (student.getId() == id) {
                ResponseEntity responseEntity = new ResponseEntity(student, HttpStatus.OK);
                return responseEntity;
            }
        }
        Map<String,String> map = new HashMap<>();
        map.put("message", "Student Not Found");
        ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ResponseEntity createStudent(@RequestBody Student student) {
        boolean newStudent=addStudent(student);
        Map<String, String> map = new HashMap<>();
        if(newStudent) {
            map.put("message", "Student added Successfully");
            ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.CREATED);
            return responseEntity;
        }
        else
        {
            map.put("message", "Student already found");
            ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.OK);
            return responseEntity;
        }
    }

    @RequestMapping(value="/update/student",method=RequestMethod.PUT)
    public ResponseEntity updateMyStudent(@RequestBody Student student)
    {
        boolean updated=updateStudent(student);
        Map<String,String> map=new HashMap<>();
        ResponseEntity responseEntity;
        if(updated)
        {
            map.put("message","Student updated successfully");
            responseEntity=new ResponseEntity(map,HttpStatus.OK);
        }
        else
        {
            map.put("message","Student Not Found");
            responseEntity=new ResponseEntity(map,HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    public boolean updateStudent(Student student)
    {
        List<Student> studentList=prepareData();
        boolean removed=false;
        Iterator<Student> iterator=studentList.iterator();
        while(iterator.hasNext())
        {
            Student s= iterator.next();
            if(s.getId()==student.getId())
            {
                iterator.remove();
                removed=true;
                break;
            }

        }
        if(removed)
            studentList.add(student);

      return  removed;
    }

    public boolean addStudent(Student student)
    {
        List<Student> studentList=prepareData();
      //  int count=0;
        boolean newStudent=false;
//        Iterator<Student> iterator=studentList.iterator();
//        while(iterator.hasNext())
//        {
//            Student s= iterator.next();
//            if(student.getId()==(s.getId()))
//            {
//                count++;
//                break;
//            }
//        }
//        if(count==0) {
//            studentList.add(student);
//            newStudent=true;
//        }

        //Using Stream
        if(studentList.stream().filter(i->i.getId()==student.getId()).count()!=0) return false;
        studentList.add(student);
        return true;

      // return newStudent;

    }

   public List<Student> prepareData()
    {
        if(studentList.isEmpty()) {
            Student s1 = new Student();
            s1.setId(1);
            s1.setName("Kuzhal");
            s1.setCollege("AAMEC");
            s1.setCity("Thanjavur");

            Role r1 = new Role();
            r1.setDept("CSE");
            r1.setYear("second yr");
            s1.setRole(r1);

            Student s2 = new Student();
            s2.setId(2);
            s2.setName("Keerthi");
            s2.setCollege("AAMEC");
            s2.setCity("Kovilvenni");

            Role r2 = new Role();
            r2.setDept("IT");
            r2.setYear("Third yr");
            s2.setRole(r2);


            studentList.add(s1);
            studentList.add(s2);
        }

        return studentList;
    }
}
