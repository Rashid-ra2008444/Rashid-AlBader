package P3;

public class Chapter {
	private String title;
	private int pageCount;

	public Chapter(String title, int pageCount) {
		this.title = title;
		this.pageCount = pageCount;
	}

	public String getTitle() {
		return title;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return title + " (" + pageCount + " pages)";
	}
}
