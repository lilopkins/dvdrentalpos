package uk.hpkns.dvdrentalpos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.hpkns.dvdrentalpos.api.v1.controllers.ModelController;
import uk.hpkns.dvdrentalpos.data.HasIdentity;
import uk.hpkns.dvdrentalpos.data.Updatable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class ModelControllerTests<T extends Updatable<T> & HasIdentity<I>,
        I, R extends CrudRepository<T, I> & PagingAndSortingRepository<T, I>, C extends ModelController<T, I, R>> {

    R repository;
    C controller;

    public abstract void setup();

    protected abstract Class<T> getTypeClass();

    protected abstract T getTestObject();

    protected abstract T getEditObject();

    protected abstract void validateChangedObject(T obj);

    @Test
    public void testGetPaged() {
        Pageable p = Pageable.unpaged();
        controller.getPaged(p);
        verify(repository).findAll(p);
    }

    @Test
    public void testGet() {
        T obj = getTestObject();
        when(repository.findById(obj.getId())).thenReturn(Optional.of(obj));

        Optional<T> opt = controller.get(obj.getId());
        verify(repository).findById(obj.getId());

        assertTrue(opt.isPresent(), "object not fetched");
        assertEquals(obj, opt.get(), "object not correct");
    }

    @Test
    public void testCreate() {
        T obj = getTestObject();
        controller.create(obj);
        verify(repository).save(obj);
    }

    @Test
    public void testUpdate() {
        T obj = getTestObject();
        T editObj = getEditObject();

        when(repository.findById(editObj.getId())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> controller.update(editObj.getId(), editObj));

        when(repository.findById(obj.getId())).thenReturn(Optional.of(obj));
        controller.update(obj.getId(), editObj);

        ArgumentCaptor<T> captor = ArgumentCaptor.forClass(getTypeClass());
        verify(repository).save(captor.capture());
        validateChangedObject(captor.getValue());
    }

    @Test
    public void testDelete() {
        controller.delete(getTestObject().getId());
        verify(repository).deleteById(getTestObject().getId());
    }
}
