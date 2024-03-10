package admin_user.service;

import java.util.List;

import admin_user.dto.FollowedUser;
import admin_user.dto.TweetDto;
import admin_user.dto.UserDto;
import admin_user.model.User;

public interface UserService {
	
	User save (UserDto userDto);
	
	UserDto getTweetById(String email);
	
	UserDto getUserId(int userId);
	
	List<UserDto> getAllUser();
	
	
	public int getuserIdByEmail(String email);
	public List<FollowedUser> isFollowed(int userId);
	

}
