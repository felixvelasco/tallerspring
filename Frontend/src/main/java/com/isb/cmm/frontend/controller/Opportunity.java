package com.isb.cmm.frontend.controller;

import java.util.List;

public class Opportunity {

	private String header;
	private String footer;
	private List<String> paragraphs;
	private String bait;

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	/**
	 * @return the footer
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * @param footer
	 *            the footer to set
	 */
	public void setFooter(String footer) {
		this.footer = footer;
	}

	/**
	 * @return the paragraphs
	 */
	public List<String> getParagraphs() {
		return paragraphs;
	}

	/**
	 * @param paragraphs
	 *            the paragraphs to set
	 */
	public void setParagraphs(List<String> paragraphs) {
		this.paragraphs = paragraphs;
	}

	/**
	 * @return the bait
	 */
	public String getBait() {
		return bait;
	}

	/**
	 * @param bait
	 *            the bait to set
	 */
	public void setBait(String bait) {
		this.bait = bait;
	}
}
