package com.vk.id26639136.WebTree.domain;

import javax.persistence.*;

@Entity
@Table
public class Folder {
    @Id
    @GeneratedValue
    private Integer id;
    private String folderName;
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Folder parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        String str = "Folder{" +
                "id=" + id +
                ", folderName='" + folderName + "'";
        if (parent != null) str += ", parentId='" + parent.getId() + "'";
        str += "}";
        return str;
    }
}
