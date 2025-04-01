package com.example.demo.Services;

import com.example.demo.entity.Venue;
import com.example.demo.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Venue getVenueById(Long id) {
        return venueRepository.findById(id).orElse(null);
    }

    public Venue updateVenue(Long id, Venue venueDetails) {
        Venue venue = venueRepository.findById(id).orElse(null);
        if (venue != null) {
            venue.setName(venueDetails.getName());
            venue.setLocation(venueDetails.getLocation());
            venue.setCapacity(venueDetails.getCapacity());
            return venueRepository.save(venue);
        }
        return null;
    }

    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }
}