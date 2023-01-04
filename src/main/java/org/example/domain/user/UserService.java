package org.example.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;


    @Transactional(readOnly = true)
    public User findByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. email=" + userEmail));
    }

    public void save(User userBase) {
        userRepository.save(userBase);
    }
}
