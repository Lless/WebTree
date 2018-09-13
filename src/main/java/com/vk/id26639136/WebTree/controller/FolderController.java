package com.vk.id26639136.WebTree.controller;

import com.vk.id26639136.WebTree.domain.Folder;
import com.vk.id26639136.WebTree.repo.FolderRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FolderController {
    public FolderController(FolderRepo repo) {
        this.repo = repo;
    }

    private FolderRepo repo;

    @GetMapping("/folders")
    public List<Folder> getFolders(@RequestParam(required = false) Folder parent) {
        return parent == null ? repo.findRootChildren() : repo.findChildren(parent);
    }
}
