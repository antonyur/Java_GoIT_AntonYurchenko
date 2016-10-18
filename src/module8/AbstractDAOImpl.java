package module8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractDAOImpl<T> implements AbstractDAO<T> {
    private List<T> objectList;

    public AbstractDAOImpl() {
        this.objectList = new ArrayList<T>();
    }

    @Override
    public T save(T o) {
        if (!objectList.contains(o))
            objectList.add(o);
        return o;
    }

    @Override
    public void delete(T o) {
        Iterator<T> itr = objectList.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals(o))
                itr.remove();
        }
    }

    @Override
    public void deleteAll(List<T> list) {
        for(T o : list)
            delete(o);
    }

    @Override
    public void saveAll(List<T> list) {
        for(T o : list)
            save(o);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public T get(long id) {
        return null;
    }

    @Override
    public List<T> getList() {
        return objectList;
    }

    @Override
    public String toString() {
        return "AbstractDAOImpl{" +
                "objectList=" + objectList +
                '}';
    }
}
