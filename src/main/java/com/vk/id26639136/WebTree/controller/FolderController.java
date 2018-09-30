package com.vk.id26639136.WebTree.controller;

import com.vk.id26639136.WebTree.domain.Folder;
import com.vk.id26639136.WebTree.repo.FolderRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {
    public FolderController(FolderRepo repo) {
        this.repo = repo;
    }

    private FolderRepo repo;

    @GetMapping()
    public List<Folder> getFolders(@RequestParam(required = false) Integer parentId) {
        return parentId == null ? repo.findRootChildren() : repo.findChildren(parentId);
    }

    @PostMapping()
    public void addFolder(@RequestBody Folder folder){

    }

    @PutMapping()
    public void updateFolder(@RequestParam Folder folder) {

    }

    @DeleteMapping()
    public void deleteFolder(@RequestParam Folder folder) {

    }
}
