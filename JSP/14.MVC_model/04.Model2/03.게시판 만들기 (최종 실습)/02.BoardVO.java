package kr.co.koo.izone.board.model;

import java.sql.*;

public class BoardVO {
	
	//bId,bName,bTitle,bContent,
	//bDate(java.sql.Timestamp),bHit
	//6개의 필드를 가진 VO클래스를 작성하세요.
	private int bId;
	private String bName;
	private String bTitle;
	private String bContent;
	private Timestamp bDate;
	private int bHit;
	
	public BoardVO() {}
	
	public BoardVO(int bId, String bName, String bTitle, String bContent, Timestamp bDate, int bHit) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	@Override
	//객체가 제대로 생성됐는지 확인하는 코드
	//우클릭 - source - generate toString으로 만든다.
	public String toString() {
		return "BoardVO [bId=" + bId + ", bName=" + bName + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bDate="
				+ bDate + ", bHit=" + bHit + "]";
	}
	
	

}
