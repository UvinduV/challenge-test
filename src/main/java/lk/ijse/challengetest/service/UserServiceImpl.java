package lk.ijse.challengetest.service;

import jakarta.transaction.Transactional;
import lk.ijse.challengetest.dao.UserDao;
import lk.ijse.challengetest.dto.UserDTO;
import lk.ijse.challengetest.entity.UserEntity;
import lk.ijse.challengetest.exeption.DataPersistExeption;
import lk.ijse.challengetest.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void createUser(UserDTO userDTO) {
        System.out.println(userDTO);
        UserEntity createUser = userDao.save(mapping.toUserEntity(userDTO));
        if (createUser == null) {
            throw new DataPersistExeption("User not saved");
        }

    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity>allUsers=userDao.findAll();
        return mapping.asUserDtoLIst(allUsers);
    }

}
