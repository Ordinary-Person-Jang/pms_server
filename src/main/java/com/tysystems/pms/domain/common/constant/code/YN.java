/**
 * 파일명 : YN.java
 * 설  명 : 작업 유형 코드
 * 작성자 : 장근수
 * 작성일 : 2025. 04. 14.
 *
 * 수정 이력 :
 *
 * 기타 사항 :
 *
 * COPYRIGHTS DevJang. ALL RIGHTS RESERVED.
 */

package com.tysystems.pms.domain.common.constant.code;


public enum YN {
	// 사용
	Y("사용"),
	// 미사용
	N("미사용");
	
	private String krNm;
	
	private YN(String krNm) {
		this.krNm = krNm;
	}

    /**
     *
     * <pre>
     * 한글명을 얻음
     * </pre>
     *
     * @return
     */
	public String getKrNm() {
		return this.krNm;
	}

}
