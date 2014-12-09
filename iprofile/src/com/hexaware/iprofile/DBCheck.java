/*package com.hexaware.iprofile;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;

public class DBCheck extends Serializable implements org.hibernate.classic.LifeCycle {
    public boolean onSave(Session session) {
        Query query = session.createQuery(from Bean b where b.field=:field");
        query.setParameters("field", this.field);
        @SuppressWarnings("unchecked")
        List<Bean> beans = query.list();
        if (beans != null && !beans.isEmpty()) {
            // This does not save the identity.
            return VETO;
        }
        return NO_VETO;
    }
}
*/