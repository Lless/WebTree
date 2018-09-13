package com.vk.id26639136.WebTree.repo;

import com.vk.id26639136.WebTree.domain.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FolderRepo extends JpaRepository<Folder, Integer> {
    @Query(value = "FROM Folder where parent=?1")
    List<Folder> findChildren(Folder parent);
    @Query("FROM Folder where parent=null")
    List<Folder> findRootChildren();
}
