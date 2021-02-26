package gradle_study.dto;

public class Title {
	private int tNo;
	private String tName;

	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Title(int tNo) {
		super();
		this.tNo = tNo;
	}

	public Title(int no, String name) {
		this.tNo = no;
		this.tName = name;
	}

	public int getNo() {
		return tNo;
	}

	public void setNo(int no) {
		this.tNo = no;
	}

	public String getName() {
		return tName;
	}

	public void setName(String name) {
		this.tName = name;
	}

	@Override
	public String toString() {
		return String.format("Title [%s, %s]", tNo, tName);
	}

}
