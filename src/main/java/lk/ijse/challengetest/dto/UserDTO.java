package lk.ijse.challengetest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String uId;
    private String name;
    private String email;
    private String phoneNo;
    private String profilePic;
}
