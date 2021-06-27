package com.security.demo.Examples.Siniflar.Persistance;

import java.util.HashMap;
import java.util.Map;

public abstract class  AbstractDao <Entity> {
    protected Map<Long,Entity> myMap;

    public AbstractDao() {
        myMap=new HashMap<>();
    }

    public abstract void save(Entity entity);
    public abstract void update(Entity entity);
    public abstract Entity retrieve(Long id);

}
