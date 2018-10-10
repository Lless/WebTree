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
    public List<Folder> getFolders(@RequestParam(required = false) Integer parentId) throws InterruptedException {
        if (parentId == null) return repo.findRootChildren();
        Thread.sleep(2000);
        return repo.findChildren(parentId);
    }

    @PostMapping()
    public void addFolder(@RequestBody Folder folder){
    }

    @PutMapping()
    public void updateFolder(@RequestBody Folder folder) throws Exception{
        if ( !repo.existsById(folder.getId()) )
            throw new Exception("Folder does not exists");
        repo.save(folder);
    }

    @DeleteMapping()
    public void deleteFolder(@RequestParam Folder folder) {
        repo.delete(folder);
    }
}
