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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;

    }

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", folderName='" + folderName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
