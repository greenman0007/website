package com.coderme.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article")
public class Article implements java.io.Serializable {

	private static final long serialVersionUID = 7913500621009123108L;
	private Long id;
	private String articleTitle;
	private String articleAbstract;
	private String articleTags;
	private String articleAuthorEmail;
	private Integer articleCommentCount;
	private Integer articleViewCount;
	private String articleContent;
	private String articlePermalink;
	private String articleHadBeenPublished;
	private String articleIsPublished;
	private String articlePutTop;
	private Timestamp articleCreateDate;
	private Timestamp articleUpdateDate;
	private Double articleRandomDouble;
	private String articleSignId;
	private String articleCommentable;
	private String articleViewPwd;
	private String articleEditorType;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(String articleTitle, String articleAbstract,
			String articleTags, String articleAuthorEmail,
			Integer articleCommentCount, Integer articleViewCount,
			String articleContent, String articlePermalink,
			String articleHadBeenPublished, String articleIsPublished,
			String articlePutTop, Timestamp articleCreateDate,
			Timestamp articleUpdateDate, Double articleRandomDouble,
			String articleSignId, String articleCommentable,
			String articleViewPwd) {
		this.articleTitle = articleTitle;
		this.articleAbstract = articleAbstract;
		this.articleTags = articleTags;
		this.articleAuthorEmail = articleAuthorEmail;
		this.articleCommentCount = articleCommentCount;
		this.articleViewCount = articleViewCount;
		this.articleContent = articleContent;
		this.articlePermalink = articlePermalink;
		this.articleHadBeenPublished = articleHadBeenPublished;
		this.articleIsPublished = articleIsPublished;
		this.articlePutTop = articlePutTop;
		this.articleCreateDate = articleCreateDate;
		this.articleUpdateDate = articleUpdateDate;
		this.articleRandomDouble = articleRandomDouble;
		this.articleSignId = articleSignId;
		this.articleCommentable = articleCommentable;
		this.articleViewPwd = articleViewPwd;
	}

	/** full constructor */
	public Article(String articleTitle, String articleAbstract,
			String articleTags, String articleAuthorEmail,
			Integer articleCommentCount, Integer articleViewCount,
			String articleContent, String articlePermalink,
			String articleHadBeenPublished, String articleIsPublished,
			String articlePutTop, Timestamp articleCreateDate,
			Timestamp articleUpdateDate, Double articleRandomDouble,
			String articleSignId, String articleCommentable,
			String articleViewPwd, String articleEditorType) {
		this.articleTitle = articleTitle;
		this.articleAbstract = articleAbstract;
		this.articleTags = articleTags;
		this.articleAuthorEmail = articleAuthorEmail;
		this.articleCommentCount = articleCommentCount;
		this.articleViewCount = articleViewCount;
		this.articleContent = articleContent;
		this.articlePermalink = articlePermalink;
		this.articleHadBeenPublished = articleHadBeenPublished;
		this.articleIsPublished = articleIsPublished;
		this.articlePutTop = articlePutTop;
		this.articleCreateDate = articleCreateDate;
		this.articleUpdateDate = articleUpdateDate;
		this.articleRandomDouble = articleRandomDouble;
		this.articleSignId = articleSignId;
		this.articleCommentable = articleCommentable;
		this.articleViewPwd = articleViewPwd;
		this.articleEditorType = articleEditorType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "articleTitle", nullable = false)
	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	@Column(name = "articleAbstract", nullable = false, length = 65535)
	public String getArticleAbstract() {
		return this.articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	@Column(name = "articleTags", nullable = false, length = 65535)
	public String getArticleTags() {
		return this.articleTags;
	}

	public void setArticleTags(String articleTags) {
		this.articleTags = articleTags;
	}

	@Column(name = "articleAuthorEmail", nullable = false)
	public String getArticleAuthorEmail() {
		return this.articleAuthorEmail;
	}

	public void setArticleAuthorEmail(String articleAuthorEmail) {
		this.articleAuthorEmail = articleAuthorEmail;
	}

	@Column(name = "articleCommentCount", nullable = false)
	public Integer getArticleCommentCount() {
		return this.articleCommentCount;
	}

	public void setArticleCommentCount(Integer articleCommentCount) {
		this.articleCommentCount = articleCommentCount;
	}

	@Column(name = "articleViewCount", nullable = false)
	public Integer getArticleViewCount() {
		return this.articleViewCount;
	}

	public void setArticleViewCount(Integer articleViewCount) {
		this.articleViewCount = articleViewCount;
	}

	@Column(name = "articleContent", nullable = false, length = 16777215)
	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	@Column(name = "articlePermalink", nullable = false)
	public String getArticlePermalink() {
		return this.articlePermalink;
	}

	public void setArticlePermalink(String articlePermalink) {
		this.articlePermalink = articlePermalink;
	}

	@Column(name = "articleHadBeenPublished", nullable = false, length = 1)
	public String getArticleHadBeenPublished() {
		return this.articleHadBeenPublished;
	}

	public void setArticleHadBeenPublished(String articleHadBeenPublished) {
		this.articleHadBeenPublished = articleHadBeenPublished;
	}

	@Column(name = "articleIsPublished", nullable = false, length = 1)
	public String getArticleIsPublished() {
		return this.articleIsPublished;
	}

	public void setArticleIsPublished(String articleIsPublished) {
		this.articleIsPublished = articleIsPublished;
	}

	@Column(name = "articlePutTop", nullable = false, length = 1)
	public String getArticlePutTop() {
		return this.articlePutTop;
	}

	public void setArticlePutTop(String articlePutTop) {
		this.articlePutTop = articlePutTop;
	}

	@Column(name = "articleCreateDate", nullable = false, length = 19)
	public Timestamp getArticleCreateDate() {
		return this.articleCreateDate;
	}

	public void setArticleCreateDate(Timestamp articleCreateDate) {
		this.articleCreateDate = articleCreateDate;
	}

	@Column(name = "articleUpdateDate", nullable = false, length = 19)
	public Timestamp getArticleUpdateDate() {
		return this.articleUpdateDate;
	}

	public void setArticleUpdateDate(Timestamp articleUpdateDate) {
		this.articleUpdateDate = articleUpdateDate;
	}

	@Column(name = "articleRandomDouble", nullable = false, precision = 22, scale = 0)
	public Double getArticleRandomDouble() {
		return this.articleRandomDouble;
	}

	public void setArticleRandomDouble(Double articleRandomDouble) {
		this.articleRandomDouble = articleRandomDouble;
	}

	@Column(name = "articleSignId", nullable = false)
	public String getArticleSignId() {
		return this.articleSignId;
	}

	public void setArticleSignId(String articleSignId) {
		this.articleSignId = articleSignId;
	}

	@Column(name = "articleCommentable", nullable = false, length = 1)
	public String getArticleCommentable() {
		return this.articleCommentable;
	}

	public void setArticleCommentable(String articleCommentable) {
		this.articleCommentable = articleCommentable;
	}

	@Column(name = "articleViewPwd", nullable = false, length = 100)
	public String getArticleViewPwd() {
		return this.articleViewPwd;
	}

	public void setArticleViewPwd(String articleViewPwd) {
		this.articleViewPwd = articleViewPwd;
	}

	@Column(name = "articleEditorType", length = 20)
	public String getArticleEditorType() {
		return this.articleEditorType;
	}

	public void setArticleEditorType(String articleEditorType) {
		this.articleEditorType = articleEditorType;
	}

}