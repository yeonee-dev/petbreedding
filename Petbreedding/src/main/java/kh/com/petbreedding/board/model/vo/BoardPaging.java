package kh.com.petbreedding.board.model.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BoardPaging {

	private List<Board> list;
	private int currentPage;	
	private int perPage;		//TODO 한 페이지 당 보일 글 갯수
	private int totalCount;		
	
	public List<Board> getList() {
		return list;
	}
	public void setList(List<Board> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
}
