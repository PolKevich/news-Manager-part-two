package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "brief")
	private String brief;

	@Column(name = "content")
	private String content;

	@Column(name = "date")
	private String newsDate;

	public News() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		News that = (News) o;
		return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(brief, that.brief)
				&& Objects.equals(content, that.content) && Objects.equals(newsDate, that.newsDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, brief, content, newsDate);
	}

	@Override
	public String toString() {
		return "News{" + "id=" + id + ", title='" + title + '\'' + ", brief='" + brief + '\'' + ", content='" + content
				+ '\'' + ", newsDate='" + newsDate + '\'' + '}';
	}
}
