package am.hgh.springsecurity.service;

import am.hgh.springsecurity.domain.UserEntity;
import am.hgh.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUseByUserName(String userName) {
        return userRepository.findUserEntitiesByUserName(userName);
    }
}
