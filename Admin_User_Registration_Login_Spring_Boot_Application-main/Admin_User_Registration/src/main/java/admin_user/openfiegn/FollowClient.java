package admin_user.openfiegn;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import admin_user.dto.FollowDto;
import    admin_user.dto.UserDto;


@FeignClient(name = "follow-app", url = "http://localhost:8084", path = "/follows/")
public interface FollowClient {

    @PostMapping("/follow")
    public ResponseEntity<FollowDto> follow(@RequestParam UserDto follower, @RequestParam UserDto following);
    
    @GetMapping("/all")
    public List<FollowDto> getAllFollows();
    
    @GetMapping("/{userId}/{followingId}")
    public boolean isFollowed(@RequestParam int userId,@RequestParam int followingId);
    
}
