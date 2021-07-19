package kh.com.petbreedding.board.model.vo;

public class OftenQna {
	private String of_num;
	private String of_title;
	private String of_cont;
	private int of_type;
	@Override
	public String toString() {
		return "OftenQna [of_num=" + of_num + ", of_title=" + of_title + ", of_cont=" + of_cont + ", of_type=" + of_type
				+ "]";
	}
	public String getOf_num() {
		return of_num;
	}
	public String getOf_title() {
		return of_title;
	}
	public String getOf_cont() {
		return of_cont;
	}
	public int getOf_type() {
		return of_type;
	}
	public void setOf_num(String of_num) {
		this.of_num = of_num;
	}
	public void setOf_title(String of_title) {
		this.of_title = of_title;
	}
	public void setOf_cont(String of_cont) {
		this.of_cont = of_cont;
	}
	public void setOf_type(int of_type) {
		this.of_type = of_type;
	}
	
	
	
}
