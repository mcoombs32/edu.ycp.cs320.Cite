package edu.ycp.cs320.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class SourceTest {

	private Book book;
	private Journal journal;
	private Website website;
	private Magazine magazine;
	private Citation magazineCite;
	
	
	@Before
	public void setUp() {
		book=new Book("Chris","Campagnola", "Title","1994", "book","york");
		journal=new Journal(SourceType.JOURNAL, "Chris","Campagnola", "Title","1994", "book","york","a","a");
		website=new Website(SourceType.WEBSITE, "Chris","Campagnola", "Title","1994", "book","york","a","a");
		magazine=new Magazine(SourceType.MAGAZINE, "Chris","Campagnola", "Title","1994", "book","york","a","a");
		magazineCite = new Citation(magazine,FormatType.MLA);
		
	}
	
	@Test
	public void testbook() throws Exception {
		assertEquals("Chris", book.getfirst());
		//assertEquals("Book", book.getsource());
		assertEquals(SourceType.BOOK, book.getSourceType());
		assertEquals("Campagnola", book.getlast());
		assertEquals("Title", book.gettitle());
		assertEquals("1994", book.getdate());
		assertEquals("york", book.getcity());
	}
	
	@Test
	public void testwebsite() throws Exception {
		assertEquals("Chris", website.getfirst());
		//assertEquals("Book", website.getsource());
		assertEquals(SourceType.WEBSITE, website.getSourceType());
		assertEquals("Campagnola", website.getlast());
		assertEquals("Title", website.gettitle());
		assertEquals("1994", website.getdate());
		assertEquals("york", website.geturl());
		assertEquals("a", website.getaccess());
		assertEquals("a", website.getwebsite());
	}
	
	@Test
	public void testmagazine() throws Exception {
		assertEquals("Chris", magazine.getfirst());
		//assertEquals("Book", magazine.getsource());
		assertEquals(SourceType.MAGAZINE, magazine.getSourceType());
		assertEquals("Campagnola", magazine.getlast());
		assertEquals("Title", magazine.gettitle());
		assertEquals("1994", magazine.getdate());
		assertEquals("york",magazine.getmagazine());
		assertEquals("a", magazine.getpagenumber());
		assertEquals("a", magazine.getvolumenumber());
	}
	@Test
	public void testjournal() throws Exception {
		assertEquals("Chris", journal.getfirst());
		//assertEquals("Book", journal.getsource());
		assertEquals(SourceType.JOURNAL, journal.getSourceType());
		assertEquals("Campagnola", journal.getlast());
		assertEquals("Title", journal.gettitle());
		assertEquals("1994", journal.getdate());
		assertEquals("york",journal.getjournal());
		assertEquals("a", journal.getpagenumber());
		assertEquals("a", journal.getvolume());
	}
	@Test
	
	public void testMag() throws Exception {
		assertEquals(magazine,magazineCite.getmagazine());
		assertEquals(FormatType.MLA, magazineCite.getformat());
		assertEquals("Campagnola,Chris,Title,york,1994,a",magazineCite.formatcit());
	}
}




