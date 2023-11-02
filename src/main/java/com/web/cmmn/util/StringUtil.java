package com.web.cmmn.util;

import jakarta.servlet.http.HttpServletRequest;

public class StringUtil {
	/**
	 * Html 코드가 들어간 문서를 표시할때 태그에 손상없이 보이기 위한 메서드
	 */
	public static String checkHtmlView (final String strString) throws Exception{
		String strNew = "";
		StringBuffer strTxt = new StringBuffer("");
		
		char chrBuff;
		int len = strString.length();
		for(int i = 0;i<len;i++) {
			chrBuff = strString.charAt(i);
			
			switch (chrBuff) {
				case '<': 
					strTxt.append("&lt;");
					break;
				case '>': 
					strTxt.append("&gt;");
					break;
				case '"': 
					strTxt.append("&quot;");
					break;
				case '\'': 
					strTxt.append("&apos;");
					break;
				case 10: 
					strTxt.append("<br>");
					break;
				case ' ': 
					strTxt.append("&nbsp;");
					break;
				default:
					strTxt.append(chrBuff);
					break;		
			}
		}
		strNew = strTxt.toString();
		return strNew;
				
	}
	
	/**
	 * 인자로 받은 String이 null일 경우 ""로 리턴
	 */
	public static String nullString(String src) throws Exception{
		if(src == null || src.equals("null")||"".equals(src)|| " ".equals(src)) {
			return "";
		}else {
			src =checkHtmlView(src);
			return src.trim();
		}
			
	}
	
	
	/**
	 * Client Ip 확인 
	 * X-Forwarded-For :  IP 주소를 식별하기 위한 표준화된 헤더
	 * WL-Proxy-Client-IP: Oracle WebLogic Server에서 사용되는 헤더
	 * Proxy-Client-IP : Microsoft ISA Server 사용되는 헤더
	 */
	public static String getClientIp(final HttpServletRequest request) throws Exception{
		String clientIp = StringUtil.nullString(request.getHeader("X-Forwarded-For"));
		if(clientIp == null || clientIp.equals("")) {
			clientIp = StringUtil.nullString(request.getHeader("WL-Proxy-Client-IP"));
		}
		if(clientIp == null || clientIp.equals("")) {
			clientIp = StringUtil.nullString(request.getHeader("Proxy-Client-IP"));
		}
		if(clientIp == null || clientIp.equals("")) {
			clientIp = request.getRemoteAddr();
		}
		return clientIp.trim();
	}
	

}
