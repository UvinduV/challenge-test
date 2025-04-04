package lk.ijse.challengetest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String uId;
    private String name;
    private String email;
    private String phoneNo;
    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;
}
