package tiy.lecture.organizer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
	public void testAddUserAndNote() throws Exception {
		String noteLang = "Python";
		String noteTitle = "UserInput";
		String noteText = "hi";
		String noteCode = "System.out";

		String email = "elhadi.sulton@gmail.com";
		String password = "sultone";
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
//		note.addLanguage(language);
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

	@Test
	public void testAddNoteUserNote() throws Exception {
		String noteSubject = "primitivetype";
		String noteName = "Learning about doubles";
		String noteCode = "System.out";

		String email = "elhadi.sulton@gmail.com";
		String password = "sultone";
		String cohort = "Iron Yard";
		String firstName = "Sulton";
		String lastName = "Elhadi";

		String noteSubject2 = "UserInput";
		String noteName2 = "Learning about input";
		String noteCode2 = "user";

		String email2 = "josh@gmail.com";
		String password2 = "joshe";
		String cohort2 = "Iron Yard";
		String firstName2 = "Josh";
		String lastName2 = "Hon";

		User user = new User(email, password, cohort, firstName, lastName);
		users.save(user);

		Note note = new Note(noteSubject,  noteCode,  noteName, user);
		notes.save(note);

		User user2 = new User(email2, password2, cohort2, firstName2, lastName2);
		users.save(user2);

		Note note2 = new Note(noteSubject2,  noteCode2,  noteName2, user2);
		notes.save(note2);


		Note noteFound = notes.findOne(note.id);
		System.out.println("==============" + note.id + " " + noteFound.id);
		assertEquals(note.id, noteFound.id);
		notes.save(note);

		Note noteFound2 = notes.findOne(note2.id);
		System.out.println("==============" + note2.id + " " + noteFound2.id);
		assertEquals(note2.id, noteFound2.id);
		notes.save(note2);

//		assertEquals(note.id, user.id);




		notes.delete(note);
		users.delete(user);

		notes.delete(note2);
		users.delete(user2);
		notes.delete(note2);
	}

	@Test
	public void testFindByTags() throws Exception {

		Tag noteTag2 = new Tag("tag1");
		tags.save(noteTag2);
		// now I have all tags in tagArrayList ...

		String noteTitle = "primitivetype";
		String noteTag = "Spring";
		String noteLanguage = "Java";
		String noteCode = "double";
		String noteText = "Learning about doubles";

		String firstName = "Sulton";
		String lastName = "Elhadi";
		String email = "elhadi.sulton@gmail.com";
		String password = "sultone";
		String cohort = "Iron Yard";



		User user = new User(email, password, cohort, firstName, lastName);
		users.save(user);

		Note note = new Note(noteText, noteCode, noteTitle, user);

		ArrayList<Tag> tagCollection = new ArrayList<Tag>();
		tagCollection.add(noteTag2);

		note.setTags(tagCollection);

		notes.save(note);

		int noteID = note.getId();
		assertNotEquals(0, noteID);

		Note retrievedNote = notes.findOne(noteID);
		assertNotNull(retrievedNote);
		assertNotNull(retrievedNote.getTags());

		List<Note> foundNotes = notes.findByTags(tagCollection);
		assertNotNull(foundNotes);
		assertEquals(1, foundNotes.size());

		notes.delete(note);
		tags.delete(noteTag2);
		users.delete(user);

	}
}
