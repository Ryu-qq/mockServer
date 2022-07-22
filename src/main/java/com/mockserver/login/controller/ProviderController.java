package com.mockserver.login.controller;

import com.mockserver.login.CookieUtil;
import com.mockserver.login.dto.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static com.mockserver.login.AuthToken.createAuthToken;


@Controller
@RequestMapping()
@Slf4j
public class ProviderController {

    @GetMapping("oauth/authorize")
    public String redirectLoginPage3(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute AuthorizationTokenRequestDto authorizationTokenRequestDto,
                                     RedirectAttributes redirectAttributes){

        String[] codeList = {"code"};
        String[] stateList = {authorizationTokenRequestDto.getState()};

        System.out.println("authorizationTokenRequestDto = " + authorizationTokenRequestDto.getClient_id());

        redirectAttributes.addAttribute("code", codeList);
        redirectAttributes.addAttribute("state", stateList);

        Optional<Cookie> oauth2_auth_request = CookieUtil.getCookie(request, "oauth2_auth_request");

        response.addCookie(oauth2_auth_request.get());

        return "redirect:http://localhost:8089/login/oauth2/code/mock";
    }

    @PostMapping("oauth/token")
    public ResponseEntity<HashMap<String, Object>> generateToken4(HttpServletRequest request){

        LocalDateTime localDateTime = LocalDateTime.now().plusDays(3);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

        LocalDateTime localDateTime2 = LocalDateTime.now().plusDays(5);
        Instant instant2 = localDateTime2.atZone(ZoneId.systemDefault()).toInstant();

        String mock = createAuthToken("mock", Date.from(instant),Keys.hmacShaKeyFor("926D96C90030DD58429D2751AC1BDBBC".getBytes()));
        String mock2 = createAuthToken("mock", Date.from(instant2), Keys.hmacShaKeyFor("926D96C90030DD58429D2751AC1BDBBC".getBytes()));

        HashSet<String> set = new HashSet<>();

        set.add("profile_nickname");
        set.add("account_email");


        HashMap<String, Object> map = new HashMap<>();
        map.put("token_type", "bearer");
        map.put("expires_in", instant);
        map.put("access_token",mock);
        map.put("refresh_token", mock2);
        map.put("refresh_token_expires_in", instant2);
        map.put("scope","profile_nickname account_email");

        return ResponseEntity.ok().body(map);

    }

}
