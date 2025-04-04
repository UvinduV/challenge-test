package lk.ijse.challengetest.service;

import lk.ijse.challengetest.dto.UserDTO;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
}
