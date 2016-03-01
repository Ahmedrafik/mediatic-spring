package fr.iocean.application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.iocean.application.model.Adherent;
import fr.iocean.application.model.Adresse;
import fr.iocean.application.model.Cotisation;
import fr.iocean.application.typeEnum.TypeCotisation;

@Sql("classpath:test-user-data.sql")
public class AdherentTest extends IntegrationTest {

	@SuppressWarnings("deprecation")
	@Test
	@WithMockUser(authorities="R_ADMIN")
	public void testCreateByAdmin() throws Exception{
		Date date = new Date(1999, 12, 24);
		Date dateCotisation = new Date(2015, 06, 13);
		
		Adherent adh= new Adherent("Sebastien", "Patrick", "pat@cabaret.net", date, new Adresse(147, "le plus beau cabaret du monde", 34000, "Montpellier"), new Cotisation(152.10f, dateCotisation, TypeCotisation.GROUPE));
		this.mockMvc.perform(post("/api/adherent")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(adh)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isCreated());
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	@WithMockUser(authorities="R_UTILISATEUR")
	public void testCreateByUser() throws Exception{
		Date date = new Date(1999, 10, 24);
		Date dateCotisation = new Date(2015, 12, 25);
		
		Adherent adh= new Adherent("Sebastien", "Patrick", "pat@cabaret.net", date, new Adresse(147, "le plus beau cabaret du monde", 34000, "Montpellier"), new Cotisation(152.10f, dateCotisation, TypeCotisation.GROUPE));
		this.mockMvc.perform(post("/api/adherent")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(adh)))
				.andExpect(status().isCreated());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@WithMockUser(authorities="R_STAGIAIRE")
	public void testCreateByStagiaire() throws Exception{
		Date date = new Date(1999, 10, 24);
		Date dateCotisation = new Date(2015, 12, 25);
		
		Adherent adh= new Adherent("Sebastien", "Patrick", "pat@cabaret.net", date, new Adresse(147, "le plus beau cabaret du monde", 34000, "Montpellier"), new Cotisation(152.10f, dateCotisation, TypeCotisation.GROUPE));
		this.mockMvc.perform(post("/api/adherent")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(adh)))
				.andExpect(status().isForbidden());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@WithMockUser(authorities="R_ADMIN")
	public void testUpdateByAdmin() throws Exception{
		Date date = new Date(1999, 10, 24);
		Date dateCotisation = new Date(2015, 12, 25);
		
		Adherent adh= new Adherent("Sebastien", "Patrick", "pat@cabaret.net", date, new Adresse(147, "le plus beau cabaret du monde", 34000, "Montpellier"), new Cotisation(152.10f, dateCotisation, TypeCotisation.GROUPE));
		this.mockMvc.perform(put("/api/utilisateur/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(adh)))
				.andExpect(status().isOk());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@WithMockUser(authorities="R_UTILISATEUR")
	public void testUpdateByUser() throws Exception{
		Date date = new Date(1999, 10, 24);
		Date dateCotisation = new Date(2015, 12, 25);
		
		Adherent adh= new Adherent("Sebastien", "Patrick", "pat@cabaret.net", date, new Adresse(147, "le plus beau cabaret du monde", 34000, "Montpellier"), new Cotisation(152.10f, dateCotisation, TypeCotisation.GROUPE));

		this.mockMvc.perform(put("/api/utilisateur/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(adh)))
				.andExpect(status().isForbidden());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@WithMockUser(authorities="R_STAGIAIRE")
	public void testUpdateByStagiaire() throws Exception{
		Date date = new Date(1999, 10, 24);
		Date dateCotisation = new Date(2015, 12, 25);
		
		Adherent adh= new Adherent("Sebastien", "Patrick", "pat@cabaret.net", date, new Adresse(147, "le plus beau cabaret du monde", 34000, "Montpellier"), new Cotisation(152.10f, dateCotisation, TypeCotisation.GROUPE));

		this.mockMvc.perform(put("/api/utilisateur/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(adh)))
				.andExpect(status().isForbidden());
	}
	
/*	@Test
	@WithMockUser(authorities="R_ADMIN")
	public void testFindAll() throws Exception{
		this.mockMvc.perform(get("/api/utilisateur"))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(jsonPath("$", hasSize(2)));
	}
	
	@Test
	@WithMockUser(authorities="R_ADMIN")
	public void testFindById() throws Exception{
		this.mockMvc.perform(get("/api/utilisateur/{id}", 1))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(jsonPath("$.id").value(1))
			.andExpect(jsonPath("$.login").value("cruella"));
	}
	
	@Test
	@WithMockUser(authorities="R_ADMIN")
	public void testDelete() throws Exception{
		this.mockMvc.perform(delete("/api/utilisateur/{id}", "1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}*/
	
}
