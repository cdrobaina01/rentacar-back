package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.NotFoundException;
import cu.edu.cujae.rentacarback.exceptions.UniqueValueException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudService<Entity, Key> {
    protected abstract String getEntityName();
    protected abstract String getKeyName();
    protected abstract JpaRepository<Entity, Key> repository();
    protected abstract Key getKey(Entity entity);
    protected abstract void validateExistingForeignKeys(Entity entity) throws UniqueValueException;
    protected abstract Entity updateData(Entity entity, Entity data);

    public List<Entity> findAll() {
        return repository().findAll();
    }

    public Entity findById(Key key) throws NotFoundException {
        return repository().findById(key).orElseThrow(() -> new NotFoundException(getEntityName(), key.toString()));
    }

    public Entity create(Entity entity) throws UniqueValueException {
        // validateAvailableKey(entity);
        // validateExistingForeignKeys(entity);
        return repository().save(entity);
    }

    public Entity update(Key key, Entity newEntity) throws NotFoundException, UniqueValueException {
        return repository().findById(key)
                .map(entity -> repository().save(updateData(entity, newEntity)))
                .orElseThrow(() -> new NotFoundException(getEntityName(), key.toString()));
    }

    public Entity delete(Key key) throws NotFoundException {
        return repository().findById(key)
                .map(entity -> {
                    repository().delete(entity);
                    return entity;
                })
                .orElseThrow(() -> new NotFoundException(getEntityName(), key.toString()));
    }

    protected void validateAvailableKey(Entity entity) throws UniqueValueException {
        if (repository().findById(getKey(entity)).isPresent()) {
            throw new UniqueValueException(getEntityName(), getKeyName());
        }
    }
}
