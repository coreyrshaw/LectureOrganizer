package tiy.lecture.organizer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

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
		String noteDate = "6/10/2016";
		String noteName = "Learning about doubles";
		String noteTag = "dataTypes";
		String noteLanguage = "Java";


		String email = "elhadi.sulton@gmail.com";
		String password = "sultone";
		String dateOfBirth = "12/02/1995";
		String cohort = "Iron Yard";
		String firstName = "Sulton";
		String lastName = "Elhadi";


		User user = new User(email, password, dateOfBirth, cohort, firstName, lastName);
		users.save(user);

		Note note = new Note(noteSubject, noteCode, noteDate, noteName, noteTag, noteLanguage, user);
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
		String lang2 = "Ruby";

		Language language = new Language(lang);
		languages.save(language);

		Language languagesFound = languages.findOne(language.id);
		System.out.println("==============" + language.id + " " + languagesFound.id);
		assertEquals(language.id, language.id);



		languages.delete(language);

	}


}
