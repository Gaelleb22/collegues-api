package dev.collegues.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
		collegue1.setMatricule(UUID.fromString("747c41b7-f164-43f7-86ad-6a42f47c6120"));
		collegues.add(collegue1);
		
		Mockito.when(collegueService.findAll()).thenReturn(collegues);
	}
	
	@Test
	void findCollegueByNomTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues?nom=Lourson"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("Lourson"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].prenoms").value("Winnie"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("Winnie@gmail.com"));
	}
	
	@Test
	void findCollegueByNomOublieTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues?nom="))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andExpect(MockMvcResultMatchers.content().string("Veuillez entrer un nom"));
	}
	
	@Test
	void findCollegueByNomIncorrectTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/collegues?nom=Autre"))
		.andExpect(MockMvcResultMatchers.status().isNotFound())
		.andExpect(MockMvcResultMatchers.content().string("Pas de Collegue à ce nom"));
	}

}
