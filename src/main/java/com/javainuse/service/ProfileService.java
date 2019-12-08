package com.javainuse.service;

import com.javainuse.model.DAOUser;

public interface ProfileService {
    DAOUser findUserById(Long id);
    DAOUser updateProfile( DAOUser profileToUpdate);
}
