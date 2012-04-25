package edu.ycp.cs320.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class SourceTest {

	private Book book;
	private Journal journal;
	private Website website;
	private Periodical magazine;
	private Citation magazineCite;
	private Citation bookcite;
	private Citation websitecite;
	private Citation journalcite; 
	
	
	@Before
	public void setUp() {

		book=new Book("Chris","Campagnola", "Title","1994", "book","york", null);
		journal=new Journal(SourceType.JOURNAL, "Chris","Campagnola", "Title","1994", "book","york","a","a", null);
		website=new Website(SourceType.WEBSITE, "Chris","Campagnola", "Title","1994", "book","york","a","a", null);
		magazine=new Periodical(SourceType.PERIODICAL, "Chris","Campagnola", "Title","1994", "book","york","a","a");

		book=new Book("Chris","Campagnola", "York College Student Review","2013", "York College of Pennsylvania","York,Pa","Print");
		journal=new Journal(SourceType.JOURNAL, "Chris","Campagnola", "York Science On The Rise","1999", "York College of Pennsylvania","York Science Reporter","5","55-67","Print");
		website=new Website(SourceType.WEBSITE, "Chris","Campagnola", "York College Problems","1111", "York College of Pennsylvania","www.ycp.edu","04/20/2012","York College of Pennsylvania","Web");
		magazine=new Periodical(SourceType.PERIODICAL, "Chris","Campagnola", "York Is Rolling Away","1994", "York College of Pennsylvania","York Times","55-66","5");
		journalcite = new Citation(journal,FormatType.MLA);
		bookcite = new Citation(book,FormatType.MLA);
		websitecite = new Citation(website,FormatType.MLA);

		magazineCite = new Citation(magazine,FormatType.MLA);
		
	}
	
	@Test
	public void testbook() throws Exception {
		assertEquals("Chris", book.getfirst());
		assertEquals(SourceType.BOOK, book.getSourceType());
		assertEquals("Campagnola", book.getlast());
		assertEquals("York College Student Review", book.gettitle());
		assertEquals("2013", book.getdate());
		assertEquals("York College of Pennsylvania",book.getpublisher());
		assertEquals("York,Pa", book.getcity());
	}
	
	@Test
	public void testwebsite() throws Exception {
		assertEquals("Chris", website.getfirst());
		assertEquals(SourceType.WEBSITE, website.getSourceType());
		assertEquals("Campagnola", website.getlast());
		assertEquals("York College Problems", website.gettitle());
		assertEquals("1111", website.getdate());
		assertEquals("York College of Pennsylvania", website.getpublisher());
		assertEquals("www.ycp.edu", website.geturl());
		assertEquals("04/20/2012", website.getaccess());
		assertEquals("York College of Pennsylvania", website.getwebsite());
	}

	
	@Test
	public void testmagazine() throws Exception {
		assertEquals("Chris", magazine.getfirst());
	
		assertEquals(SourceType.PERIODICAL, magazine.getSourceType());
		assertEquals("Campagnola", magazine.getlast());
		assertEquals("York Is Rolling Away", magazine.gettitle());
		assertEquals("1994", magazine.getdate());
		assertEquals("York College of Pennsylvania",magazine.getpublisher());
		assertEquals("York Times",magazine.getmagazine());
		assertEquals("55-66", magazine.getpagenumber());
		assertEquals("5", magazine.getvolumenumber());
	}
	
	@Test
	public void testjournal() throws Exception {
		assertEquals("Chris", journal.getfirst());
		assertEquals(SourceType.JOURNAL, journal.getSourceType());
		assertEquals("Campagnola", journal.getlast());
		assertEquals("York Science On The Rise", journal.gettitle());
		assertEquals("1999", journal.getdate());
		assertEquals("York College of Pennsylvania",journal.getpublisher());
		assertEquals("York Science Reporter",journal.getjournal());
		assertEquals("55-67", journal.getpagenumber());
		assertEquals("5", journal.getvolume());
	}

	
	@Test
	public void testBookMLA() throws Exception {
		assertEquals(book,bookcite.getbook());
		assertEquals(FormatType.MLA,bookcite.getformat());
		assertEquals("Campagnola, Chris. York College Student Review. York,Pa: York College of Pennsylvania, 2013. Print.",bookcite.formatcit());
	}
	@Test
	public void testJournalMLA() throws Exception {
		assertEquals(journal,journalcite.getjournal());
		assertEquals(FormatType.MLA, journalcite.getformat());
		assertEquals("Campagnola, Chris. \"York Science On The Rise\". York Science Reporter 5 (1999): 55-67. Print.",journalcite.formatcit());
	}
	@Test
	public void testWebsiteMLA() throws Exception {
		assertEquals(website,websitecite.getwebsite());
		assertEquals(FormatType.MLA, websitecite.getformat());
		assertEquals("Campagnola, Chris. \"York College Problems\". York College of Pennsylvania. York College of Pennsylvania, 1111. Web. 20 Apr. 2012. <www.ycp.edu>.",websitecite.formatcit());
	}
@Test
	
	public void testMagMLA() throws Exception {
		assertEquals(magazine,magazineCite.getmagazine());
		assertEquals(FormatType.MLA, magazineCite.getformat());
		assertEquals("Campagnola, Chris. \"York Is Rolling Away\". York Times 1994: 55-66. Print.",magazineCite.formatcit());
	}
@Test
public void testBookAPA() throws Exception {
	bookcite.setformattype(FormatType.APA);
	assertEquals(book,bookcite.getbook());
	assertEquals(FormatType.APA,bookcite.getformat());
	assertEquals("Campagnola, C. (2013). York College Student Review. York,Pa: York College of Pennsylvania.",bookcite.formatcit());
}
@Test
public void testJournalAPA() throws Exception {
	journalcite.setformattype(FormatType.APA);
	assertEquals(journal,journalcite.getjournal());
	assertEquals(FormatType.APA, journalcite.getformat());
	assertEquals("Campagnola, C. (1999). \"York Science On The Rise\". York Science Reporter, 5, 55-67.",journalcite.formatcit());
}
@Test
public void testWebsiteAPA() throws Exception {
	websitecite.setformattype(FormatType.APA);
	assertEquals(website,websitecite.getwebsite());
	assertEquals(FormatType.APA, websitecite.getformat());
	assertEquals("Campagnola, C. (1111). \"York College Problems\". Retrieved from www.ycp.edu",websitecite.formatcit());
}
@Test

public void testMagAPA() throws Exception {
	magazineCite.setformattype(FormatType.APA);
	assertEquals(magazine,magazineCite.getmagazine());
	assertEquals(FormatType.APA, magazineCite.getformat());
	assertEquals("Campagnola, C. (1994). \"York Is Rolling Away\". York Times, 5, 55-66.",magazineCite.formatcit());
}
@Test
public void testBookChicago() throws Exception {
	bookcite.setformattype(FormatType.CHICAGO);
	assertEquals(book,bookcite.getbook());
	assertEquals(FormatType.CHICAGO,bookcite.getformat());
	assertEquals("Campagnola, Chris. York College Student Review York,Pa: York College of Pennsylvania, 2013.",bookcite.formatcit());
}
@Test
public void testJournalChicago() throws Exception {
	journalcite.setformattype(FormatType.CHICAGO);
	assertEquals(journal,journalcite.getjournal());
	assertEquals(FormatType.CHICAGO, journalcite.getformat());
	assertEquals("Campagnola, Chris. \"York Science On The Rise\". York Science Reporter 5 (1999): 55-67",journalcite.formatcit());
}
@Test
public void testWebsiteChicago() throws Exception {
	websitecite.setformattype(FormatType.CHICAGO);
	assertEquals(website,websitecite.getwebsite());
	assertEquals(FormatType.CHICAGO, websitecite.getformat());
	assertEquals("Campagnola, Chris. \"York College Problems\". York College of Pennsylvania, Last modified 1111. Accessed Apr. 20, 2012. www.ycp.edu.",websitecite.formatcit());
}
@Test

public void testMagChicago() throws Exception {
	magazineCite.setformattype(FormatType.CHICAGO);
	assertEquals(magazine,magazineCite.getmagazine());
	assertEquals(FormatType.CHICAGO, magazineCite.getformat());
	assertEquals("Campagnola, Chris. \"York Is Rolling Away\". York Times, 1994.",magazineCite.formatcit());
}
}




