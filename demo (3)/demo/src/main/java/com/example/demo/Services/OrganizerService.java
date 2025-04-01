package com.example.demo.Services;

import com.example.demo.entity.Organizer;
import com.example.demo.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Organizer organizer = organizerRepository.findById(id).orElse(null);
        if (organizer != null) {
            organizer.setName(organizerDetails.getName());
            return organizerRepository.save(organizer);
        }
        return null;
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}