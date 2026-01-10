package com.tysystems.pms.domain.common.constant;

/**
 * 파일명 : Constants.java
 * 설  명 : 상수값 정의
 * 작성자 : 장근수
 * 작성일 : 2025. 04. 14.
 * 
 * 수정 이력 : 
 * 
 * 기타 사항 : 
 *
 * COPYRIGHTS DevJang. ALL RIGHTS RESERVED.
 *
 */
public class Constants {
	/**
	 * spring-MVC JSON view name
	 */
	public static final String BBS_SCRN_ID = "CM_BBS";
	
	/**
	 * 게시판 조회 URL
	 */
	public static final String BBS_URL = "/cm/bbs/bbsListLink.do";
	
	/**
	 * 게시글 조회 서비스
	 */
	public static final String INQUIRY_EVENT_URI = "/cm/bbs/inquiryAtclList.tx";
	/**
	 * 조회 EVENT_ID
	 */
	public static final String INQUIRY_EVENT_ID = "Q01";
	
	/**
	 * 조회 EVENT_NM
	 */
	public static final String INQUIRY_EVENT_NM = "조회";
	
	/**
	 * 조회 EVENT_CD
	 */
	public static final String INQUIRY_EVENT_CD = "Q";
	
	/**
	 * 게시판 (등록)저장 URI
	 */
	public static final String SAVE_EVENT_URI = "/cm/bbs/bbsReg.do";
	/**
	 * 저장 EVENT_ID
	 */
	public static final String SAVE_EVENT_ID = "S01";
	/**
	 * 저장 EVENT_CD
	 */
	public static final String SAVE_EVENT_CD = "S";
	
	/**
	 * 저장 EVENT_NM
	 */
	public static final String SAVE_EVENT_NM = "저장";
	
	/**
	 * 상태값 Y
	 */
	public static final String Y_STATUS = "Y";
	
	/**
	 * 상태값 N
	 */
	public static final String N_STATUS = "N";
	
	/**
	 * 사용자 구분 기본 값 - STF(직원)
	 */
	public static final String DEFAULT_USR_TYP_CD = "STF";
	/**
	 * 기술 등급 기본 값 - BIG(초급)
	 */
	public static final String DEFAULT_TECH_GRD_CD = "BIG";
	/**
	 * 투입구분 기본 값 - CB(투입전)
	 */
	public static final String DEFAULT_PUT_STA_CD = "CB";
	
	/**
	 * 관리자 권한 SU
	 */
	public static final String ADMIN_AUTH = "SU";
	
	
	
}
