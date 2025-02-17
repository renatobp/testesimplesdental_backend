package br.com.testesimplesdental.testesimplesdental.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import br.com.testesimplesdental.testesimplesdental.models.Contatos;
import br.com.testesimplesdental.testesimplesdental.repositories.BaseRepository;

@ExtendWith(MockitoExtension.class)
public class ContatosServiceTestCase {

    private ContatosService contatosService;

    @Mock
    private BaseRepository<Contatos, Long> repository;

    private Contatos contato;

    @BeforeEach
    void setUp() throws Exception {
	contatosService = new ContatosService();
	contato = new Contatos();
	contato.setId(1L);
	contato.setNome("Maria Souza");
	contato.setCreated_date(LocalDate.now());

	// Injetar o repository manualmente
	Field repositoryField = GenericServiceImpl.class.getDeclaredField("repository");
	repositoryField.setAccessible(true);
	repositoryField.set(contatosService, repository);
    }

    @Test
    void testFindAll() {
	List<Contatos> contatosList = Arrays.asList(contato);
	when(repository.findAll()).thenReturn(contatosList);

	List<Contatos> result = contatosService.findAll();
	assertEquals(1, result.size());
	assertEquals(contato.getNome(), result.get(0).getNome());
    }

    @Test
    void testFindById() {
	when(repository.findById(1L)).thenReturn(Optional.of(contato));

	Contatos result = contatosService.findById(1L);
	assertNotNull(result);
	assertEquals(contato.getNome(), result.getNome());
    }

    @Test
    void testSave() {
	when(repository.save(contato)).thenReturn(contato);

	ResponseEntity<String> response = contatosService.save(contato);
	assertEquals("Salvo com sucesso!", response.getBody());
	verify(repository, times(1)).save(contato);
    }

    @Test
    void testDelete() {
	doNothing().when(repository).delete(contato);

	ResponseEntity<String> response = contatosService.delete(1L, contato);
	assertEquals("Excluído com sucesso!", response.getBody());
	verify(repository, times(1)).delete(contato);
    }

    @Test
    void testEdit() {
	when(repository.findById(1L)).thenReturn(Optional.of(contato));
	when(repository.save(contato)).thenReturn(contato);

	ResponseEntity<String> response = contatosService.edit(1L, contato);
	assertEquals("Atualizado com sucesso!", response.getBody());
	verify(repository, times(1)).save(contato);
    }

    // Classe concreta para testes
    public static class ContatosService extends GenericServiceImpl<Contatos, Long> {
    }
}
