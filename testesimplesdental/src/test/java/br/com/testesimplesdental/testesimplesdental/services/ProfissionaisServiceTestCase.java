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

import br.com.testesimplesdental.testesimplesdental.models.Profissionais;
import br.com.testesimplesdental.testesimplesdental.repositories.BaseRepository;

@ExtendWith(MockitoExtension.class)
public class ProfissionaisServiceTestCase {

    private ProfissionaisService profissionaisService;

    @Mock
    private BaseRepository<Profissionais, Long> repository;

    private Profissionais profissional;

    @BeforeEach
    void setUp() throws Exception {
	profissionaisService = new ProfissionaisService();
	profissional = new Profissionais();
	profissional.setId(1L);
	profissional.setNome("João Silva");
	profissional.setCreated_date(LocalDate.now());

	// Injeta o repository manualmente
	Field repositoryField = GenericServiceImpl.class.getDeclaredField("repository");
	repositoryField.setAccessible(true);
	repositoryField.set(profissionaisService, repository);
    }

    @Test
    void testFindAll() {
	List<Profissionais> profissionaisList = Arrays.asList(profissional);
	when(repository.findAll()).thenReturn(profissionaisList);
	List<Profissionais> result = profissionaisService.findAll();
	assertEquals(1, result.size());
	assertEquals(profissional.getNome(), result.get(0).getNome());
    }

    @Test
    void testFindById() {
	when(repository.findById(1L)).thenReturn(Optional.of(profissional));
	Profissionais result = profissionaisService.findById(1L);
	assertNotNull(result);
	assertEquals(profissional.getNome(), result.getNome());
    }

    @Test
    void testSave() {
	when(repository.save(profissional)).thenReturn(profissional);
	ResponseEntity<String> response = profissionaisService.save(profissional);
	assertEquals("Salvo com sucesso!", response.getBody());
	verify(repository, times(1)).save(profissional);
    }

    @Test
    void testDelete() {
	doNothing().when(repository).delete(profissional);
	ResponseEntity<String> response = profissionaisService.delete(1L, profissional);
	assertEquals("Excluído com sucesso!", response.getBody());
	verify(repository, times(1)).delete(profissional);
    }

    @Test
    void testEdit() {
	when(repository.findById(1L)).thenReturn(Optional.of(profissional));
	when(repository.save(profissional)).thenReturn(profissional);
	ResponseEntity<String> response = profissionaisService.edit(1L, profissional);
	assertEquals("Atualizado com sucesso!", response.getBody());
	verify(repository, times(1)).save(profissional);
    }

    // Classe concreta para testes
    public static class ProfissionaisService extends GenericServiceImpl<Profissionais, Long> {
    }
}
