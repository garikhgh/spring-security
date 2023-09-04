package am.hgh.springsecurity.dummy;

import am.hgh.springsecurity.domain.UserEntity;
import am.hgh.springsecurity.repository.UserRepository;
import am.hgh.springsecurity.security.EncriptionAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class FakeUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void create() {
        LongStream.rangeClosed(0, 5).forEach(id -> {
            var d = UserEntity.builder()
//                    .id(id)
                    .userName("Valiko_" + id)
                    .authority("read")
                    .password(passwordEncoder.encode("valiko_" + id))
                    .algorithm(EncriptionAlgorithm.BCRYPT)
                    .build();
            userRepository.save(d);
        });
    }
}
