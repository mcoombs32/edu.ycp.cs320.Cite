package edu.ycp.cs320.project;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class SourceTest {
	private Source source;
	private Book book;
	private Journal journal;
	private Website website;

	private Citation bookcite;
	private Citation websitecite;
	private Citation journalcite; 

	private Book a;
	private Website b;
	private Periodical c;

	private Map<String,Citation> citeMap;
	

	private Journal d;



	@Before
	public void setUp() {


		a=new Book();
		b=new Website();
		c=new Periodical();
		d=new Journal();



		book=new Book("Chris","Campagnola", "York College Student Review","2013", "York College of Pennsylvania","York,Pa","Print");
		journal=new Journal(SourceType.JOURNAL, "Chris","Campagnola", "York Science On The Rise","1999", "York College of Pennsylvania","York Science Reporter","5","55-67","Print");
		website=new Website(SourceType.WEBSITE, "Chris","Campagnola", "York College Problems","1111", "York College of Pennsylvania","www.ycp.edu","04/20/2012","York College of Pennsylvania","Web");
		journalcite = new Citation(journal,FormatType.MLA);
		bookcite = new Citation(book,FormatType.MLA);
		websitecite = new Citation(website,FormatType.MLA);


	
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

		assertEquals("Print",book.getmedium());

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
		assertEquals("Web",website.getmedium());
	}


	@Test
	public void test() throws Exception {
		assertEquals("Chris", c.getfirst());
		assertEquals(SourceType.PERIODICAL, c.getSourceType());
		assertEquals("Campagnola", c.getlast());
		assertEquals("York Is Rolling Away", c.gettitle());
		assertEquals("1994", c.getdate());
		assertEquals("York College of Pennsylvania",c.getpublisher());
		assertEquals("York Times",c.getmagazine());
		assertEquals("55-66", c.getpagenumber());
		assertEquals("5", c.getvolumenumber());
		assertEquals("Print",c.getmedium());
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
		assertEquals("Print",journal.getmedium());
	}

	@Test
	public void testBookMLA() throws Exception {
		assertEquals(book,bookcite.getSource());
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
		assertEquals(c,journalcite.getmagazine());
		assertEquals(FormatType.MLA, journalcite.getformat());
		assertEquals("Campagnola, Chris. \"York Is Rolling Away\". York Times 1994: 55-66. Print.",journalcite.formatcit());
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
		journalcite.setformattype(FormatType.APA);
		assertEquals(c,journalcite.getmagazine());
		assertEquals(FormatType.APA, cCite.getformat());
		assertEquals("Campagnola, C. (1994). \"York Is Rolling Away\". York Times, 5, 55-66.",cCite.formatcit());
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
		cCite.setformattype(FormatType.CHICAGO);
		assertEquals(c,cCite.getc());
		assertEquals(FormatType.CHICAGO, cCite.getformat());
		assertEquals("Campagnola, Chris. \"York Is Rolling Away\". York Times, 1994.",cCite.formatcit());

	}
	@Test
	public void testsetsource() throws Exception {
		book.setfirst("Joe");
		book.setlast("Bell");
		book.setdate("2013");
		book.settitle("The Wind");
		book.setpublisher("Book");
		book.setcity("New York");
		journal.setjournal("The Daily Planet");
		journal.setpagenumber("55-67");
		assertEquals("Joe", book.getfirst());
		assertEquals(SourceType.BOOK, book.getSourceType());
		assertEquals("Bell", book.getlast());
		assertEquals("The Wind", book.gettitle());
		assertEquals("2013", book.getdate());
		assertEquals("Book",book.getpublisher());
		assertEquals("New York", book.getcity());
		assertEquals("The Daily Planet",journal.getjournal());
		assertEquals("55-67",journal.getpagenumber());

	}
	@Test
	public void testsetbook() throws Exception {
		book.setfirst("Joe");
		book.setlast("Bell");
		book.setdate("2013");
		book.settitle("The Wind");
		book.setpublisher("Book");
		book.setcity("New York");
		journal.setjournal("The Daily Planet");
		journal.setpagenumber("55-67");
		journal.setvolume("5");
		website.seturl("www.york.edu");
		website.setaccess("05/06/12");
		website.setwebsite("York College");
		c.setmagazine("York Daily");
		c.setpagenumber("34-45");
		c.setvolume("101");
		assertEquals("Joe", book.getfirst());
		assertEquals(SourceType.BOOK, book.getSourceType());
		assertEquals("Bell", book.getlast());
		assertEquals("The Wind", book.gettitle());
		assertEquals("2013", book.getdate());
		assertEquals("Book",book.getpublisher());
		assertEquals("New York", book.getcity());
		assertEquals("The Daily Planet",journal.getjournal());
		assertEquals("55-67",journal.getpagenumber());
		assertEquals("5",journal.getvolume());
		assertEquals("www.york.edu",website.geturl());
		assertEquals("05/06/12",website.getaccess());
		assertEquals("York College",website.getwebsite());
		assertEquals("34-45",c.getpagenumber());
		assertEquals("101",c.getvolumenumber());
		assertEquals("York Daily",c.getmagazine());

	}
	@Test
	public void testgetmonth() throws Exception {

		assertEquals("Jan.", website.getmonth("01"));
		assertEquals("Feb.", website.getmonth("02"));
		assertEquals("Mar.", website.getmonth("03"));
		assertEquals("Apr.", website.getmonth("04"));
		assertEquals("May", website.getmonth("05"));
		assertEquals("Jun.", website.getmonth("06"));
		assertEquals("Jul.", website.getmonth("07"));
		assertEquals("Aug.", website.getmonth("08"));
		assertEquals("Sep.", website.getmonth("09"));
		assertEquals("Oct.", website.getmonth("10"));
		assertEquals("Nov.", website.getmonth("11"));
		assertEquals("Dec.", website.getmonth("12"));
		assertEquals(null, website.getmonth("121"));
	}
	@Test
	public void testmappersistance() throws Exception {



	}
}








