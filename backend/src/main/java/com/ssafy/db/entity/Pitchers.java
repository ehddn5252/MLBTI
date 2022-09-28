/**
 * 
 */
package com.ssafy.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**

  * @FileName : Batters.java
  * @Project : mlb-analysis-project
  * @Date : 2022. 9. 22 
  * @작성자 : 김동우
  * @변경이력 :
  * @프로그램 설명 :
  */

@Entity
@Setter
@Getter
public class Pitchers {
	
//	@OneToOne
//	@JoinColumn(name="player_uid")
//	BaseballPlayers baseballPlayer;
	
	@Id
	int playerUid;
	
	Integer season;
	
	@OneToOne
	@JoinColumn(name="team_uid")
	Teams team;
	
	String league;
	String teamName;
	String name;
	String position;
	Integer leftHitNum;
	Integer rightHitNum;
	Integer leftTwobHitNum;
	Integer rightTwobHitNum;
	Integer leftThreebHitNum;
	Integer rightThreebHitNum;
	Integer leftHrNum;
	Integer rightHrNum;
	Integer leftPaNum;
	Integer rightPaNum;
	Integer leftEr;
	Integer rightEr;
	Integer leftNotMyEr;
	Integer rightNotMyEr;
	Integer leftGameNum;
	Integer rightGameNum;
	Integer leftBbNum;
	Integer rightBbNum;
	Integer leftAoNum;
	Integer rightAoNum;
	Integer leftDpNum;
	Integer rightDpNum;
	Integer leftIbbNum;
	Integer rightIbbNum;
	Integer leftInningNum;
	Integer rightInningNum;	
	String playerWeatherTmi;
	Float average;
	Float standardDeviation;
	String education;

}
