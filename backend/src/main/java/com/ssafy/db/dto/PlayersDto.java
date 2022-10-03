/**
 * 
 */
package com.ssafy.db.dto;

import com.ssafy.db.entity.Batters;
import com.ssafy.db.entity.Pitchers;

import lombok.Getter;
import lombok.Setter;

/**

  * @FileName : BattersDto.java
  * @Project : mlb-analysis-project
  * @Date : 2022. 9. 27 
  * @작성자 : 김동우
  * @변경이력 :
  * @프로그램 설명 : custom team 꾸릴 때 만드는 dto
  */

@Getter
@Setter
public class PlayersDto {
	String name;
	int season;
	int playerUid;
	String league;
	String teamName;
	String position;
	float indicator;
	
	public static PlayersDto of(Batters batters) {
		PlayersDto b = new PlayersDto();
		b.setPlayerUid(batters.getPlayerUid());
		b.setName(batters.getName());
		b.setLeague(batters.getLeague());
		b.setSeason(batters.getSeason());
		b.setTeamName(batters.getTeamName());
		// 여기서 타율 계산
		float batAvg = (batters.getLeftHitNum()+batters.getRightHitNum()+batters.getLeftTwobHitNum()+batters.getRightTwobHitNum()+batters.getLeftThreebHitNum()+batters.getRightThreebHitNum()+batters.getLeftHrNum()+batters.getRightHrNum())/(float)(batters.getLeftAtBatNum()+batters.getRightAtBatNum());
		b.setIndicator(batAvg);
		return b;
	}
	
	public static PlayersDto of(Pitchers pitchers) {
		PlayersDto b = new PlayersDto();
		b.setPlayerUid(pitchers.getPlayerUid());
		b.setName(pitchers.getName());
		b.setLeague(pitchers.getLeague());
		b.setSeason(pitchers.getSeason());
		b.setTeamName(pitchers.getTeamName());
		// 여기서 타율 계산
//		float era = Math.round(((float)(pitchers.getLeftEr() + pitchers.getRightEr())*9*1000)/(pitchers.getLeftInningNum() + pitchers.getRightInningNum()))/(float)1000;
		float era1 = Math.round(((float)(pitchers.getLeftEr() + pitchers.getRightEr())*9*1000*3)/(pitchers.getLeftOutNum() + pitchers.getRightOutNum()))/(float)1000;
		
		b.setIndicator(era1);
		return b;
	}
}