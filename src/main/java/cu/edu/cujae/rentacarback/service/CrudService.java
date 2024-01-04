package cu.edu.cujae.rentacarback.service;

import cu.edu.cujae.rentacarback.exceptions.notfound.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudService<Entity, Key> {
    protected abstract String getEntityName();
    protected abstract JpaRepository<Entity, Key> repository();

    protected abstract void validateKeys(Entity entity);
    protected abstract Entity updateData(Entity entity, Entity data);

    public List<Entity> findAll() {
        return repository().findAll();
    }

    public Entity findById(Key key) throws NotFoundException {
        return repository().findById(key).orElseThrow(() -> new NotFoundException(getEntityName(), key.toString()));
    }

    public Entity create(Entity entity) {
        validateKeys(entity);
        return repository().save(entity);
    }

    public Entity update(Key key, Entity newEntity) throws NotFoundException {
        validateKeys(newEntity);
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
}
