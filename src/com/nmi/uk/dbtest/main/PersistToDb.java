package com.nmi.uk.dbtest.main;

import javax.persistence.PreUpdate;
import javax.persistence.*;

/**
 * Created by Darren on 23/08/2014.
 */
public class PersistToDb {

    @PreUpdate
    void preUpdate(Object object) {
    }

    public PersistToDb(){

    }


}
