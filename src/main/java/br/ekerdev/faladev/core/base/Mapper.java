package br.ekerdev.faladev.core.base;

/**
 * T: DTO
 * K: Entity
 */
public abstract class Mapper<T, K> {
    /**
     * @param k Entity
     * @return Entity to DTO.
     */
    protected abstract T mapTo(K k);

    /**
     * @param t DTO
     * @return DTO to entity.
     */
    protected abstract K mapFrom(T t);
}
