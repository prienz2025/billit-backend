package com.billit.domain.users.entity;

import com.billit.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class User extends BaseEntity {

  private String email;

  private String password;

  private String profileImage;

  private String nickname;

  private String token;

  @Default
  private Role role = Role.USER;

  @Default
  private ProviderType providerType = ProviderType.LOCAL;

  private User(String email, String password, String profileImage, String nickname, String token,
      Role role, ProviderType providerType) {
    this.email = email;
    this.password = password;
    this.profileImage = profileImage;
    this.nickname = nickname;
    this.token = token;
    this.role = role;
    this.providerType = providerType;
  }

  public static User createUser(String email, String password, String profileImage) {
    return User.builder().email(email).password(password).profileImage(profileImage).build();
  }

  public void changePassword(String newPassword) {
    this.password = newPassword;
  }

  public void changeNickname(String newNickname) {
    this.nickname = newNickname;
  }

  public void changeProfileImage(String newProfileImage) {
    this.profileImage = newProfileImage;
  }

  public boolean isNotDefaultProfileImage(String defaultProfileImage) {
    return !this.profileImage.equals(defaultProfileImage);
  }

}