package kr.or.ddit.card.vo;

public class CardVO {
	private String card_id;
	private String card_name;
	
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	
	@Override
	public String toString() {
		return "CardVO [card_id=" + card_id + ", card_name=" + card_name + "]";
	}
	
	
}
