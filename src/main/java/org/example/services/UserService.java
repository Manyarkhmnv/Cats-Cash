package org.example.services;

import lombok.AllArgsConstructor;
import org.example.dao.OwnerRepository;
import org.example.dao.UserRepository;
import org.example.models.Cats;
import org.example.models.Owners;
import org.example.models.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final OwnerRepository ownerRepository;
    @Transactional
    public void saveUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        Owners owner = new Owners();
        owner.setFirst_name(user.getFirst_name());
        owner.setLast_name(user.getLast_name());
        owner.setOwner_id(user.getOwner_id());
        ownerRepository.save(owner);
    }

}
