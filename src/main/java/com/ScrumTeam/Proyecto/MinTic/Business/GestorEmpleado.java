package com.ScrumTeam.Proyecto.MinTic.Business;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class GestorEmpleado implements EmpleadoInterface {


    private EmpleadoRepositorio repositorio = new EmpleadoRepositorio() {
        @Override
        public List<Empleado> findAll() {
            return null;
        }

        @Override
        public List<Empleado> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Empleado> findAllById(Iterable<String> strings) {
            return null;
        }

        @Override
        public <S extends Empleado> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Empleado> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Empleado> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Empleado> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<String> strings) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Empleado getOne(String s) {
            return null;
        }

        @Override
        public Empleado getById(String s) {
            return null;
        }

        @Override
        public Empleado getReferenceById(String s) {
            return null;
        }

        @Override
        public <S extends Empleado> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Empleado> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Empleado> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Empleado> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Empleado> findById(String s) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(String s) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(String s) {

        }

        @Override
        public void delete(Empleado entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends String> strings) {

        }

        @Override
        public void deleteAll(Iterable<? extends Empleado> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Empleado> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Empleado> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Empleado> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Empleado> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Empleado, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };



    @Override
    public List<Empleado> getEmpleado() {
        return repositorio.findAll();
    }

    @Override
    public Empleado getEmpleado(String id) throws Exception {
        Optional<Empleado> empleadobd = repositorio.findById(id);
        if (empleadobd.isPresent()){
            return empleadobd.get();
        }
        throw new Exception("Empleado no Existe.");

    }

    @Override
    public String setUsuario(Empleado empleado_parametro) {
        repositorio.save(empleado_parametro);
        return "Empleado Creado Con Exito.";
    }

    @Override
    public Empleado updateUsuarioAll(Empleado empleado_update, String id) {
        return null;
    }

    @Override
    public Empleado updateUsuario(Empleado empleado_update, String id) {
        return null;
    }

    @Override
    public String deleteUsuario(String id) {
        repositorio.deleteById(id);
        return "Empleado Eliminado Con Exito.";
    }
}
