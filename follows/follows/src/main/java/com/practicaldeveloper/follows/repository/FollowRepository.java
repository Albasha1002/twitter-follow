package com.practicaldeveloper.follows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.practicaldeveloper.follows.model.Follow;

@Repository
@EnableJpaRepositories
public interface FollowRepository extends JpaRepository<Follow, Integer> {
    // You can define custom query methods here if needed
	
	 @Query("SELECT f FROM Follow f WHERE f.follower.userId = :followerId")
	 Follow findFollowByFollowerId(int followerId);
//	Follow findByFollowerAndFollowing(int followerId, int followingId);

	
}

