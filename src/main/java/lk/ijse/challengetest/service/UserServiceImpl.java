package lk.ijse.challengetest.service;

import jakarta.transaction.Transactional;
import lk.ijse.challengetest.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Override
    public void createUser(UserDTO userDTO) {
        System.out.println(userDTO);

    }

}
