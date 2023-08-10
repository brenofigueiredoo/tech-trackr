package com.breno.techtrackr.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.breno.techtrackr.dto.TechnologiesDto;
import com.breno.techtrackr.exception.AppException;
import com.breno.techtrackr.model.Technologies;
import com.breno.techtrackr.model.User;
import com.breno.techtrackr.repository.TechnologiesRepository;
import com.breno.techtrackr.repository.UserRepository;

@Service
public class TechnologiesService {

    private final TechnologiesRepository technologiesRepository;
    private final UserRepository userRepository;

    public TechnologiesService(TechnologiesRepository technologiesRepository, UserRepository userRepository) {
        this.technologiesRepository = technologiesRepository;
        this.userRepository = userRepository;
    }

    private void existsTechnologieByName(final TechnologiesDto techData) {

        if (technologiesRepository.existsTechnologieByName(techData.getName())) {
            throw new AppException("Name Already Registered", HttpStatus.CONFLICT);
        }

    }

    public Technologies createTechnologie(final TechnologiesDto techData, final long userId) {

        existsTechnologieByName(techData);

        final User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        final Technologies newTech = new Technologies(foundUser, techData.getName(), techData.getStatus());

        return technologiesRepository.save(newTech);
    }

    public List<Technologies> readTechnologies(long userId) {
        return userRepository.findTechnologiesByUserId(userId);
    }
}
