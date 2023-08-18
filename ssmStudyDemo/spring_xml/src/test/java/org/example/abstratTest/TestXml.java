package org.example.abstratTest;

import org.example.pojo.Clazz;
import org.example.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXml {


    @Test
    public void testXml(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentOne = (Student) context.getBean("studentOne");
        System.out.println(studentOne);
    }
//
//    @Test
//    public void testXml2(){
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student studentTwo = (Student) context.getBean("studentTwo");
//        System.out.println(studentTwo);
//    }

    @Test
    public void testXml3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student studentThree = (Student) context.getBean("studentThree");
        System.out.println(studentThree);
    }

    @Test
    public void testXml4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("studentFour");
        System.out.println(student);
    }

    @Test
    public void testXml5(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("studentFive");
        System.out.println(student);
    }

    @Test
    public void testXml6(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("studentSix");
        System.out.println(student);
    }

    @Test
    public void testXmlClazz(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = (Clazz) context.getBean("clazzTwo");
        System.out.println(clazz);
    }

    @Test
    public void testXmlClazz2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = (Clazz) context.getBean("clazzThree");
        System.out.println(clazz);
    }

    @Test
    public void testXml7(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("studentSeven");
        System.out.println(student);
    }

    @Test
    public void testXml8(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("studentEight");
        System.out.println(student);
    }

    @Test
    public void testXml9(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("studentNine");
        System.out.println(student);
    }
}
