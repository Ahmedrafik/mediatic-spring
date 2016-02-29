package fr.iocean.application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;

import fr.iocean.application.model.Utilisateur;


@Sql("classpath:test-user-data.sql")
public class UserTest extends IntegrationTest{
	
	@Test
	@WithMockUser(roles="R_ADMIN")
	public void testCreateByAdmin() throws Exception{
		Utilisateur utilisateur = new Utilisateur("Fondepierre", "Cindy", "Cindy.Fondes@papillon.lumiere", "Cindy", "papillon");
		this.mockMvc.perform(post("/api/utilisateur")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonHelper.serialize(utilisateur)))
				.andExpect(status().isCreated());
	}
}
