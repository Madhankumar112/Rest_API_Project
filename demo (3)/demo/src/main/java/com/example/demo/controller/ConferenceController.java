package com.example.demo.controller;

import com.example.demo.entity.Conference;
import com.example.demo.Services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/{id}")
    public Conference getConferenceById(@PathVariable Long id) {
        return conferenceService.getConferenceById(id);
    }

    @PostMapping
    public Conference createConference(@RequestBody Conference conference) {
        return conferenceService.createConference(conference);
    }

    @PutMapping("/{id}")
    public Conference updateConference(@PathVariable Long id, @RequestBody Conference conference) {
        return conferenceService.updateConference(id, conference);
    }

    @DeleteMapping("/{id}")
    public void deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
    }

    @GetMapping("/paged")
    public Page<Conference> getConferencesPaged(@PageableDefault(size = 10, sort = "startDate") Pageable pageable) {
        return conferenceService.getConferences(pageable);
    }
}