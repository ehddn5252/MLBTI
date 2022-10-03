package com.ssafy.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.service.BaseballPlayerService;
import com.ssafy.api.service.ScheduleService;
import com.ssafy.db.entity.BaseballPlayers;
import com.ssafy.db.entity.Schedules;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**

* @FileName : BaseballPlayerController.java
* @Date : 2022. 9. 20
* @작성자 : 인예림
* @변경이력 : x
* @프로그램 설명 : 선수 API 요청 처리를 위한 컨트롤러 정의.
*/
@Api(value = "선수 API", tags = {"StartingPlayer"})
@RestController
@RequestMapping("/api/starting_player")
public class StartingPlayerController {
	@Autowired
	BaseballPlayerService baseballPlayerService;
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/")
	@ApiOperation(value = "선수 상세 조회", notes = "<strong>uid</strong>를 통해 선수를 상세조회한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 404, message = "선수 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<BaseballPlayers> getStartingPlayerByDateAndTeamUid(
			@ApiParam(value="team_uid", required = true) @RequestParam("team_uid") int team_uid,
			@ApiParam(value="date", required = true) @RequestParam("date") String date
			) {
		String processedDate = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8);
		System.out.println(processedDate);
		List<Schedules> s = (ArrayList<Schedules>) scheduleService.getScheduleByDate(processedDate);
		/*
		 * 1. schedule에서 그날 경기가 있는 team_id list 가져오기
		   2. https://statsapi.mlb.com/api/v1/teams/143/roster?date=03/10/2022
		   2. 위의 api에서 팀 id와 date를 넣어서 그날 그팀 선발 명단 player_uid를 가져옴.
		   3. front 에서는 가져온 player_uid 리스트를 simulation에 보냄
		   4. back은 player_uid 들을 가져와서 시뮬 돌림
		 */
		

		return null;
	}
	
}
