package com.examServer.ExamServer.model.currentaffair;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentAffairs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String content;
    private String Date ;
    private Long  updatedBy;
    private String imageAddress;


        //creating a getter setter for the method here




}
