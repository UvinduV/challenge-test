package lk.ijse.challengetest.util;

import lk.ijse.challengetest.dto.UserDTO;
import lk.ijse.challengetest.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> asUserDtoLIst(List<UserEntity> userEntityList){
        return modelMapper.map(userEntityList, new TypeToken<List<UserDTO>>() {}.getType());

    }
}
