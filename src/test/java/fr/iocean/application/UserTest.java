package fr.iocean.application;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import fr.iocean.application.model.Utilisateur;


@Sql("classpath:test-user-data.sql")
public class UserTest extends IntegrationTest{
	
	@Test
	@WithMockUser(authorities="R_ADMIN")
	public void testCreateByAdmin() throws Exception{
		Utilisateur utilisateur = new Utilisateur("Fondepierre", "Cindy", "Cindy.Fondes@papillon.lumiere", "Cindy", "papillon");
		this.mockMvc.perform(post("/api/utilisateur")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(utilisateur)))
				.andExpect(status().isCreated());
	}
	
	
	@Test
	@WithMockUser(authorities="R_UTILISATEUR")
	public void testCreateByUser() throws Exception{
		Utilisateur utilisateur = new Utilisateur("pumba", "pumba", "pumba@papillon.lumiere", "Pumba", "hakuna");
		this.mockMvc.perform(post("/api/utilisateur")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(utilisateur)))
				.andExpect(status().isForbidden());
	}
	
	@Test
	@WithMockUser(authorities="R_ADMIN")
	public void testUpdateByAdmin() throws Exception{
		Utilisateur utilisateur = new Utilisateur("pumba", "pumba", "pumba@papillon.lumiere", "Pumba", "hakuna");
		this.mockMvc.perform(put("/api/utilisateur/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(utilisateur)))
				.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(authorities="R_UTILISATEUR")
	public void testUpdateByUser() throws Exception{
		Utilisateur utilisateur = new Utilisateur("pumba", "pumba", "pumba@papillon.lumiere", "Pumba", "hakuna");
		this.mockMvc.perform(put("/api/utilisateur/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(utilisateur)))
				.andExpect(status().isForbidden());
	}
	
	@Test
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
	}
	
	
	
}
