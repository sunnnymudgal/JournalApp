package com.app.controller;

import com.app.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean add(@RequestBody JournalEntry entry){
        journalEntries.put(entry.getId(),entry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @PutMapping("/update/{myId}")
    public JournalEntry update(@PathVariable Long myId, @RequestBody JournalEntry entry){
        return journalEntries.put(myId, entry);
    }

    @PutMapping("/delete/{myId}")
    public JournalEntry delete(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

}
