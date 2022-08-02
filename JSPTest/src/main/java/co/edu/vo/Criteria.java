package co.edu.vo;

public class Criteria {

	   private int pageNum;
	   private int amount;
	   
	   public Criteria() {
	      this(1, 10);   //1페이지당 보여주고싶은내용 10개씩
	   }
	   
	   public Criteria(int pageNum, int amount) {
	      this.pageNum = pageNum;
	      this.amount = amount;
	   }

	   public int getPageNum() {
	      return pageNum;
	   }

	   public void setPageNum(int pageNum) {
	      this.pageNum = pageNum;
	   }

	   public int getAmount() {
	      return amount;
	   }

	   public void setAmount(int amount) {
	      this.amount = amount;
	   }

	   @Override
	   public String toString() {
	      return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	   }
	   
	
}
