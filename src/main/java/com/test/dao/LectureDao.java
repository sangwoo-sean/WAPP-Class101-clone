package com.test.dao;

import com.test.dto.LectureDto;
import com.test.mapper.LectureMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LectureDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<LectureDto> readBasicDataList() {
        try {
            System.out.println("calling Lecture list do");
            LectureMapper lMapper = sqlSession.getMapper(LectureMapper.class);
            ArrayList<LectureDto> lectureInfoList = lMapper.readBasicDataList();
            System.out.println("calling Lecture list end");
            return lectureInfoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertLecture(String category, String name, String price, String regDate, String img) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            //TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            System.out.println("dao: " + category + "," + name + "," + price + "," + regDate + "," + img);
            lecMapper.insertLecture(category, name, price, regDate, img);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void deleteLecture(String lectureNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureNo);
            lecMapper.deleteLecture(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LectureDto readBasicDataByLecNo(String lectureNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureNo);
            return lecMapper.readBasicDataByLecNo(lectureNo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecName(String lectureName) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureName);
            return lecMapper.readBasicDataByLecName(lectureName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecCategory(String lectureCategory) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lectureCategory);
            return lecMapper.readBasicDataByLecCategory(lectureCategory);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<LectureDto> readBasicDataByLecPrice(String minPrice, String maxPrice) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + minPrice + "~" + maxPrice);
            return lecMapper.readBasicDataByLecPrice(minPrice, maxPrice);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateLecture(String lecNo, String lecName, String lecCategory, String lecImg, String lecPrice) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + lecNo);
            lecMapper.updateLecture(lecNo, lecName, lecCategory, lecImg, lecPrice);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public ArrayList<LectureDto> readBasicDataListByUserNo(String userNo) {
        try {
            LectureMapper lecMapper = sqlSession.getMapper(LectureMapper.class);
            System.out.println("dao: " + userNo);
            ArrayList<LectureDto> lectureInfoList = lecMapper.readBasicDataListByUserNo(userNo);
            return lectureInfoList;
        } catch (Exception e) {
            System.out.println("what error ㅜㅜ");
            e.printStackTrace();
            return null;
        }
    }
}