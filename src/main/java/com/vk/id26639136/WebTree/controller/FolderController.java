package com.vk.id26639136.WebTree.controller;

import com.vk.id26639136.WebTree.domain.Folder;
import com.vk.id26639136.WebTree.repo.FolderRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/folders")
public class FolderController {
    public FolderController(FolderRepo repo) {
        this.repo = repo;
    }

    private FolderRepo repo;

    @GetMapping()
    public List<Folder> getFolders(@RequestParam(required = false) Integer parentId) throws InterruptedException {
        if (parentId == null) return repo.findRootChildren();
        Thread.sleep(2000);
        return repo.findChildren(parentId);
    }

    @PostMapping()
    public Integer addFolder(@RequestBody Folder folder){
        repo.save(folder);
        return folder.getId();
    }

    @PutMapping()
    public void updateFolder(@RequestBody Folder folder) throws Exception{
        if ( !repo.existsById(folder.getId()) )
            throw new Exception("Folder does not exists");
        repo.save(folder);
    }

    @DeleteMapping()
    public void deleteFolder(@RequestParam Folder folder) {
        Deque<Folder> subFolders = new ArrayDeque<>();
        subFolders.add(folder);
        while (!subFolders.isEmpty()) {
            Folder f = subFolders.removeLast();
            repo.delete(f);
            subFolders.addAll(repo.findChildren(f.getId()));
        }
    }
}
