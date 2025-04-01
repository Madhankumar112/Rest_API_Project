package com.example.demo.Services;

import com.example.demo.entity.Conference;
import com.example.demo.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll(); // Retrieves all conferences
    }

    public Conference getConferenceById(Long id) {
        return conferenceRepository.findById(id).orElse(null); // Handle not found case appropriately
    }

    public Conference createConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public Conference updateConference(Long id, Conference conference) {
        conference.setId(id); // Ensure the ID is set for the update
        return conferenceRepository.save(conference);
    }

    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }

    public Page<Conference> getConferences(Pageable pageable) {
        return conferenceRepository.findAll(pageable);
    }
}