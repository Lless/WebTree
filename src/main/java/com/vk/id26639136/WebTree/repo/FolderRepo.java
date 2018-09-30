package com.vk.id26639136.WebTree.repo;

import com.vk.id26639136.WebTree.domain.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FolderRepo extends JpaRepository<Folder, Integer> {
    @Query("FROM Folder where parentId=?1")
    List<Folder> findChildren(Integer parentId);
    @Query("FROM Folder where parentId=null")
    List<Folder> findRootChildren();
}
