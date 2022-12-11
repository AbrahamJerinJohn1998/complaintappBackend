package com.example.complaintnewappbackend.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.complaintnewappbackend.model.Complaint;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository <Complaint,Integer> {
    @Query(value = "SELECT  u.address, u.`email`, u.`name`, u.`phone`, c.complaints FROM `user_detail` u JOIN complaints c ON u.id=c.user_id",nativeQuery = true)
    List<Map<String,String>> ViewAllComplaint();

    @Query(value = "SELECT `id`, `complaints`, `user_id` FROM `complaints` WHERE `user_id`= :user_id",nativeQuery = true)
    List<Complaint> ViewMyComplaint(@Param("user_id") Integer user_id);
}
