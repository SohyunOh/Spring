package ex05.collection;

import java.util.List;
import java.util.Map;

public class Custom {

	//멤버변수로 컬렉션 타입
	private List<String> lists;
	private List<MemberVO> vo;
	private Map<String, Object> maps;
	
	//getter, setter
	public List<String> getLists() {
		return lists;
	}
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	public List<MemberVO> getVo() {
		return vo;
	}
	public void setVo(List<MemberVO> vo) {
		this.vo = vo;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	
	
	
}
