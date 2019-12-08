package com.javainuse.service.impl;

import com.javainuse.model.DAOUser;
import com.javainuse.repository.UserDao;
import com.javainuse.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserDao userRepository;
    @Override
    public DAOUser findUserById(Long id) {
        return userRepository.findDAOUserById(id);
    }

    @Override
    public DAOUser updateProfile(DAOUser profileToUpdate) {
        DAOUser profile = userRepository.findDAOUserById(profileToUpdate.getId());
        if (profile != null) {
            if (profileToUpdate.getFirstName() != null) {
                profile.setFirstName(profileToUpdate.getFirstName());
            }
            if (profileToUpdate.getLastName() != null) {
                profile.setLastName(profileToUpdate.getLastName());
            }
            if (profileToUpdate.getEmail() != null) {
                profile.setEmail(profileToUpdate.getEmail());
            }
            if (profileToUpdate.getPhoneNumber() != null) {
                profile.setPhoneNumber(profileToUpdate.getPhoneNumber());
            }
            if (profileToUpdate.getUrlprofilepicture() != null) {
                profile.setUrlprofilepicture(profileToUpdate.getUrlprofilepicture());
            }
            if(profileToUpdate.getTelEntreprise() != null) {
                profile.setTelEntreprise(profileToUpdate.getTelEntreprise());
            }
            if(profileToUpdate.getEntreprise() != null) {
                profile.setEntreprise(profileToUpdate.getEntreprise());
            }
            if (profileToUpdate.getEmailEntreprise() != null) {
                profile.setEmailEntreprise(profileToUpdate.getEmailEntreprise());
            }
            if (profileToUpdate.getAdresseEntreprise() != null) {
                profile.setAdresseEntreprise(profileToUpdate.getAdresseEntreprise());
            }
            return userRepository.save(profile);
        }
        return null;
    }
}
