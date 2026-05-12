package com.tareas.gestion_tareas.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.tareas.gestion_tareas.model.Tarea;
import com.tareas.gestion_tareas.service.TareaService;

import org.springframework.test.context.bean.override.mockito.MockitoBean;

import jakarta.persistence.EntityNotFoundException;

// TareaControllerTest — prueba la capa web en aislamiento
@WebMvcTest(TareaController.class)
class TareaControllerTest {
 @Autowired MockMvc mockMvc;
 @MockitoBean TareaService service;
 @Test void get_tareaExiste_retorna200() throws Exception {
 Tarea t = new Tarea(); t.setId(1L); t.setTitulo("Test");
 when(service.buscarPorId(1L)).thenReturn(t);
 mockMvc.perform(get("/api/tareas/1"))
 .andExpect(status().isOk())
 .andExpect(jsonPath("$.titulo").value("Test"));
 }
 @Test void get_noExiste_retorna404() throws Exception {
 when(service.buscarPorId(99L)).thenThrow(new
 EntityNotFoundException("no encontrada"));

 mockMvc.perform(get("/api/tareas/99")).andExpect(status().isNotFound());
 }
}
