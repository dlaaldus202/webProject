package com.web.page.login.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.querydsl.codegen.utils.StringUtils;
import com.web.cmmn.cocode.ResponseCode;
import com.web.cmmn.util.StringUtil;
import com.web.page.login.domin.UserVo;
import com.web.page.login.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("user")
public class LoginController {
	
	//Path지정 
	private static final String FOLER_PATH = "/Page/Login/";

	
	@Autowired
	private UserService userService;
	
	@GetMapping(FOLER_PATH + "login.do")
	public String login( @ModelAttribute("searchVO") UserVo user, Model model) throws Exception{
		/*User findUser = userService.getUser(user);
		
		if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
			model.addAttribute("user", findUser);
			return "forward:getBoardList";
		} */
		return FOLER_PATH + "login";		
	}
	
	@ResponseBody
	@PostMapping("/login.do")
	public HashMap<String, Object> login( @RequestParam(value ="userId") final String userId, @RequestParam(value ="userPwd")  final String userPwd, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String clientIp = StringUtil.getClientIp(request);
		HashMap<String, Object> returnMap = new HashMap<>();
		
		// 비즈니스 로직 수행
        boolean success = true; // 성공 여부에 따라 설정
        String returnCode = "S001"; // 리턴 코드 설정
        String returnMsg = "성공하였습니다."; // 리턴 메시지 설정
		
		UserVo user = new UserVo();
		user.setId(userId);
		user.setPwd(userPwd);
		
		log.info("================================");
        log.info("userId :"+ userId);
        log.info("userPwd :"+ userPwd);
		log.info("================================");
		

		UserVo findUser = userService.getUser(user);
		if (findUser != null && findUser.getPwd().equals(user.getPwd())) {
	        // 로그인 성공 시
	        returnMap.put("success", true);
	        returnMap.put("returnCode", ResponseCode.S001.name());
	        returnMap.put("returnMsg", ResponseCode.S001.getMessage());
	        
	        // 다른 필요한 데이터를 추가로 반환하려면 여기에 추가
	    } else {
	        // 로그인 실패 시
	        returnMap.put("success", false);
	        returnMap.put("returnCode", ResponseCode.E002.name());
	        returnMap.put("returnMsg", ResponseCode.E002.getMessage());
	    }
		
		
		
		
        return returnMap;	
	}
	
	/*

	@GetMapping("/loginView")
	public String loginView() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}
	*/
}









