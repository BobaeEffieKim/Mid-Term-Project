package co.edu.vo;

public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String writeDate;
	private int visitCnt;
	
	public BoardVO() {}

	public BoardVO(int seq, String title, String writer, String content, String writeDate, int visitCnt) {
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writeDate = writeDate;
		this.visitCnt = visitCnt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public int getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}
	
	
	
	
	
	
}
