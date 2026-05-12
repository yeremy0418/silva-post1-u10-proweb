package com.tareas.gestion_tareas.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import com.tareas.gestion_tareas.model.Tarea;
import static org.assertj.core.api.Assertions.assertThat;

// TareaRepositoryTest — prueba la BD con H2 en memoria
@DataJpaTest
class TareaRepositoryTest {
    @Autowired
    TareaRepository repo;
    @Autowired
    TestEntityManager em;

    @BeforeEach
    void setUp() {
        Tarea t = new Tarea();
        t.setTitulo("Pendiente");
        t.setCompletada(false);
        em.persistAndFlush(t);
    }

    @Test
    void findByCompletada_false_retornaUnaTarea() {
        assertThat(repo.findByCompletada(false)).hasSize(1)
                .extracting("titulo").containsExactly("Pendiente");
    }
}
