package com.practicaldeveloper.follows.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.practicaldeveloper.follows.dto.FollowDto;
import com.practicaldeveloper.follows.model.Follow;
import com.practicaldeveloper.follows.repository.FollowRepository;



import java.util.ArrayList;
import java.util.List;

@Service
public class FollowService {
    
    private final FollowRepository followRepository;
    


    @Autowired
    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public List<FollowDto> getAllFollows() {
    	
    	List<Follow> follows= followRepository.findAll();
    	
    	List<FollowDto> followdetails=new ArrayList<>();
    	
    	
    	for(Follow follow:follows) {
    		System.out.println(follow);
    		System.out.println(follow.getFollower().getUserId());
    		FollowDto followdto =new FollowDto();
    		followdto.setFollowId(follow.getFollowId());
    		followdto.setFollower(follow.getFollower());
    		followdto.setFollowing(follow.getFollowing());
    		followdto.setFollowDate(follow.getFollowDate());
    		
    		followdetails.add(followdto);
    		
    }
    	
        return followdetails;
    }

    public Follow addFollow(Follow follow) {
        return followRepository.save(follow);
    }
    
    public void unfollowByFollowId(int followId) {
        followRepository.deleteById(followId);
    }

    public boolean isFollowed(int userId,int following) {
    	System.out.println(userId+"userId");
    	Follow follow=followRepository.findFollowByFollowerId(userId);
    	System.out.println(follow);
    	System.out.println(follow.getFollowing().getUserId());
    	System.out.println(following+"followung");
    	System.out.println(following==follow.getFollowing().getUserId());
    	if(following==follow.getFollowing().getUserId()) {
    		return true;
    	}
    	return false;
    }

    // Add other methods as needed
}

