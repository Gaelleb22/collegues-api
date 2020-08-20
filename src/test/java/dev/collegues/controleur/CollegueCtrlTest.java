package dev.collegues.controleur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import dev.collegues.controler.CollegueCtrl;
import dev.collegues.entite.Collegue;
import dev.collegues.service.CollegueService;

@WebMvcTest(CollegueCtrl.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CollegueCtrlTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CollegueService collegueService;
	
	@BeforeEach
	void setUp() {
		List<Collegue> collegues = new ArrayList<>();
		Collegue collegue1 = new Collegue();
		collegue1.setNom("Lourson");
		collegue1.setPrenoms("Winnie");
		collegue1.setEmail("Winnie@gmail.com");
		collegue1.setPhotoUrl("http://photo");
		collegue1.setMatricule(UUID.fromString("747c41b7-f164-43f7-86ad-6a42f47c6120"));
		collegues.add(collegue1);
		
		Collegue collegue2 = new Collegue();
		collegue2.setNom("Mouri");
		collegue2.setPrenoms("Ran");
		collegue2.setEmail("ran@gmail.com");
		collegue2.setPhotoUrl("http://photo2");
		collegue2.setMatricule(UUID.fromString("2bd0937d-43f0-4612-aa0c-2c398b6b1298"));
		collegues.add(collegue2);
		
		Mockito.when(collegueService.findAll()).thenReturn(collegues);
		
		Optional<Collegue> col = Optional.of(collegues.get(0));
		Mockito.when(collegueService.findByUuid(UUID.fromString("747c41b7-f164-43f7-86ad-6a42f47c6120"))).thenReturn(col);
		
	}
	
	//Tests findCollegueByNom
	@Test
	void findCollegueByNomCorrectTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues?nom=Lourson"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Lourson"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").value("Winnie"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("Winnie@gmail.com"));
	}
	
	@Test
	void findCollegueByNomInvalidTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues?nom="))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andExpect(MockMvcResultMatchers.content().string("Veuillez entrer un nom"));
	}
	
	@Test
	void findCollegueByNomNotFoundTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues?nom=Autre"))
		.andExpect(MockMvcResultMatchers.status().isNotFound())
		.andExpect(MockMvcResultMatchers.content().string("Pas de Collegue à ce nom"));
	}
	
	
	//Tests findCollegueByMatricule
	@Test
	void findCollegueByMatriculeCorrectTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues/747c41b7-f164-43f7-86ad-6a42f47c6120"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Lourson"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").value("Winnie"));
	}
	
	@Test
	void findCollegueByMatriculeInvalidTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues/747c41b7f164-43f786ad6a42f47c6120"))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andExpect(MockMvcResultMatchers.content().string("Uuid invalide"));
	}
	
	@Test
	void findCollegueByMatriculeNotFoundTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues/747c41b7-f164-43f7-86ad-6a42f47c61"))
		.andExpect(MockMvcResultMatchers.status().isNotFound())
		.andExpect(MockMvcResultMatchers.content().string("Pas de Collegue avec ce matricule"));
	}
	
	//Test findPhotos
	@Test
	void findPhotosCorrectTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues/photos"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].matricule").value("747c41b7-f164-43f7-86ad-6a42f47c6120"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].photoUrl").value("http://photo"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].matricule").value("2bd0937d-43f0-4612-aa0c-2c398b6b1298"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].photoUrl").value("http://photo2"));
		
	}
	
	//Test creerCollegue
	@Test
	void creerCollegueTestOk() throws Exception{
		Collegue collegue = new Collegue();
		collegue.setNom("Poirot");
		collegue.setPrenoms("Hercule");
		collegue.setDateDeNaissance(LocalDate.of(1900, 05, 26));
		collegue.setEmail("HP@gmail.com");
		collegue.setPhotoUrl("http://photo");
		collegue.setMatricule(UUID.fromString("402c41b7-f164-43f7-86ad-6a42f47c6120"));
		
		Mockito.when(collegueService.creer("Poirot", "Hercule", "HP@gmail.com", LocalDate.of(1900, 05, 26), "http://photo")).thenReturn(collegue);
		String param = "{ \"nom\":\"Poirot\", \"prenoms\":\"Hercule\", \"dateDeNaissance\":\"1900-05-26\", \"email\":\"HP@gmail.com\", \"photoUrl\":\"http://photo\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post("/").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(param))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value("Poirot"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.prenoms").value("Hercule"));
	}

}
