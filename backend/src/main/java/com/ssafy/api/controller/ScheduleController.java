/**
 * 
 */
package com.ssafy.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.response.BaseRes;
import com.ssafy.api.service.ScheduleService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Schedules;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**

  * @FileName : ScheduleController.java
  * @Project : mlb-analysis-project
  * @Date : 2022. 9. 22 
  * @작성자 : 김동우
  * @변경이력 :
  * @프로그램 설명 :
  */

@Api(value = "스케줄 API", tags = {"Schedule"})
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping("/{gameId}")
	@ApiOperation(value = "gameId로 스케줄 가져오기", notes = "<strong>gameId를 통해 스케줄을 가져온다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<BaseRes> register(
			@PathVariable @ApiParam(value="gameId", required = true)int gameId) {
		// uid, email 중 무엇을 기준으로 찾을지
		Optional<Schedules> schedule = scheduleService.getScheduleByGameId(gameId);
		
		if(!schedule.isPresent()) {
			return ResponseEntity.status(404).body(BaseRes.of(404, "failed"));
		}
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(schedule.get().toString());
		return ResponseEntity.status(200).body(BaseRes.of(200, "Success",schedule.get()));
	}
}
