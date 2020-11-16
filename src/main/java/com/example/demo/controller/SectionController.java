package com.example.demo.controller;

import com.example.demo.dto.SectionItem;
import com.example.demo.entity.ResultBean;
import com.example.demo.entity.Section;
import com.example.demo.exception.MyException;
import com.example.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    SectionService sectionService;

    @RequestMapping("/info")
    public ResultBean<Section> info(@RequestBody Map<String, String> map) throws MyException {
        String sid = map.get("sid");
        Integer id = Integer.parseInt(sid);
        System.out.println("Section: info");
        return ResultBean.success(sectionService.info(id));
    }

    @RequestMapping("/add")
    public ResultBean<Void> Add(@RequestBody Map<String, String> map) throws MyException {
        String courseId = map.get("cid");
        String semester = map.get("semester");
        String endTime = map.get("endTime");
        System.out.println("Section: adding");
        sectionService.Add(courseId, semester, endTime);
        return ResultBean.success(null);
    }

    @RequestMapping("/delete")
    public ResultBean<Void> Delete(@RequestBody Map<String, String> map) throws MyException {
        String sid = map.get("sid");
        Integer id = Integer.parseInt(sid);
        System.out.println("Section: deleting");
        sectionService.Delete(id);
        return ResultBean.success(null);
    }

    @RequestMapping("/list")
    public ResultBean<List<SectionItem>> List(@RequestBody Map<String, Integer> map) throws MyException {
        Integer userId = map.get("uid");
        Integer role = map.get("role");
        Integer listType = map.get("list_type");
        System.out.println("Section: listing");
        return ResultBean.success(sectionService.List(userId, role, listType));
    }
 }
