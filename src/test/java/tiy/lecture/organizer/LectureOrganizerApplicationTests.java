package tiy.lecture.organizer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LectureOrganizerApplication.class)
@WebAppConfiguration
public class LectureOrganizerApplicationTests {
	@Autowired
	NoteRepository notes;

	@Autowired
	TagRepository tags;

	@Autowired
	UserRepository users;

	@Autowired
	LanguageRepository languages;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testAddNote() throws Exception {

		Iterable<Tag> allTags = tags.findAll();
		ArrayList<Tag> tagArrayList = new ArrayList<Tag>();
		for (Tag currentTag : allTags) {
			tagArrayList.add(currentTag);
		}
		// now I have all tags in tagArrayList ...

		String noteSubject = "primitivetype";
		String noteCode = "double";
		LocalDateTime created_at = LocalDateTime.now();
		String noteName = "Learning about doubles";
		String noteTag = "dataTypes";
		String noteLanguage = "Java";


		String email = "elhadi.sulton@gmail.com";
		String password = "sultone";
		String dateOfBirth = "12/02/1995";
		String cohort = "Iron Yard";
		String firstName = "Sulton";
		String lastName = "Elhadi";


		User user = new User(email, password, cohort, firstName, lastName);
		users.save(user);

		Note note = new Note(noteSubject,  noteCode,  noteName, user);
		notes.save(note);

		Note noteFound = notes.findOne(note.id);
		System.out.println("==============" + note.id + " " + noteFound.id);
		assertEquals(note.id, noteFound.id);



		User noteUser = note.getUser();
		assertNotNull(noteUser);
		assertEquals(user.getId(), noteUser.getId());



//		Set<Note> noteList = noteUser.getNotes();
//		assertNotNull(noteList);
//		assertEquals(noteList.iterator().next().getId(), note.getId());


		notes.delete(note);
		users.delete(user);
	}

	@Test
	public void testAddNoteTag() throws Exception {
		String noteTag = "userInput";


		Tag tag = new Tag(noteTag);
		tags.save(tag);

		Tag tagFound = tags.findOne(tag.id);
		System.out.println("==============" + tag.id + " " + tagFound.id);
		assertEquals(tag.id, tagFound.id);


		tags.delete(tag);

	}

	@Test
	public void testAddLanguage() throws Exception {
		String lang = "Python";


		Language language = new Language(lang);
		languages.save(language);

		Language languagesFound = languages.findOne(language.id);
		System.out.println("==============" + language.id + " " + languagesFound.id);
		assertEquals(language.id, languagesFound.id);


		languages.delete(language);

	}

	@Test
	public void testAddLanguageAndNote() throws Exception {
		String noteLang = "Python";
		String noteTitle = "UserInput";
		String noteText = "hi";

		String noteCode = "System.out";
		String email = "elhadi.sulton@gmail.com";
		String password = "sultone";
		String dateOfBirth = "12/02/1995";
		String cohort = "Iron Yard";
		String firstName = "Sulton";
		String lastName = "Elhadi";
		User user = new User(email, password, cohort, firstName, lastName);
		users.save(user);
		Language language = new Language(noteLang);
		languages.save(language);
		Note note = new Note(noteCode, noteTitle, noteText, user);
		Language languagesFound = languages.findOne(language.id);
		System.out.println("==============" + language.id + " " + languagesFound.id);
		assertEquals(language.id, languagesFound.id);
//		Language noteLanguage = note.;
		note.addLanguage(language);
		notes.save(note);
		notes.delete(note);
		languages.delete(language);
		users.delete(user);
	}

	@Test
	public void testAddAndRetrieveTags() throws Exception {
		String tag1 = "UserInput";
		String tag2 = "PrimitiveTypes";
		String tag3 = "Css";


		ArrayList<Tag> tagArrayList = new ArrayList<Tag>();

		Tag firstTag = new Tag(tag1);
		Tag secondTag = new Tag(tag2);
		Tag thirdTag = new Tag(tag3);

		tagArrayList.add(firstTag);
		tagArrayList.add(secondTag);
		tagArrayList.add(thirdTag);

		tags.save(firstTag);
		tags.save(secondTag);
		tags.save(thirdTag);

		Tag tag1Found = tags.findOne(firstTag.id);
		System.out.println("==============" + firstTag.id + " " + tag1Found.id);
		Tag tag2Found = tags.findOne(secondTag.id);
		System.out.println("==============" + secondTag.id + " " + tag2Found.id);
		Tag tag3Found = tags.findOne(thirdTag.id);
		System.out.println("==============" + thirdTag.id + " " + tag3Found.id);

		assertEquals(firstTag.id, tag1Found.id);
		assertEquals(secondTag.id, tag2Found.id);
		assertEquals(thirdTag.id, tag3Found.id);

		tags.delete(firstTag);
		tags.delete(secondTag);
		tags.delete(thirdTag);

	}
}
