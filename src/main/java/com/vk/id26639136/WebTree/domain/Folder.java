package com.vk.id26639136.WebTree.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Folder {
    @Id
    @GeneratedValue
    private Integer id;
    private String folderName;
    private Integer parentId;
}
