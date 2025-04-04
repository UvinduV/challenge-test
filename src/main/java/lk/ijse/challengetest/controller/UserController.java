package lk.ijse.challengetest.controller;

import lk.ijse.challengetest.dto.UserDTO;
import lk.ijse.challengetest.exeption.DataPersistExeption;
import lk.ijse.challengetest.service.UserService;
import lk.ijse.challengetest.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(
            @RequestPart("name") String name,
            @RequestPart("email") String email,
            @RequestPart("phoneNo") String phoneNo,
            @RequestPart("profilePic") MultipartFile profilePic
    ){

        String userId = AppUtil.generateUserId();
        String picToBase64="";
        try {
            byte[] bytesProPic = profilePic.getBytes();
            picToBase64= AppUtil.profilePicToBase64(bytesProPic);

            var buildUserDTO=new UserDTO();
            buildUserDTO.setUId(userId);
            buildUserDTO.setName(name);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPhoneNo(phoneNo);
            buildUserDTO.setProfilePic(picToBase64);

            userService.createUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }catch (DataPersistExeption e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> ListAllUsers(){
        return userService.getAllUsers();
    }
}


