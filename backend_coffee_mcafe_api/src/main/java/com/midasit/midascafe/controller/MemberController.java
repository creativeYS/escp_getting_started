package com.midasit.midascafe.controller;

import com.midasit.midascafe.controller.rqrs.RegisterMemberRq;
import com.midasit.midascafe.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Member Controller")
@RestController
@RequestMapping("member")
@RequiredArgsConstructor  // 생성자 주입
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "멤버 등록", description = "새로운 멤버를 등록합니다.")
    @PostMapping
    public ResponseEntity<String> registerMember(@RequestBody @Valid RegisterMemberRq registerMemberRq) {
        int statusCode = memberService.registerMember(registerMemberRq);

        if (statusCode == 201) {
            return ResponseEntity.ok("멤버 등록 성공");
        } else if (statusCode == 404) {
            return new ResponseEntity<>("셀이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        } else if (statusCode == 409) {
            return new ResponseEntity<>("이미 등록된 멤버입니다.", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>("멤버 등록에 실패하였습니다.", HttpStatus.valueOf(statusCode));
        }
    }
}