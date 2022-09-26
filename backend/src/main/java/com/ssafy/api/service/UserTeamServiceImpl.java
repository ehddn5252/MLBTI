package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.db.entity.BaseballPlayers;
import com.ssafy.db.entity.UserTeams;
import com.ssafy.db.entity.Users;
import com.ssafy.db.repository.UserTeamRepository;

/**

* @FileName : UserTeamServiceImpl.java
* @Date : 2022. 9. 21
* @작성자 : 인예림
* @변경이력 : x
* @프로그램 설명 : 유저팀 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
*/
@Service("userTeamService")
public class UserTeamServiceImpl implements UserTeamService{
	@Autowired
	UserTeamRepository userTeamRepository;
	
	@Override
	public UserTeams createUserTeam(Users user, BaseballPlayers baseballPlayer, String position) {
		UserTeams userTeam = new UserTeams();
		userTeam.setUser(user);
		userTeam.setBaseballPlayer(baseballPlayer);
		userTeam.setPosition(position);
		return userTeamRepository.save(userTeam);
	}

	@Override
	public void deleteUserTeamByUid(Integer uid) {
		userTeamRepository.deleteById(uid);
	}

	@Override
	public void deleteUserTeamByUserUid(Integer user_uid) {
		userTeamRepository.deleteAllByUserUid(user_uid);
	}
	
	@Override
	public List<UserTeams> getUserTeamByUserUid(Integer user_uid) {
		List<UserTeams> team_list = userTeamRepository.findAllByUserUid(user_uid);
		return team_list;
	}

	@Override
	public UserTeams updateUserTeam(Integer uid, BaseballPlayers baseballPlayer) {
		UserTeams userTeam = userTeamRepository.findById(uid).orElse(null);
		
		if(userTeam == null) {
			return null;
		}
		
		userTeam.setBaseballPlayer(baseballPlayer);
		return userTeamRepository.save(userTeam);
	}

}